package com.jda.service;

import com.jda.model.LoginModel;
import com.jda.model.UserModel;

public interface IUserService {
	public boolean registerUser(UserModel model);
	
	public boolean loginUser(LoginModel model);
}
