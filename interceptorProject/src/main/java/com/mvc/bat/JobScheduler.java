package com.mvc.bat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class JobScheduler {

//	  @Scheduled(cron="0 0 1 * * *") 스케쥴 설정 (초, 분, 시, 일, 월, 년) 
	  @Scheduled(fixedDelay=60000) // 1 분마다
	  public void scheduler() {
	    Calendar calendar = Calendar.getInstance();
	    Date date = calendar.getTime();
	    String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	    System.out.println("스케쥴러 작동 시간 : " + today);
	    
	  }

	
}