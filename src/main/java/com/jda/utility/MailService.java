package com.jda.utility;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService{
	
	@Autowired
//	private JavaMailSenderImpl javaMailSenderImpl;
	//@Autowired
	//private SimpleMailMessage preConfiguredMessage;
	
	public void sendMail(String link) {
		
		JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
		javaMail.setHost("smtp.gmail.com");
		javaMail.setPort(25);
		javaMail.setUsername("try.java01@gmail.com");
		javaMail.setPassword("qwertyuiop!@#$%");
		Properties properties = javaMail.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sanketrathi2330@gmail.com");
		message.setSubject("Forgot Password Bootcamp");
		message.setText("Click on the Link Below /n" + link );
		javaMail.send(message);;
	}

}
