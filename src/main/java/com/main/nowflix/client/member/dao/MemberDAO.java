package com.main.nowflix.client.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.member.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sql;

	// 회원가입
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}

	// 로그인
	public MemberVO login(MemberVO vo) throws Exception {

		return sql.selectOne("memberMapper.login", vo);
	}

	// 서비스에서 보낸 파라미터들을 memberUpdate 에 담는다
	public void memberUpdate(MemberVO vo) throws Exception {
		sql.update("memberMapper.memberUpdate", vo);
	}

	// 패스워드 체크
	public int passCheck(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.passCheck", vo);
		return result;
	}

	// 유저이메일이 db에 있는지 검사 있으면 1 없으면 0 반환
	public int idCheck(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.idCheck", vo);
		return result;
	}

	public int oauthEmailCheck(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.oauthEmailCheck", vo);
		return result;
	}

	public void oauthRegister(MemberVO vo) throws Exception {
		sql.insert("memberMapper.oauthRegister", vo);
	}

	public String certCheck(MemberVO vo) throws Exception {
		String code = sql.selectOne("memberMapper.certCheck", vo);
		return code;
	}

	public void certUpdate(MemberVO vo) throws Exception {
		System.out.println("dao certUpdate 실행");
		sql.update("memberMapper.certUpdate", vo);
	}

	public String ticketCheck(MemberVO vo) throws Exception {
		System.out.println("dao ticketCheck 실행");
		String result = sql.selectOne("memberMapper.ticketCheck", vo);
		return result;
	}

	public String genreCheck(MemberVO vo) throws Exception {
		System.out.println("dao genreCheck 실행");
		String result = sql.selectOne("memberMapper.genreCheck", vo);
		return result;
	}

	public void updateTicket(MemberVO vo) throws Exception {
		System.out.println("dao updateTicket 실행");
		sql.update("memberMapper.updateTicket", vo);
	}

	public void addinfo(MemberVO vo) throws Exception {
		System.out.println("dao addinfo 실행");
		sql.update("memberMapper.addinfo", vo);
	}

	public void setGenre(MemberVO vo) throws Exception {
		System.out.println("Member테이블 genre Y로 바꿈");
		sql.update("memberMapper.setGenre", vo);
	}

	public MemberVO getMember(MemberVO vo) throws Exception {
		System.out.println("getMember DAO");
		return sql.selectOne("memberMapper.getMember", vo);
	}

	public void kakaoConnect(MemberVO vo) throws Exception {
		System.out.println("dao kakaoConnect 실행");
		sql.update("memberMapper.kakaoConnect", vo);
	}

	public void naverConnect(MemberVO vo) throws Exception {
		System.out.println("dao naverConnect 실행");
		sql.update("memberMapper.naverConnect", vo);
	}
}
