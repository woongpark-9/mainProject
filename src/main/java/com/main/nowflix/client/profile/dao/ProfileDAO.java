package com.main.nowflix.client.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.profile.vo.ProfileVO;

@Repository
public class ProfileDAO {
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	// 장르를 골랐는지 체크
	public int genreCheck(MemberVO vo) {
		System.out.println("dao genreCheck 실행");
		int result = sqlSessionTemplate.selectOne("profileMapper.genreCheck",vo);
		return result;
	}

	public List<ProfileVO> getProfileList(ProfileVO profileVO) {
		System.out.println("dao getProfileList실행");
		return sqlSessionTemplate.selectList("profileMapper.getProfileList", profileVO);
	}
	
	public ProfileVO getProfile(ProfileVO vo) {
		return sqlSessionTemplate.selectOne("profileMapper.getProfile", vo);
	}
	
	public void createProfile(ProfileVO vo) {
		sqlSessionTemplate.insert("profileMapper.profileAdd", vo);
	}
	
	public void updateProfile(ProfileVO vo) {
		sqlSessionTemplate.update("profileMapper.updateProfile", vo);
	}
	
	public void setProfile(ProfileVO vo) {
		sqlSessionTemplate.update("profileMapper.setProfile", vo);
	}
	
}
