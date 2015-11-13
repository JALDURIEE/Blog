package com.ping.blog.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.common.annotation.Controller;
import com.ping.blog.daoimpl.UserDaoImpl;
import com.ping.blog.filter.InputFilter;
import com.ping.blog.util.StringUtil;
import com.ping.blog.vo.User;

@Controller(name = "LoginController", url = "/Blog/login.do")
public class LoginController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = new HashMap<String, Object>();

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			if (StringUtil.isBlank(userName) || StringUtil.isBlank(password)) {
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

		return modelMap;

	}

	
}
