package com.ssafy.happyhouse.util;

import org.springframework.stereotype.Component;

@Component
public class EmailInfo {
	public static String getEmail() {
		final String email="leesh0768@gmail.com";
		return email;
	}
	public static String getEmailPassword() {
		final String password="1q2w3e!@#";
		return password;
	}
}
