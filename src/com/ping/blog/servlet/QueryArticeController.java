package com.ping.blog.servlet;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.common.annotation.Controller;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.daoimpl.ArticleDaoImpl;
import com.ping.blog.util.StringUtil;
import com.ping.blog.vo.Article;

@Controller(name="QueryArticeController",url="/Blog/queryArticles.do")
public class QueryArticeController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp) {
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
		return modelMap;	}

}
