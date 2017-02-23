package org.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.UserDao;
import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;
import org.view.VUserId;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao uDao;

	@Override
	public Object checkUsername(String username) {
		if (uDao.getUser(username) == null)
			return JsonObject.getResult(1, "用户名可用", true);
		else
			return JsonObject.getResult(0, "用户名重复", false);
	}

	@Override
	public Object getUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		long id = user.getId();
		VUserId v = uDao.getUser(id);

		return JsonObject.getResult(1, "当前用户信息", v);
	}

	@Override
	public Object register(String username, String password, long createTime) {
		User user = new User(username, password, createTime);
		long uid = uDao.addUser(user);
		if (uid != -1) {
			UserDetail ud = new UserDetail();
			ud.setUserId(uid);
			if (uDao.addUserDetail(ud) != 1)
				return JsonObject.getResult(1, "添加用户成功", true);
			return JsonObject.getResult(0, "添加用户失败", false);
		} else {
			return JsonObject.getResult(0, "添加用户失败", false);
		}
	}

	@Override
	public Object login(HttpSession httpSession, String username,
			String password) {
		User u = uDao.getUser(username, password);
		if (u != null) {
			httpSession.setAttribute("user", u);
			return JsonObject.getResult(1, "登录成功", true);
		} else {
			return JsonObject.getResult(0, "用户名或密码错误", false);
		}
	}

	@Override
	public Object deleteUser(HttpSession session, long id) {
		User user = (User) session.getAttribute("user"); // 因为有拦截器判断是否登录，所有不需要判断
		if (user.getUsername().equals("admin")) {
			if (uDao.deleteUser(id))
				return JsonObject.getResult(1, "删除成功", true);
			else
				return JsonObject.getResult(0, "删除失败", false);
		} else {
			return JsonObject.getResult(0, "只有超级管理员才能删除用户", false);
		}
	}

	@Override
	public Object updateUserPassword(HttpSession httpSession, String oPassword,
			String nPassword) {
		User user = (User) httpSession.getAttribute("user");
		if (user.getPassword().equals(oPassword)) {
			if (uDao.updateUserPassword(user.getId(), nPassword)) {
				user.setPassword(nPassword);
				httpSession.setAttribute("user", user);
				return JsonObject.getResult(1, "修改密码成功", true);
			} else
				return JsonObject.getResult(0, "修改密码失败", false);
		} else {
			return JsonObject.getResult(0, "密码错误", false);
		}
	}

	@Override
	public Object updateUserDetail(HttpSession session, UserDetail u) {
		User user = (User) session.getAttribute("user");
		u.setUserId(user.getId());
		if (uDao.updateUserDetail(u))
			return JsonObject.getResult(1, "修改用户信息成功", true);
		else
			return JsonObject.getResult(0, "修改用户信息成功", false);
	}

	@Override
	public Object getUserList() {
		List<User> list = uDao.getUserList();

		return JsonObject.getResult(1, "success", list);
	}

	@Override
	public Object getSession(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		List list = new ArrayList<>();
		list.add(user);
		return JsonObject.getResult(1, "获取session", list);
	}
}
