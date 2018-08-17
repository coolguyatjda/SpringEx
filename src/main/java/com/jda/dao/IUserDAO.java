package com.jda.dao;

import com.jda.model.LoginModel;
import com.jda.model.UserModel;

public interface IUserDAO {
	public int registerUser(UserModel model);

	public UserModel loginUser(LoginModel model);
}
