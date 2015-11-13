package com.ping.blog.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ping.blog.common.ResponseEnum;
import com.ping.blog.daoimpl.UserDaoImpl;
import com.ping.blog.util.CalendarUtil;
import com.ping.blog.util.StringUtil;

public class InputFilter implements Filter {

	private static Logger logger = Logger.getLogger(InputFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		
		//记录日志
		HttpServletRequest request = (HttpServletRequest) req;
		String addr = request.getRemoteAddr();
		String url = request.getRequestURL().toString();
		logger.info("ip:"+addr + "访问-------" + url);
		request.getParameterNames();
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			logger.info(paraName + ": " + request.getParameter(paraName));
		}

		String userName = req.getParameter("userName");
		String path = HttpServletRequest.class.cast(req).getRequestURI();
		if (path.contains("/insertArticle.do") || path.contains("/updateArticle.do")
				|| path.contains("/deleteArticle.do")) {

			try {
				String loginTimeStr = null;
				if (!StringUtil.isBlank(userName)) {
					loginTimeStr = (String) req.getServletContext().getAttribute(userName);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (loginTimeStr == null || "".equals(loginTimeStr)
						|| CalendarUtil.isAfterHalfHour(dateFormat.parse(loginTimeStr))) {
					if (!StringUtil.isBlank(userName)) {
						req.getServletContext().removeAttribute(userName);
					}
					Map<String, Object> map = new HashMap<String, Object>();
					ResponseEnum responseEnum = ResponseEnum.FAILURE;
					responseEnum.setMessage("please login");
					map.put("code", responseEnum.getCode());
					map.put("msg", responseEnum.getMessage());
					Gson gson = new Gson();
					String json = gson.toJson(map);
					resp.getWriter().write(json);
					return;

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Map<String, Object> map = new HashMap<String, Object>();
				ResponseEnum responseEnum = ResponseEnum.FAILURE;
				responseEnum.setMessage("please login");
				map.put("code", responseEnum.getCode());
				map.put("msg", responseEnum.getMessage());
				Gson gson = new Gson();
				String json = gson.toJson(map);
				resp.getWriter().write(json);
				return;

			}
		}
		chain.doFilter(req, resp);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------Filter-------------------------------------------------");

	}

}
