package com.mvc.project.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.project.bat.JobScheduler;
import com.mvc.project.service.LoginService;
import com.mvc.project.vo.LoginVo;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	private static JobScheduler js = new JobScheduler();
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("login");
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		LoginVo vo = new LoginVo();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		vo.setId(id);
		vo.setPw(id);
		vo.setDate(today);
		
		js.insertVos(vo);
		
		return "login";
	}
}
