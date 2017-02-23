package org.service;

import javax.servlet.http.HttpSession;

import org.model.UserDetail;

public interface UserService {
	/**
	 * 1检验名户名是否重复
	 * @param username
	 * @return
	 */
	public Object checkUsername(String username);
	
	/**
	 * 1.5通过id获取用户信息，这里使用缓存session中保存的id来查询
	 * @param session
	 * @return
	 */
	public Object getUser(HttpSession session);
	
	/**
	 * 2添加用户，注册
	 * @param username
	 * @param password
	 * @param createTime
	 * @return
	 */
	public Object register(String username,String password,long createTime);
	
	/**
	 * 3验证登录
	 * @param httpSession
	 * @param username
	 * @param password
	 * @return
	 */
	public Object login(HttpSession httpSession,String username,String password);
	
	/**
	 * 4删除用户及用户详细信息，仅超级管理员用
	 * @param id
	 * @return
	 */
	public Object deleteUser(HttpSession session,long id);
	
	/**
	 * 5修改密码
	 * @param httpSession
	 * @param oPassword
	 * @param nPassword
	 * @return
	 */
	public Object updateUserPassword(HttpSession httpSession,String oPassword,String nPassword);
	
	/**
	 * 6修改用户详细信息
	 * @param u	（参数：name,email,userId）
	 * @return
	 */
	public Object updateUserDetail(HttpSession session,UserDetail u);
	
	/**
	 * 7获取用户详细列表
	 * @return
	 */
	public Object getUserList();
	
	/**
	 * 获取当前session信息
	 * @param httpSession
	 * @return
	 */
	public Object getSession(HttpSession httpSession);
}
