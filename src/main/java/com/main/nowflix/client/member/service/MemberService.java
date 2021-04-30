package com.main.nowflix.client.member.service;

import com.main.nowflix.client.member.vo.MemberVO;

public interface MemberService {
	public void register(MemberVO vo) throws Exception;

	public MemberVO login(MemberVO vo) throws Exception;

	public void memberUpdate(MemberVO vo) throws Exception;

	public int idCheck(MemberVO vo) throws Exception;

	public int passChk(MemberVO vo) throws Exception;

	public void oauthRegister(MemberVO vo) throws Exception;

	public int oauthEmailCheck(MemberVO vo) throws Exception;

	public String certCheck(MemberVO vo) throws Exception;

	public void certUpdate(MemberVO vo) throws Exception;

	public String ticketCheck(MemberVO vo) throws Exception;

	public String genreCheck(MemberVO vo) throws Exception;

	public void updateTicket(MemberVO vo) throws Exception;

	public void addinfo(MemberVO vo) throws Exception;

	public void setGenre(MemberVO vo) throws Exception;
}
