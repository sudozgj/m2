package org.service.imp;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dao.FileioDao;
import org.model.Fileio;
import org.model.User;
import org.service.FileioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class FileioServiceImp implements FileioService {
	@Autowired
	private FileioDao fDao;

	@Override
	public Object addFile(HttpSession session, HttpServletRequest request,
			CommonsMultipartFile file) throws Exception {

		long upTime = new Date().getTime() / 1000; // 上传时间
		String fileName = file.getOriginalFilename(); // 上传文件名
		String path = request.getRealPath("/"); // 项目路径

		File dir = new File(path + "UpFileDir");
		if (!dir.exists() && !dir.isDirectory()) { // 路径不存在则创建
			dir.mkdir();
		}
		String fileRealName = upTime + "_" + new Random().nextInt(10)
				+ fileName.substring(fileName.indexOf(".")); // 文件实际名
		String fPath = dir + File.separator + fileRealName; // 文件最终路径

		String url = new readProperties().getP("server") + "UpFileDir" + "/"
				+ fileRealName;

		File f = new File(fPath);
		file.transferTo(f);
		// --文件传输完成--
		User user = (User) session.getAttribute("user");

		Fileio fileio = new Fileio();
		fileio.setUsername(user.getUsername()); // 文件上传用户
		fileio.setFilename(fileName); // 文件上传名
		fileio.setTime(upTime); // 上传时间
		fileio.setDir(fPath); // 文件上传路径
		fileio.setUrl(url); // 文件url

		if (fDao.addFile(fileio))
			return JsonObject.getResult(1, "上传成功", true);
		else
			return JsonObject.getResult(1, "上传失败", false);
	}

	@Override
	public Object getFileList(Integer start, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		List li = fDao.getFileList(start, limit);
		long c = fDao.getFileCount();
		map.put("count", c);
		map.put("list", li);

		return JsonObject.getResult(1, "获取文件列表", map);
	}

	@Override
	public Object deleteFile(HttpSession session, long id) {
		try {
			User user = (User) session.getAttribute("user");
			String sUsername = user.getUsername();
			Fileio f = fDao.getFile(id);
			if (f != null) {
				if (sUsername.equals("admin")
						|| sUsername.equals(f.getUsername())) { // 不是本人或不是admin无法删除
					String dir = f.getDir();
					if (fDao.deleteFile(id)) {
						// 将文件从文件系统中删除
						File file = new File(dir);
						file.delete();
						return JsonObject.getResult(1, "删除文件成功", true);
					} else {
						return JsonObject.getResult(0, "删除文件失败", false);
					}
				} else {
					return JsonObject.getResult(0, "无法删除他人文件", false);
				}
			} else {
				return JsonObject.getResult(0, "文件id无效", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonObject.getResult(0, "删除文件失败", false);
		}
	}
}
