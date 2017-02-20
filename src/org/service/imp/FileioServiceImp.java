package org.service.imp;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dao.FileioDao;
import org.model.Fileio;
import org.model.User;
import org.service.FileioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.Param;

@Service
public class FileioServiceImp implements FileioService {
	@Autowired
	private FileioDao fDao;
	
	@Override
	public int addFile(HttpSession session, HttpServletRequest request,
			CommonsMultipartFile file) throws Exception{
		
		User user = (User) session.getAttribute("user");
		if(user!=null){
			long upTime = new Date().getTime();		//上传时间
			
			String fileName = file.getOriginalFilename(); // 上传文件名
			String path = request.getRealPath("/"); // 项目路径

			File dir = new File(path + "UpFileDir");
			if (!dir.exists() && !dir.isDirectory()) { // 路径不存在则创建
				dir.mkdir();
			}
			String fileRealName = upTime + "_" + fileName; // 文件实际名
			String fPath = dir + "/" + fileRealName; // 文件最终路径

			String url = Param.server+"UpFileDir"+"/"+fileRealName;
			System.out.println(url);
//			File f = new File(fPath);
//			file.transferTo(f);
//			
//			Fileio fileio = new Fileio();
//			fileio.setUsername(user.getUsername());
//			fileio.setFilename(fileName);
//			fileio.setTime(upTime);
//			fileio.setDir()
//			
//			fDao.addFile(f)
			
			return 1;
		}else{
			return -1;	//没有登录
		}
	}

	@Override
	public Map getFileList(Integer start, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
