package com.jda.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jda.dao.UserDAO;
import com.jda.service.UserService;
import com.mysql.cj.core.exceptions.PasswordExpiredException;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.jda.controller")
@EnableWebMvc
public class Configuration {
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME"));
		driverManagerDataSource.setUsername(System.getenv("DBUSER"));
		driverManagerDataSource.setPassword(System.getenv("DBPASSWORD"));
		return driverManagerDataSource;
		
	}
	
	@Bean
	public UserDAO getUserdao(){
		return new UserDAO();
	}
	
	@Bean
	public UserService getUserService(){
		return new UserService();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public JavaMailSender getMailSender(){
//		JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
//		javaMail.setHost("smtp.gmail.com");
//		javaMail.setPort(587);
//		javaMail.setUsername("try.java01@gmail.com");
//		javaMail.setPassword("qwertyuiop!@#$%");
//		Properties properties = javaMail.getJavaMailProperties();
//		properties.put("mail.transport.protocol", "smtp");
//		properties.put("mail.smtp.auth", true);
//		properties.put("mail.smtp.starttls.enable", true);
//		properties.put("mail.debug", true);
//		return javaMail;
//	}
}
