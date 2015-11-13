package com.ping.blog.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ping.blog.common.DBConnection;
import com.ping.blog.dao.ArticleDao;
import com.ping.blog.vo.Article;

public class ArticleDaoImpl implements ArticleDao {

	private Connection connection;

	public boolean insertArticle(Article article) {
		// TODO Auto-generated method stub
		String sql = "insert into articles(title,tag,content,createTime,updateTime,author) values('"
				+ article.getTitle() + "', '" + article.getTag() + "', '" + article.getContent() + "', '"
				+ article.getCreateTime() + "', '" + article.getUpdateTime() + "', '" + article.getAuthor() + "')";
		System.out.println("sql--------------->" + sql);
		return DBConnection.excuteSql(sql);
	}

	public List<Article> queryArticles() {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		String sql = "select * from articles";
		Statement statement = null;
		ResultSet rs = null;
		List<Article> list = new ArrayList<Article>();
		Article article = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				article = new Article();
				article.setArticleId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setTag(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setCreateTime(rs.getString(5));
				article.setUpdateTime(rs.getString(6));
				article.setAuthor(rs.getString(7));
				list.add(article);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				DBConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

	public List<Article> queryArticleByPageNumber(int pageNumber) {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		String sql = "select * from articles limit " + pageNumber * 10 + ", 10";
		System.out.println("sql---------------------->" + sql);
		Statement statement = null;
		ResultSet rs = null;
		List<Article> list = new ArrayList<Article>();
		Article article = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				article = new Article();
				article.setArticleId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setTag(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setCreateTime(rs.getString(5));
				article.setUpdateTime(rs.getString(6));
				article.setAuthor(rs.getString(7));
				list.add(article);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				DBConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		String sql = "update articles set title='" + article.getTitle() + "', tag='" + article.getTag() + "', content='"
				+ article.getContent() + "', updateTime='" + article.getUpdateTime() + "' " + "where articleId="
				+ article.getArticleId();
		System.out.println("sql---------------->" + sql);
		return DBConnection.excuteSql(sql);
	}

	public boolean deleteArticleById(int articleId) {
		// TODO Auto-generated method stub
		String sql = "delete from articles where articleId=" + articleId + "";
		System.out.println("sql---------------->" + sql);
		return DBConnection.excuteSql(sql);
	}

	public int queryArticleAmount() {
		// TODO Auto-generated method stub

		String sql = "select count(*) from articles";
		connection = DBConnection.getConnection();
		System.out.println("sql---------------------->" + sql);
		Statement statement = null;
		ResultSet rs = null;
		int amount = 0;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				DBConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return amount;
	}

}
