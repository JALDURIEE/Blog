package com.ping.blog.util;

import java.util.Date;

public class CalendarUtil {	
	
	public  static boolean isAfterHalfHour(Date loginTime){
		
		Date  halfHourAfterLogin = new Date(loginTime.getTime()+30*60*1000);
		Date currentTime = new Date(); 
		if(currentTime.after(halfHourAfterLogin)){
			return true;
		}
		return false;
	}

}
