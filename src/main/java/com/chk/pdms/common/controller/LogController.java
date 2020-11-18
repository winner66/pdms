package com.chk.pdms.common.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chk.pdms.common.domain.LogDO;
import com.chk.pdms.common.domain.PageDO;
import com.chk.pdms.common.service.LogService;
import com.chk.pdms.common.utils.Query;
import com.chk.pdms.common.utils.R;

@RequestMapping("/common/log")
@Controller
public class LogController {
	@Autowired
	LogService logService;
	String prefix = "common/log";

	@RequiresPermissions("common:log:log")
	@GetMapping()
	String log() {
		return prefix + "/log";
	}

	@RequiresPermissions("common:log:log")
	@ResponseBody
	@GetMapping("/list")
	PageDO<LogDO> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		PageDO<LogDO> page = logService.queryList(query);
		return page;
	}

	@RequiresPermissions("common:log:log")
	@ResponseBody
	@PostMapping("/remove")
	R remove(Long id) {
		if (logService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("common:log:log")
	@ResponseBody
	@PostMapping("/batchRemove")
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
