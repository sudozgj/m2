package org.dao;

import java.util.List;

import org.model.Fileio;

public interface FileioDao {
	/**
	 * 添加文件
	 * @param f
	 * @return
	 */
	public boolean addFile(Fileio f);
	/**
	 * 获取文件列表
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getFileList(Integer start,Integer limit);
	/**
	 * 计算文件数目
	 * @return
	 */
	public long getFileCount();
}
