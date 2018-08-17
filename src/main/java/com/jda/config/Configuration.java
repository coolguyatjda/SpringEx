package com.jda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME"));
		driverManagerDataSource.setUsername(System.getenv("DBUSER"));
		driverManagerDataSource.setPassword(System.getenv("DBPASSWORD"));
		return driverManagerDataSource;
		
	}
}
