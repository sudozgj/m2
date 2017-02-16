package org.test;

import java.util.Date;

import org.dao.imp.UserDaoImp;

import org.dao.UserDao;
import org.model.User;

public class test01 {
	public static void main(String[] args) {

		UserDao uDao = new UserDaoImp();
//		System.out.println(uDao.addUser(new User("haha","df",(int)new Date().getTime()/1000)));;
		System.out.println(new Date().getTime()/1000);
		System.out.println((int)new Date().getTime()/1000);
		System.out.println(new Long(new Date().getTime()/1000).intValue());
	}
}
