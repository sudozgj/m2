package org.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.User;
import org.service.FileioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.tool.JsonObject;

@Controller
public class FileioController {
	@Autowired
	private FileioService fService;
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Object uploadFile2(HttpSession session, HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {

		fService.addFile(session, request, file);
		

		return JsonObject.getResult(1, "source", null);
	}

	@RequestMapping("/uploadFile2")
	@ResponseBody
	public Object uploadFile3(HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {

		String path = request.getRealPath("/"); // 项目路径
		File dir = new File(path + "UpFileDir");
		if (!dir.exists() && !dir.isDirectory()) { // 路径不存在则创建
			dir.mkdir();
		}
		String fPath = dir + "/" + new Date().getTime() + "_"; // 文件路径+前缀

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file1 = multiRequest.getFile(iter.next()
						.toString());
				if (file1 != null) {
					file1.transferTo(new File(fPath
							+ file1.getOriginalFilename())); // 上传
				}
			}
		}
		return JsonObject.getResult(1, "source", null);
	}

}
