package com.main.nowflix.client.profile.service;

import java.util.List;

import com.main.nowflix.client.profile.vo.ProfileVO;

public interface ProfileService {
	public List<ProfileVO> getProfileList(ProfileVO profileVO) throws Exception;
	public ProfileVO getProfile(ProfileVO vo) throws Exception;
	public void createProfile(ProfileVO vo) throws Exception;
	public void updateProfile(ProfileVO vo) throws Exception;
}
