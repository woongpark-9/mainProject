package com.main.nowflix.client.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.dao.ProfileDAO;
import com.main.nowflix.client.profile.vo.ProfileVO;



@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDAO profileDAO;

	@Override
	public List<ProfileVO> getProfileList(ProfileVO profileVO) throws Exception {
		System.out.println("profileServiceImpl getProfileList¿€µø");
		return profileDAO.getProfileList(profileVO);
	}

	@Override
	public void createProfile(ProfileVO vo) throws Exception {
		profileDAO.createProfile(vo);
	}

	@Override
	public ProfileVO getProfile(ProfileVO vo) throws Exception {
		return profileDAO.getProfile(vo);
	}

	@Override
	public void updateProfile(ProfileVO vo) throws Exception {
		profileDAO.updateProfile(vo);
	}

	@Override
	public void setProfile(String[] arr) throws Exception {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	
	
	
}
