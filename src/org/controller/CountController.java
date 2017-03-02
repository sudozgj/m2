package org.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountController implements HttpSessionListener{

	/**
	 * 统计在线人数
	 */
	
	@RequestMapping("/getOnlineCount")
	@ResponseBody
	public Object getLogList(Integer start, Integer limit) throws Exception {
//		HttpSessionEvent event;
//		ServletContext context=event.getSession().getServletContext();   
//        Integer count=(Integer)context.getAttribute("count");
//		
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("onlineNum", ""+count);
//		return map;
		return null;
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("创建session......");   
        ServletContext context=event.getSession().getServletContext();   
        Integer count=(Integer)context.getAttribute("count");   
        if(count==null){   
            count=new Integer(1);   
        }else{   
            int co = count.intValue( );   
            count= new Integer(co+1);
        }   
        System.out.println("当前用户人数："+count);   
        context.setAttribute("count", count);//保存人数   
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("销毁session......");   
        ServletContext context=event.getSession().getServletContext();   
        Integer count=(Integer)context.getAttribute("count");   
        int co=count.intValue();   
        count=new Integer(co-1);   
        context.setAttribute("count", count);   
        System.out.println("当前用户人数："+count); 
	}
}
