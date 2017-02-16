package org.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.UserDao;
import org.dao.UserDetailDao;
import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao uDao;
	@Autowired
	private UserDetailDao udDao;
	

	@Override
	public boolean login(HttpSession httpSession,String username, String password) {
		System.out.println("	username:"+username);
		System.out.println("	password:"+password);
		
		User user = new User(username,password);
		User u = uDao.login(user);
		if(u!=null){
			u.setPassword("******");
			httpSession.setAttribute("user", u);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean register(String username,String password,long createTime) {
		User user = new User(username,password,createTime);
		long uid = uDao.addUser(user);
		if(uid!=-1){
			UserDetail ud = new UserDetail();
			ud.setUserId(uid);
			if(udDao.addUserDetail(ud)!=1)
				return true;
			return false;
		}else {
			return false;
		}
	}

	@Override
	public List getUserList() {
		List<User> list = uDao.getUserList();
		
		return list;
	}

	@Override
	public List getSession(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		List list=  new ArrayList<>();
		list.add(user);
		System.out.println("	"+user.getId());
		return list;
	}
}
