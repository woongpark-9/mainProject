package com.main.nowflix.client.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.member.dao.MemberDAO;
import com.main.nowflix.client.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO dao;
	@Override
	public void register(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.register(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.memberUpdate(vo);
	}

	@Override
	public int idCheck(MemberVO vo) throws Exception {
		int result = dao.idCheck(vo);
		return result;
	}

	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = dao.passCheck(vo);
		return result;
	}

	@Override
	public void oauthRegister(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.oauthRegister(vo);
		
	}

	@Override
	public int oauthEmailCheck(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		int result = dao.oauthEmailCheck(vo);
		return result;
		
	}
	@Override
	public String certCheck(MemberVO vo) throws Exception {
		String code = dao.certCheck(vo);
		return code;
	}

	@Override
	public void certUpdate(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.certUpdate(vo);
	}

	@Override
	public String ticketCheck(MemberVO vo) throws Exception {
			String result = dao.ticketCheck(vo);
			return result;
	}

	@Override
	public String genreCheck(MemberVO vo) throws Exception {
		String result = dao.genreCheck(vo);
		return result;
	}
	
	@Override
	public void updateTicket(MemberVO vo) throws Exception {
		dao.updateTicket(vo);
	
	}
	
	@Override
	public void addinfo(MemberVO vo) throws Exception {
		dao.addinfo(vo);
		
	}
	@Override
	   public void setGenre(MemberVO vo) throws Exception {
	      dao.setGenre(vo);
	      
	   }
	
}
