package com.main.nowflix.client.profile.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.profile.vo.ProfileVO;

public interface ProfileService {
	public List<ProfileVO> getProfileList(ProfileVO profileVO, MemberVO memberVO,HttpSession session) throws Exception;

	public ProfileVO getProfile(ProfileVO vo) throws Exception;

	public ProfileVO createProfile(ProfileVO vo, MemberVO memberVO) throws Exception;

	public void updateProfile(ProfileVO vo) throws Exception;

	public void setProfile(String[] arr, MemberVO member) throws Exception;
	
	public void deleteProfile(ProfileVO profile) throws Exception;
	
	public void updateProfileEdit(ProfileVO vo)throws Exception;

}