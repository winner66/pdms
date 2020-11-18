package com.chk.pdms.cm.controller;

import com.chk.pdms.cm.domain.CmContact;
import com.chk.pdms.cm.domain.UserAccount;
import com.chk.pdms.cm.service.CmUserService;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/cm/user")
public class CmUserController {
    private String prefix = "cm/user";

    @Autowired
    private CmUserService userService;

    @GetMapping("")
    @RequiresPermissions("cm:user:user")
    public String User(){
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("cm:user:user")
    public Page<UserAccount> list(Date startDate, Date endDate, PageReq pageReq){
        return userService.list(startDate, endDate, pageReq);
    }
}
