package com.ping.blog.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.common.annotation.Controller;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.daoimpl.ArticleDaoImpl;
import com.ping.blog.util.StringUtil;

@Controller(name="DeleteArticleController",url="/Blog/deleteArticle.do")
public class DeleteArticleController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp) {
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
