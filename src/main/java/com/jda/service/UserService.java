package com.jda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.dao.IUserDAO;
import com.jda.model.UserModel;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDAO userdao;

	public boolean registerUser(UserModel model) {
userdao.registerUser(model);
		return false;
	}

}
