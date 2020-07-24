package com.mvc.project.controllers;

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
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		LoginVo vo = new LoginVo();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		vo.setId(id);
		vo.setPw(id);
		
		JobScheduler js = new JobScheduler();
		js.scheduler(vo);
		
		
		return "login";
	}
}
