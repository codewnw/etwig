package com.etwig.service;

public interface MailService {
	void sendMail(String toAddress, String subject, String text);
}
