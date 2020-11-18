package com.chk.pdms.pd.controller;

import com.chk.pdms.common.domain.Tree;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdClassService;
import com.chk.pdms.pd.service.PdParamService;
import com.chk.pdms.pd.vo.PdClassVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/pd/class")
public class PdClassController {
    private String prefix = "pd/class";
    @Autowired
    private PdClassService pdClassService;

    @Autowired
    private PdParamService pdParamService;

    private void init(Model model){
        List<PdParam> quality = pdParamService.listByType("质量等级");
        Set<String> qaCode = new LinkedHashSet<>();
        for (PdParam param : quality) {
            qaCode.add(param.getGp());
        }
        model.addAttribute("qagps", qaCode);
    }

    @GetMapping()
    @RequiresPermissions("pd:class:class")
    public String pdClass() {
        return prefix + "/list";
    }

    @GetMapping("/tree-view")
    @RequiresPermissions("pd:class:class")
    public String treeView() {
        return prefix + "/tree";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("pd:class:class")
    public List<PdClass> list() {
        List<PdClass> classes = pdClassService.list();
        return classes;
    }

    @ResponseBody
    @GetMapping("/tree")
    @RequiresPermissions("pd:class:class")
    public List<Tree<PdClass>> tree() {
        List<Tree<PdClass>> classes = pdClassService.tree();
        return classes;
    }

    @GetMapping("/add/{pId}")
    @RequiresPermissions("pd:class:class")
    public String add(Model model, @PathVariable("pId") Long pId){
        PdClassVo clz = new PdClassVo();
        model.addAttribute("clz", clz);
        if (pId != 0) {
            clz.setpId(pId);
            PdClassVo pdClass = pdClassService.get(pId);
            clz.setLevel(pdClass.getLevel() + 1);
            model.addAttribute("pName", pdClass.getName());
        }else{
            clz.setpId(0L);
            clz.setLevel(1);
            model.addAttribute("pName", "");
        }
        init(model);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("pd:class:class")
    public String get(Model model, @PathVariable("id") Long id){
        PdClassVo clz = pdClassService.get(id);
        model.addAttribute("clz", clz);
        if (clz.getpId() != 0) {
            PdClass parentClass = pdClassService.get(clz.getpId());
            model.addAttribute("pName", parentClass.getName());
        }else{
            model.addAttribute("pName", "");
        }
        init(model);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("pd:class:class")
    public R save(PdClassVo clz){
        this.pdClassService.save(clz);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("pd:class:class")
    public R delete(Long id){
        Boolean delete = this.pdClassService.delete(id);
        if (delete){
            return R.ok();
        }else{
            return R.error("含有下级分类,不能删除!");
        }
    }
}
