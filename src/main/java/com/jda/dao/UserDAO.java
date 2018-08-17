package com.jda.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jda.model.UserModel;

@Repository
public class UserDAO implements IUserDAO{

	@Autowired
	private DataSource dataSource;
	
	public int registerUser(UserModel userModel){
		// TODO Auto-generated method stubn 
		int id = 0;
		try{
			Connection connection = dataSource.getConnection();
			String insertlQuery = "insert into data values(?, ?, ?, ?)";
			Object object[] = new Object[]{userModel.getName(), userModel.getEmail(), userModel.getPassword(), userModel.getPhoneNumber()};
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			id = jdbcTemplate.update(insertlQuery, object);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}

}
