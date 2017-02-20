package org.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileioService {
	public int addFile(HttpSession session,HttpServletRequest request,@RequestParam("file") CommonsMultipartFile file) throws Exception;
	
	public Map getFileList(Integer start,Integer limit);
}
