package com.mvc.project.bat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.mvc.project.dao.LoginDao;
import com.mvc.project.vo.LoginVo;

public class JobScheduler {

	@Autowired
	private LoginDao dao;

	private static List<LoginVo> vos = new ArrayList<LoginVo>();
	
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();
	String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	
//	  @Scheduled(cron="0 0 1 * * *") 스케쥴 설정 (초, 분, 시, 일, 월, 년) 
	@Scheduled(fixedDelay = 5000) // 1 분마다
	public void scheduler() {
		
		System.out.println("insert 스케쥴러 작동 시간 : " + today);
		
		for (int i = 0; i < vos.size(); i++) {
			dao.insertLog(vos.get(i));
		}
		
		vos.clear();
	}
	
	public void insertVos (LoginVo vo) {
		
		vos.add(vo);
		
	}
}