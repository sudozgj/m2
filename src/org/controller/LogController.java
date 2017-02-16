package org.controller;

import java.util.List;
import java.util.Map;

import org.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class LogController {
	@Autowired
	private LogService lService;

	@RequestMapping("/getLogList")
	@ResponseBody
	public Object getLogList(Integer start, Integer limit) throws Exception {
		Map map = lService.getLogList(start, limit);
		return JsonObject.getResult(1, "获取日志", map);
	}
}
