package com.ping.blog.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ping.blog.common.ResponseEnum;

public class DispacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> cacheController = new HashMap<String, Object>();
	
	private Logger logger = Logger.getLogger(DispacherServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(req,resp);
	}
	
	private void  handleRequest(HttpServletRequest req,HttpServletResponse resp){
		
		try {
			String url = req.getRequestURI();
			Map<String, Class> mapping = (Map<String, Class>) req.getServletContext()
					.getAttribute(MyServletContextListener.MAPPING);
			Class clazz = mapping.get(url);
			if (clazz != null) {
				BaseController controller = (BaseController) cacheController.get(clazz.getName());
				if (controller == null) {
					controller = (BaseController) clazz.newInstance();
					cacheController.put(clazz.getName(), controller);
				}
				Map<String, Object> map = controller.doService(req, resp);
				Gson gson = new Gson();
				String json = gson.toJson(map);
				logger.info("返回的json数据--------------------->"+json);
				System.out.println("返回的json数据--------------------->" + json);
				resp.getWriter().write(json);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
