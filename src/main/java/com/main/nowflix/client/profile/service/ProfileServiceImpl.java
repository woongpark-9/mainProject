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
   public List<ProfileVO> getProfileList(ProfileVO profileVO, MemberVO memberVO) throws Exception {
      System.out.println("profileServiceImpl getProfileList¿€µø");
      profileVO.setEmail(memberVO.getEmail());
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
         System.out.println(member.getEmail());
         System.out.println(member.getNickname());
         String genre_name = "";
         
         for(int i = 0; i < arr.length; i++) {
            genre_name = genre_name + arr[i] + ",";
         }
         
         ProfileVO profile = new ProfileVO(member.getEmail(), member.getNickname(),
               "N", "http://yonom.duckdns.org/images/profile/Netflix-character3.png",
               genre_name);
         
         profileDAO.setProfile(profile);
         
      
      }


   
   
   
   
}