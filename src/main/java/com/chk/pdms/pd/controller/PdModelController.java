package com.chk.pdms.pd.controller;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.utils.BDException;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdClassService;
import com.chk.pdms.pd.service.PdModelService;
import com.chk.pdms.pd.service.PdParamService;
import com.chk.pdms.pd.vo.PdModelVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pd/model")
public class PdModelController {
    private String prefix = "pd/model";

    @Autowired
    private PdModelService modelService;

    @Autowired
    private PdClassService classService;

    @Autowired
    private PdParamService paramService;

    @Autowired
    private DictService dictService;

    private void init(Model model) {
        List<DictDO> type = dictService.listByType("产品参数类别");
        List<DictDO> cut = dictService.listByType("产品参数分割");
        model.addAttribute("type", type);
        model.addAttribute("cut", cut);

        List<PdParam> quality = paramService.listByType("质量等级");
        model.addAttribute("quality", quality);
    }

    @GetMapping()
    @RequiresPermissions("pd:model:model")
    public String pdModel(Model model, String mode) {
        //mode: page | win
        mode = StringUtils.isBlank(mode) ? "page" : mode;
        model.addAttribute("mode", mode);
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("pd:model:model")
    public Page<PdModelVo> list(Long pcId, String name, PageReq pageReq) {
        Page<PdModelVo> list = modelService.list(pcId, name, pageReq);
        return list;
    }

    @GetMapping("/add/{pcId}")
    @RequiresPermissions("pd:model:model")
    public String add(Model model, @PathVariable("pcId") Long pcId) {
        PdModelVo vo = new PdModelVo();
        if (pcId != 0L) {
            PdClass clz = classService.get(pcId);
            vo.setPdClassId(clz.getId());
            vo.setPcName(clz.getName());
        }
        vo.arrayOR();
        model.addAttribute("model", vo);
        init(model);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("pd:model:model")
    public String get(Model model, @PathVariable("id") Long id) {
        PdModelVo pdm = modelService.get(id);
        model.addAttribute("model", pdm);
        init(model);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("pd:model:model")
    public R save(PdModelVo modelVo) {
        try {
            this.modelService.save(modelVo);
        } catch (BDException e) {
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("pd:model:model")
    public R delete(Long id) {
        this.modelService.delete(id);
        return R.ok();
    }

//    @ResponseBody
//    @GetMapping("format-order-rule")
//    @RequiresPermissions("pd:model:model")
//    public R formatOrderRule(){
//        this.modelService.formatOrderRule();
//        return R.ok();
//    }

    @ResponseBody
    @GetMapping("update-img")
    @RequiresPermissions("pd:model:model")
    public R formatOrderRule() {
        this.modelService.updateImg();
        return R.ok();
    }
}
