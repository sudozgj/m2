package org.service.imp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountService implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("创建session......");
		ServletContext context = event.getSession().getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			count = new Integer(1);
		} else {
			int co = count.intValue();
			count = new Integer(co + 1);
		}
		System.out.println("当前用户人数：" + count);
		context.setAttribute("count", count);// 保存人数
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("销毁session......");
		ServletContext context = event.getSession().getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		int co = count.intValue();
		count = new Integer(co - 1);
		context.setAttribute("count", count);
		System.out.println("当前用户人数：" + count);
	}
}
