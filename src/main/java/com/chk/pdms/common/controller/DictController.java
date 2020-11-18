package com.chk.pdms.common.controller;

import com.chk.pdms.common.config.Constant;
import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.domain.SysDictType;
import com.chk.pdms.common.service.DictService;
import com.chk.pdms.common.service.DictTypeService;
import com.chk.pdms.common.utils.PageUtils;
import com.chk.pdms.common.utils.Query;
import com.chk.pdms.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
 */

@Controller
@RequestMapping("/common/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@Autowired
	private DictTypeService dictTypeService;

	@GetMapping()
	@RequiresPermissions("common:dict:dict")
	String dict() {
		return "common/dict/dict";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:dict:dict")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<DictDO> dictList = dictService.list(query);
		int total = dictService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:dict:dict")
	String add() {
		return "common/dict/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:dict:dict")
	String edit(@PathVariable("id") Long id, Model model) {
		DictDO dict = dictService.get(id);
		model.addAttribute("dict", dict);
		return "common/dict/edit";
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
		dictService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("common:dict:dict")
	public R remove(Long id) {
		if (dictService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
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

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("common:dict:dict")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/dict/add";
	}

	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/list/{type}")
	public List<DictDO> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", type);
		List<DictDO> dictList = dictService.list(map);
		return dictList;
	}
//
//	查询类型type(sys_dict_type)
	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/list/allType")
	public List<SysDictType> listByAllType() {
		// 查询列表数据
		return dictTypeService.list();
	}

	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/add/dict_type")
	public R addDictType(SysDictType type) {
		if ( dictTypeService.save(type) > 0) {
			return R.ok();
		}
		return R.error();
	}
	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/update/dict_type")
	public R updateDictType(SysDictType type) {
		if (dictTypeService.update(type) > 0) {
			return R.ok();
		}
		return R.error();
	}
	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/delete/dict_type/{id}")
	public R removeDictType( @PathVariable("id") Long id) {
		if (dictTypeService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("common:dict:dict")
	@ResponseBody
	@GetMapping("/delete/dict_type")
	public R batchRemoveDictType(@RequestParam("ids[]")  Long[] id) {
		dictTypeService.batchRemove(id);
		return  R.ok();
	}

}
