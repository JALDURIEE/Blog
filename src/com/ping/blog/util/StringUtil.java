package com.ping.blog.util;

public class StringUtil {
	
	public static boolean isBlank(String str){
		
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}

}
