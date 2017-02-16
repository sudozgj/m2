package org.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpSession httpSession,String username,String password) throws Exception{
		if(uService.login(httpSession, username, password)){
			return JsonObject.getResult(1, "登录成功", true);
		}else {
			return JsonObject.getResult(0, "用户名或密码错误", false);
		}
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Object register(String username,String password) throws Exception{
		if(uService.register(username, password,new Date().getTime()/1000))
			return JsonObject.getResult(1, "添加用户成功", true);
		else
			return JsonObject.getResult(0, "添加用户失败", false);
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public Object getUserList() throws Exception{
		List uList = uService.getUserList();
		return JsonObject.getResult(1, "success", uList);
	}
	
	@RequestMapping("/getSession")
	@ResponseBody
	public Object getSession(HttpSession httpSession) throws Exception{
		return JsonObject.getResult(1, "获取session", uService.getSession(httpSession));
	}
}
