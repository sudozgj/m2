package org.dao;

import java.util.List;

import org.model.UserDetail;

public interface UserDetailDao {
	/**
	 * 添加用户详细信息
	 * @param ud
	 * @return
	 */
	public long addUserDetail(UserDetail ud);
	/**
	 * 获取用户详细信息列表
	 * @return
	 */
	public List getUserDetail();
	/**
	 * 编辑用户详细信息
	 * @param ud
	 * @return
	 */
	public boolean editUserDetail(UserDetail ud);
}
