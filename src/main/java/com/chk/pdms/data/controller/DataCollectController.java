package com.chk.pdms.data.controller;

import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.data.service.DataCollectService;
import com.chk.pdms.data.vo.DcVo;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/datac/pd")
public class DataCollectController {
    private String prefix = "datac/pd";

    @Autowired
    private DataCollectService collectService;

    @GetMapping("/pd")
    @RequiresPermissions("pd:datac:datac")
    public String pd() {
        return prefix + "/pd-list";
    }

    @GetMapping("/pd-date")
    @RequiresPermissions("pd:datac:datac")
    public String pdDate() {
        return prefix + "/pd-date-list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("pd:datac:datac")
    public Page<DcVo> list(DcVo dc, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        Page<DcVo> page = collectService.list(dc,pageReq);
        return page;
    }

    @ResponseBody
    @GetMapping("/list-date")
    @RequiresPermissions("pd:datac:datac")
    public Page<DcVo> listDate(DcVo dc, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        Page<DcVo> page = collectService.listDate(dc,pageReq);
        return page;
    }
}
