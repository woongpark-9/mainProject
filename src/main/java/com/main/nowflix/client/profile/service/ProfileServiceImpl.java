package com.main.nowflix.client.profile.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.profile.dao.ProfileDAO;
import com.main.nowflix.client.profile.vo.ProfileVO;

@SessionAttributes("member")
@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDAO profileDAO;

	@Override
	public List<ProfileVO> getProfileList(ProfileVO profileVO, MemberVO memberVO,HttpSession session) throws Exception {
		System.out.println("profileServiceImpl getProfileList�۵�");
//		memberVO = (MemberVO) session.getAttribute("member");
		profileVO.setEmail(memberVO.getEmail());
		return profileDAO.getProfileList(profileVO);
	}

	@Override
	public ProfileVO createProfile(ProfileVO vo, MemberVO memberVO) throws Exception {
		System.out.println("createProfile�� ù��° ��" + vo.toString());
		vo.setEmail(memberVO.getEmail());
		vo.setGenre_name("N");

		System.out.println("createProfile�� profileVO" + vo.toString());
		profileDAO.createProfile(vo);
		vo = profileDAO.getProfileNew(vo);
		System.out.println("serviceImpl ����" + vo);
		return vo;
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
		System.out.println(arr);

		String genre_name = "";

		for (int i = 0; i < arr.length; i++) {
			genre_name = genre_name + arr[i] + ",";
		}

		System.out.println(genre_name);
		System.out.println(member.toString());

		if (member.getGenre().equals("N")) {
			System.out.println("1");
			ProfileVO profileVO = new ProfileVO(member.getEmail(), member.getNickname(), "N",
					"http://yonom.duckdns.org/images/profile/Netflix-avatar0.png", genre_name);
			System.out.println(profileVO.toString());

			profileDAO.setProfile(profileVO);

		} else {
			System.out.println("getGenreCheck�� Y�϶� ����");
			ProfileVO profileVO = new ProfileVO();
			profileVO.setEmail(member.getEmail());
			profileVO = profileDAO.getProfileNew(profileVO);

			profileVO.setGenre_name(genre_name);
			profileDAO.updateProfile(profileVO);

		}
	}

	@Override
	public void updateProfileEdit(ProfileVO vo) throws Exception {
		profileDAO.updateProfileEdit(vo);

	}

	@Override
	public void deleteProfile(ProfileVO profile) throws Exception {
		profileDAO.deleteProfile(profile);

	}

}