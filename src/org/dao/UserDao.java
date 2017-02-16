package org.dao;

import java.util.List;

import org.model.User;

public interface UserDao {
	/**
	 * 验证登录
	 * @param u
	 * @return
	 */
	public User login(User u);
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public long addUser(User u);
	/**
	 * 获取用户列表
	 * @return
	 */
	public List getUserList();
}
