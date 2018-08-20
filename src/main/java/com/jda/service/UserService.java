package com.jda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jda.dao.IUserDAO;
import com.jda.model.LoginModel;
import com.jda.model.UserModel;
import com.jda.utility.MailService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDAO userdao;
	
	@Autowired
	PasswordEncoder passEncoder;

	public boolean registerUser(UserModel model) {
		model.setPassword(passEncoder.encode(model.getPassword()));
		if (userdao.registerUser(model) > 0) 
			return true;
		return false;
	}

		public boolean loginUser(LoginModel model) {
		UserModel userModel = userdao.loginUser(model);
			if (userModel != null && passEncoder.matches(model.getPassword(), userModel.getPassword())){
//				MailService temp = new MailService();
//				temp.sendMail();
				return true;
			}
			return false;		
	}
		
		public void forgotPass(LoginModel model) {
		UserModel userModel = userdao.loginUser(model);
			if (userModel != null)
				new MailService().sendMail("");
	}
}
