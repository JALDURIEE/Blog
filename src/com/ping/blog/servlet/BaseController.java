package com.ping.blog.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;

public abstract class BaseController {
	
	private static final String CODE_KEY = "code";
	private static final String MSG_KEY = "msg";
	private static final String DATA_KEY = "data";
	
	public abstract Map<String,Object> doService(HttpServletRequest req,HttpServletResponse resp);

	protected final void buildResponse(Map<String,Object> modelMap, ResponseEnum responseEnum) {
		buildResponse(modelMap,responseEnum,null);
	}
	
	protected final void buildResponse(Map<String,Object> modelMap, ResponseEnum responseEnum, Object data) {
		modelMap.put(CODE_KEY, responseEnum.getCode());
		modelMap.put(MSG_KEY, responseEnum.getMessage());
		if(data != null) {
			modelMap.put(DATA_KEY, data);
		}
	}
}
