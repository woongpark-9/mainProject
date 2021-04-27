package com.main.nowflix.util;

import java.util.Properties;
import com.main.nowflix.util.SHA256;
import com.main.nowflix.util.Gmail;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class sendMail {
	public static void mailCheck(String mail) {
		String email = mail;
		
		String host = "http://localhost:8080/nowflix/";
		String from = "nowflixHero@gmail.com";
		String to = email;
		String subject = "Nowflix Email 인증";
		new SHA256();
		String content = "<table align='center' cellpadding='0' cellspacing='0' width='600'><tr><td align='center' style='padding: 40px 0 30px 0;'><img src='https://fontmeme.com/permalink/210413/b2522af35e728ced3dc3c289470ed140.png'  style='display: block;' /></td></tr><tr><td align='center'>아래 링크를 누르면 Nowfilx 회원 인증이 완료됩니다.</td></tr><tr><td align='center'><a href='" + host + "emailCheck.do?cert=" + SHA256.getSHA256(to) + "'>인증하기</a></td></tr></table>";
	
		Properties p = new Properties();
		p.put("mail.smtp.host","gmail-smtp.l.google.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	
	
	public static void paymentInfo(String mail) {
		String email = mail;
		
		String host = "http://localhost:8080/nowflix/";
		String from = "nowflixHero@gmail.com";
		String to = email;
		String subject = "Nowflix Email 인증";

		String content = "<table align='center' cellpadding='0' cellspacing='0' width='600'><tr><td align='center' style='padding: 40px 0 30px 0;'><img src='https://fontmeme.com/permalink/210413/b2522af35e728ced3dc3c289470ed140.png'  style='display: block;' /></td></tr><tr><td align='center'>아래 링크를 누르면 Nowfilx 회원 인증이 완료됩니다.</td></tr><tr><td align='center'><a href='" + host + "emailCheck.do?cert=" + SHA256.getSHA256(to) + "'>인증하기</a></td></tr></table>";
	
		Properties p = new Properties();
		p.put("mail.smtp.host","gmail-smtp.l.google.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	
}
