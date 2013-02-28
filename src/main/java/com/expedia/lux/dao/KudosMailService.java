package com.expedia.lux.dao;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class KudosMailService {
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String from, String to, String subject, String msg) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
		//message.setContent(message, "text/html; charset=utf-8");
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
	
}
