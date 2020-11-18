package com.chk.pdms.fpd.controller;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.fpd.domain.FpdMap;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.service.FpdMapService;
import com.chk.pdms.fpd.service.FpdModelService;
import com.chk.pdms.fpd.vo.FpdMapVo;
import com.chk.pdms.fpd.vo.FpdModelVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fpd/map")
public class FpdMapController {
    private String prefix = "fpd/map";

    @Autowired
    private FpdMapService mapService;

    @Autowired
    private FpdModelService modelService;

    @Autowired
    private DictService dictService;

    private void init(Model model){
        List<DictDO> type = dictService.listByType("产品参数类别");
        model.addAttribute("type", type);

        PageReq pageReq = new PageReq();
        pageReq.setPageNum(1);
        pageReq.setPageSize(500);
        Page<FpdModel> models = modelService.list(null, pageReq);
        model.addAttribute("model", models.getRows());
    }

    @GetMapping()
    @RequiresPermissions("fpd:map:map")
    public String pdModel(Model model) {
        init(model);
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("fpd:map:map")
    public Page<FpdMapVo> list(Long fmId, PageReq pageReq) {
        Page<FpdMapVo> list = mapService.list(fmId, pageReq);
        return list;
    }

    @GetMapping("/add")
    @RequiresPermissions("fpd:map:map")
    public String add(Model model) {
        FpdMap map = new FpdMap();
        model.addAttribute("map", map);
        init(model);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("fpd:map:map")
    public String get(Model model, @PathVariable("id") Long id) {
        FpdMap map = mapService.get(id);
        model.addAttribute("map", map);
        init(model);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("fpd:map:map")
    public R save(FpdMap map) {
        boolean save = this.mapService.save(map);
        if (!save){
            return R.error("已存在此类型的国外参数!");
        }
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("fpd:map:map")
    public R delete(Long id) {
        this.mapService.delete(id);
        return R.ok();
    }
}
