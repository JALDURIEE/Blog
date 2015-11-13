package com.ping.blog.servlet;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.blog.common.ResponseEnum;
import com.ping.blog.common.annotation.Controller;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.daoimpl.ArticleDaoImpl;
import com.ping.blog.util.StringUtil;
import com.ping.blog.vo.Article;

@Controller(name = "InsertArticleController", url = "/Blog/insertArticle.do")
public class InsertArticleController extends BaseController {

	@Override
	public Map<String, Object> doService(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String title = req.getParameter("title");
		String tag = req.getParameter("tag");
		String content = req.getParameter("content");
		String author = req.getParameter("userName");
		// String createTime = req.getParameter("createTime");
		try {
			
			if (StringUtil.isBlank(author) || StringUtil.isBlank(title) || StringUtil.isBlank(tag)
					|| StringUtil.isBlank(content)) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime = format.format(new Date());
			Article article = new Article();
			article.setTitle(title);
			article.setTag(tag);
			article.setContent(content);
			article.setCreateTime(createTime);
			article.setUpdateTime(createTime);
			article.setAuthor(author);
			ArticleDao articleDao = new ArticleDaoImpl();
			if (!articleDao.insertArticle(article)) {
				buildResponse(modelMap, ResponseEnum.FAILURE);
				return modelMap;
			}
			buildResponse(modelMap, ResponseEnum.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			buildResponse(modelMap, ResponseEnum.FAILURE);
		}
		return modelMap;	}

}
