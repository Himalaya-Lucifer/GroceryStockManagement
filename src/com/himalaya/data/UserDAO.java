package com.himalaya.data;

import java.io.InputStream;

import com.himlaya.model.User;

public interface UserDAO {

	public void addUser(User user)throws Exception;
	public User getUser(String userId)throws Exception;
	public void updatePhoto(String userId,InputStream inputStream) throws Exception;
}
