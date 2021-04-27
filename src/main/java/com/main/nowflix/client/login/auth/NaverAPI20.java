package com.main.nowflix.client.login.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverAPI20 extends DefaultApi20 implements SnsUrls { // auth 2.0
	// naverAPI auth는 항상 싱글톤으로만들어야함 -> 
	// private)싱글톤 : JVM에 Object가 하나만 생성되게 함 (외부에서 생성되면 안됨 =

	private NaverAPI20() {
	}
	
	private static class InstanceHolder {
		private static final NaverAPI20 INSTANCE = new NaverAPI20();
	}

	public static NaverAPI20 instance() {
		return InstanceHolder.INSTANCE;
	}

	// DefaulApi20

	@Override
	public String getAccessTokenEndpoint() {
		return NAVER_ACCESS_TOKEN;
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return NAVER_AUTH;
	}
}