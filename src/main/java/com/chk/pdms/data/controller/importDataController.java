package com.chk.pdms.data.controller;

import com.chk.pdms.common.utils.R;
import com.chk.pdms.data.service.ImportService;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.fpd.service.FpdSeriesService;
import com.chk.pdms.pd.service.PdInfoService;
import com.chk.pdms.pd.vo.ImportDataVo;
import com.chk.pdms.pd_material.service.PdMaterialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/import/pd/info")
public class importDataController {
    @Autowired
    private PdInfoService infoService;
    @Autowired
    private PdExportExcelService excel;
    @Autowired
    private FpdSeriesService fpdService;
    @Autowired
    private ImportService importService;
    @Autowired
    private PdMaterialService materialService;
//    @Autowired
//    private PdInfoService infoService;

    static  private  String MATERIAL="Material";
    static  private  String Info="info";
//    static  private  String Master="Material";
    static  private  String FPD="fpd";
    @ResponseBody
    @PostMapping("import-data")
    @RequiresPermissions("pd:info:info")
    public R importData(ImportDataVo vo){
        ImportDataVo rsp = importService.importData(vo,Info);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }


    @ResponseBody
    @PostMapping("import-Material-data")
    @RequiresPermissions("pd:info:info")
    public R importMaterialData(ImportDataVo vo){
        ImportDataVo rsp = importService.importData(vo,MATERIAL);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }


    @ResponseBody
    @PostMapping("import-fpd-data")
    @RequiresPermissions("pd:fpd:fpd")
    public R importFPDData(ImportDataVo vo){
        ImportDataVo rsp = importService.importData(vo,FPD);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }
}
