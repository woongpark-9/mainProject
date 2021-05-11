package com.main.nowflix.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.main.nowflix.client.kakao.pay.vo.KakaoPayApprovalVO;


public class sendMail {
	public static void mailCheck(String mail) {
		String email = mail;
		
		String host = "http://ec2-18-221-64-44.us-east-2.compute.amazonaws.com:8080/nowflix/";
		String from = "nowflixHero@gmail.com";
		String to = email;
		String subject = "Nowflix Email ����";
		new SHA256();
		String content = "<table align='center' cellpadding='0' cellspacing='0' width='600'><tr><td align='center' style='padding: 40px 0 30px 0;'><img src='https://fontmeme.com/permalink/210413/b2522af35e728ced3dc3c289470ed140.png'  style='display: block;' /></td></tr><tr><td align='center'>�Ʒ� ��ũ�� ������ Nowfilx ȸ�� ������ �Ϸ�˴ϴ�.</td></tr><tr><td align='center'><a href='" + host + "emailCheck.do?cert=" + SHA256.getSHA256(to) + "'>�����ϱ�</a></td></tr></table>";
	
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
	
	
	public static void paymentInfo(String mail, KakaoPayApprovalVO vo) {
		String email = mail;
		Date approved_at = vo.getApproved_at();
		String partner_order_id = vo.getPartner_order_id();
		String item_name = vo.getItem_name();
		int amount = vo.getAmount().getTotal();
		String payment_method_type = vo.getPayment_method_type();
		String card_info = vo.getCard_info().getPurchase_corp();
		String host = "http://localhost:8080/nowflix/";
		String from = "nowflixHero@gmail.com";
		String to = email;
		String subject = "Nowflix ���� ����";

		String content = "<table align='center' cellpadding='0' cellspacing='0' width='600'><tr><td align='center' style='padding: 40px 0 30px 0;'><img src='https://fontmeme.com/permalink/210413/b2522af35e728ced3dc3c289470ed140.png'  style='display: block;' /></td></tr><tr><td align='center'>Nowflix ���� ����</td></tr><tr><td align='left'>���� �Ͻ� : </td><td align='left'></td></tr><tr><td align='left'>�ֹ� ��ȣ : </td><td align='left'>" + partner_order_id + "</td></tr><tr><td align='left'>��ǰ ���� : </td><td align='left'>" + item_name + "</td></tr><tr><td align='left'>���� �ݾ� : </td><td align='left'></td></tr><tr><td align='left'>���� ��� : </td><td align='left'>" + payment_method_type + "</td></tr><tr><td align='left'>���� ī�� : </td><td align='left'>" + card_info + "</td></tr></table>";
	
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
