package org.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class SourceController {
	@RequestMapping("/getSource")
	@ResponseBody
	public Object getLogList(HttpSession session, HttpServletRequest request)
			throws Exception {
		String getRealPath = session.getServletContext().getRealPath("/");
		String getServerInfo = session.getServletContext().getServerInfo();
		String sessionContext = session.getSessionContext().toString();
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI();
		String contextPath=request.getContextPath();
		String servletPath = request.getServletPath();
		String localAddr = request.getLocalAddr();
		String remoteAddr= request.getRemoteAddr();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getRealPath", getRealPath);
		map.put("getServerInfo", getServerInfo);
		map.put("sessionContext", sessionContext);
		map.put("requestURL", requestURL);
		map.put("requestURI", requestURI);
		map.put("contextPath", contextPath);
		map.put("servletPath", servletPath);
		map.put("localAddr", localAddr);
		map.put("remoteAddr", remoteAddr);
		return JsonObject.getResult(1, "获取资源", map);
	}
}
