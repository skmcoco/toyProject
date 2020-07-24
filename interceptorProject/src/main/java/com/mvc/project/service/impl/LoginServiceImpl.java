package com.mvc.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.project.dao.LoginDao;
import com.mvc.project.service.LoginService;
import com.mvc.project.vo.LoginVo;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao dao;
	
	@Override
	public void insertLog(LoginVo vo) throws Exception {
		dao.insertLog(vo);
	}

}
