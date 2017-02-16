package org.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor {

	/**
	 * Handler 执行前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("\nSome拦截器——preHandle");
		
		return true;
	}

	/**
	 * Handler 执行后，return 前调用
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("\nSome拦截器——postHandle");
	}

	/**
	 * Handler 执行后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("\nSome拦截器——afterCompletion");
	}

}
