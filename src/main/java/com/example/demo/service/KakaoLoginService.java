package com.example.demo.service;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class KakaoLoginService {
	
	public String getKakaoAccessToken(String code) {
		String accessToken = "";
		String refreshToken = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			
			
		} catch (Exception e) {System.out.println("getKakaoAccessToken : "+e.getMessage());}
		
		
		return null;
	}

}
