//package com.chk.pdms.data.utils;
//
//import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
//import com.chk.pdms.common.utils.OrderRuleUtil;
//import com.chk.pdms.common.vo.ParamType;
//import com.chk.pdms.data.ExportPdDetailReq;
//import com.chk.pdms.data.PdDetailExcel;
//import com.chk.pdms.pd.dao.PdParamDao;
//import com.chk.pdms.pd.domain.PdDetail;
//import com.chk.pdms.pd.domain.PdInfo;
//import com.chk.pdms.pd.domain.PdModel;
//import com.chk.pdms.pd.domain.PdParam;
//import com.chk.pdms.pd.service.PdInfoService;
//import com.chk.pdms.pd.service.PdModelService;
//import com.chk.pdms.pd.vo.CasRsp;
//import com.chk.pdms.pd.vo.SelRsp;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//public class OrderRuleStringUtil<T> {
//
//    @Autowired
//    private PdInfoService pdInfoService;
//
//    @Autowired
//    private PdModelService pdModelService;
//
//    @Autowired
//    private PdParamDao pdParamDao;
//
//    private PdDetail  pdDetail;
//
//
//    OrderRuleStringUtil(PdDetail  pdDetail){
//        this.pdDetail=pdDetail;
//    }
//
//    public   List<String> exportPdList(){
//
//
//        List<String> list=new ArrayList<>();
//
//
//        return list ;
//    }
//    public  String  setRule(PdInfo pdInfo, PdModel model, ExportPdDetailReq req) {
//        String rule = getOrderRule(model,pdInfo);
//        String pd = replace(rule, "|", "");
//        pd = replace(pd, ParamType.quality.value(), pdInfo.getQuality());
//        pd = replace(pd, ParamType.std.value(), pdInfo.getStd());
//        pd = replace(pd, ParamType.size.value(), pdInfo.getSize());
//        pd = replace(pd, ParamType.temperature.value(), pdInfo.getTemperature());
//        pd = replace(pd, ParamType.voltage.value(), pdInfo.getVoltage());
//        pd = replace(pd, ParamType.model.value(), pdInfo.getModel());
//        pd = OrderRuleUtil.resetSingleModel(pd, pdInfo.getModel());
//        pd = replace(pd, ParamType.elecCode.value(), pdInfo.getElecCode());
//        pd = replace(pd, ParamType.elecType.value(), pdInfo.getElecType());
//        pd = replace(pd, ParamType.temperRange.value(), pdInfo.getTemperRange());
//        pd = replace(pd, ParamType.capNum.value(), pdInfo.getCapNum());
//        pd = replace(pd, ParamType.elecSer.value(), pdInfo.getElecSer());
//        pd = replace(pd, ParamType.socStr.value(), pdInfo.getSocStr());
//        pd = replace(pd, ParamType.packType.value(), pdInfo.getPackType());
//
//        //以下是需要可搜索可选择的
//        if (StringUtils.isNotBlank(req.getCapacityCode())) {
//            pd = replace(pd, ParamType.capacity.value(), req.getCapacityCode());
//        }
//        if (StringUtils.isNotBlank(req.getTolerance())) {
//            pd = replace(pd, ParamType.tolerance.value(), req.getTolerance());
//        }
//        if (StringUtils.isNotBlank(req.getOutlet())) {
//            pd = replace(pd, ParamType.outlet.value(), req.getOutlet());
//        }
//
//        if (StringUtils.isNotBlank(req.getWireMa())) {
//            pd = replace(pd, ParamType.wireMa.value(), "[" + (req.getWireMa() == null ? "" :req.getWireMa()) + "]");
//        }
//
//        if(StringUtils.isNotBlank(req.getWireSiz())){
//
//            pd = replace(pd, ParamType.wireSize.value(), "[" + (req.getWireSiz() == null ? "" : req.getWireSiz()) + "]");
//        }
//        if(StringUtils.isNotBlank(req.getPin())){
//            pd = replace(pd, ParamType.pin.value(), "[" + (req.getPin() == null ? "" :req.getPin() ) + "]");
//        }
//
//
//
//        return pd;
//    }
//
//    public List<String>  setRuleDesc(PdModel model, PdInfo pd){
//        String rule = getOrderRule(model,pd);
//        String[] ss = OrderRuleUtil.getRuleDesc(rule);
//        return Arrays.asList(ss);
//    }
//
//    /**
//     * 读取数据
//     * @return
//     */
//    public  List<PdDetailExcel> data1()            {
//        List<PdDetailExcel> list = new ArrayList<PdDetailExcel>() ;
//        List<PdInfo>   pdInfoList= new ArrayList<>();
//        pdInfoList =pdInfoService.getPorcelainDielectric();
//
//
//        Integer  pdInfoSize=pdInfoList.size();
//
//        for(int i = 1 ; i< pdInfoSize;i ++){
//            PdDetailExcel pdDetail= new PdDetailExcel();
//            Long modelId = pdInfoList.get(i).getPdModelId();
//
//
//            PdModel pdModel= pdModelService.get(modelId);
//            PdInfo pd=  pdInfoList.get(i);
//            ExportPdDetailReq req= new ExportPdDetailReq();
////            产品编号
//            req.setId(pdInfoList.get(i).getId());
//
//
//            pdDetail.setSize(pd.getSize());
//            pdDetail.setQuality(pd.getQuality());
//            pdDetail.setAllStd(pdModel.getFeature());
//            pdDetail.setStd(pd.getStd());
//
////            分类
//            pdDetail.setClassName("瓷介电容器");
//            pdDetail.setHKclass(pdModel.getPdClassId().toString());
//            pdDetail.setName(pdModel.getName());
//            pdDetail.setImage(pdModel.getOrderRuleUrl());
//            pdDetail.setPdf(pdModel.getOrderRuleUrl());
//
//            List<PdParam> tolerances = getTolerance(req, pdInfoList.get(i));
//            List<PdParam> outlets = getOutlet(req, pdInfoList.get(i));
//            List<PdParam> capacities = getCapacity(req, pdInfoList.get(i));
//
//            setVoltage(pd);
//            setTolerance(pd,tolerances, req);
//            setOutlet(pd,outlets, req);
//
//            setCapacity(pd,capacities, req);
//            setWireMa(pd);
//            setWireSize(pd);
//            setPin(pd);
//            if(tolerances.size()>0){
////                容量
//                if(outlets.size()>0){
////                精度
//                    if(capacities.size()>0){
//
//                        for(int t=0;t<pd.getTolerances().size();t++){
//                            for(int tt=0;tt<pd.getOutlets().size();tt++){
//                                for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
//                                    List<SelRsp> out= pd.getOutlets();
//                                    req.setOutlet(out.get(tt).getValue());
//                                    req.setTolerance(pd.getTolerances().get(t).getValue());
//                                    List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
//                                    for(int tttt=0;tttt<cap.size();tttt++){
//                                        req.setCapacity(cap.get(tttt).getValue());
//                                        req.setCapacityCode(cap.get(tttt).getLabel());
//                                        pdDetail.setCode(setRule(pd,pdModel,req));
//                                        list.add(pdDetail) ;
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                }else{
//                    if(capacities.size()>0){
//                        for(int t=0;t<pd.getTolerances().size();t++){
//
//                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
//                                List<SelRsp> out= pd.getOutlets();
//
//                                req.setTolerance(pd.getTolerances().get(t).getValue());
//                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
//                                for(int tttt=0;tttt<cap.size();tttt++){
//                                    req.setCapacity(cap.get(tttt).getValue());
//                                    req.setCapacityCode(cap.get(tttt).getLabel());
//                                    pdDetail.setCode(setRule(pd,pdModel,req));
//                                    list.add(pdDetail) ;
//                                }
//
//                            }
//
//                        }
//                    }
//                }
//            } else{
//                if(outlets.size()>0){
////                精度
//                    if(capacities.size()>0){
//
//                        for(int tt=0;tt<pd.getOutlets().size();tt++){
//                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
//                                List<SelRsp> out= pd.getOutlets();
//                                req.setOutlet(out.get(tt).getValue());
//
//                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
//                                for(int tttt=0;tttt<cap.size();tttt++){
//                                    req.setCapacity(cap.get(tttt).getValue());
//                                    req.setCapacityCode(cap.get(tttt).getLabel());
//                                    pdDetail.setCode(setRule(pd,pdModel,req));
//                                    list.add(pdDetail) ;
//                                }
//
//                            }
//                        }
//
//                    }
//                }else{
//                    if(capacities.size()>0){
//
//
//                        for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
//
//                            List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
//                            for(int tttt=0;tttt<cap.size();tttt++){
//                                req.setCapacity(cap.get(tttt).getValue());
//                                req.setCapacityCode(cap.get(tttt).getLabel());
//                                pdDetail.setCode(setRule(pd,pdModel,req));
//                                list.add(pdDetail) ;
//                            }
//
//                        }
//
//
//                    }
//                }
//            }
//
//
//
//
//
//
////
////
////            user.setAllStd("100"+i);
////            user.setName("name_"+i);
////            user.setClassName("dfs");
////            user.setCode("address_"+ i);
////            user.setQuality("sdfs");
//
//        }
//        return list ;
//    }
//
//
//
//
//}
