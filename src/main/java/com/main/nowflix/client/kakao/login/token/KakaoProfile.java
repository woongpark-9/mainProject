package com.main.nowflix.client.kakao.login.token;

import java.util.Properties;

import org.springframework.context.annotation.Profile;


public class KakaoProfile {
 public Integer id;
 public String connected_at;
 public Properties properties;
 public KakaoAccount kakao_account;


 public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getConnected_at() {
	return connected_at;
}


public void setConnected_at(String connected_at) {
	this.connected_at = connected_at;
}


public Properties getProperties() {
	return properties;
}


public void setProperties(Properties properties) {
	this.properties = properties;
}


public KakaoAccount getKakao_account() {
	return kakao_account;
}


public void setKakao_account(KakaoAccount kakao_account) {
	this.kakao_account = kakao_account;
}


public class Properties {
  public String nickname;
  public String profile_image;
  public String thumbnail_image;
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getProfile_image() {
	return profile_image;
}
public void setProfile_image(String profile_image) {
	this.profile_image = profile_image;
}
public String getThumbnail_image() {
	return thumbnail_image;
}
public void setThumbnail_image(String thumbnail_image) {
	this.thumbnail_image = thumbnail_image;
}
  
  
 }


 public class KakaoAccount {
  public Boolean profile_needs_agreement;
  public Profile profile;
  public Boolean has_email;
  public Boolean email_needs_agreement;
  public Boolean is_email_valid;
  public Boolean is_email_verified;
  public String email;
  public String birthyear;
  public Boolean has_birthday;
  public Boolean birthyear_needs_agreement;
  public String gender;
  public Boolean gender_needs_agreement;
  public String birthday;
  public Boolean birthday_needs_agreement;
  public String birthday_type;
  public Boolean has_gender;
  
  public Boolean getHas_gender() {
	return has_gender;
}


public void setHas_gender(Boolean has_gender) {
	this.has_gender = has_gender;
}


public String getBirthday() {
	return birthday;
}


public void setBirthday(String birthday) {
	this.birthday = birthday;
}


public Boolean getBirthday_needs_agreement() {
	return birthday_needs_agreement;
}


public void setBirthday_needs_agreement(Boolean birthday_needs_agreement) {
	this.birthday_needs_agreement = birthday_needs_agreement;
}


public String getBirthday_type() {
	return birthday_type;
}


public void setBirthday_type(String birthday_type) {
	this.birthday_type = birthday_type;
}


public Boolean getHas_birthday() {
	return has_birthday;
}


public void setHas_birthday(Boolean has_birthday) {
	this.has_birthday = has_birthday;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public Boolean getGender_needs_agreement() {
	return gender_needs_agreement;
}


public void setGender_needs_agreement(Boolean gender_needs_agreement) {
	this.gender_needs_agreement = gender_needs_agreement;
}


public String getBirthyear() {
	return birthyear;
}


public void setBirthyear(String birthyear) {
	this.birthyear = birthyear;
}


public Boolean getBirthyear_needs_agreement() {
	return birthyear_needs_agreement;
}


public void setBirthyear_needs_agreement(Boolean birthyear_needs_agreement) {
	this.birthyear_needs_agreement = birthyear_needs_agreement;
}


public Boolean getProfile_needs_agreement() {
	return profile_needs_agreement;
}


public void setProfile_needs_agreement(Boolean profile_needs_agreement) {
	this.profile_needs_agreement = profile_needs_agreement;
}


public Profile getProfile() {
	return profile;
}


public void setProfile(Profile profile) {
	this.profile = profile;
}


public Boolean getHas_email() {
	return has_email;
}


public void setHas_email(Boolean has_email) {
	this.has_email = has_email;
}


public Boolean getEmail_needs_agreement() {
	return email_needs_agreement;
}


public void setEmail_needs_agreement(Boolean email_needs_agreement) {
	this.email_needs_agreement = email_needs_agreement;
}


public Boolean getIs_email_valid() {
	return is_email_valid;
}


public void setIs_email_valid(Boolean is_email_valid) {
	this.is_email_valid = is_email_valid;
}


public Boolean getIs_email_verified() {
	return is_email_verified;
}


public void setIs_email_verified(Boolean is_email_verified) {
	this.is_email_verified = is_email_verified;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public class Profile {
   public String nickname;
   public String thumbnail_image_url;
   public String profile_image_url;
   public Boolean is_default_image;
   
public Boolean getIs_default_image() {
	return is_default_image;
}
public void setIs_default_image(Boolean is_default_image) {
	this.is_default_image = is_default_image;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getThumbnail_image_url() {
	return thumbnail_image_url;
}
public void setThumbnail_image_url(String thumbnail_image_url) {
	this.thumbnail_image_url = thumbnail_image_url;
}
public String getProfile_image_url() {
	return profile_image_url;
}
public void setProfile_image_url(String profile_image_url) {
	this.profile_image_url = profile_image_url;
}
   
   
  }
 }
}