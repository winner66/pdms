package com.chk.pdms.data.service;

import com.alibaba.excel.EasyExcel;
import com.chk.pdms.common.utils.OrderRuleUtil;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.utils.EasyExcelUtil;
import com.chk.pdms.data.PdDetailExcel;
import com.chk.pdms.data.ExportPdDetailReq;
import com.chk.pdms.data.vo.FPDSeriesVo;
import com.chk.pdms.fpd.domain.FpdSeries;
import com.chk.pdms.pd.dao.PdClassDao;
import com.chk.pdms.pd.dao.PdInfoDao;
import com.chk.pdms.pd.dao.PdModelDao;
import com.chk.pdms.pd.dao.PdParamDao;
import com.chk.pdms.pd.domain.*;
import com.chk.pdms.pd.service.PdInfoService;
import com.chk.pdms.pd.service.PdModelService;
import com.chk.pdms.pd.vo.CasRsp;
import com.chk.pdms.pd.vo.SelRsp;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Service
public class PdExportExcelService {

    @Autowired
    private PdInfoService pdInfoService;

    @Autowired
    private PdModelService pdModelService;

    @Autowired
    private PdParamDao pdParamDao;

    private  static Long  MAXCount=10000*100L;



    /**
     * 从数据库中读取数据
     * @return
     */
    public  List<PdDetailExcel> data1()            {
        List<PdDetailExcel> list = new ArrayList<PdDetailExcel>() ;
        List<PdInfo>   pdInfoList= new ArrayList<>();
        pdInfoList =pdInfoService.getPorcelainDielectric();


        Integer  pdInfoSize=pdInfoList.size();

        for(int i = 1 ; i< pdInfoSize;i ++){
            PdDetailExcel pdDetail= new PdDetailExcel();
            Long modelId = pdInfoList.get(i).getPdModelId();


            PdModel pdModel= pdModelService.get(modelId);
            PdInfo pd=  pdInfoList.get(i);
            ExportPdDetailReq req= new ExportPdDetailReq();
//            产品编号
            req.setId(pdInfoList.get(i).getId());


            pdDetail.setSize(pd.getSize());
            pdDetail.setQuality(pd.getQuality());
            pdDetail.setAllStd(pdModel.getFeature());
            pdDetail.setStd(pd.getStd());

//            分类
            pdDetail.setClassName("瓷介电容器");
            pdDetail.setHKclass(pdModel.getPdClassId().toString());
            pdDetail.setName(pdModel.getName());
            pdDetail.setImage(pdModel.getOrderRuleUrl());
            pdDetail.setPdf(pdModel.getOrderRuleUrl());

            List<PdParam> tolerances = getTolerance(req, pdInfoList.get(i));
            List<PdParam> outlets = getOutlet(req, pdInfoList.get(i));
            List<PdParam> capacities = getCapacity(req, pdInfoList.get(i));

            setVoltage(pd);
            setTolerance(pd,tolerances, req);
            setOutlet(pd,outlets, req);

            setCapacity(pd,capacities, req);
            setWireMa(pd);
            setWireSize(pd);
            setPin(pd);
            if(tolerances.size()>0){
//                容量
                if(outlets.size()>0){
//                精度
                    if(capacities.size()>0){

                        for(int t=0;t<pd.getTolerances().size();t++){
                            for(int tt=0;tt<pd.getOutlets().size();tt++){
                                for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                    List<SelRsp> out= pd.getOutlets();
                                    req.setOutlet(out.get(tt).getValue());
                                    req.setTolerance(pd.getTolerances().get(t).getValue());
                                    List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();

                                    for(int tttt=0;tttt<cap.size();tttt++){
                                        req.setCapacity(cap.get(tttt).getValue());
                                        req.setCapacityCode(cap.get(tttt).getLabel());
                                        pdDetail.setCode(setRule(pd,pdModel,req));
                                        list.add(pdDetail) ;
                                    }

                                }
                            }
                        }
                    }
                }else{
                    if(capacities.size()>0){
                        for(int t=0;t<pd.getTolerances().size();t++){

                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();

                                req.setTolerance(pd.getTolerances().get(t).getValue());
                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;
                                }

                            }

                        }
                    }
                }
            } else{
                if(outlets.size()>0){
//                精度
                    if(capacities.size()>0){

                        for(int tt=0;tt<pd.getOutlets().size();tt++){
                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();
                                req.setOutlet(out.get(tt).getValue());

                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;
                                }

                            }
                        }

                    }
                }else{
                    if(capacities.size()>0){


                        for(int ttt=0;ttt<pd.getCapacities().size();ttt++){

                            List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                            for(int tttt=0;tttt<cap.size();tttt++){
                                req.setCapacity(cap.get(tttt).getValue());
                                req.setCapacityCode(cap.get(tttt).getLabel());
                                pdDetail.setCode(setRule(pd,pdModel,req));
                                list.add(pdDetail) ;
                            }

                        }


                    }
                }
            }






//
//
//            user.setAllStd("100"+i);
//            user.setName("name_"+i);
//            user.setClassName("dfs");
//            user.setCode("address_"+ i);
//            user.setQuality("sdfs");

        }
        return list ;
    }

    public  List<PdDetailExcel> data(){
        List<PdDetailExcel> list = new ArrayList<PdDetailExcel>() ;
        List<PdInfo>   pdInfoList= new ArrayList<>();
        pdInfoList =pdInfoService.getAll();


        Integer  pdInfoSize=pdInfoList.size();

        for(int i = 1 ; i< pdInfoSize;i ++){
            PdDetailExcel pdDetail= new PdDetailExcel();
            Long modelId = pdInfoList.get(i).getPdModelId();


            PdModel pdModel= pdModelService.get(modelId);
            PdInfo pd=  pdInfoList.get(i);
            ExportPdDetailReq req= new ExportPdDetailReq();
//            产品编号
            req.setId(pdInfoList.get(i).getId());


            pdDetail.setSize(pd.getSize());
            pdDetail.setQuality(pd.getQuality());
            pdDetail.setAllStd(pdModel.getFeature());
            pdDetail.setStd(pd.getStd());

//            分类
            pdDetail.setClassName("瓷介电容器");
            pdDetail.setHKclass(pdModel.getPdClassId().toString());
            pdDetail.setName(pdModel.getName());
            pdDetail.setImage(pdModel.getOrderRuleUrl());
            pdDetail.setPdf(pdModel.getOrderRuleUrl());

            List<PdParam> tolerances = getTolerance(req, pdInfoList.get(i));
            List<PdParam> outlets = getOutlet(req, pdInfoList.get(i));
            List<PdParam> capacities = getCapacity(req, pdInfoList.get(i));

            setVoltage(pd);
            setTolerance(pd,tolerances, req);
            setOutlet(pd,outlets, req);

            setCapacity(pd,capacities, req);
            setWireMa(pd);
            setWireSize(pd);
            setPin(pd);
            if(tolerances.size()>0){
//                容量
                if(outlets.size()>0){
//                精度
                    if(capacities.size()>0){

                        for(int t=0;t<pd.getTolerances().size();t++){
                            for(int tt=0;tt<pd.getOutlets().size();tt++){
                                for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                    List<SelRsp> out= pd.getOutlets();
                                    req.setOutlet(out.get(tt).getValue());
                                    req.setTolerance(pd.getTolerances().get(t).getValue());
                                    List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                    for(int tttt=0;tttt<cap.size();tttt++){
                                        req.setCapacity(cap.get(tttt).getValue());
                                        req.setCapacityCode(cap.get(tttt).getLabel());
                                        pdDetail.setCode(setRule(pd,pdModel,req));
                                        list.add(pdDetail) ;
                                    }

                                }
                            }
                        }
                    }else{
                        for(int t=0;t<pd.getTolerances().size();t++){
                            for(int tt=0;tt<pd.getOutlets().size();tt++){
                                List<SelRsp> out= pd.getOutlets();
                                req.setOutlet(out.get(tt).getValue());
                                req.setTolerance(pd.getTolerances().get(t).getValue());


                                pdDetail.setCode(setRule(pd,pdModel,req));
                                list.add(pdDetail) ;


                            }
                        }
                    }

                }else{
                    if(capacities.size()>0){
                        for(int t=0;t<pd.getTolerances().size();t++){

                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();

                                req.setTolerance(pd.getTolerances().get(t).getValue());
                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;
                                }

                            }

                        }
                    }else{
                        for(int t=0;t<pd.getTolerances().size();t++){
                                req.setTolerance(pd.getTolerances().get(t).getValue());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;

                            }
                        }

                }
            } else{
                if(outlets.size()>0){
//                精度
                    if(capacities.size()>0){

                        for(int tt=0;tt<pd.getOutlets().size();tt++){
                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();
                                req.setOutlet(out.get(tt).getValue());

                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;
                                }
                            }
                        }
                    }else{
                        for(int tt=0;tt<pd.getOutlets().size();tt++){

                                List<SelRsp> out= pd.getOutlets();
                                req.setOutlet(out.get(tt).getValue());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    list.add(pdDetail) ;
                        }
                    }
                }else{
                    if(capacities.size()>0){


                        for(int ttt=0;ttt<pd.getCapacities().size();ttt++){

                            List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                            for(int tttt=0;tttt<cap.size();tttt++){
                                req.setCapacity(cap.get(tttt).getValue());
                                req.setCapacityCode(cap.get(tttt).getLabel());
                                pdDetail.setCode(setRule(pd,pdModel,req));
                                list.add(pdDetail) ;
                            }
                        }

                    }else{

                    }
                }
            }

        }
        return list ;
    }
    public  List<PdDetailExcel> data2(){

        List<PdDetailExcel> list = new ArrayList<PdDetailExcel>() ;
        List<PdInfo>   pdInfoList= new ArrayList<>();
        pdInfoList =pdInfoService.getEMI();
        Integer  pdInfoSize=pdInfoList.size();
        for(int i = 1 ; i< pdInfoSize;i ++){

            PdDetailExcel pdDetail= new PdDetailExcel();
            Long modelId = pdInfoList.get(i).getPdModelId();


            PdModel pdModel= pdModelService.get(modelId);
            PdInfo pd=  pdInfoList.get(i);
            ExportPdDetailReq req= new ExportPdDetailReq();
//            产品编号
            req.setId(pdInfoList.get(i).getId());


            pdDetail.setSize(pd.getSize());
            pdDetail.setQuality(pd.getQuality());
            pdDetail.setAllStd(pdModel.getFeature());
            pdDetail.setStd(pd.getStd());

//            分类
            pdDetail.setClassName("瓷介电容器");
            pdDetail.setHKclass(pdModel.getPdClassId().toString());
            pdDetail.setHKmodel(pdModel.getId().toString());
            pdDetail.setName(pdModel.getName());
            pdDetail.setImage(pdModel.getOrderRuleUrl());
            pdDetail.setPdf(pdModel.getOrderRuleUrl());

            List<PdParam> tolerances = getTolerance(req, pdInfoList.get(i));
            List<PdParam> outlets = getOutlet(req, pdInfoList.get(i));
            List<PdParam> capacities = getCapacity(req, pdInfoList.get(i));

            setVoltage(pd);
            setTolerance(pd,tolerances, req);
            setOutlet(pd,outlets, req);

            setCapacity(pd,capacities, req);
            setWireMa(pd);
            setWireSize(pd);
            setPin(pd);
            if(pd.getWireMas().size()>0){
                for(int ttt=0;ttt<pd.getWireMas().size();ttt++){

                    pdDetail.setImage(pd.getWireMas().get(ttt).getValue());
                    req.setWireMa(pd.getWireMas().get(ttt).getValue());
                    pdDetail.setCode(setRule(pd,pdModel,req));
                    list.add(pdDetail) ;
                }
            }
            if(pd.getWireSizes().size()>0){
                for(int ttt=0;ttt<pd.getWireSizes().size();ttt++){

                    pdDetail.setImage(pd.getWireSizes().get(ttt).getValue());
                    req.setWireSiz(pd.getWireSizes().get(ttt).getValue());
                    pdDetail.setCode(setRule(pd,pdModel,req));
                    list.add(pdDetail) ;
                }
            }
            if(pd.getPins().size()>0){
                for(int ttt=0;ttt<pd.getPins().size();ttt++){

                    pdDetail.setImage(pd.getPins().get(ttt).getValue());
                    req.setPin(pd.getPins().get(ttt).getValue());
                    pdDetail.setCode(setRule(pd,pdModel,req));
                    list.add(pdDetail) ;
                }
            }
            if(pd.getTolerances().size()>0){
//                容量
                if(pd.getOutlets().size()>0){
//                精度
                    if(pd.getCapacities().size()>0){

                        for(int t=0;t<pd.getTolerances().size();t++){
                            for(int tt=0;tt<pd.getOutlets().size();tt++){
                                for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                    List<SelRsp> out= pd.getOutlets();
                                    req.setOutlet(out.get(tt).getValue());
                                    req.setTolerance(pd.getTolerances().get(t).getValue());
                                    List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                    for(int tttt=0;tttt<cap.size();tttt++){
                                        req.setCapacity(cap.get(tttt).getLabel());

                                        req.setCapacityCode(cap.get(tttt).getLabel());
                                        pdDetail.setImage(cap.get(tttt).getLabel());
                                        pdDetail.setCode(setRule(pd,pdModel,req));
                                        list.add(pdDetail) ;
                                    }

                                }
                            }
                        }
                    }
                }else{
                    if(pd.getCapacities().size()>0){
                        for(int t=0;t<pd.getTolerances().size();t++){

                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();

                                req.setTolerance(pd.getTolerances().get(t).getValue());
                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    pdDetail.setImage(cap.get(tttt).getLabel());
                                    list.add(pdDetail) ;
                                }

                            }

                        }
                    }
                }
            } else{
                if(pd.getOutlets().size()>0){
//                精度
                    if(pd.getCapacities().size()>0){

                        for(int tt=0;tt<pd.getOutlets().size();tt++){
                            for(int ttt=0;ttt<pd.getCapacities().size();ttt++){
                                List<SelRsp> out= pd.getOutlets();
                                req.setOutlet(out.get(tt).getValue());

                                List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                                for(int tttt=0;tttt<cap.size();tttt++){
                                    req.setCapacity(cap.get(tttt).getValue());
                                    req.setCapacityCode(cap.get(tttt).getLabel());
                                    pdDetail.setCode(setRule(pd,pdModel,req));
                                    pdDetail.setImage(cap.get(tttt).getLabel());
                                    list.add(pdDetail) ;
                                }

                            }
                        }

                    }
                }else{
                    if(pd.getCapacities().size()>0){


                        for(int ttt=0;ttt<pd.getCapacities().size();ttt++){

                            List<CasRsp> cap=pd.getCapacities().get(ttt).getChildren();
                            for(int tttt=0;tttt<cap.size();tttt++){
                                req.setCapacity(cap.get(tttt).getValue());
                                req.setCapacityCode(cap.get(tttt).getLabel());
                                pdDetail.setCode(setRule(pd,pdModel,req));
                                pdDetail.setImage(cap.get(tttt).getLabel());
                                list.add(pdDetail) ;
                            }

                        }


                    }
                }
            }

        }
        return list ;
    }

    public  void  getExcelList(String fileName) throws Exception {
        List<PdDetailExcel> res = new ArrayList<PdDetailExcel>() ;
        List<PdInfo>   pdInfoList= new ArrayList<>();
        List<PdDetail> pdDetailList= new ArrayList<>();
        AtomicInteger atomicInteger= new AtomicInteger(1);
        pdInfoList= pdInfoService.getEMI();
//        pdInfoList= pdInfoService.getPdsByModelId(5L);
//        PdInfo infos= new PdInfo();
//        infos.setId(33448L);
//        pdInfoList.add(infos);
        System.out.println( "pdInfoList:");
        System.out.println( pdInfoList.size());
        for (PdInfo info: pdInfoList
             ) {
            ExportPdDetailReq req= new ExportPdDetailReq();
            req.setId(info.getId());
            PdDetail pdDetail= pdInfoService.getPdDetail(req);

            pdDetailList.add(pdDetail);
        }

        for (PdDetail detail: pdDetailList
        ) {
            List<PdDetailExcel> tem = getPdExcelList(detail);
            if(tem.size()+res.size()> MAXCount){
//                保存数据

                try {
                    EasyExcelUtil.writeExcel(res,fileName+atomicInteger.get(), PdDetailExcel.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.gc();
                res= new ArrayList<PdDetailExcel>() ;
                atomicInteger.set(atomicInteger.get()+1);

            }
            else{
                res.addAll(tem);
            }

        }
        System.out.println( "PdDetailExcel:");
        System.out.println(  res.size());
        if(res.size()>0){
            try {
                EasyExcelUtil.writeExcel(res,fileName, PdDetailExcel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
//    某产品的导出
    private List<PdDetailExcel> getPdExcelList(PdDetail detail)  {
        List<PdDetailExcel> res= new ArrayList<>();
        PdDetailExcel pdDetailExcel= new PdDetailExcel();
        pdDetailExcel.setSize(detail.getPdInfo().getSize());
        pdDetailExcel.setQuality(detail.getPdInfo().getQuality());
        pdDetailExcel.setAllStd(detail.getPdModel().getFeature());
        pdDetailExcel.setStd(detail.getPdInfo().getStd());

//            分类
        pdDetailExcel.setClassName(detail.getPdModel().getName());

        pdDetailExcel.setImage(detail.getPdClass().getIconUrl());
        pdDetailExcel.setPdf(detail.getPdClass().getPdfUrl());
        pdDetailExcel.setHKclass(detail.getPdClass().getName());
        pdDetailExcel.setHKmodel(detail.getPdModel().getId().toString());
        pdDetailExcel.setName(detail.getPdModel().getName());

        List<String> list = detail.getCodeString();
        System.out.println( "ruleList:");
        System.out.println(  list.size());
        try{
            System.gc();
            for (String order:list   ) {
                PdDetailExcel excel=new PdDetailExcel();

                BeanUtils.copyProperties(excel, pdDetailExcel);
//                BeanUtils.cop
                excel.setCode(order);
//                if()
                res.add(excel);

            }
        }catch (Exception e) {

        }
        return  res;
    }





    public void printByEasyExcel( HttpServletResponse response) throws IOException {
        //查询要导出的明细信息
        List<?> modelList = data1();
        String fileName = "d:/111.xlsx" ;
        try {
            EasyExcelUtil.writeExcel( modelList, fileName,PdDetailExcel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    可以使用反射class
    public void exportFpdSeriesData(List<FpdSeries> fpdSeries, HttpServletResponse response, String filename)throws IOException {
        try {
            // 文件下载
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            EasyExcel.write(bos, FPDSeriesVo.class).autoCloseStream(Boolean.FALSE).sheet("sheet").doWrite(fpdSeries);

            EasyExcelUtil.downloadFile(filename, bos, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setWireMa(PdInfo info) {
        if (StringUtils.isNotBlank(info.getWireMa())) {
            String[] ss = StringUtils.split(info.getWireMa(), ";");
            for (String s : ss) {
                info.getWireMas().add(new SelRsp(s, s));
            }
        }
    }
    private void setPin(PdInfo info) {
        if (StringUtils.isNotBlank(info.getPin())) {
            String[] ss = StringUtils.split(info.getPin(), ";");
            for (String s : ss) {
                info.getPins().add(new SelRsp(s, s));
            }
        }
    }
    private void setWireSize( PdInfo info) {
        if (StringUtils.isNotBlank(info.getWireSize())) {
            String[] ss = StringUtils.split(info.getWireSize(), ";");
            for (String s : ss) {
                info.getWireSizes().add(new SelRsp(s, s));
            }
        }
    }

    public  String  setRule(PdInfo pdInfo, PdModel model, ExportPdDetailReq req) {
        String rule = getOrderRule(model,pdInfo);
        String pd = replace(rule, "|", "");
        pd = replace(pd, ParamType.quality.value(), pdInfo.getQuality());
        pd = replace(pd, ParamType.std.value(), pdInfo.getStd());
        pd = replace(pd, ParamType.size.value(), pdInfo.getSize());
        pd = replace(pd, ParamType.temperature.value(), pdInfo.getTemperature());
        pd = replace(pd, ParamType.voltage.value(), pdInfo.getVoltage());
        pd = replace(pd, ParamType.model.value(), pdInfo.getModel());
        pd = OrderRuleUtil.resetSingleModel(pd, pdInfo.getModel());
        pd = replace(pd, ParamType.elecCode.value(), pdInfo.getElecCode());
        pd = replace(pd, ParamType.elecType.value(), pdInfo.getElecType());
        pd = replace(pd, ParamType.temperRange.value(), pdInfo.getTemperRange());
        pd = replace(pd, ParamType.capNum.value(), pdInfo.getCapNum());
        pd = replace(pd, ParamType.elecSer.value(), pdInfo.getElecSer());
        pd = replace(pd, ParamType.socStr.value(), pdInfo.getSocStr());
        pd = replace(pd, ParamType.packType.value(), pdInfo.getPackType());

        //以下是需要可搜索可选择的
        if (StringUtils.isNotBlank(req.getCapacityCode())) {
            pd = replace(pd, ParamType.capacity.value(), req.getCapacityCode());
        }
        if (StringUtils.isNotBlank(req.getTolerance())) {
            pd = replace(pd, ParamType.tolerance.value(), req.getTolerance());
        }
        if (StringUtils.isNotBlank(req.getOutlet())) {
            pd = replace(pd, ParamType.outlet.value(), req.getOutlet());
        }

        if (StringUtils.isNotBlank(req.getWireMa())) {
            pd = replace(pd, ParamType.wireMa.value(), "[" + (req.getWireMa() == null ? "" :req.getWireMa()) + "]");
        }

        if(StringUtils.isNotBlank(req.getWireSiz())){

            pd = replace(pd, ParamType.wireSize.value(), "[" + (req.getWireSiz() == null ? "" : req.getWireSiz()) + "]");
        }
       if(StringUtils.isNotBlank(req.getPin())){
           pd = replace(pd, ParamType.pin.value(), "[" + (req.getPin() == null ? "" :req.getPin() ) + "]");
       }



        return pd;
    }
    public List<String>  setRuleDesc(PdModel model, PdInfo pd){
        String rule = getOrderRule(model,pd);
        String[] ss = OrderRuleUtil.getRuleDesc(rule);
         return Arrays.asList(ss);
    }

    private String getOrderRule(PdModel model,PdInfo pd) {
        String orderRule =model.getOrderRule();
        String[] s = StringUtils.split(orderRule, "__");
        if (s.length == 2) {
            if (StringUtils.isNotBlank(pd.getOutlet())) {
                orderRule = s[0];
            }
            if (StringUtils.isNotBlank(pd.getCapNum())) {
                orderRule = s[1];
            }
        }
        orderRule = replace(orderRule, "|", "");
        if (StringUtils.isBlank(pd.getOutlet())) {
            orderRule = replace(orderRule, "-" + ParamType.outlet.value(), "");
            orderRule = replace(orderRule, ParamType.outlet.value(), "");
        }
        if (StringUtils.isBlank(pd.getCapNum())) {
            orderRule = replace(orderRule, "-" + ParamType.capNum.value(), "");
            orderRule = replace(orderRule, ParamType.capNum.value(), "");
        }
        return orderRule;
    }
    public String replace(final String text, final String searchString, final String replacement) {
        String replace = replacement == null ? "" : replacement;
        return StringUtils.replace(text, searchString, replace);
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
    private List<PdParam> getCapacity(ExportPdDetailReq req, PdInfo pdInfo) {
        List<PdParam> capacities=new ArrayList<>();
        if (StringUtils.isNotBlank(req.getCapacity())){
            capacities = pdParamDao.getCapacities(Integer.valueOf(req.getCapacity()), Integer.valueOf(req.getCapacity()));
        }else{


                if(pdInfo.getCapacityMinIdx()!=null&& pdInfo.getCapacityMaxIdx()!=null){
                    capacities = pdParamDao.getCapacities(pdInfo.getCapacityMinIdx(), pdInfo.getCapacityMaxIdx());
                }



        }
        return capacities;
    }

    private List<PdParam> getOutlet(ExportPdDetailReq req, PdInfo pdInfo) {
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
//
    private void setCapacity( PdInfo info ,List<PdParam> capacities, ExportPdDetailReq req) {
        if (StringUtils.isNotBlank(req.getCapacityCode())) {
            String name = "";
            for (PdParam capacity : capacities) {
                if (capacity.getCode().equals(req.getCapacityCode())) {
                    name = capacity.getGp();
                }
            }
            info.setCapacity(req.getCapacityCode() + "[" + name + "]");
        } else {
//                for (PdParam capacity : capacities) {
//                    this.pdInfo.getCapacities().add(new SelRsp(capacity.getCode() + "[" + capacity.getGp() + "]", capacity.getCode()));
//                }
            Map<String, List<PdParam>> map = new HashMap<>();
            for (PdParam capacity : capacities) {
                List<PdParam> pdParams = map.get(capacity.getGp());
                if (pdParams == null) {
                    pdParams = new ArrayList<>();
                    map.put(capacity.getGp(), pdParams);
                }
                pdParams.add(capacity);
            }
            for (Map.Entry<String, List<PdParam>> entry : map.entrySet()) {
                String gp = entry.getKey();
                List<PdParam> ps = entry.getValue();
                CasRsp cas = new CasRsp(gp, gp, true);
                for (PdParam p : ps) {
                    //这里用code作为value方便些
                    cas.getChildren().add(new CasRsp(p.getCode(), p.getCode(), false));
                }
                info.getCapacities().add(cas);
            }
        }
    }

    private void setOutlet( PdInfo pdInfo,List<PdParam> outlets, ExportPdDetailReq req) {
        if (StringUtils.isNotBlank(req.getOutlet())) {
            String name = "";
            for (PdParam outlet : outlets) {
                if (outlet.getCode().equals(req.getOutlet())) {
                    name = outlet.getName();
                    break;
                }
            }
            pdInfo.setOutlet(req.getOutlet() + "[" + name + "]");
        } else {

            for (PdParam outlet : outlets) {
                pdInfo.getOutlets().add(new SelRsp(outlet.getCode() + "[" + (outlet.getName() == null ? "" : outlet.getName()) + "]", outlet.getCode()));
            }
        }
    }

    private void setTolerance( PdInfo pdInfo,List<PdParam> tolerances, ExportPdDetailReq req) {
        //之前选了参数值，不需要选择
        if (StringUtils.isNotBlank(req.getTolerance())) {
            String name = "";
            for (PdParam tolerance : tolerances) {
                if (tolerance.getCode().equals(req.getTolerance())) {
                    name = tolerance.getName();
                    break;
                }
            }
           pdInfo.setTolerance(req.getTolerance() + "[" + name + "]");
        } else {

            for (PdParam tolerance : tolerances) {
               pdInfo.getTolerances().add(new SelRsp(tolerance.getCode() + "[" + (tolerance.getName() == null ? "" : tolerance.getName()) + "]", tolerance.getCode()));
            }
        }
    }

    private void setVoltage(PdInfo pdInfo) {
        if ("0".equals(pdInfo.getVoltage())) {
            pdInfo.setVoltage("0[50V]");
        }
        if ("1".equals(pdInfo.getVoltage())) {
            pdInfo.setVoltage("1[100V]");
        }
        if ("10".equals(pdInfo.getVoltage())) {
            pdInfo.setVoltage("10[100V]");
        }
    }


}
