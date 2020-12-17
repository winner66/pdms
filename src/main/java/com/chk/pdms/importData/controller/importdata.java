package com.chk.pdms.importData.controller;

import com.chk.pdms.common.utils.R;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.pd.service.PdInfoService;
import com.chk.pdms.pd.vo.ImportDataVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class importdata {
    @Autowired
    private PdInfoService infoService;
    @Autowired
    private PdExportExcelService excel;
    @Autowired
//    private PdInfoService infoService;
//    @Autowired
//    private PdInfoService infoService;

    @ResponseBody
    @PostMapping("import-data")
    @RequiresPermissions("pd:info:info")
    public R importData(ImportDataVo vo){
        ImportDataVo rsp = infoService.importData(vo);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }


    @ResponseBody
    @PostMapping("import-data")
    @RequiresPermissions("pd:info:info")
    public R importMaterialData(ImportDataVo vo){
        ImportDataVo rsp = infoService.importData(vo);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }
}
