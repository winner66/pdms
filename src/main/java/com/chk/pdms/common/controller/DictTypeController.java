package com.chk.pdms.common.controller;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.service.DictTypeService;
import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.common.utils.PageUtils;
import com.chk.pdms.common.utils.Query;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.vo.PdClassVo;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/common/dictType")
public class DictTypeController extends BaseController {
    @Autowired
    private DictService dictService;

    @Autowired
    private DictTypeService dictTypeService;



    @GetMapping()
    @RequiresPermissions("common:dict:dict")
    String dict() {
        return "common/dictType/dict";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:dict:dict")
    public List<DictDO> list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        List<DictDO> dictList = dictService.listAll();
        return dictList;
    }

    @GetMapping("/add/{pId}/{type}")
    @RequiresPermissions("common:dict:dict")
    public  String add(Model model, @PathVariable("pId") Long pId, @PathVariable("type") String type) {

        DictDO dict = new DictDO();

        model.addAttribute("dictType", dict);
        if (pId != 0) {
            dict.setParentId(pId);
            DictDO Pdict = dictService.get(pId);
            dict.setLevel(Pdict.getLevel() + 1);
            dict.setType(type);
            model.addAttribute("PreName", Pdict.getName());
        }else{
            dict.setParentId(0L);
            dict.setLevel(1);
            dict.setType(type);
            model.addAttribute("PreName", "");
        }
        return "common/dictType/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("common:dict:dict")
    public String edit( Model model,@PathVariable("id") Long id) {
        DictDO dict = dictService.get(id);
        model.addAttribute("dict", dict);
        return "common/dictType/edit";
    }
    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:dict:dict")
    public R save(DictDO dict) {
        if (dictService.save(dict) > 0) {
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("common:dict:dict")
    public R update(DictDO dict) {
        if (dictService.update(dict) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/remove")
    @RequiresPermissions("common:dict:dict")
    public R  remove( Long id, Model model) {
        Boolean delete= dictService.delete(id);
        if (delete){
            return R.ok();
        }else{
            return R.error("含有下级分类,不能删除!");
        }
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("common:dict:dict")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        dictService.batchRemove(ids);
        return R.ok();
    }







    @GetMapping("/type")
    @ResponseBody
    public List<DictDO> listType() {
        return dictService.listType();
    };

//    // 类别已经指定增加
//    @GetMapping("/add/{type}/{description}")
//    @RequiresPermissions("common:dict:dict")
//    String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
//        model.addAttribute("type", type);
//        model.addAttribute("description", description);
//        return "common/dict/add";
//    }

}
