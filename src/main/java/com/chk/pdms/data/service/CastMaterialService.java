package com.chk.pdms.data.service;

import com.chk.pdms.common.constat.IsModelEnum;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.dao.DataDao;
import com.chk.pdms.data.vo.*;
import com.chk.pdms.pd.dao.PdClassDao;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdModelExample;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd_material.dao.ClassMaterialTypeDao;
import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import com.chk.pdms.pd_material.service.PdMaterialService;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CastMaterialService {
    private Logger log = LoggerFactory.getLogger(CastService.class);

    @Autowired
    private DataDao dataDao;

    @Autowired
    private PdModelDao modelDao;

    @Autowired
    private ClassMaterialTypeDao classMaterialTypeDao;
    @Autowired
    private PdClassDao ClassDao;
    @Autowired
    private PdMaterialService materialService;

    /**
     * 判断 某info 数据库里是否有该产品系列
     */
    public void isModel(Set<String> set, Map<String, PdModel> modelMap, PdInfoMaterial info, IsModelEnum type) {
        String modelCode = info.getModel() +"|" + info.getQuality();
        PdModel model =(PdModel)modelMap.get(modelCode.toLowerCase());
        if("HKLBPF".equals(info.getModel())||"HKLLPF".equals(info.getModel())||"HKLHPF".equals(info.getModel())||"JLTC-H".equals(info.getModel())||"JLTC-P".equals(info.getModel())||"JLTC-P3".equals(info.getModel())){
//               /LTCC滤波器、功分器、


            if( type.getValue()==1){
                //TODO  有型号
                if (model != null ) {
//                （model+Quality）
                    info.setPdModelId(Integer.valueOf(model.getId().toString()));
                }else {
                    //    插入的产品没有对应的系列（model+Quality）
//                判断第二种方法
                    if(info.getModelId()!=null){

                        info.setPdModelId(Integer.valueOf(info.getModelId()));

                    }else{
                        set.add(modelCode);
                    }

                }
            }else{
//            不需要
            }


        }else{

            if( type.getValue()==1){
                //TODO  有型号
                if (model != null ) {
//                （model+Quality）
                    info.setPdModelId(Integer.valueOf(model.getId().toString()));
                }else {
                    //    插入的产品没有对应的系列（model+Quality）
//                判断第二种方法
                    if(info.getModelId()!=null){

                        info.setPdModelId(Integer.valueOf(info.getModelId()));

                    }else{
                        set.add(modelCode);
                    }

                }
            }else{
//            不需要
            }


        }




    }




    public List<PdModel> castPdModel(List<ModelVo> vos, List<PDHKLBPFInfoVo>LBPFVos, List<PDHKLLPFInfoVo>LLPEVos, List<PDHKLHPFInfoVo>LHPFVos, List<PDJLTCInfoVo>JLTCVos, List<PDCSInfoVo> pdcsInfoVos, List<PDPorcelainInfoVo> pdPorcelainInfoVos, List<PDSizingMaterialInfoVo> pdSizingMaterialInfoVos , List<PDRawPorcelainWithInfoVo> rawPorcelainWithInfoVos) {
        Map<String, String> ruleMap = new HashMap<>();
        for (PDHKLBPFInfoVo vo : LBPFVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDHKLLPFInfoVo vo : LLPEVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDHKLHPFInfoVo vo : LHPFVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDJLTCInfoVo vo :JLTCVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDCSInfoVo vo :pdcsInfoVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDPorcelainInfoVo vo : pdPorcelainInfoVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDRawPorcelainWithInfoVo vo :  rawPorcelainWithInfoVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PDSizingMaterialInfoVo vo : pdSizingMaterialInfoVos) {
//            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }

        for (ModelVo vo : vos) {
            String rule = ruleMap.get(vo.getCode());
            if (StringUtils.isNotBlank(rule)) {
                vo.setOrderRule(rule);
            }
        }

        List<ClassVo> classVos = dataDao.getDataMapper().listClz();
        Map<String, ClassVo> clzMap = new LinkedHashMap<>();
        for (ClassVo vo : classVos) {
            String key = vo.getLev1() + "__" + vo.getLev21() + "__" + vo.getLev22() + "__" + vo.getLev3();
            clzMap.put(key, vo);
        }
        Set<String> set = new LinkedHashSet<>();
        List<PdModel> models = new ArrayList<>();
        for (ModelVo vo : vos) {
            String key = vo.getClz1() + "__" + vo.getClz2() + "__" + vo.getClz3() + "__" + vo.getClz4();
            ClassVo clz = clzMap.get(key);
            PdModel model = castPdModel(vo);
            if (clz != null) {
                model.setPdClassId(clz.getId());//TODO ？？？
            }else{
                set.add(key);
            }
            models.add(model);
        }

        for (String s : set) {
            log.error(s);
        }
        return models;
    }
    @SneakyThrows
    public PdModel castPdModel(ModelVo vo) {
        PdModel pdModel = new PdModel();
        BeanUtils.copyProperties(pdModel, vo);
        pdModel.setCompany(vo.getRemark());
        return pdModel;
    }
    @SneakyThrows
    private void addInfo(List<PdInfoMaterial> infos, PdInfoMaterial info) {
        boolean add = false;
//        if (StringUtils.isNotBlank(info.getTemperature())) {
//            //有温度特性是多选的情况，这里拆分成多条数据
//            String[] ss = StringUtils.split(info.getTemperature(), ";");
//            if (ss.length > 1) {
//                add = true;
//                for (String s : ss) {
//                    PdInfo pdinfo = new PdInfo();
//                    BeanUtils.copyProperties(pdinfo, info);
//                    pdinfo.setTemperature(s);
//                    infos.add(pdinfo);
//                }
//            }
//        }
//
//        //同温度相同的处理方式
//        if (StringUtils.isNotBlank(info.getElecCode())){
//            String[] ss = StringUtils.split(info.getElecCode(), ";");
//            if (ss.length > 1) {
//                add = true;
//                for (String s : ss) {
//                    PdInfo pdinfo = new PdInfo();
//                    BeanUtils.copyProperties(pdinfo, info);
//                    pdinfo.setElecCode(s);
//                    infos.add(pdinfo);
//                }
//            }
//        }

        if (!add) {
            infos.add(info);
        }
    }
    public Map<String, Object> castMaterialPdInfo(List<PDHKLBPFInfoVo>LBPFVos, List<PDHKLLPFInfoVo>LLPEVos, List<PDHKLHPFInfoVo>LHPFVos, List<PDJLTCInfoVo>JLTCVos, List<PDCSInfoVo> pdcsInfoVos, List<PDHKJBPFInfoVo>JBPFVos,List<PDPorcelainInfoVo> pdPorcelainInfoVos, List<PDSizingMaterialInfoVo> pdSizingMaterialInfoVos , List<PDRawPorcelainWithInfoVo> rawPorcelainWithInfoVos) {
        HashMap<String, Object> result = new HashMap<>();
        List<PdInfoMaterial> infos = new ArrayList<>();
        result.put("PdInfoMaterial", infos);
        Map<String, PdModel> modelMap = buildModelMap();
        Set<String> set = new LinkedHashSet<>();

        for (PDHKLBPFInfoVo vo :LBPFVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDHKLLPFInfoVo vo : LLPEVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDHKLHPFInfoVo vo : LHPFVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDJLTCInfoVo vo : JLTCVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for(PDCSInfoVo vo : pdcsInfoVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDRawPorcelainWithInfoVo  vo: rawPorcelainWithInfoVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDSizingMaterialInfoVo vo : pdSizingMaterialInfoVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDPorcelainInfoVo vo : pdPorcelainInfoVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDHKJBPFInfoVo vo : JBPFVos) {
            PdInfoMaterial info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }

        result.put("noModelInfo", set);
        if (set.size() > 0){
            log.error("无对应型号的产品");
        }
        for (String s : set) {
            log.error(s);
        }
        if (set.size() > 0){
            return result;
        }

        List<PdParam> capacities = dataDao.listParam(ParamType.capacity.value());


        for (PdInfoMaterial info : infos) {
            String key = materialService.buildFtIndex(info);
            info.setSearchKey(key);
        }
        return result;
    }
//

    /**
     * 在classMaterialTypeDao中获取class集合，通过class id获取model
     * @return
     */

    private Map<String, PdModel> buildModelMap() {

        List<Long> classIds=classMaterialTypeDao.getExClassMaterialmapper().getclassIdList();
        PdModelExample example= new PdModelExample();
        example.createCriteria().andPdClassIdIn(classIds);
        List<PdModel> models = modelDao.getModelMapper().selectByExample(example);

        Map<String, PdModel> modelMap = new HashMap<>();
        for (PdModel model : models) {

           if("HKLBPF".equals(model.getCode())||"HKLLPF".equals(model.getCode())||"HKLHPF".equals(model.getCode())||"JLTC-H".equals(model.getCode())||"JLTC-P".equals(model.getCode())||"JLTC-P3".equals(model.getCode())){
//               /LTCC滤波器、功分器、
               String qaCode = model.getQaCode();
               String[] qas = StringUtils.split(qaCode, ";");
               for (String qa : qas) {
                   String key = model.getCode() + "|" + qa;
                   modelMap.put(key.toLowerCase(), model);
               }
           }else{
               String key = model.getName();
               modelMap.put(key, model);

           }
        }
        return modelMap;
    }
    public void addV(PdInfoMaterial pdInfo) {
        if (pdInfo.getRatedCurrent() != null && !StringUtils.contains(pdInfo.getRatedCurrent().toUpperCase(), "MA")) {
            pdInfo.setRatedCurrent(pdInfo.getRatedCurrent() + "mA");
        }
        if (pdInfo.getPowerCapacity() != null && !StringUtils.contains(pdInfo.getPowerCapacity().toUpperCase(), "W")) {
            pdInfo.setPowerCapacity(pdInfo.getPowerCapacity() + "W");
        }
    }
    public void addM(PdInfoMaterial pdInfo) {
        if (pdInfo.getFrequencyRange() != null && !StringUtils.contains(pdInfo.getFrequencyRange().toUpperCase(), "M")) {
            pdInfo.setFrequencyRange(pdInfo.getFrequencyRange() + "M");
        }
    }
    public void addSearchKeyCS(PdInfoMaterial pdInfo) {

    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDJLTCInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("4");
        if(pdInfo.getModel().equals("JLTC-P")){
            pdInfo.setMaterialType2("1");
        }else if(pdInfo.getModel().equals("JLTC-P3")){
            pdInfo.setMaterialType2("2");
        }else{
            pdInfo.setMaterialType2("3");
        }
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDHKJBPFInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("2");
        if(vo.getClazz().equals("A")){
            pdInfo.setMaterialType2("3");
        }else if(vo.getClazz().equals("B")){
            pdInfo.setMaterialType2("2");
        }else if(vo.getClazz().equals("C")){
            pdInfo.setMaterialType2("1");
        }else{
;
        }
        addV(pdInfo);
        addM(pdInfo);

        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDHKLHPFInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("1");
        pdInfo.setMaterialType2("3");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDHKLLPFInfoVo vo) {
        PdInfoMaterial pdInfo= new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("1");
        pdInfo.setMaterialType2("1");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDHKLBPFInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("1");
        pdInfo.setMaterialType2("2");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDCSInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("7");
        pdInfo.setMaterialType2("1");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDPorcelainInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("9");
        pdInfo.setMaterialType2("1");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDRawPorcelainWithInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("8");
        pdInfo.setMaterialType2("1");
        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfoMaterial castPdInfo(PDSizingMaterialInfoVo vo) {
        PdInfoMaterial pdInfo = new PdInfoMaterial();
        BeanUtils.copyProperties(pdInfo, vo);
        pdInfo.setMaterialType("6");
        if(vo.getClazz().equals("LTCC")){
            pdInfo.setMaterialType2("1");
        }else if("HTCC".equals(vo.getClazz())){
            pdInfo.setMaterialType2("2");
        }else{
            pdInfo.setMaterialType2("3");
        }

        addV(pdInfo);
        addM(pdInfo);
        return pdInfo;
    }

}
