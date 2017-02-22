package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MappingController {
	
	/**
	 * 用于列出后台管理所有映射关系的列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMappingList")
	@ResponseBody
	public Object getMappingList()throws Exception{
		
		return null;
	}
}
