package com.chk.pdms.pd.controller;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.domain.Tree;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdClassService;
import com.chk.pdms.pd.service.PdParamService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/pd/param")
public class PdParamController {

    private String prefix = "pd/param";

    @Autowired
    private PdParamService paramService;

    @Autowired
    private PdClassService classService;

    @Autowired
    private DictService dictService;

    private void init(Model model, String path) {
        if ("std".equalsIgnoreCase(path)) {
            List<DictDO> gps = dictService.listByType("执行标准分类");
            model.addAttribute("gps", gps);
        }
        List<DictDO> type = dictService.listByType("产品参数类别");
        Iterator<DictDO> i = type.iterator();
        while (i.hasNext()) {
            DictDO dict = i.next();
            if (ParamType.quality.value().equals(dict.getValue()) || ParamType.std.value().equals(dict.getValue()) ||
                    ParamType.size.value().equals(dict.getValue()) || ParamType.temperature.value().equals(dict.getValue()) ||
                    ParamType.voltage.value().equals(dict.getValue()) || ParamType.model.value().equals(dict.getValue()) ||
                    ParamType.capacity.value().equals(dict.getValue()) || ParamType.tolerance.value().equals(dict.getValue()) ||
                    ParamType.outlet.value().equals(dict.getValue())) {
                i.remove();
            }
        }
        model.addAttribute("paramType", type);
    }

    @RequestMapping("/{path}")
    @RequiresPermissions("pd:param:param")
    public String pdParam(Model model, @PathVariable("path") String path, String mode) {
        init(model, path);
        //mode: page | win
        mode = StringUtils.isBlank(mode) ? "page" : mode;
        model.addAttribute("mode", mode);
        return prefix + "/" + path + "/list";
    }

    @ResponseBody
    @RequestMapping("/{path}/list")
    @RequiresPermissions("pd:param:param")
    public Page<PdParam> list(PdParam param, PageReq pageReq, @PathVariable("path") String path) {
        if ("other".equals(path) && StringUtils.isBlank(param.getType())){
            param.setType(path);
        }
        Page<PdParam> params = paramService.list(param, pageReq);
        return params;
    }

    @ResponseBody
    @RequestMapping("/{path}/gp-tree")
    @RequiresPermissions("pd:param:param")
    public List<Tree<PdParam>> gpTree(String type, @PathVariable("path") String path) {
        List<Tree<PdParam>> trees = paramService.gpTree(type);
        return trees;
    }

    @GetMapping("/{path}/add")
    @RequiresPermissions("pd:param:param")
    public String add(Model model, @PathVariable("path") String path) {
        init(model, path);
        PdParam param = new PdParam();
        model.addAttribute("p", param);
        return prefix + "/" + path + "/edit";
    }

    @GetMapping("/{path}/get/{id}")
    @RequiresPermissions("pd:param:param")
    public String get(Model model, @PathVariable("path") String path, @PathVariable("id") Long id) {
        init(model, path);
        PdParam param = paramService.get(id);
        model.addAttribute("p", param);
//        if ("size".equals(path)){
//            PdClass clz = classService.get(Long.valueOf(param.getGp()));
//            model.addAttribute("className", clz.getName());
//        }
        return prefix + "/" + path + "/edit";
    }

    @ResponseBody
    @PostMapping("/{path}/save")
    @RequiresPermissions("pd:param:param")
    public R save(PdParam param, @PathVariable("path") String path) {
        this.paramService.save(param);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("/{path}/delete")
    @RequiresPermissions("pd:param:param")
    public R delete(Long id, @PathVariable("path") String path) {
        this.paramService.delete(id);
        return R.ok();
    }
}
