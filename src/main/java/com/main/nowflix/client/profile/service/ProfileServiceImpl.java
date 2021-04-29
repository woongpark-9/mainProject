package com.main.nowflix.client.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.profile.dao.ProfileDAO;
import com.main.nowflix.client.profile.vo.ProfileVO;



@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDAO profileDAO;

	@Override
	public List<ProfileVO> getProfileList(ProfileVO profileVO) throws Exception {
		System.out.println("profileServiceImpl getProfileList작동");
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
	   public void setProfile(String[] arr, MemberVO member) throws Exception {
	      int horror = 0;
	      int comic = 0;
	      int action = 0;
	      int thriller = 0;
	      int sf = 0;
	      int adventure = 0;
	      int drama = 0;
	      int animation = 0;
	      int crime = 0;
	      int familyg = 0;
	      int fantasy = 0;
	      int mystery = 0;
	      int romance = 0;
	      int melodrama = 0;
	      int a_historical_drama = 0;
	      
	      // 프로파일 장르컬럼에 값입력
	      System.out.println("프로필 장르컬럼에 값입력");
	      for(int i=0; i<arr.length; i++) {
	         if(arr[i].contains("스릴러")) {
	            thriller++;
	         }
	         if(arr[i].contains("SF")) {
	            sf++;
	         }
	         if(arr[i].contains("액션")) {
	            action++;
	         }
	         if(arr[i].contains("어드벤처")) {
	            adventure++;
	         }
	         if(arr[i].contains("드라마")) {
	            drama++;
	         }
	         if(arr[i].contains("애니메이션")) {
	            animation++;
	         }
	         if(arr[i].contains("범죄")) {
	            crime++;
	         }
	         if(arr[i].contains("코미디")) {
	            comic++;
	         }
	         if(arr[i].contains("가족")) {
	            familyg++;
	         }
	         if(arr[i].contains("판타지")) {
	            fantasy++;
	         }
	         if(arr[i].contains("미스터리")) {
	            mystery++;
	         }
	         if(arr[i].contains("공포")) {
	            horror++;
	         }
	         if(arr[i].contains("로멘스")) {
	            romance++;
	         }
	         if(arr[i].contains("멜로")) {
	            melodrama++;
	         }
	         if(arr[i].contains("시대극")) {
	            a_historical_drama++;
	         }
	      }
	      
	      System.out.println(member.getEmail());
	      System.out.println(member.getNickname());
	      
	      ProfileVO profile = new ProfileVO(member.getEmail(), member.getNickname(),
	            horror, comic, action, thriller, sf, adventure, drama, animation,
	            crime, familyg, fantasy, mystery, romance, melodrama, a_historical_drama,
	            "N", "http://yonom.duckdns.org/images/profile/Netflix-character3.png");
	      
	      profileDAO.setProfile(profile);
	      
	   
	   }
	   

	
	
	
	
}
