package com.ping.blog.controller.base;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ping.blog.common.ResponseEnum;

public abstract class BaseController extends HttpServlet{
	
	private static final String CODE_KEY = "code";
	private static final String MSG_KEY = "msg";
	private static final String DATA_KEY = "data";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	    Map<String, Object> map = doService(req,resp);
	    Gson gson = new Gson();
		String json =  gson.toJson(map);
		System.out.println("返回的json数据--------------------->"+json);
		resp.getWriter().write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = doService(req,resp);
		Gson gson = new Gson();
		String json =  gson.toJson(map);
		System.out.println("返回的json数据--------------------->"+json);
		resp.getWriter().write(json);
	}

	
	public abstract Map<String,Object> doService(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException ;
	
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
