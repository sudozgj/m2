package org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.service.FileioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileioController {
	@Autowired
	private FileioService fService;
	
	@RequestMapping("/addFile")
	@ResponseBody
	public Object addFile(HttpSession session, HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {
		return fService.addFile(session, request, file);
	}

	@RequestMapping("/getFileList")
	@ResponseBody
	public Object getFileList(Integer start,Integer limit)throws Exception{
		return fService.getFileList(start, limit);
	}
	
	@RequestMapping("/deleteFile")
	@ResponseBody
	public Object deleteFile(HttpSession session,long id)throws Exception{
		return fService.deleteFile(session, id);
	}
}
