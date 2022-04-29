package com.seleniumexpress.Rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RCAppEmailServiceImpl implements RCAppEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public void sendEmail(String userName,String userEmail, String result) {
		
		SimpleMailMessage newEmail=new SimpleMailMessage();
		newEmail.setTo(userEmail);
		newEmail.setSubject("Relation Calculator Application Result");
		newEmail.setText("Hi "+userName+" the result predicted by the LCApp is "+result);
		
		javaMailSender.send(newEmail);

	}

}
