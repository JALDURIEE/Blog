package com.ping.blog.dao;

import java.util.List;

import com.ping.blog.vo.Article;

public interface ArticleDao {
	
	public boolean insertArticle(Article article);
	public List<Article> queryArticles();
	public List<Article> queryArticleByPageNumber(int pageNumber);
	public boolean updateArticle(Article article);
	public boolean deleteArticleById(int articleId);
	public int queryArticleAmount();
}
