package com.jda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jda.model.LoginModel;
import com.jda.model.UserModel;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private DataSource dataSource;

	public int registerUser(UserModel userModel) {
		// TODO Auto-generated method stubn
		int id = 0;
		try {
			Connection connection = dataSource.getConnection();
			String insertlQuery = "insert into data values(?, ?, ?, ?)";
			Object object[] = new Object[] { userModel.getName(), userModel.getEmail(), userModel.getPassword(),
			      userModel.getPhoneNumber() };
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			id = jdbcTemplate.update(insertlQuery, object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public UserModel loginUser(LoginModel userModel) {

		try{
		Connection con = dataSource.getConnection();
		String insertlQuery = "select * from data where email=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return (UserModel) jdbcTemplate.queryForObject(insertlQuery,
		      new Object[] { userModel.getEmail()}, new RowMapper() {
			      public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				      UserModel user = new UserModel();
				      user.setName(resultSet.getString("name"));
				      user.setEmail(resultSet.getString("email"));
				      user.setPassword(resultSet.getString("password"));
				      user.setPhoneNumber(resultSet.getString("phoneNumber"));
				      return user;
			      }

		      });
	}catch(Exception e){
		return null;
	}
	}

	public int update(LoginModel model, String uuid) {
		int id = 0;
		try {
			Connection con = dataSource.getConnection();
			String insertlQuery = "update data set password=? where uuid=?";
			Object object[] = new Object[]{model.getPassword(), uuid};
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate.update(insertlQuery, object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return id;
	}

	public int insertUuid(LoginModel model, String uuid) {
		try {
			Connection con = dataSource.getConnection();
			String insertlQuery = "update data set uuid=? where email=?";
			Object object[] = new Object[]{uuid, model.getEmail()};
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate.update(insertlQuery, object);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
