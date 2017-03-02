package org.dao;

import java.util.List;

import org.model.Log;

public interface LogDao {
	/**
	 * 获取日志
	 * @return
	 */
	public List getLogList(Integer start,Integer limit);
	/**
	 * 添加日志
	 * @param log
	 * @return
	 */
	public boolean addLog(Log log);
	/**
	 * 计算日志数目
	 * @return
	 */
	public long getLogCount();
	
	/**
	 * 统计日志每个类型的数目
	 * @return
	 */
	public List getLogTypeCount();
}
