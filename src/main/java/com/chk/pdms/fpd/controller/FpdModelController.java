package com.chk.pdms.fpd.controller;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.service.FpdModelService;
import com.chk.pdms.fpd.vo.FpdModelVo;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.service.PdClassService;
import com.chk.pdms.pd.service.PdModelService;
import com.chk.pdms.pd.vo.PdModelVo;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fpd/model")
public class FpdModelController {
    private String prefix = "fpd/model";

    @Autowired
    private FpdModelService modelService;

    @Autowired
    private DictService dictService;

    private void init(Model model){
        List<DictDO> type = dictService.listByType("产品参数类别");
        List<DictDO> cut = dictService.listByType("产品参数分割");
        model.addAttribute("type", type);
        model.addAttribute("cut", cut);

        List<String> pos = new ArrayList<>();
        for (int i = 1; i <= 20; i++){
            pos.add(i + "");
        }
        model.addAttribute("pos", pos);

        List<String> bit = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            bit.add(i + "");
        }
        model.addAttribute("bit", bit);
    }

    @GetMapping()
    @RequiresPermissions("fpd:model:model")
    public String pdModel() {
        return prefix + "/list";
    }

    @SneakyThrows
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("fpd:model:model")
    public Page<FpdModel> list(String name, PageReq pageReq) {
        Page<FpdModel> list = modelService.list(name, pageReq);
        List<FpdModel> vos = new ArrayList<>();
        for (FpdModel model : list.getRows()) {
            FpdModelVo vo = new FpdModelVo();
            BeanUtils.copyProperties(vo, model);
            vos.add(vo);
        }
        list.setRows(vos);
        return list;
    }

    @GetMapping("/add")
    @RequiresPermissions("fpd:model:model")
    public String add(Model model) {
        FpdModelVo vo = new FpdModelVo();
        model.addAttribute("model", vo);
        vo.arrayOR();
        init(model);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("fpd:model:model")
    public String get(Model model, @PathVariable("id") Long id) {
        FpdModel fpdm = modelService.get(id);
        model.addAttribute("model", fpdm);
        init(model);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("fpd:model:model")
    public R save(FpdModel model) {
        this.modelService.save(model);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("fpd:model:model")
    public R delete(Long id) {
        this.modelService.delete(id);
        return R.ok();
    }

//    @ResponseBody
//    @GetMapping("format-order-rule")
//    @RequiresPermissions("fpd:model:model")
//    public R formatOrderRule(){
//        this.modelService.formatOrderRule();
//        return R.ok();
//    }
}
