package com.ping.blog.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class InterfaceTest {

	@Test
	public void testLoginSuccess() {

		String url = "http://localhost:8080/Blog/login.do";
		String data = "userName=tiancong&password=123456";
		try {
			String json = queryData(url, data);
			Gson gson = new Gson();
			BaseModel baseModel = gson.fromJson(json, BaseModel.class);
			Assert.assertEquals("0", baseModel.getCode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

//	@Test
//	public void testLoginFail() {
//
//		String url = "http://localhost:8080/Blog/login.do";
//		String[] args = { "userName=tiancong&password=1234561", "password=1234561", "userName=tiancong", "" };
//		try {
//			for (int i = 0; i < args.length; i++) {
//				String json = queryData(url, args[0]);
//				Gson gson = new Gson();
//				BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//				Assert.assertTrue(!"0".equals(baseModel.getCode()));
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//
//		}
//
//	}
//
//	@Test
//	public void testQueryArticles() {
//
//		String url = "http://localhost:8080/Blog/queryArticles.do";
//		String data = "pageNumber=0";
//		try {
//			String json = queryData(url, data);
//			Gson gson = new Gson();
//			BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//			Assert.assertEquals("0", baseModel.getCode());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//	}
//
//	@Test
//	public void testQueryFail() {
//
//		String url = "http://localhost:8080/Blog/queryArticles.do";
//
//		String[] args = { "pageNumber=", "pageNumber=u", "" };
//		try {
//			for (int i = 0; i < args.length; i++) {
//				String json = queryData(url, args[i]);
//				Gson gson = new Gson();
//				BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//				Assert.assertTrue(!"0".equals(baseModel.getCode()));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//	}
//
//	@Test
//	public void testInsertArticle() {
//		String url = "http://localhost:8080/Blog/insertArticle.do";
//		String data = "userName=tiancong&title=Java IO&tag=java&content=java io study";
//		try {
//			String json = queryData(url, data);
//			Gson gson = new Gson();
//			BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//			Assert.assertEquals("0", baseModel.getCode());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//
//	}
//
//	@Test
//	public void testInsertFail() {
//
//		String url = "http://localhost:8080/Blog/insertArticle.do";
//		String[] args = { "userName=tiancong&title=Java IO&tag=java", "",
//				"title=Java IO&tag=java&content=java io study", "userName=tiancong&tag=java&content=java io study" };
//		try {
//			for (int i = 0; i < args.length; i++) {
//				String json = queryData(url, args[i]);
//				Gson gson = new Gson();
//				BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//				Assert.assertTrue(!"0".equals(baseModel.getCode()));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//
//	}
//
//	@Test
//	public void testUpdateArticle() {
//
//		String url = "http://localhost:8080/Blog/updateArticle.do";
//		String data = "userName=tiancong&articleId=2&title=Java IO&tag=java&content=java io study";
//		try {
//			String json = queryData(url, data);
//			Gson gson = new Gson();
//			BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//			Assert.assertEquals("0", baseModel.getCode());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//	}
//
//	@Test
//	public void testUpdateFail() {
//
//		String url = "http://localhost:8080/Blog/updateArticle.do";
//		String[] args = { "userName=tiancong&articleId=2&title=Java IO&tag=java", "",
//				"articleId=2&title=Java IO&tag=java&content=java io study",
//				"userName=tiancong&tag=java&content=java io study" };
//
//		try {
//			for (int i = 0; i < args.length; i++) {
//				String json = queryData(url, args[i]);
//				Gson gson = new Gson();
//				BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//				Assert.assertTrue(!"0".equals(baseModel.getCode()));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//
//	}

//	@Test
//	public void deleteArticle() {
//
//		String url = "http://localhost:8080/Blog/deleteArticle.do";
//		String data = "userName=tiancong&articleId=11";
//		try {
//			String json = queryData(url, data);
//			Gson gson = new Gson();
//			BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//			Assert.assertEquals("0", baseModel.getCode());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//
//	}

//	@Test
//	public void testDeleteFail() {
//		String url = "http://localhost:8080/Blog/deleteArticle.do";
//		String[] args = { "userName=tiancong", "articleId=12", "" };
//		try {
//			for (int i = 0; i < args.length; i++) {
//				String json = queryData(url, args[i]);
//				Gson gson = new Gson();
//				BaseModel baseModel = gson.fromJson(json, BaseModel.class);
//				Assert.assertTrue(!"0".equals(baseModel.getCode()));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//
//	}

	private String queryData(String url, String data) throws Exception {

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setReadTimeout(30000);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.getOutputStream().write(data.getBytes("utf-8"));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}

		return sb.toString();

	}

	public static class BaseModel<T> {

		private String code;
		private String msg;
		private T data;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

}
