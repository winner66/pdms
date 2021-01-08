package com.chk.pdms.pd_material.service.impl;

import com.chk.pdms.common.dao.dictDao;
import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.common.utils.IKUtil;
import com.chk.pdms.common.vo.*;
import com.chk.pdms.data.service.ImportService;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.dao.PdParamDao;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdClassService;
import com.chk.pdms.pd.vo.ImportDataVo;
import com.chk.pdms.pd.vo.PdFtVo;
import com.chk.pdms.pd.vo.PdInfoVo;
import com.chk.pdms.pd.vo.PdSkVo;
import com.chk.pdms.pd_material.Dto.PdFtMaterialVo;
import com.chk.pdms.pd_material.dao.ClassMaterialTypeDao;
import com.chk.pdms.pd_material.dao.PdInfoMaterialDao;
import com.chk.pdms.pd_material.domain.ClassMaterialType;
import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import com.chk.pdms.pd_material.service.PdMaterialService;
import com.chk.pdms.pd_material.vo.PdMaterialVo;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class PdMaterialServiceImpl implements PdMaterialService {

    private Logger log = LoggerFactory.getLogger(PdMaterialServiceImpl.class);

    @Value("${virtual.filePath}")
    private String filePath;
    @Autowired
    private ImportService importService;
    @Autowired
    private PdParamDao pdParamDao;
    @Autowired
    private PdModelDao modelDao;
    @Autowired
    private PdClassService pdClassService;
    @Autowired
    private dictDao dict;
    @Autowired
    private PdInfoMaterialDao materialDao;
    @Autowired
    private ClassMaterialTypeDao classMaterialTypeDao;


    @SneakyThrows
    @Transactional
    public ImportDataVo importData(ImportDataVo vo) {
        String file = FileUtil.transferTo(vo.getData(), filePath, "import-data/Material/info");
        String path = filePath + file.replace("/files", "");
        Map<String, Object> map = importService.importMaterialInfo(path, false, false);
        String code = (String)map.get("code");
        ImportDataVo rsp = new ImportDataVo();
        if (code.equals("200")){
            rsp.setCode(code);
            Integer num = (Integer)map.get("num");
            if (num > 0){
                rsp.setMsg("导入成功<br>导入数量:" + num);
            }else{
                rsp.setMsg("导入完成<br>导入数量:" + num + "<br>请确认模板正确且有数据");
            }
        }else{
            rsp.setCode(code);
            Set<String> noModelInfo = (Set) map.get("noModelInfo");
            rsp.setCode(code);
            StringBuilder sb = new StringBuilder();
            for (String s : noModelInfo) {
                sb.append("<br>").append(s);
            }
            rsp.setMsg("导入失败<br>无对应型号的产品:" + sb.toString());
        }
        File dataFile = new File(path);
        if (dataFile.isFile()) {
            dataFile.delete();
        }
        return rsp;
    }

    @Override
    public String buildFtIndex(PdInfoMaterial info) {
        PdFtMaterialVo  ft= new PdFtMaterialVo();
        try {
            BeanUtils.copyProperties(ft, info);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String kw = buildFt(ft);
        info.setSearchKey(kw);
        return kw;
    }
    private String buildFt(PdFtMaterialVo ft) {
        StringBuilder key = new StringBuilder();
        appendKey(key, ft.getModel());
        appendKey(key, ft.getStd());
        appendKey(key, ft.getQuality());
        appendKey(key, ft.getSize());
        appendKey(key,ft.getOutlet());
        appendKey(key,ft.getInsertionLoss());
        appendKey(key,ft.getAmplitudeBalance());
        appendKey(key,ft.getAppearance());
        appendKey(key,ft.getBandwidth());
        appendKey(key,ft.getBasisMaterial());
        appendKey(key,ft.getBreakdownVoltage());
        appendKey(key,ft.getCenterFrequency());
        appendKey(key,ft.getCutOffFrequency());
        appendKey(key,ft.getD10());
        appendKey(key,ft.getD50());
        appendKey(key,ft.getD90());
        appendKey(key,ft.getDielectricLossBy1mhz());
        appendKey(key,ft.getDielectricLossBy19g());
        appendKey(key,ft.getDielectricLossBy20g());
        appendKey(key,ft.getDielectricStrength());
        appendKey(key,ft.getPowderDensity());
        appendKey(key,ft.getEvaluatingScope());
        appendKey(key,ft.getFlexureStrength());
        appendKey(key,ft.getLengthWidthCode());
        appendKey(key,ft.getFrequencyRange());
        appendKey(key,ft.getInsulationResistance());
        appendKey(key,ft.getInsulationResistanceBy25());
        appendKey(key,ft.getInsulationResistanceBy125());
        appendKey(key,ft.getIsolation());
        appendKey(key,ft.getMaterialCode());
        appendKey(key,ft.getOutOfBandRejection1());
        appendKey(key,ft.getOutOfBandRejection2());
        appendKey(key,ft.getOutOfBandRejection3());
        appendKey(key,ft.getOutOfBandRejection4());
        appendKey(key,ft.getOutOfBandRejection5());
        appendKey(key,ft.getVswrStopBand());
        appendKey(key,ft.getVswr());
        appendKey(key,ft.getVswrStopBand());
        appendKey(key,ft.getVswrPassBand());
        appendKey(key,ft.getPassBandInsertionLossBy13());
        appendKey(key,ft.getPassBandInsertionLossBy20typ());
        appendKey(key,ft.getSoakingTime());
        appendKey(key,ft.getSpecificSurfacearea());

        appendKey(key,ft.getOther());
        appendKey(key,ft.getPadMetallurgy());
        appendKey(key,ft.getPhaseBalance());
        appendKey(key,ft.getPerformance());
        appendKey(key,ft.getPermittivity());
        appendKey(key,ft.getPermittivityBy15g());
        appendKey(key,ft.getPermittivityBy19g());
        appendKey(key,ft.getPowerCapacity());
        appendKey(key,ft.getPassBandRange());
        appendKey(key,ft.getSurfaceCode());
        appendKey(key,ft.getThicknessCode());
        appendKey(key,ft.getSinteringTemperature());
        appendKey(key,ft.getStopBandBy20());
        appendKey(key,ft.getStopBandBy40());

        appendKey(key,ft.getRatedCurrent());
        appendKey(key,ft.getTemperatureAlterationRatio());
        appendKey(key,ft.getRipple());

        String kw = StringUtils.replace(key.toString(), " |", "|");
        kw = StringUtils.replace(kw, "| ", "|").trim();
        return kw;
    }

    private StringBuilder appendKey(StringBuilder sb, String s) {

        return appendKey(sb, s, "|");
    }


    @Override
    public void save(PdInfoMaterial info) {
        buildFtIndex(info);
        if (info.getId() == null) {
            materialDao.getPdInfoMaterialMapper().insert(info);
        } else {
            materialDao.getPdInfoMaterialMapper().updateByPrimaryKey(info);
        }
    }
    public Page<PdMaterialVo> list(String key, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        key = IKUtil.analyzWithSymbol(key, "+");
        List<PdMaterialVo> pdInfos = materialDao.getExPdInfoMaterialMapper().list(key);
        return new Page(pdInfos);
    }

    @SneakyThrows
    public PdMaterialVo  get(Long id) {
        PdInfoMaterial info = materialDao.getPdInfoMaterialMapper().selectByPrimaryKey(Integer.valueOf(id.toString()));
        PdModel model = modelDao.getModelMapper().selectByPrimaryKey(Long.valueOf(info.getPdModelId()));
        PdMaterialVo vo = new PdMaterialVo();
        vo.setPmName(model.getName());
        vo.setPmCode(model.getCode());
        vo.setPdClassId(model.getPdClassId());
        BeanUtils.copyProperties(vo, info);
        return vo;
    }


    @Transactional
    public void delete(Long id) {
        materialDao.getPdInfoMaterialMapper().deleteByPrimaryKey(Integer.valueOf(id.toString()));
    }

    @Override
    public List<TableRsp> getclzLevel1() {
        List<TableRsp> res= new ArrayList<>();
        List<ClassMaterialType> CMT=classMaterialTypeDao.getExClassMaterialmapper().List();
        Set<String> setClass=new HashSet<>();

        for(ClassMaterialType r1: CMT){
            if(!setClass.contains(r1.getClassName())){
                setClass.add(r1.getClassName());
                TableRsp cmrsp= new TableRsp(r1.getClassName(),r1.getClassId().toString());
                res.add(cmrsp);
            }
        }
        return res;
    }

    //    LTCC class 下的所有的分类
    @Override
    public List<TreeRsp> getclz(){
        List<TreeRsp> res= new ArrayList<>();
        List<ClassMaterialType> CMT=classMaterialTypeDao.getExClassMaterialmapper().List();
        Set<String> setClass=new HashSet<>();

        for(ClassMaterialType r1: CMT){
            if(!setClass.contains(r1.getClassName())){
                setClass.add(r1.getClassName());
                TreeRsp cmrsp= new TreeRsp(r1.getClassName(),r1.getClassId().toString());
                res.add(cmrsp);
            }
        }
        for( ClassMaterialType cm:CMT){
            for(TreeRsp pclass:res){
                if( pclass.getLabel().equals(cm.getClassName())&&!"".equals(cm.getMaterialType2())&&cm.getMaterialType2()!=null){
                    TreeRsp  child= new TreeRsp(cm.getDes(),cm.getMaterialType()+"_"+cm.getMaterialType2(),false);
                    List<TreeRsp> childs=pclass.getChildren();
                    if(childs==null){
                        pclass.setChild(true);
                    }
                    childs=pclass.getChildren();
                    childs.add(child);
                }else if("".equals(cm.getMaterialType2())){

                }else{
//                  pclass.setHasChildren(false);
                }
            }

        }

        return  res;
    }


    private StringBuilder appendKey(StringBuilder sb, String s, String sy) {
        if (StringUtils.isNotBlank(s)) {
            sb.append(s).append(sy);
        }
        return sb;
    }

    private void appendKey(Set set, Collection c) {
        if (c != null) {
            set.addAll(c);
        }
    }

    @Transactional
    public void buildFtIndex() {
        Long start = System.currentTimeMillis();
        log.info("buildPdFtIndex start...");

        int pageNum = 1;
        int pageSize = 1000;
        int total = 0;
        List<PdFtMaterialVo> pdFtVos = null;
        for (; ; pageNum++) {
            log.info("buildFtIndex pageNum: {}， pageSize: {}", pageNum, pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<PdSkVo> pdsks = new ArrayList<>();
            pdFtVos =materialDao.getExPdInfoMaterialMapper().ListFt();
            for (PdFtMaterialVo ft : pdFtVos) {
                String kw = this.buildFt(ft);
                pdsks.add(new PdSkVo(Long.valueOf(ft.getId()), kw));
            }
            materialDao.getExPdInfoMaterialMapper().updateSearchKey(pdsks);
            total += pdFtVos.size();
            if (pdFtVos.size() < pageSize) {
                break;
            }
        }
        log.info("update pd ft total {}", total);
        log.info("buildPdFtIndex end, used time : {}ms", System.currentTimeMillis() - start);
    }





}
