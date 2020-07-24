package com.mvc.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.project.vo.LoginVo;

@Repository
public class LoginDao {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private static String namespace = "com.mvc.project.dao.LoginDao";
	
	public void insertLog(LoginVo vo) {
		sqlsession.insert( namespace + ".insertLog", vo);
	}

}
