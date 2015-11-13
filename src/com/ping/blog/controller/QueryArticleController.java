package com.ping.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.controller.base.BaseController;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.daoimpl.ArticleDaoImpl;
import com.ping.blog.util.StringUtil;
import com.ping.blog.vo.Article;

public class QueryArticleController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String pageNumber = req.getParameter("pageNumber");
		ArticleDao articleDao = new ArticleDaoImpl();
		try {
			if (StringUtil.isBlank(pageNumber)) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			List<Article> list = articleDao.queryArticleByPageNumber(Integer.parseInt(pageNumber));
			if (list == null || list.isEmpty()) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			
			Map<String, Object> articlesModel = new HashMap<String, Object>();
			articlesModel.put("acticleInfos", list);
			articlesModel.put("pageNumber", pageNumber);
			int totalAmount =  articleDao.queryArticleAmount();
			articlesModel.put("totalAmount", totalAmount);
			buildResponse(modelMap, ResponseEnum.SUCCESS, articlesModel);
		} catch (Exception e) {
			e.printStackTrace();
			buildResponse(modelMap, ResponseEnum.FAILURE);
		}
		return modelMap;
	}

}
