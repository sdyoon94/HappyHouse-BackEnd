package com.ssafy.happyhouse.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class CryptoUtil {
	public static String sha512(String str) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		if(str!=null) {
			MessageDigest md=MessageDigest.getInstance("SHA-512");
			md.update(str.getBytes("utf-8"));
			return Base64.getEncoder().encodeToString(md.digest());
		}
		return "";
	}
}


//SHA-512 암호화 알고리즘 코드
//파라미터로 비밀번호 보내면 암호화 문자열 리턴

//SHA-512 선택 이유
//암호화 알고리즘은 단방향, 양방향 두가지로 나뉜다.
//단방향은 암호화만 가능하고 양방향은 암호화, 복호화가 가능한데
//비밀번호 같은 경우 암호화된 문자열을 비교하면 되기 때문에(원본 데이터를 알 필요가 없기 때문에) 굳이 복호화할 필요가 없다.
//따라서 단방향 알고리즘을 선택해야 하는데
//단방향 알고리즘엔 MD5, SHA 시리즈가 있다.
//MD5는 보안 취약점이 발견된 알고리즘이므로 SHA 계열을 선택했고
//그 중에서도 가장 긴 Bit수를 사용하는 SHA-512를 선택하였다.
