package com.chk.pdms.data.service;

import com.chk.pdms.common.constat.IsModelEnum;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.dao.DataDao;
import com.chk.pdms.data.vo.*;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdInfoService;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CastService {

    private Logger log = LoggerFactory.getLogger(CastService.class);

    @Autowired
    private DataDao dataDao;

    @Autowired
    private PdModelDao modelDao;

    @Autowired
    private PdInfoService infoService;



//    @PostConstruct
//    public void init() {
//        // some init function
//        this.modelMap= buildModelMap();
//        this.set= new LinkedHashSet<>();
//
//    }

    /**
     * 判断 某info 数据库里是否有该产品系列
     */
    public void isModel(Set<String> set, Map<String, PdModel>modelMap, PdInfo info, IsModelEnum  type) {
        String modelCode = info.getModel() + "|" + info.getStd() + "|" + info.getQuality();
        PdModel model = modelMap.get(modelCode);
        if( type.getValue()==1){
            //TODO  有型号
            if (model != null ) {
                info.setPdModelId(model.getId());
            }else {
        //    插入的产品没有对应的系列（code/）
                set.add(modelCode);
            }
        }else{
//            不需要
        }

    }




    public List<PdModel> castPdModel(List<ModelVo> vos, List<DataRuleVo> dataRuleVos, List<PinVo> pinVo, List<MutilVo> mutilVos, List<SingleVo> singleVos, List<HKIVo> hkiVos, List<ThreeVo> threeVos, List<TerVo> terVos, List<HeartVo> heartVos) {
        Map<String, String> ruleMap = new HashMap<>();
        for (DataRuleVo vo : dataRuleVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (PinVo vo : pinVo) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (MutilVo vo : mutilVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (SingleVo vo : singleVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (HKIVo vo : hkiVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (ThreeVo vo : threeVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (TerVo vo : terVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
        }
        for (HeartVo vo : heartVos) {
            ruleMap.put(vo.getModel() + "|" + vo.getStd(), vo.getOrderRule());
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

    public List<PdParam> castVoltage(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        for (int i = 0; i < infos.size(); i++) {
            PdInfo info = infos.get(i);
            if (StringUtils.isNotBlank(info.getVoltage())) {
                String code = info.getVoltage();
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(i + 1);
                    param.setType(ParamType.voltage.value());
                    String name = code;
                    if (!StringUtils.contains(code.toUpperCase(), "V")) {
                        if ("0".equals(code)) {
                            name = "0[50V]";
                        }
                        if ("1".equals(code)) {
                            name = "1[100V]";
                        }
                        if ("10".equals(code)) {
                            name = "10[100V]";
                        }
                    }
                    param.setName(name);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        ArrayList<PdParam> result = new ArrayList<>(params.values());
        Collections.sort(result, new Comparator<PdParam>() {
            @Override
            public int compare(PdParam o1, PdParam o2) {
                String v1 = o1.getCode().toUpperCase();
                String v2 = o2.getCode().toUpperCase();
                if (!StringUtils.contains(v1, "V") && !StringUtils.contains(v2, "V")) {
                    return Integer.valueOf(v1).compareTo(Integer.valueOf(v2));
                }
                if (!StringUtils.contains(v1, "V") && StringUtils.contains(v2, "V")) {
                    return 1;
                }
                if (StringUtils.contains(v1, "V") && !StringUtils.contains(v2, "V")) {
                    return -1;
                }
                if (StringUtils.contains(v1, "V") && StringUtils.contains(v2, "V")) {
                    v1 = StringUtils.replace(v1, "V", "");
                    v2 = StringUtils.replace(v2, "V", "");
                    Float i1 = 0f;
                    Float i2 = 0f;
                    if (StringUtils.contains(v1, "K")) {
                        i1 = (Float.valueOf(StringUtils.replace(v1, "K", "")) * 1000);
                    } else {
                        i1 = Float.valueOf(v1);
                    }
                    if (StringUtils.contains(v2, "K")) {
                        i2 = (Float.valueOf(StringUtils.replace(v2, "K", "")) * 1000);
                    } else {
                        i2 = Float.valueOf(v2);
                    }
                    return i1.compareTo(i2);
                }
                return 0;
            }
        });
        int i = 0;
        for (PdParam param : result) {
            param.setIdx(++i);
        }
        return result;
    }

    public List<PdParam> castOutlet(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            if (StringUtils.isNotBlank(info.getOutlet())) {
                String code = info.getOutlet();
                String[] codes = StringUtils.split(code, ";");
                for (String s : codes) {
                    if (!params.containsKey(s)) {
                        PdParam param = new PdParam();
                        param.setIdx(++i);
                        param.setType(ParamType.outlet.value());
                        param.setName(null);//TODO ???
                        param.setCode(s);
                        params.put(s, param);
                    }
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castTolerance(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            if (StringUtils.isNotBlank(info.getTolerance())) {
                String code = info.getTolerance();
                String[] codes = StringUtils.split(code, ";");
                for (String s : codes) {
                    if (!params.containsKey(s)) {
                        PdParam param = new PdParam();
                        param.setIdx(++i);
                        param.setType(ParamType.tolerance.value());
                        param.setName(null);//TODO ???
                        param.setCode(s);
                        params.put(s, param);
                    }
                }
            }
        }
        return new ArrayList<>(params.values());
    }

//    public static void main(String[] args) {
//        String s = ";z;m;";
//        System.out.println(Arrays.toString(StringUtils.split(s, ";")));
//        System.out.println(Arrays.toString(StringUtils.splitPreserveAllTokens(s, ";")));
//        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparator(s, ";")));
//        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparatorPreserveAllTokens(s, ";")));
//    }

    public List<PdParam> castTemperature(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            if (StringUtils.isNotBlank(info.getTemperature())) {
                String code = info.getTemperature();
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.temperature.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    @Deprecated
    //应该从model中提取qa
    public List<PdParam> castQuality() {
        List<ClassVo> classVos = this.dataDao.getDataMapper().listClz();
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (ClassVo clz : classVos) {
            String key = clz.getQa();
            if (StringUtils.isBlank(key)){
                continue;
            }
            if (!params.containsKey(key)) {
                PdParam param = new PdParam();
                param.setIdx(++i);
                param.setType(ParamType.quality.value());
                param.setName(clz.getLev22());
                param.setCode(key);
                param.setGp(clz.getLev22());
                params.put(key, param);
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castStd(List<PdModel> models) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdModel model : models) {
            String code = StringUtils.split(model.getCode(), "|")[1];
            if (!params.containsKey(code)) {
                PdParam param = new PdParam();
                param.setIdx(++i);
                param.setType(ParamType.std.value());
                param.setName(model.getName());//TODO ???
                param.setCode(code);
                param.setDescr(model.getCompany());
                params.put(code, param);
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castSize(List<SizeVo> sizeVos) {
        List<PdParam> params = new ArrayList<>();
        int i = dataDao.getNextIdxOfSize();
        for (SizeVo vo : sizeVos) {
            PdParam param = castSize(vo);
            param.setIdx(i++);
            params.add(param);
        }
        return params;
    }

    @SneakyThrows
    public PdParam castSize(SizeVo vo) {
        PdParam param = new PdParam();
        param.setType(ParamType.size.value());
        param.setName(vo.getDesc());
        param.setCode(vo.getCode());
        param.setIdx(vo.getIdx());
        param.setGp(vo.getRemark());
        param.setRel(vo.getStd());
        return param;
    }

    @SneakyThrows
    private void addInfo(List<PdInfo> infos, PdInfo info) {
        boolean add = false;
        if (StringUtils.isNotBlank(info.getTemperature())) {
            //有温度特性是多选的情况，这里拆分成多条数据
            String[] ss = StringUtils.split(info.getTemperature(), ";");
            if (ss.length > 1) {
                add = true;
                for (String s : ss) {
                    PdInfo pdinfo = new PdInfo();
                    BeanUtils.copyProperties(pdinfo, info);
                    pdinfo.setTemperature(s);
                    infos.add(pdinfo);
                }
            }
        }

        //同温度相同的处理方式
        if (StringUtils.isNotBlank(info.getElecCode())){
            String[] ss = StringUtils.split(info.getElecCode(), ";");
            if (ss.length > 1) {
                add = true;
                for (String s : ss) {
                    PdInfo pdinfo = new PdInfo();
                    BeanUtils.copyProperties(pdinfo, info);
                    pdinfo.setElecCode(s);
                    infos.add(pdinfo);
                }
            }
        }

        if (!add) {
            infos.add(info);
        }
    }

    public Map<String, Object> castPdInfo(List<DataRuleVo> dataRuleVos, List<PinVo> pinVos, List<MutilVo> mutilVos, List<SingleVo> singleVos, List<HKIVo> hkiVos, List<ThreeVo> threeVos, List<TerVo> terVos, List<HeartVo> heartVos, List<PDHKLBPFInfoVo>LBPFVos, List<PDHKLLPFInfoVo>LLPEVos, List<PDLHPFInfoVo>LHPFVos, List<PDJLTCInfoVo>JLTCVos, List<PDCSInfoVo> pdcsInfoVos, List<PDPorcelainInfoVo> pdPorcelainInfoVos, List<PDSizingMaterialInfoVo> pdSizingMaterialInfoVos , List<PDRawPorcelainWithInfoVo> rawPorcelainWithInfoVos) {
        HashMap<String, Object> result = new HashMap<>();
        List<PdInfo> infos = new ArrayList<>();
        result.put("pdInfo", infos);
        Map<String, PdModel> modelMap = buildModelMap();
        Set<String> set = new LinkedHashSet<>();

        for (DataRuleVo vo : dataRuleVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PinVo vo : pinVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);

        }
        for (MutilVo vo : mutilVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (SingleVo vo : singleVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (HKIVo vo : hkiVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (ThreeVo vo : threeVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (TerVo vo : terVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);

            addInfo(infos, info);
        }
        for (HeartVo vo : heartVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDHKLBPFInfoVo vo :LBPFVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDHKLLPFInfoVo vo : LLPEVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDLHPFInfoVo vo : LHPFVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for (PDJLTCInfoVo vo : JLTCVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.hasModel);
            addInfo(infos, info);
        }
        for(PDCSInfoVo vo : pdcsInfoVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDRawPorcelainWithInfoVo  vo: rawPorcelainWithInfoVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDSizingMaterialInfoVo vo : pdSizingMaterialInfoVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
            addInfo(infos, info);
        }
        for (PDPorcelainInfoVo vo : pdPorcelainInfoVos) {
            PdInfo info = castPdInfo(vo);
            isModel(set,modelMap,info,IsModelEnum.notModel);
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
        //init capacity idx
        Map<String, Integer> capMap = this.buildCapacityMap(capacities);
        for (PdInfo info : infos) {
            //TODO cap my be null
            if (StringUtils.isNotBlank(info.getCapacityMin())) {
                info.setCapacityMinIdx(capMap.get(info.getCapacityMin()));
                info.setCapacityMaxIdx(capMap.get(info.getCapacityMax()));
            }
        }

        for (PdInfo info : infos) {
            if (StringUtils.isNotBlank(info.getTolerance())) {
                info.setTolerance(";" + info.getTolerance() + ";");
            }
            if (StringUtils.isNotBlank(info.getOutlet())) {
                info.setOutlet(";" + info.getOutlet() + ";");
            }
            if (StringUtils.isNotBlank(info.getWireMa())) {
                info.setWireMa(";" + info.getWireMa() + ";");
            }
            if (StringUtils.isNotBlank(info.getWireSize())) {
                info.setWireSize(";" + info.getWireSize() + ";");
            }
            if (StringUtils.isNotBlank(info.getPin())){
                info.setPin(";" + info.getPin() + ";");
            }
            String key = infoService.buildFtIndex(info, capacities);
            info.setSearchKey(key);
        }
        return result;
    }

    private Map<String, PdModel> buildModelMap() {
        List<PdModel> models = modelDao.list();
        Map<String, PdModel> modelMap = new HashMap<>();
        for (PdModel model : models) {
            String qaCode = model.getQaCode();
            String[] qas = StringUtils.split(qaCode, ";");
            for (String qa : qas) {
                String key = model.getCode() + "|" + qa;
                modelMap.put(key, model);
            }
        }
        return modelMap;
    }

//    private Map<String, PdModel> buildModelMap() {
//        List<ClassVo> classVos = dataDao.getDataMapper().listClz();
//        Map<Long, List<ClassVo>> clzMap = new HashMap<>();
//        for (ClassVo vo : classVos) {
//            Long key = vo.getId();
//            List<ClassVo> clzs = clzMap.get(key);
//            if (clzs == null) {
//                clzs = new ArrayList<>();
//                clzMap.put(key, clzs);
//            }
//            clzs.add(vo);
//        }
//        List<PdModel> models = modelDao.list();
//        Map<String, PdModel> modelMap = new HashMap<>();
//        for (PdModel model : models) {
//            String key = model.getCode();
////            modelMap.put(key, model);
//            List<ClassVo> clzs = clzMap.get(model.getPdClassId());
//            //todo ???
//            if (clzs != null) {
//                for (ClassVo clz : clzs) {
//                    modelMap.put(key + "|" + clz.getQa(), model);
//                }
//            }
//        }
//        return modelMap;
//    }


    public List<PdParam> castWireMa(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getWireMa();
            if (StringUtils.isNotBlank(code)) {
                String[] codes = StringUtils.split(code, ";");
                for (String s : codes) {
                    if (!params.containsKey(s)) {
                        PdParam param = new PdParam();
                        param.setIdx(++i);
                        param.setType(ParamType.wireMa.value());
                        param.setName(null);//TODO ???
                        param.setCode(s);
                        params.put(s, param);
                    }
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castWireSize(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getWireSize();
            if (StringUtils.isNotBlank(code)) {
                String[] codes = StringUtils.split(code, ";");
                for (String s : codes) {
                    if (!params.containsKey(s)) {
                        PdParam param = new PdParam();
                        param.setIdx(++i);
                        param.setType(ParamType.wireSize.value());
                        param.setName(null);//TODO ???
                        param.setCode(s);
                        params.put(s, param);
                    }
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castPin(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getPin();
            if (StringUtils.isNotBlank(code)) {
                String[] codes = StringUtils.split(code, ";");
                for (String s : codes) {
                    if (!params.containsKey(s)) {
                        PdParam param = new PdParam();
                        param.setIdx(++i);
                        param.setType(ParamType.pin.value());
                        param.setName(null);//TODO ???
                        param.setCode(s);
                        params.put(s, param);
                    }
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castElecCode(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getElecCode();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.elecCode.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castCapNum(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getCapNum();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.capNum.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castElecType(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getElecType();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.elecType.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castTemperRange(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getTemperRange();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.temperRange.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castElecSer(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getElecSer();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.elecSer.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castSocStr(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getSocStr();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.socStr.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    public List<PdParam> castPackType(List<PdInfo> infos) {
        Map<String, PdParam> params = new LinkedHashMap<>();
        int i = 0;
        for (PdInfo info : infos) {
            String code = info.getPackType();
            if (StringUtils.isNotBlank(code)) {
                if (!params.containsKey(code)) {
                    PdParam param = new PdParam();
                    param.setIdx(++i);
                    param.setType(ParamType.packType.value());
                    param.setName(null);//TODO ???
                    param.setCode(code);
                    params.put(code, param);
                }
            }
        }
        return new ArrayList<>(params.values());
    }

    private Map<String, Integer> buildCapacityMap(List<PdParam> capacities) {
        Map<String, Integer> capacityMap = new HashMap<>();
        for (PdParam capacity : capacities) {
            capacityMap.put(capacity.getCode(), capacity.getIdx());
        }
        return capacityMap;
    }

    //hki的不加v
    public void addV(PdInfo pdInfo) {
        if (pdInfo.getVoltage() != null && !StringUtils.contains(pdInfo.getVoltage().toUpperCase(), "V")) {
            pdInfo.setVoltage(pdInfo.getVoltage() + "V");
        }
    }

    @SneakyThrows
    public PdInfo castPdInfo(DataRuleVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(PinVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(MutilVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(SingleVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(HKIVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(ThreeVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(TerVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

    @SneakyThrows
    public PdInfo castPdInfo(HeartVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDJLTCInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDLHPFInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDHKLLPFInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDHKLBPFInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDCSInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDPorcelainInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDRawPorcelainWithInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }
    @SneakyThrows
    public PdInfo castPdInfo(PDSizingMaterialInfoVo vo) {
        PdInfo pdInfo = new PdInfo();
        BeanUtils.copyProperties(pdInfo, vo);
        addV(pdInfo);
        return pdInfo;
    }

}
