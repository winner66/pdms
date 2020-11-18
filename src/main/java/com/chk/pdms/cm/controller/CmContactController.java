package com.chk.pdms.cm.controller;


import com.chk.pdms.cm.domain.CmContact;
import com.chk.pdms.cm.service.CmContactService;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cm/contact")
public class CmContactController {
    private String prefix = "cm/contact";

    @Autowired
    private CmContactService contactService;

    private void init(Model model){
        List<CmContact> areas = contactService.listContactByType("大区");
        model.addAttribute("areas", areas);

        List<String> types = new ArrayList<>();
        types.add("公司");
        types.add("大区");
        types.add("办事处");
        model.addAttribute("types", types);
    }

    @GetMapping("")
    @RequiresPermissions("cm:contact:contact")
    public String contact(){
        return prefix + "/list";
    }

    @GetMapping("/add")
    @RequiresPermissions("cm:contact:contact")
    public String add(Model model){
        init(model);
        CmContact contact = new CmContact();
        model.addAttribute("contact", contact);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("cm:contact:contact")
    public String get(Model model, @PathVariable("id") Long id){
        init(model);
        CmContact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return prefix + "/edit";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("cm:contact:contact")
    public Page<CmContact> list(PageReq pageReq){
        return contactService.list(pageReq);
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("cm:contact:contact")
    public R save(CmContact contact){
        contactService.save(contact);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("cm:contact:contact")
    public R delete(Long id){
        contactService.delete(id);
        return R.ok();
    }

}
