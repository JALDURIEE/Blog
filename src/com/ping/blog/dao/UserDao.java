package com.ping.blog.dao;

import com.ping.blog.vo.User;

public interface UserDao {
	
	public User queryUserByUserName(String userName);
	public boolean verifyUser(User user,String password);

}
