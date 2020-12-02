package com.chk.pdms.pd.controller;

import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.service.PdInfoService;
import com.chk.pdms.pd.service.PdParamService;
import com.chk.pdms.pd.vo.ImportDataVo;
import com.chk.pdms.pd.vo.PdInfoVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/pd/info")
public class PdInfoController {
    private String prefix = "pd/info";

    @Autowired
    private PdInfoService infoService;
    @Autowired
    private PdExportExcelService excel;

    @Autowired
    private PdParamService paramService;

    private void init(Model model, PdInfo info){
        List<PdParam> params = paramService.list4Info();

        List<PdParam> quality = new ArrayList<>();
        List<PdParam> size = new ArrayList<>();
        List<PdParam> capacity = new ArrayList<>();
        List<PdParam> temperature = new ArrayList<>();
        List<PdParam> voltage = new ArrayList<>();
        List<PdParam> tolerance = new ArrayList<>();
        List<PdParam> outlet = new ArrayList<>();
        List<PdParam> elecCode = new ArrayList<>();
        List<PdParam> capNum = new ArrayList<>();
        List<PdParam> elecType = new ArrayList<>();
        List<PdParam> temperRange = new ArrayList<>();
        List<PdParam> wireMa = new ArrayList<>();
        List<PdParam> wireSize = new ArrayList<>();
        List<PdParam> elecSer = new ArrayList<>();
        List<PdParam> socStr = new ArrayList<>();
        List<PdParam> packType = new ArrayList<>();
        List<PdParam> pin = new ArrayList<>();

        model.addAttribute("quality", quality);
//        model.addAttribute("size", size);
        model.addAttribute("capacity", capacity);
        model.addAttribute("temperature", temperature);
        model.addAttribute("voltage", voltage);
        model.addAttribute("tolerance", tolerance);
        model.addAttribute("outlet", outlet);
        model.addAttribute("elecCode", elecCode);
        model.addAttribute("capNum", capNum);
        model.addAttribute("elecType", elecType);
        model.addAttribute("temperRange", temperRange);
        model.addAttribute("wireMa", wireMa);
        model.addAttribute("wireSize", wireSize);
        model.addAttribute("elecSer", elecSer);
        model.addAttribute("socStr", socStr);
        model.addAttribute("packType", packType);
        model.addAttribute("pin", pin);

        for (PdParam param : params) {
            if (ParamType.quality.value().equals(param.getType())){
                quality.add(param);
            }else if (ParamType.size.value().equals(param.getType())){
                size.add(param);
            }else if (ParamType.capacity.value().equals(param.getType())){
                capacity.add(param);
            }else if (ParamType.temperature.value().equals(param.getType())){
                temperature.add(param);
            }else if (ParamType.voltage.value().equals(param.getType())){
                voltage.add(param);
            }else if (ParamType.tolerance.value().equals(param.getType())){
                tolerance.add(param);
            }else if (ParamType.outlet.value().equals(param.getType())){
                outlet.add(param);
            }else if (ParamType.elecCode.value().equals(param.getType())){
                elecCode.add(param);
            }else if (ParamType.capNum.value().equals(param.getType())){
                capNum.add(param);
            }else if (ParamType.elecType.value().equals(param.getType())){
                elecType.add(param);
            }else if (ParamType.temperRange.value().equals(param.getType())){
                temperRange.add(param);
            }else if (ParamType.wireMa.value().equals(param.getType())){
                wireMa.add(param);
            }else if (ParamType.wireSize.value().equals(param.getType())){
                wireSize.add(param);
            }else if (ParamType.elecSer.value().equals(param.getType())){
                elecSer.add(param);
            }else if (ParamType.socStr.value().equals(param.getType())){
                socStr.add(param);
            }else if (ParamType.packType.value().equals(param.getType())){
                packType.add(param);
            }else if (ParamType.pin.value().equals(param.getType())){
                pin.add(param);
            }
        }

        Map<String, List<PdParam>> sizeMap = new LinkedHashMap<>();
        for (PdParam s : size) {
            List<PdParam> list = sizeMap.get(s.getRel());
            if (list == null){
                list = new ArrayList();
                sizeMap.put(s.getRel(), list);
            }
            list.add(s);
        }
        model.addAttribute("size", sizeMap);

        List<PdParam> selectedSize = null;
        if (info != null && info.getStd() != null){
            selectedSize = sizeMap.get(info.getStd());
        }
        selectedSize = selectedSize == null ? new ArrayList<>() : selectedSize;
        model.addAttribute("selectedSize", selectedSize);
    }

    @PostMapping("/test/printByEasyExcel")
    public void printByEasyExcel( HttpServletResponse response) throws IOException {
        excel.printByEasyExcel(response);
    }


    @GetMapping()
    @RequiresPermissions("pd:info:info")
    public String pdModel() {
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("pd:info:info")
    public Page<PdInfoVo> list(String key, PageReq pageReq) {
        Page<PdInfoVo> list = infoService.list(key, pageReq);
        return list;
    }

    @GetMapping("/add")
    @RequiresPermissions("pd:info:info")
    public String add(Model model) {
        PdInfoVo info = new PdInfoVo();
        model.addAttribute("info", info);
        init(model, info);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("pd:info:info")
    public String get(Model model, @PathVariable("id") Long id) {
        PdInfoVo info = infoService.get(id);
        model.addAttribute("info", info);
        init(model, info);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("pd:info:info")
    public R save(PdInfo info) {
        this.infoService.save(info);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("pd:info:info")
    public R delete(Long id) {
        this.infoService.delete(id);
        return R.ok();
    }

    @ResponseBody
    @GetMapping("build-ft-index")
    @RequiresPermissions("pd:info:info")
    public R buildFtIndex(){
        infoService.buildFtIndex();
        return R.ok();
    }

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

}
