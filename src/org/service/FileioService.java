package org.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileioService {
	/**
	 * 1上传文件
	 * @param session
	 * @param request
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Object addFile(HttpSession session,HttpServletRequest request,@RequestParam("file") CommonsMultipartFile file) throws Exception;
	
	/**
	 * 2获取文件列表，提供分页参数，不传默认start=0、limit=15,并返回文件总数
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getFileList(Integer start,Integer limit);
	
	/**
	 * 3删除文件（删除数据库记录+删除文件夹下文件）
	 * @param id
	 * @return
	 */
	public Object deleteFile(HttpSession session,long id);
}
