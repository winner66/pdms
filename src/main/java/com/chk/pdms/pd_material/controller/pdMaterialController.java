package com.chk.pdms.pd_material.controller;

import com.alibaba.fastjson.JSON;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.*;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdInfoService;
import com.chk.pdms.pd.service.PdParamService;
import com.chk.pdms.pd.vo.ImportDataVo;
import com.chk.pdms.pd.vo.PdInfoVo;
import com.chk.pdms.pd_material.dao.ClassMaterialTypeDao;
import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import com.chk.pdms.pd_material.service.PdMaterialService;
import com.chk.pdms.pd_material.vo.PdMaterialVo;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pd/material")
public class pdMaterialController {
    private String prefix = "pd/material";

    @Autowired
    private PdMaterialService  materialService;

    private PdExportExcelService excel;

    @Autowired
    private PdParamService paramService;
    private void init(Model model, PdMaterialVo info){
        List<PdParam> params = paramService.listMaterialInfo();

        List<PdParam> quality = new ArrayList<>();
        List<PdParam> size = new ArrayList<>();
        List<PdParam> bandwidth  = new ArrayList<>();
        List<PdParam> centerFrequency  = new ArrayList<>();
        List<PdParam> lengthWidthCode = new ArrayList<>();
        List<PdParam> materialCode = new ArrayList<>();
        List<PdParam> thicknessCode = new ArrayList<>();
        List<PdParam> surfaceCode = new ArrayList<>();

        List<PdParam> cutOffFrequency = new ArrayList<>();
        List<PdParam> basisMaterial = new ArrayList<>();
        List<PdParam> frequencyRange = new ArrayList<>();
        List<PdParam> passBandRange = new ArrayList<>();
        model.addAttribute("quality", quality);
        model.addAttribute("size", size);
        model.addAttribute("bandwidth",bandwidth);
        model.addAttribute("centerFrequency",centerFrequency);
        model.addAttribute("lengthWidthCode",lengthWidthCode);
        model.addAttribute("materialCode",materialCode);
        model.addAttribute("thicknessCode",thicknessCode);
        model.addAttribute("surfaceCode",surfaceCode);
        model.addAttribute("cutOffFrequency",cutOffFrequency);
        model.addAttribute("basisMaterial",basisMaterial);
        model.addAttribute("frequencyRange",frequencyRange);
        model.addAttribute("passBandRange",passBandRange);



        for (PdParam param : params) {
            if (ParamType.quality.value().equals(param.getType())){
                quality.add(param);
            }else if (ParamType.size.value().equals(param.getType())) {
                size.add(param);
            }else if (ParamType.bandwidth.value().equals(param.getType())) {
                bandwidth.add(param);
            }
            else if (ParamType.centerFrequency.value().equals(param.getType())) {
             centerFrequency.add(param);
            }else if (ParamType.lengthWidthCode.value().equals(param.getType())) {
                lengthWidthCode.add(param);
            }else if (ParamType.materialCode.value().equals(param.getType())) {
                materialCode.add(param);
            }else if (ParamType.thicknessCode.value().equals(param.getType())) {
                thicknessCode.add(param);
            }else if (ParamType.surfaceCode.value().equals(param.getType())) {
                surfaceCode.add(param);
            }else if (ParamType.cutOffFrequency.value().equals(param.getType())) {
                cutOffFrequency.add(param);
            }else if (ParamType.basisMaterial.value().equals(param.getType())) {
                basisMaterial.add(param);
            }else if (ParamType.frequencyRange.value().equals(param.getType())) {
                frequencyRange.add(param);
            }else if (ParamType.passBandRange.value().equals(param.getType())) {
                passBandRange.add(param);
            }

        }
    }
    @GetMapping()
    @RequiresPermissions("pd:material:material")
    public String pdModel() {
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("pd:material:material")
    public Page<PdMaterialVo> list(String key, PageReq pageReq) {

        Page<PdMaterialVo> list = materialService.list(key, pageReq);
        return list;
    }

    @GetMapping("/add")
    @RequiresPermissions("pd:material:material")
    public String add(Model model) {
        PdMaterialVo info = new PdMaterialVo();
        model.addAttribute("info", info);

        List<TableRsp> tag= materialService.getclzLevel1();
        List<TreeRsp> tag2= materialService.getclz();
        model.addAttribute("tag",tag);
        model.addAttribute("tag2",tag2);

        init(model, info);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("pd:material:material")
    public String get(Model model, @PathVariable("id") Long id) {
        PdMaterialVo info = materialService.get(id);
//        info.setTag(info.getMaterialType()+"_"+info.getMaterialType2());

        model.addAttribute("info", info);
        List<TableRsp> tag= materialService.getclzLevel1();
        List<TreeRsp> tag2= materialService.getclz();
        model.addAttribute("tag",tag);
        model.addAttribute("tag2",tag2);
        init(model, info);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("pd:material:material")
    public R save(PdInfoMaterial info) {
        this.materialService.save(info);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("pd:info:info")
    public R delete(Long id) {
        this.materialService.delete(id);
        return R.ok();
    }
    @ResponseBody
    @PostMapping("import-data")
    @RequiresPermissions("pd:material:material")
    public R importData(ImportDataVo vo){
        ImportDataVo rsp = materialService.importData(vo);
        if (rsp.getCode().equals("200")) {
            return R.ok(rsp.getMsg());
        }else{
            return R.error(rsp.getMsg());
        }
    }
    @ResponseBody
    @GetMapping("build-ft-index")
    @RequiresPermissions("pd:material:material")
    public R buildFtIndex(){
        materialService.buildFtIndex();
        return R.ok();
    }


    @GetMapping("/getTag2")
    @RequiresPermissions("pd:material:material")
    public R getTag2() {

        List<TreeRsp> tag2= materialService.getclz();
        String Str = JSON.toJSONString(tag2);
        return  R.ok(Str);
    }
}
