package com.main.nowflix.client.login.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.main.nowflix.client.member.vo.MemberVO;

public class SNSLogin {
	private OAuth20Service oauthService;
	private SnsValue sns;

	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId()).apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl()).defaultScope("profile").build(sns.getApi20Instance());

		this.sns = sns;
	}

	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}
	
	public String getGoogleAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public MemberVO getMemberProfile(String code) throws Exception {
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);

		OAuthRequest request = new OAuthRequest(Verb.GET, this.sns.getProfileUrl());
		oauthService.signRequest(accessToken, request);

		Response response = oauthService.execute(request);
		return parseJson(response.getBody());
	}

//	public String getUserProfile(String code) throws Exception {
//		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
//
//		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
//		oauthService.signRequest(accessToken, request);
//
//		Response response = oauthService.execute(request);
//		return response.getBody();
//	}

	private MemberVO parseJson(String body) throws Exception {
		MemberVO member = new MemberVO();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);

		String message = rootNode.get("message").asText();
		System.out.println(message);
		
		JsonNode responseNode = rootNode.path("response");
		
		String name = responseNode.get("name").asText();
		String email = responseNode.get("id").asText();
		String naver = responseNode.get("email").asText();
		
		member.setEmail(email);
		member.setNickname(name);
		member.setNaver(naver);
		
		System.out.println("네이버 고유번호 : "+member.getEmail());
		System.out.println("네이버 사용자 이름 :"+member.getNickname());
		System.out.println("네이버 이메일 : "+member.getNaver());
		
		

		return member;
	}

}
