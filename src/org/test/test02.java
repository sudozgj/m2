package org.test;

import org.dao.UserDao;
import org.dao.imp.UserDaoImp;
import org.model.UserDetail;
import org.view.VUserId;

public class test02 {
	public static void main(String[] args) {
//		UserDetail u=new UserDetail();
//		u.setUserId(25L);
//		u.setName("kate");
//		u.setEmail("k@qq.com");
//		
//		UserDao uDao = new UserDaoImp();
//		uDao.updateUserDetail(u);
	
		UserDao uDao = new UserDaoImp();
		uDao.deleteUser(24L);
		
	}
}
