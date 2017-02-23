package org.dao;

import java.util.List;

import org.model.Fileio;

public interface FileioDao {
	/**
	 * 1添加文件
	 * @param f
	 * @return
	 */
	public boolean addFile(Fileio f);
	
	/**
	 * 2获取文件列表
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getFileList(Integer start,Integer limit);
	
	/**
	 * 2.5通过id获取Fileio对象
	 * @param id
	 * @return
	 */
	public Fileio getFile(long id);
	
	/**
	 * 3计算文件数目
	 * @return
	 */
	public long getFileCount();
	
	/**
	 * 4删除文件，仅超级管理员或自己操作
	 * @param id
	 * @return
	 */
	public boolean deleteFile(long id);
}
