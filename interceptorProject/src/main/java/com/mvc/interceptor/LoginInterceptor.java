package com.mvc.interceptor;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	protected Log log = LogFactory.getLog(LoginInterceptor.class);
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
			log.debug("============================== PostHandle ==============================");
			log.info(" Class       \t:  " + handler.getClass());
			log.info(" Request URI \t:  " + request.getRequestURI());
			log.info(" Servlet URI \t:  " + request.getServletPath());
			log.info(" 접속 id : " + request.getParameter("id") + " / 접속 id pw : " + request.getParameter("pw") + " 접속시간 :" + format.format(date));
			log.info("==================================================================== ");

		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
