package com.ping.blog.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ping.blog.common.ResponseEnum;
import com.ping.blog.controller.base.BaseController;
import com.ping.blog.daoimpl.UserDaoImpl;
import com.ping.blog.util.StringUtil;
import com.ping.blog.vo.User;

public class LoginController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, Object> modelMap = new HashMap<String, Object>();

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			if (StringUtil.isBlank(userName) || StringUtil.isBlank(password) ) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			User user = userDaoImpl.queryUserByUserName(userName);

			// 账号不存在
			if (user == null) {
				buildResponse(modelMap, ResponseEnum.INVALID_REG_NAME);
				return modelMap;
			}

			// 密码错误
			if (!userDaoImpl.verifyUser(user, password)) {
				buildResponse(modelMap, ResponseEnum.INVALID_LOGIN_PWD);
				return modelMap;
			}

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String loginTime = format.format(new Date());
			// 设置登录时间
			req.getServletContext().setAttribute(user.getUserName(), loginTime);
			Map<String, Object> userModel = new HashMap<String, Object>();
			userModel.put("user", user);
			buildResponse(modelMap, ResponseEnum.SUCCESS, userModel);
		} catch (Exception e) {
			e.printStackTrace();
			buildResponse(modelMap, ResponseEnum.FAILURE);
		}
		
//		resp.sendRedirect(arg0);

		return modelMap;
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setUserId(1);
		user.setUserName("tiancong");
		user.setPassword("1342323");
		user.setNickName("jalduriee");
		user.setPhone("15751866099");
		user.setEmail("540563628@qq.com");
		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("tiancong");
		user1.setPassword("1342323");
		user1.setNickName("jalduriee");
		user1.setPhone("15751866099");
		user1.setEmail("540563628@qq.com");
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user1);
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("user", user);
		map.put("code", ResponseEnum.FAILURE.getCode());
		map.put("msg", ResponseEnum.FAILURE.getMessage());
		map.put("data", userMap);
		Gson gson = new Gson();
		System.out.println("gson------>" + gson.toJson(map));
	}

}
