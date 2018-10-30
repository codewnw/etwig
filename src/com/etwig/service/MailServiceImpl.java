package com.etwig.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServiceImpl implements MailService {

	@Override
	public void sendMail(String toAddress, String subject, String text) {
		String from = "contact.dailymitra@gmail.com";
		String userName = "contact.dailymitra";
		String password = "Weln@mitra";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		try {
			Message mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress(from));
			mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			mail.setSubject(subject);
			mail.setText(text);

			Transport.send(mail);
			System.out.println("Sent!!!");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
