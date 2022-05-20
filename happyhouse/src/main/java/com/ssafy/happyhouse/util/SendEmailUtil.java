package com.ssafy.happyhouse.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendEmailUtil {
	public static String makeTempPw(int tempPwLength) {
		String tempPw="";
		for (int i = 0; i < tempPwLength; i++) {
			//33~126
			tempPw+=Character.toString((int)(Math.random()*94)+33);
		}
		return tempPw;
	}
	
	public static String SendEmail(String userEmail) {
		String recipient=userEmail;
		int tempPwLength=10;
		String tempPw=makeTempPw(tempPwLength);
		
		final String email="내 이메일 주소";
		final String password="이메일 비밀번호";
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(email));
 
            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
            // Subject
            message.setSubject("Happyhouse 임시 비밀번호 설정");
 
            // Text
            message.setText("임시 비밀번호는 "+tempPw+"입니다. \n로그인 후 바꾸시길 바랍니다.");
 
            Transport.send(message);    // send message
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
		return tempPw;
	}
}
