package com.chk.pdms.pd.service;

import com.alibaba.excel.EasyExcel;
import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.dao.dictDao;
import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.common.utils.IKUtil;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.ExportPdDetailReq;
import com.chk.pdms.data.service.ImportService;
import com.chk.pdms.pd.dao.PdClassDao;
import com.chk.pdms.pd.dao.PdInfoDao;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.dao.PdParamDao;
import com.chk.pdms.pd.domain.*;
import com.chk.pdms.pd.vo.*;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.expression.Lists;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PdInfoService {

    private Logger log = LoggerFactory.getLogger(PdInfoService.class);

    @Autowired
    private PdInfoDao infoDao;

    @Autowired
    private PdModelDao modelDao;

    @Autowired
    private PdClassDao classDao;

    @Autowired
    private PdParamDao pdParamDao;

    @Autowired
    private ImportService importService;

    @Autowired
    private PdClassService pdClassService;
    @Autowired
    private dictDao dict;


    @Value("${virtual.filePath}")
    private String filePath;

    public Page<PdInfoVo> list(String key, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        key = IKUtil.analyzWithSymbol(key, "+");
        List<PdInfoVo> pdInfos = infoDao.getExtInfoMapper().list(key);

        return new Page(pdInfos);
    }

    @SneakyThrows
    public PdInfoVo get(Long id) {
        PdInfo info = infoDao.getInfoMapper().selectByPrimaryKey(id);
        PdModel model = modelDao.getModelMapper().selectByPrimaryKey(info.getPdModelId());
        PdInfoVo vo = new PdInfoVo();
        vo.setPmName(model.getName());
        vo.setPmCode(model.getCode());
        vo.setPdClassId(model.getPdClassId());
        BeanUtils.copyProperties(vo, info);
        return vo;
    }

    /**
     * 获取某系列的产品集合list
     * @param modelId
     * @return
     */
    @SneakyThrows
    public List<PdInfo> getPdsByModelId(Long modelId) {
        PdInfoExample infoExample= new PdInfoExample();
        infoExample.createCriteria().andPdModelIdEqualTo(modelId);
        List<PdInfo> vo = infoDao.getInfoMapper().selectByExample(infoExample);
        return vo;
    }
    public PdDetail getPdDetail(ExportPdDetailReq req) {
        PdInfo pdInfo = infoDao.getInfoMapper().selectByPrimaryKey(req.getId());

        PdModel pdModel = modelDao.getModelMapper().selectByPrimaryKey(pdInfo.getPdModelId());

        PdClass pdClass = classDao.getClassMapper().selectByPrimaryKey(pdModel.getPdClassId());

        PdParam size = pdParamDao.getSize(pdInfo.getStd(), pdInfo.getSize());
        PdParam quality = pdParamDao.getPdParam(ParamType.quality.value(), pdInfo.getQuality());
        PdParam temperature = pdParamDao.getPdParam(ParamType.temperature.value(), pdInfo.getTemperature());

        List<PdParam> tolerances = getTolerance(req, pdInfo);
        List<PdParam> outlets = getOutlet(req, pdInfo);
        List<PdParam> capacities = getCapacity(req, pdInfo);
        /**
         * 返回""
         */
        String pdf=getpdf("");

        PdDetail detail = new PdDetail(pdClass, pdf, pdModel, pdInfo, size, quality, temperature, tolerances, outlets, capacities, req);
        return detail;
    }

    private String getpdf(String className) {

        List<DictDO> dicts = dict.listByType("打开PDF的产品分类");
//        对应名称
        List<DictDO> dict2 = dict.listByType("应用指南");
//        1.
//        2.
//        3.
        Map<String,DictDO> pdfClz = new HashMap();
        for (DictDO dictitem : dicts) {
            pdfClz.put(dictitem.getName(), dictitem);
        }

        if (pdfClz.containsKey(className)) {
          return pdfClz.get(className).getValue();
        } else {

            return "";
        }

    }

    private List<PdParam> getTolerance(ExportPdDetailReq req, PdInfo pdInfo) {
        List<PdParam> tolerances = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getTolerance())) {
            List<String> codes;
            if (StringUtils.isNotBlank(req.getTolerance())){
                codes = Arrays.asList(new String[]{req.getTolerance()});
            }else{
                codes = Arrays.asList(StringUtils.split(pdInfo.getTolerance(), ";"));
            }
            tolerances = pdParamDao.getPdParam(ParamType.tolerance.value(), codes);
        }
        return tolerances;
    }

    private List<PdParam> getOutlet(ExportPdDetailReq  req, PdInfo pdInfo) {
        List<PdParam> outlets = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getOutlet())) {
            List<String> codes;
            if (StringUtils.isNotBlank(req.getOutlet())){
                codes = Arrays.asList(new String[]{req.getOutlet()});
            }else{
                codes = Arrays.asList(StringUtils.split(pdInfo.getOutlet(), ";"));
            }
            outlets = pdParamDao.getPdParam(ParamType.outlet.value(), codes);
        }
        return outlets;
    }

    private List<PdParam> getCapacity(ExportPdDetailReq  req, PdInfo pdInfo) {
        List<PdParam> capacities;
        if (StringUtils.isNotBlank(req.getCapacity())){
            capacities = pdParamDao.getCapacities(Integer.valueOf(req.getCapacity()), Integer.valueOf(req.getCapacity()));
        }else{
            capacities = pdParamDao.getCapacities(pdInfo.getCapacityMinIdx(), pdInfo.getCapacityMaxIdx());
        }
        return capacities;
    }

    @Transactional
    public void save(PdInfo info) {
        if (StringUtils.isNotBlank(info.getTolerance())) {
            info.setTolerance(";" + StringUtils.replace(info.getTolerance(), ",", ";") + ";");
        }
        if (StringUtils.isNotBlank(info.getOutlet())) {
            info.setOutlet(";" + StringUtils.replace(info.getOutlet(), ",", ";") + ";");
        }
        if (StringUtils.isNotBlank(info.getWireMa())) {
            info.setWireMa(";" + StringUtils.replace(info.getWireMa(), ",", ";") + ";");
        }
        if (StringUtils.isNotBlank(info.getWireSize())) {
            info.setWireSize(";" + StringUtils.replace(info.getWireSize(), ",", ";") + ";");
        }
        if (StringUtils.isNotBlank(info.getPin())) {
            info.setPin(";" + StringUtils.replace(info.getPin(), ",", ";") + ";");
        }
        buildFtIndex(info);
        if (info.getId() == null) {
            infoDao.getInfoMapper().insert(info);
        } else {
            infoDao.getInfoMapper().updateByPrimaryKey(info);
        }
    }

    @Transactional
    public void delete(Long id) {
        infoDao.getInfoMapper().deleteByPrimaryKey(id);
    }

    @SneakyThrows
    private String buildFtIndex(PdInfo info) {
        List<PdParam> capacities = pdParamDao.getCapacities(info.getCapacityMinIdx(), info.getCapacityMaxIdx());
        return buildFtIndex(info, capacities);
    }

    @SneakyThrows
    public String buildFtIndex(PdInfo info, List<PdParam> capacities) {
        PdFtVo ft = new PdFtVo();
        BeanUtils.copyProperties(ft, info);
        if (info.getCapacityMinIdx() != null && info.getCapacityMaxIdx() != null) {
            String capacity = getCapacities(capacities, info.getCapacityMinIdx(), info.getCapacityMaxIdx());
            ft.setCapacity(capacity);
        }
        String kw = buildFt(ft);
        info.setSearchKey(kw);
        return kw;
    }

    private String buildFt(PdFtVo ft) {
        StringBuilder key = new StringBuilder();
//        Set<String> set = new HashSet<>();
//        appendKey(set, IKUtil.analyzList(ft.getPcName()));
//        appendKey(set, IKUtil.analyzList(ft.getPmName()));
//        appendKey(set, IKUtil.analyzList(ft.getPmPurpose()));
//        appendKey(set, IKUtil.analyzList(ft.getPmFeature()));
//        appendKey(set, IKUtil.analyzList(StringUtils.split(ft.getPmCode(), "|")[0]));
//        for (String s : set) {
//            appendKey(key, s, " ");
//        }

        appendKey(key, ft.getModel());
        appendKey(key, ft.getStd());
        appendKey(key, ft.getQuality());
        appendKey(key, ft.getSize());
        appendKey(key, ft.getTemperature());
        appendKey(key, ft.getVoltage());
        appendKey(key, ft.getCapacity());
        appendKey(key, ft.getElecCode());
        appendKey(key, ft.getCapNum());
        appendKey(key, ft.getElecType());
        appendKey(key, ft.getTemperRange());
        appendKey(key, ft.getElecSer());
        appendKey(key, ft.getSocStr());
        appendKey(key, ft.getPackType());
        appendKey(key, StringUtils.replace(ft.getTolerance(), ";", " "));
        appendKey(key, StringUtils.replace(ft.getOutlet(), ";", " "));
        appendKey(key, StringUtils.replace(ft.getWireMa(), ";", " "));
        appendKey(key, StringUtils.replace(ft.getWireSize(), ";", " "));
        appendKey(key, StringUtils.replace(ft.getPin(), ";", " "));
        String kw = StringUtils.replace(key.toString(), " |", "|");
        kw = StringUtils.replace(kw, "| ", "|").trim();
        return kw;
    }

    private String getCapacities(List<PdParam> capacities, int min, int max) {
        StringBuilder sb = new StringBuilder();
        for (PdParam capacity : capacities) {
            if (capacity.getIdx() >= min && capacity.getIdx() <= max) {
                sb.append(capacity.getCode()).append(" ");
            }
        }
        return sb.toString().trim();
    }

    @Transactional
    public void buildFtIndex() {
        Long start = System.currentTimeMillis();
        log.info("buildPdFtIndex start...");
        LinkedList<PdParam> capacity = new LinkedList<>(pdParamDao.getPdPrams(ParamType.capacity.value()));
        int pageNum = 1;
        int pageSize = 1000;
        int total = 0;
        List<PdFtVo> pdFtVos = null;
        for (; ; pageNum++) {
            log.info("buildFtIndex pageNum: {}， pageSize: {}", pageNum, pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<PdSkVo> pdsks = new ArrayList<>();
            pdFtVos = infoDao.getExtInfoMapper().listFt();
            for (PdFtVo ft : pdFtVos) {
                if(ft.getCapacityMinIdx() != null && ft.getCapacityMaxIdx() != null)
                ft.setCapacity(getCapacities(capacity, ft.getCapacityMinIdx(), ft.getCapacityMaxIdx()));
                String kw = this.buildFt(ft);
                pdsks.add(new PdSkVo(ft.getId(), kw));
            }
            infoDao.getExtInfoMapper().updateSearchKey(pdsks);
            total += pdFtVos.size();
            if (pdFtVos.size() < pageSize) {
                break;
            }
        }
        log.info("update pd ft total {}", total);
        log.info("buildPdFtIndex end, used time : {}ms", System.currentTimeMillis() - start);
    }

    private StringBuilder appendKey(StringBuilder sb, String s) {
        return appendKey(sb, s, "|");
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

    @SneakyThrows
    @Transactional
    public ImportDataVo importData(ImportDataVo vo) {
        String file = FileUtil.transferTo(vo.getData(), filePath, "import-data/info");
        String path = filePath + file.replace("/files", "");
        Map<String, Object> map = importService.importInfo(path, false, false);
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

    public List<PdInfo> getAll() {
        return infoDao.getExtInfoMapper().listAll();
    }

    public List<PdInfo> getLTCC() {
        List<PdInfo> res=new ArrayList<>();
        Set<Long> pdModelList;
        PdModelExample modelExample= new PdModelExample();
        List<Long> pdclass= new ArrayList<>();

        pdclass= pdClassService.list(3L).stream().map(r->r.getId()).collect(Collectors.toList());

        modelExample.createCriteria().andPdClassIdIn(pdclass);
        pdModelList= modelDao.getModelMapper().selectByExample(modelExample).stream().map(r->r.getId()).collect(Collectors.toSet());


        List<PdInfo> pdInfoList= infoDao.getExtInfoMapper().listAll();

        for(int i=0;i<pdInfoList.size();i++){
           if(pdModelList.contains(pdInfoList.get(i).getPdModelId())){
               res.add(pdInfoList.get(i));
           }
        }
        return res;
    }
    public List<PdInfo> getEMI() {
        List<PdInfo> res=new ArrayList<>();
        Set<Long> pdModelList;
        PdModelExample modelExample= new PdModelExample();
        List<Long> pdclass= new ArrayList<>();

//        pdclass= pdClassService.list(2L).stream().map(r->r.getId()).collect(Collectors.toList());
        pdclass= pdClassService.list2(4L).stream().map(r->r.getId()).collect(Collectors.toList());

        modelExample.createCriteria().andPdClassIdIn(pdclass);
        pdModelList= modelDao.getModelMapper().selectByExample(modelExample).stream().map(r->r.getId()).collect(Collectors.toSet());


        List<PdInfo> pdInfoList= infoDao.getExtInfoMapper().listAll();

        for(int i=0;i<pdInfoList.size();i++){
            if(pdModelList.contains(pdInfoList.get(i).getPdModelId())){
                res.add(pdInfoList.get(i));
            }
        }
        return res;
    }

    public List<PdInfo> getPorcelainDielectric() {
        List<PdInfo> res=new ArrayList<>();
        Set<Long> pdModelList;
        PdModelExample modelExample= new PdModelExample();
        List<Long> pdclass= new ArrayList<>();

        pdclass= pdClassService.list(1L).stream().map(r->r.getId()).collect(Collectors.toList());

        modelExample.createCriteria().andPdClassIdIn(pdclass);
        pdModelList= modelDao.getModelMapper().selectByExample(modelExample).stream().map(r->r.getId()).collect(Collectors.toSet());


        List<PdInfo> pdInfoList= infoDao.getExtInfoMapper().listAll();

        for(int i=0;i<pdInfoList.size();i++){
            if(pdModelList.contains(pdInfoList.get(i).getPdModelId())){
                res.add(pdInfoList.get(i));
            }
        }
        return res;
    }
    public List<PdInfo> getPdinfoModel(Long modelId){
        List<PdInfo> res=new ArrayList<>();
        PdInfoExample example= new PdInfoExample();
        example.createCriteria().andPdModelIdEqualTo(modelId);
        res= infoDao.getInfoMapper().selectByExample(example);
        return  res;
    }
//    @Deprecated
//    @SneakyThrows
//    @Transactional
//    public String importData() {
//        String path = "e:/常规电压低频数据规格表20200217.xlsx";
//        List<PdClass> list = classDao.list();
//        Map<Long, PdClass> clzMap = new HashMap<>();
//        for (PdClass clz : list) {
//            clzMap.put(clz.getId(), clz);
//        }
//        List<PdModel> models = modelDao.list();
//        Map<String, PdModel> modelMap = new HashMap<>();
//        for (PdModel model : models) {
//            modelMap.put(model.getCode(), model);
//        }
//        List<PdParam> params = pdParamDao.getPdPrams(ParamType.size.value());
//        Map<String, Map<String, PdParam>> sizeMap = new HashMap<>();
//        for (PdParam size : params) {
//            String key = size.getGp() + "_" + size.getRel();
//            Map<String, PdParam> map = sizeMap.get(key);
//            if (map == null) {
//                map = new HashMap<>();
//                sizeMap.put(key, map);
//            }
//            map.put(size.getCode(), size);
//        }
//
//        List<PdParam> capacities = pdParamDao.getPdPrams(ParamType.capacity.value());
//        Map<String, Integer> capacityMap = new HashMap<>();
//        for (PdParam capacity : capacities) {
//            capacityMap.put(capacity.getCode(), capacity.getIdx());
//        }
//
//        List<PdInfoExcel> excels = EasyExcel.read(path).head(PdInfoExcel.class).sheet().doReadSync();
//        List<PdInfo> infos = new ArrayList<>();
//        for (PdInfoExcel excel : excels) {
//            PdInfo info = new PdInfo();
//            BeanUtils.copyProperties(info, excel);
//            String modelName = excel.getModelName() + "|" + excel.getStd();
//            PdModel model = modelMap.get(modelName);
//            if (model == null) {
//                return "型号表中未找到型号:[" + excel.getModelName() + "|" + excel.getStd() + "]";
//            }
//            info.setPdModelId(model.getId());
//
////            String clzName = clzMap.get(model.getPdClassId()).getName();
//            String clzName = "多层片式瓷介电容器";
//            String key = clzName + "_" + excel.getStd();
//            Map<String, PdParam> sizes = sizeMap.get(key);
//            if (sizes == null) {
//                return "参数表中未定义分类[" + key + "]的[" + excel.getSize() + "]尺寸";
//            }
//            PdParam size = sizes.get(excel.getSize());
//            if (size == null) {
//                return "参数表中未定义分类[" + key + "]的[" + excel.getSize() + "]尺寸";
//            }
////            info.setPdSizeId(size.getId());
//            Integer min = capacityMap.get(excel.getCapacityMin());
//            if (min == null) {
//                return "参数表中未定义容量[" + excel.getCapacityMin() + "]";
//            }
//            Integer max = capacityMap.get(excel.getCapacityMax());
//            if (max == null) {
//                return "参数表中未定义容量[" + excel.getCapacityMax() + "]";
//            }
//            info.setCapacityMinIdx(min);
//            info.setCapacityMaxIdx(max);
//
//
//            String capacity = getCapacities(capacities, info.getCapacityMinIdx(), info.getCapacityMaxIdx());
//            PdFtVo ft = new PdFtVo();
//            BeanUtils.copyProperties(ft, info);
//            ft.setPcName(clzName);
//            ft.setPmCode(model.getCode());
//            ft.setPmName(model.getName());
////            ft.setPmPurpose(model.getPurpose());
////            ft.setPmFeature(model.getFeature());
//            ft.setCapacity(capacity);
//            String kw = buildFt(ft);
//            info.setSearchKey(kw);
//            infos.add(info);
//        }
//
//        if (infos.size() > 0) {
//            log.info("pd info total : {}", infos.size());
//            List<List<PdInfo>> partition = ListUtils.partition(infos, 500);
//            for (List<PdInfo> pdInfos : partition) {
//                log.info("import pd info {} :", pdInfos);
//                infoDao.getExtInfoMapper().insert(pdInfos);
//            }
//        }
//        return "200";
//    }
}
