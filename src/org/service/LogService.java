package org.service;


public interface LogService {
	/**
	 * 获取日志列表，分页参数start、limit不传默认为0、15
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getLogList(Integer start,Integer limit);
	
	/**
	 * 统计日志每种类型的数目
	 * @return
	 */
	public Object getLogTypeCount();
}
