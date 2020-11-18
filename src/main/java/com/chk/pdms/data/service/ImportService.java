package com.chk.pdms.data.service;

import com.alibaba.excel.EasyExcel;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.dao.DataDao;
import com.chk.pdms.data.vo.*;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.vo.PdInfoVo;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class ImportService {

    private Logger log = LoggerFactory.getLogger(ImportService.class);

    @Autowired
    private ClassService classService;

    @Autowired
    private CastService castService;

    @Autowired
    private DataDao dataDao;

    /**
     * 全量导入clz，会先删除已存在的所有clz
     */
    public void importClz(String path) {
        List<ClassVo> classVos = EasyExcel.read(path).head(ClassVo.class).sheet().doReadSync();
        classService.importClz(classVos);
    }

    /**
     * 每个sheet上有订货标识，通过每个产品数据sheet的mode+std, 反推出该型号的订货标识。
     * 通过lev1,lev2,lev3,lev4与产品分类关联上
     *
     * @param path
     * @param clear
     * @param dataRuleVos
     * @param pinVo
     * @param mutilVos
     * @param singleVos
     * @param hkiVos
     * @param threeVos
     * @param terVos
     * @param heartVos
     */
    public void importModel(String path, boolean clear, List<DataRuleVo> dataRuleVos, List<PinVo> pinVo, List<MutilVo> mutilVos, List<SingleVo> singleVos, List<HKIVo> hkiVos, List<ThreeVo> threeVos, List<TerVo> terVos, List<HeartVo> heartVos) {
        List<ModelVo> modelVos = EasyExcel.read(path).head(ModelVo.class).sheet(ModelVo.sheet).doReadSync();
        List<PdModel> models = castService.castPdModel(modelVos, dataRuleVos, pinVo, mutilVos, singleVos, hkiVos, threeVos, terVos, heartVos);
        if (clear) {
            dataDao.deleteModel();
        }
        dataDao.getDataMapper().insertModel(models);
    }

    /**
     * 通过model+std+qa, 与产品型号关联上
     *
     * @param path
     * @param clear 清空原有数据
     * @Param checkDup 检查是否有重复数据
     */
    public Map<String, Object> importInfo(String path, boolean checkDup, boolean clear) {
        Map<String, Object> result = new HashMap<>();
//        产品数据规则
        List<DataRuleVo> dataRuleVos = EasyExcel.read(path).head(DataRuleVo.class).sheet(DataRuleVo.sheet).doReadSync();
//        多芯组
        List<PinVo> pinVo = EasyExcel.read(path).head(PinVo.class).sheet(PinVo.sheet).doReadSync();
//        多层芯片
        List<MutilVo> mutilVos = EasyExcel.read(path).head(MutilVo.class).sheet(MutilVo.sheet).doReadSync();
//        单层芯片
        List<SingleVo> singleVos = EasyExcel.read(path).head(SingleVo.class).sheet(SingleVo.sheet).doReadSync();
//        HKI
        List<HKIVo> hkiVos = EasyExcel.read(path).head(HKIVo.class).sheet(HKIVo.sheet).doReadSync();
//        三端
        List<ThreeVo> threeVos = EasyExcel.read(path).head(ThreeVo.class).sheet(ThreeVo.sheet).doReadSync();
//        接线端子
        List<TerVo> terVos = EasyExcel.read(path).head(TerVo.class).sheet(TerVo.sheet).doReadSync();
//        穿心
        List<HeartVo> heartVos = EasyExcel.read(path).head(HeartVo.class).sheet(HeartVo.sheet).doReadSync();

        //增量导入不处理型号
        //importModel(path, clear, dataRuleVos,pinVo,mutilVos, singleVos, hkiVos, threeVos, terVos, heartVos);

        Map<String, Object> map = castService.castPdInfo(dataRuleVos, pinVo, mutilVos, singleVos, hkiVos, threeVos, terVos, heartVos);
        Set<String> noModelInfo = (Set<String>) map.get("noModelInfo");
        if(noModelInfo.size() > 0){
            result.put("code", "1000");
            result.put("noModelInfo", noModelInfo);
            return result;
        }

        List<PdInfo> infos = (List<PdInfo>) map.get("pdInfo");
        int dupCount = 0;
        if (checkDup) {
            for (PdInfo info : infos) {
                List<PdInfoVo> vos = dataDao.getDataMapper().get(info);
                if (vos.size() >= 0) {
                    dupCount++;
                }
            }
        }
        log.info("info dupCount = {}", dupCount);

        if (clear) {
            dataDao.deleteInfo();
        }
        List<List<PdInfo>> partition = ListUtils.partition(infos, 500);
        for (List<PdInfo> par : partition) {
            dataDao.getDataMapper().insertInfo(par);
        }
        result.put("code", "200");
        result.put("num", infos.size());
        return result;
    }

    /**
     * 导入尺寸
     *
     * @param path
     * @param clear 是否清空原有的尺寸
     */
    public void importSize(String path, boolean clear) {
        List<SizeVo> sizeVos = EasyExcel.read(path).head(SizeVo.class).sheet(SizeVo.sheet).doReadSync();
        List<PdParam> size = castService.castSize(sizeVos);
        if (clear) {
            dataDao.deleteParam(ParamType.size.value());
        }
        dataDao.getDataMapper().insertParam(size);
    }

    @Transactional
    public void init() {
        String clzPath = "C:\\Users\\admin\\Desktop\\new\\旧APP产品分类表-建议新分类对应表20200220.xlsx";

//        String path = "C:\\Users\\admin\\Desktop\\new\\合并总（徐琴返）20200224.xlsx";
        String path = "C:\\Users\\admin\\Desktop\\new\\合并总（徐琴返）20200229-补充宇标.xlsx";

//
        //执行标准从model中获取
//        List<PdParam> std = castService.castStd(models);
//        List<PdParam> noExist = listNotExistParam("执行标准", std);
//        dataDao.deleteParam(ParamType.std.value());
//        dataDao.getDataMapper().insertParam(std);
//
//        //温度特性
//        List<PdParam> temperature = castService.castTemperature(infos);
//        dataDao.deleteParam(ParamType.temperature.value());
//        dataDao.getDataMapper().insertParam(temperature);
//        //精度
//        List<PdParam> tolerance = castService.castTolerance(infos);
//        dataDao.deleteParam(ParamType.tolerance.value());
//        dataDao.getDataMapper().insertParam(tolerance);
//
//        //引出端
//        List<PdParam> outlet = castService.castOutlet(infos);
//        dataDao.deleteParam(ParamType.outlet.value());
//        dataDao.getDataMapper().insertParam(outlet);
//
//        //电压
//        List<PdParam> voltage = castService.castVoltage(infos);
//        dataDao.deleteParam(ParamType.voltage.value());
//        dataDao.getDataMapper().insertParam(voltage);

        //质量等级
//        List<PdParam> quality = castService.castQuality();
//        dataDao.deleteParam(ParamType.quality.value());
//        dataDao.getDataMapper().insertParam(quality);

//        //电极材料代码
//        List<PdParam> elecCode = castService.castElecCode(infos);
//        dataDao.deleteParam(ParamType.elecCode.value());
//        dataDao.getDataMapper().insertParam(elecCode);
//
//        //电容数量
//        List<PdParam> capNum = castService.castCapNum(infos);
//        dataDao.deleteParam(ParamType.capNum.value());
//        dataDao.getDataMapper().insertParam(capNum);
//
//        //电路形式
//        List<PdParam> elecType = castService.castElecType(infos);
//        dataDao.deleteParam(ParamType.elecType.value());
//        dataDao.getDataMapper().insertParam(elecType);
//
//        //工作温度范围
//        List<PdParam> temperRange = castService.castTemperRange(infos);
//        dataDao.deleteParam(ParamType.temperRange.value());
//        dataDao.getDataMapper().insertParam(temperRange);
//
//        //引线材质
//        List<PdParam> wireMa = castService.castWireMa(infos);
//        dataDao.deleteParam(ParamType.wireMa.value());
//        dataDao.getDataMapper().insertParam(wireMa);
//
//        //引线长短
//        List<PdParam> wireSize = castService.castWireSize(infos);
//        dataDao.deleteParam(ParamType.wireSize.value());
//        dataDao.getDataMapper().insertParam(wireSize);
//
//        //电流系列
//        List<PdParam> elecSer = castService.castElecSer(infos);
//        dataDao.deleteParam(ParamType.elecSer.value());
//        dataDao.getDataMapper().insertParam(elecSer);
//
//        //端头结构
//        List<PdParam> socStr = castService.castSocStr(infos);
//        dataDao.deleteParam(ParamType.socStr.value());
//        dataDao.getDataMapper().insertParam(socStr);
//
//        //包装方式
//        List<PdParam> packType = castService.castPackType(infos);
//        dataDao.deleteParam(ParamType.packType.value());
//        dataDao.getDataMapper().insertParam(packType);
//
//        //引脚形状
//        List<PdParam> pin = castService.castPin(infos);
//        dataDao.deleteParam(ParamType.pin.value());
//        dataDao.getDataMapper().insertParam(pin);
//
//        System.out.println("123");
        //容量 用原来的
    }

    private List<PdParam> listNotExistParam(String type, List<PdParam> params) {
        if (CollectionUtils.isEmpty(params)) {
            return params;
        }
        List<String> codes = new ArrayList<>();
        for (PdParam p : params) {
            codes.add(p.getCode());
        }
        List<PdParam> exist = dataDao.list(type, codes);
        Map<String, PdParam> existMap = new HashMap<>();
        for (PdParam param : exist) {
            existMap.put(param.getCode(), param);
        }
        List<PdParam> rsp = new ArrayList<>();
        for (PdParam param : params) {
            if (!existMap.containsKey(param.getCode())) {
                rsp.add(param);
            }
        }
        return rsp;
    }
}
