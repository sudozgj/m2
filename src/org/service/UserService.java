package org.service;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface UserService {
	public boolean login(HttpSession httpSession,String username,String password);
	
	public boolean register(String username,String password,long createTime);
	
	public List getUserList();
	
	public List getSession(HttpSession httpSession);
}
