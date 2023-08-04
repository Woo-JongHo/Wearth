package com.example.demo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserJpaRepository;
import com.example.demo.vo.UsersVO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoLoginService {

	@Autowired
	private UserJpaRepository ur;
	
	
	public String getKakaoAccessToken (String code) {
		String accessToken = "";
		String refreshToken = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			// setDoOutput()은 OutputStream으로 POST 데이터를 넘겨 주겠다는 옵션이다.
			// POST 요청을 수행하려면 setDoOutput()을 true로 설정한다.
			conn.setDoOutput(true);
			
			// POST 요청에서 필요한 파라미터를 OutputStream을 통해 전송
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			String sb = "grant_type=authorization_code" +
					"&client_id=29ba16db25cdb9eb61b39a437825310b" + // REST_API_KEY
					"&redirect_uri=http://localhost:8080/kakao/callback" + // REDIRECT_URI
					"&code=" + code;
			bufferedWriter.write(sb);
			bufferedWriter.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			// 요청을 통해 얻은 데이터를 InputStreamReader을 통해 읽어 오기
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			StringBuilder result = new StringBuilder();
			
			while ((line = bufferedReader.readLine()) != null) {
				result.append(line);
			}
			System.out.println("response body : " + result);
			
			JsonElement element = JsonParser.parseString(result.toString());
			
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
			refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
			
			System.out.println("accessToken : " + accessToken);
			System.out.println("refreshToken : " + refreshToken);
			
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}
	
	public Optional<UsersVO> getUserInfo(String accessToken) {
	    String postURL = "https://kapi.kakao.com/v2/user/me";

	    try {
	        URL url = new URL(postURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");

	        conn.setRequestProperty("Authorization", "Bearer " + accessToken);

	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String line = "";
	        StringBuilder result = new StringBuilder();

	        while ((line = br.readLine()) != null) {
	            result.append(line);
	        }
	        System.out.println("response body : " + result);

	        JsonElement element = JsonParser.parseString(result.toString());
	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	        JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

	        String id = "kakao@"+element.getAsJsonObject().get("id").getAsString();
	        return ur.findById(id);
	       

	    } catch (IOException exception) {
	        exception.printStackTrace();
	    }
	    
	    return Optional.empty();
	}

}
