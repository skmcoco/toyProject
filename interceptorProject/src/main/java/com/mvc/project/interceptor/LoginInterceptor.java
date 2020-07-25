package com.mvc.project.interceptor;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Date date = new Date();
	protected DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String logindate = format.format(date);
		
		if (id != null && pw != null) {
			logger.debug("============================== PostHandle ==============================");
			logger.info(" Class       \t:  " + handler.getClass());
			logger.info(" Request URI \t:  " + request.getRequestURI());
			logger.info(" Servlet URI \t:  " + request.getServletPath());
			logger.info(" 접속 id : " + request.getParameter("id") + " / 접속 id pw : " + request.getParameter("pw") + " 접속시간 :" + format.format(date));
			logger.info("==================================================================== ");

		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
