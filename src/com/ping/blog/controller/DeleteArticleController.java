package com.ping.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.controller.base.BaseController;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.daoimpl.ArticleDaoImpl;
import com.ping.blog.util.StringUtil;

public class DeleteArticleController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String articleId = req.getParameter("articleId");
		try {
			
			if (StringUtil.isBlank(articleId)) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			ArticleDao articleDao = new ArticleDaoImpl();
			if (!articleDao.deleteArticleById(Integer.parseInt(articleId))) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
			}
			buildResponse(modelMap, ResponseEnum.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			buildResponse(modelMap, ResponseEnum.FAILURE);
		}
		return modelMap;
	}

}
