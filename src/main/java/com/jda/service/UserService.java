package com.jda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.dao.IUserDAO;
import com.jda.model.LoginModel;
import com.jda.model.UserModel;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDAO userdao;

	public boolean registerUser(UserModel model) {
		if (userdao.registerUser(model) > 0) {
			return true;
		} else {
			return false;
		}
	}

		public boolean loginUser(LoginModel model) {
			if (userdao.loginUser(model) != null) {
				return true;
			} else {
				return false;
			}		
	}
}
