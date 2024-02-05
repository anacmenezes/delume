package com.delume.services.authorization;

import org.springframework.mail.SimpleMailMessage;

import com.delume.domain.Employee;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Employee employee, String newPass);
}