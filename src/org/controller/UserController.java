package org.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;
import org.view.VUserId;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	@RequestMapping("/checkUsername")
	@ResponseBody
	public Object checkUsername(String username) throws Exception {
		return uService.checkUsername(username);
	}

	@RequestMapping("/register")
	@ResponseBody
	public Object register(User u) throws Exception {
		long time = new Date().getTime() / 1000;
		return uService.register(u.getUsername(), u.getPassword(), time);
	}

	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpSession httpSession, User u) throws Exception {
		return uService.login(httpSession, u.getUsername(), u.getPassword());
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public Object deleteUser(HttpSession session, long id) throws Exception {
		return uService.deleteUser(session, id);
	}

	@RequestMapping("/updateUserPassword")
	@ResponseBody
	public Object updateUserPassword(HttpSession session, String oPwd,
			String nPwd) throws Exception {
		return uService.updateUserPassword(session, oPwd, nPwd);
	}
	
	@RequestMapping("/updateUserDetail")
	@ResponseBody
	public Object updateUserDetail(HttpSession session,String name,String email) throws Exception {
		UserDetail u = new UserDetail();
		u.setName(name);
		u.setEmail(email);
		return uService.updateUserDetail(session,u);
	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public Object getUserList() throws Exception {
		return uService.getUserList();
	}

	@RequestMapping("/getSession")
	@ResponseBody
	public Object getSession(HttpSession httpSession) throws Exception {
		return uService.getSession(httpSession);
	}
}
