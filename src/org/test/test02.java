package org.test;

import java.util.List;

import org.dao.LogDao;
import org.dao.imp.LogDaoImp;
import org.tool.readProperties;

public class test02 {
	public static void main(String[] args) {
		LogDao lDao = new LogDaoImp();
		List li = lDao.getLogTypeCount();
		System.err.println("1");
		System.out.println(li);
		
	}
}
