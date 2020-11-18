package com.chk.pdms.pd.service;


import com.chk.pdms.common.utils.BDException;
import com.chk.pdms.common.utils.ChkResource;
import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.vo.ModelVo;
import com.chk.pdms.pd.dao.PdClassDao;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.vo.PdModelVo;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class PdModelService {

    @Autowired
    private PdModelDao modelDao;

    @Autowired
    private PdClassDao classDao;

    @Value("${virtual.filePath}")
    private String filePath;

    public Page<PdModelVo> list(Long pcId, String pcName, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<PdModelVo> pdInfos = modelDao.getExtModelMapper().list(pcId, pcName);
        return new Page(pdInfos);
    }

    @SneakyThrows
    public PdModelVo get(Long id) {
        PdModel model = modelDao.getModelMapper().selectByPrimaryKey(id);
        PdClass clz = classDao.getClassMapper().selectByPrimaryKey(model.getPdClassId());
        PdModelVo vo = new PdModelVo();
        BeanUtils.copyProperties(vo, model);
        vo.setPcName(clz.getName());
        vo.trySpliltRule();
        vo.arrayOR();
        return vo;
    }

    @SneakyThrows
    @Transactional
    public void save(PdModelVo modelVo) {
        if (StringUtils.isNotBlank(modelVo.getSuperQaCode())) {
            modelVo.setQaCode(StringUtils.replace(modelVo.getSuperQaCode(), ",", ";"));
        }
        boolean exist = modelDao.exist(modelVo.getId() == null ? -1L : modelVo.getId(), modelVo.getCode(), modelVo.getSuperQaCode());
        if (exist){
            throw new BDException("已有相同数据存在: 型号-" + modelVo.getCode() + ", 质量等级-" + modelVo.getSuperQaCode());
        }

        String murl = FileUtil.transferTo(modelVo.getManual(), filePath,"manual");
        if (murl != null) {
            modelVo.setManualUrl(murl);
        }
        String orUrl1 = FileUtil.transferTo(modelVo.getOrderRuleImg(), filePath,"images/pd-rule");
        String orUrl2 = FileUtil.transferTo(modelVo.getOrderRuleImg2(), filePath,"images/pd-rule");
        if (orUrl1 != null) {
            modelVo.setOrderRuleUrl(orUrl1);
        }
        if (orUrl2 != null){
            modelVo.setOrderRuleUrl2(orUrl2);
        }

        modelVo.tryMergeRule();
        String objUrl1 = FileUtil.transferTo(modelVo.getObjectImg1(), filePath,"images/pd-model");
        if (objUrl1 != null) {
            modelVo.setObjectUrl1(objUrl1);
        }
        String objUrl2 = FileUtil.transferTo(modelVo.getObjectImg2(), filePath,"images/pd-model");
        if (objUrl2 != null) {
            modelVo.setObjectUrl2(objUrl2);
        }
        String objUrl3 = FileUtil.transferTo(modelVo.getObjectImg3(), filePath,"images/pd-model");
        if (objUrl3 != null) {
            modelVo.setObjectUrl3(objUrl3);
        }
        modelVo.setObjectUrl(modelVo.buildObjectUrl());

        PdModel model = new PdModel();
        PropertyUtils.copyProperties(model, modelVo);
        model.setQaCode(modelVo.getSuperQaCode());
        try {
            if (model.getId() == null) {
                modelDao.getModelMapper().insert(model);
            } else {
                modelDao.getModelMapper().updateByPrimaryKey(model);
            }
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                throw new BDException("已有相同数据存在: 型号-" + model.getCode() + ", 质量等级-" + model.getQaCode());
            }else{
                throw e;
            }
        }
    }

    @Transactional
    public void delete(Long id) {
        modelDao.getModelMapper().deleteByPrimaryKey(id);
    }

    public void formatOrderRule() {
        List<PdModel> models = this.modelDao.list();
        for (PdModel model : models) {
            String rule = model.getOrderRule();
            String format = formatOR(rule);
            PdModel pm = new PdModel();
            pm.setId(model.getId());
            pm.setOrderRule(format);
            this.modelDao.getModelMapper().updateByPrimaryKeySelective(pm);
        }
    }

    private static String formatOR(String orderRule) {
        String rule = orderRule;
        for (ParamType type : ParamType.values()) {
            rule = StringUtils.replace(rule, type.value(), type.value() + "||");
        }
        if (StringUtils.endsWith(rule, "||")) {
            rule = StringUtils.substringBeforeLast(rule, "||");
        }
        rule = StringUtils.replace(rule, "|| ", "| |");
        rule = StringUtils.replace(rule, "||-", "|-|");
        return rule;
    }

    public void updateImg() {
        ChkResource chk = new ChkResource();
        String base = "http://116.62.26.69:8088/hket-internet/manage/show_file.shtml?filePath=";
        List<PdModel> list = this.modelDao.list();
        for (PdModel model : list) {
            if (StringUtils.isNotBlank(model.getOrderRuleUrl())) {
                String ruleUrl = "";
                String[] urls = StringUtils.split(model.getOrderRuleUrl(), ",");
                for (int i = 0; i <= urls.length - 1; i++) {
                    String url = base + urls[i];
                    String sufixx = StringUtils.substringAfterLast(urls[i], ".");
                    String name = "/files/images/pd-rule/" + FileUtil.renameUploadFile(model.getId() + "-" + (i + 1) + "." + sufixx);
                    String local = "e:/img/" + name;
                    chk.download(url, local);
                    ruleUrl += name + ",";
                }
                if (StringUtils.endsWith(ruleUrl, ",")) {
                    ruleUrl = StringUtils.substringBeforeLast(ruleUrl, ",");
                }

                PdModel pdm = new PdModel();
                pdm.setId(model.getId());
                pdm.setOrderRuleUrl(ruleUrl);
                this.modelDao.getModelMapper().updateByPrimaryKeySelective(pdm);
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ModelVo vo = new ModelVo();
        PdModel pd = new PdModel();
        BeanUtils.copyProperties(pd, vo);

//        String aa = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|引出端形式|-|执行标准";
//        String bb = "执行标准,产品型号,封装及外形尺寸,-,温度特性/系数,-,电压,-,精度/容量偏差,-,引出端形式,-,电容";
//        String[] a = StringUtils.split(aa, "|");
//        Arrays.toString(a);
//        System.out.println("----------------------------------");
//        String[] b = StringUtils.splitPreserveAllTokens(aa, "|");
//        Arrays.toString(b);
//        System.out.println("----------------------------------");

//        String[] ss = aa.split(",");
//        System.out.println(ss.toString());
        String org = "质量等级 产品型号-封装及外形尺寸-温度特性/系数-电压-电容精度/容量偏差-引出端形式-执行标准";
        String s1 = formatOR(org);
        System.out.println(org);
        System.out.println(s1);
//        String[] split = StringUtils.split(s1,"|");
//        for (String s : split) {
//            System.out.println(s);
//        }
//        System.out.println("over");
    }
}
