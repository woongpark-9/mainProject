package com.main.nowflix.client.login.auth;

import org.apache.commons.lang3.StringUtils;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;

public class SnsValue implements SnsUrls {
	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;
	
	private boolean isNaver;
	private boolean isGoogle;

	public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
		this.service = service;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUrl = redirectUrl;

		this.isNaver = StringUtils.equalsIgnoreCase("naver", this.service);
		this.isGoogle = StringUtils.equalsIgnoreCase("google", this.service);

		if (isNaver) {
			this.api20Instance = NaverAPI20.instance();
			this.profileUrl = NAVER_PROFILE_URL;

		} else if (isGoogle) {
			this.api20Instance = GoogleApi20.instance();
			this.profileUrl = GOOGLE_PROFILE_URL;
		}
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public DefaultApi20 getApi20Instance() {
		return api20Instance;
	}

	public void setApi20Instance(DefaultApi20 api20Instance) {
		this.api20Instance = api20Instance;
	}

	
	public boolean isNaver() {
		return isNaver;
	}

	public void setNaver(boolean isNaver) {
		this.isNaver = isNaver;
	}

	public boolean isGoogle() {
		return isGoogle;
	}

	public void setGoogle(boolean isGoogle) {
		this.isGoogle = isGoogle;
	}

	@Override
	public String toString() {
		return "SnsValue [service=" + service + ", clientId=" + clientId + ", clientSecret=" + clientSecret
				+ ", redirectUrl=" + redirectUrl + ", api20Instance=" + api20Instance + "]";
	}

}
