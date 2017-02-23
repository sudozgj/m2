package org.dao;

import java.util.List;

import org.model.User;
import org.model.UserDetail;
import org.view.VUserId;

public interface UserDao {
	/**
	 * 1检验用户名是否重复,true 可用,flase 已用
	 * @param username
	 * @return
	 */
	public User getUser(String username);
	
	/**
	 * 1.5通过id获取用户信息+详细信息，返回的是视图
	 * @param id
	 * @return
	 */
	public VUserId getUser(long id);
	
	/**
	 * 2验证登录
	 * @param u
	 * @return
	 */
	public User getUser(String username,String password);
	
	/**
	 * 3添加用户（注册）
	 * @param u
	 * @return
	 */
	public long addUser(User u);
	
	/**
	 * 4添加用户详细信息
	 * @param ud
	 * @return
	 */
	public long addUserDetail(UserDetail ud);
	
	/**
	 * 5删除用户，仅限超级管理员操作
	 * @param id
	 * @return
	 */
	public boolean deleteUser(long id);
	
	/**
	 * 6修改用户密码，
	 * @param u	(参数: id，newPassword)
	 * @return
	 */
	public boolean updateUserPassword(long id,String password);
	
	/**
	 * 7修改用户详细信息
	 * @param u	(参数：name,email,userId)
	 * @return
	 */
	public boolean updateUserDetail(UserDetail u);
	
	/**
	 * 8获取用户列表,通过视图
	 * @return
	 */
	public List getUserList();
}
