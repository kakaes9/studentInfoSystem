package org.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class File implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		request.setCharacterEncoding("utf-8");

		return true;
	}


}
