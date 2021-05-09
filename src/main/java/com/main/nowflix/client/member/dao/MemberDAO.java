package com.main.nowflix.client.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.member.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sql;

	// ȸ������
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}

	// �α���
	public MemberVO login(MemberVO vo) throws Exception {

		return sql.selectOne("memberMapper.login", vo);
	}

	// ���񽺿��� ���� �Ķ���͵��� memberUpdate �� ��´�
	public void memberUpdate(MemberVO vo) throws Exception {
		sql.update("memberMapper.memberUpdate", vo);
	}

	// �н����� üũ
	public int passCheck(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.passCheck", vo);
		return result;
	}

	// �����̸����� db�� �ִ��� �˻� ������ 1 ������ 0 ��ȯ
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
		System.out.println("dao certUpdate ����");
		sql.update("memberMapper.certUpdate", vo);
	}

	public String ticketCheck(MemberVO vo) throws Exception {
		System.out.println("dao ticketCheck ����");
		String result = sql.selectOne("memberMapper.ticketCheck", vo);
		return result;
	}

	public String genreCheck(MemberVO vo) throws Exception {
		System.out.println("dao genreCheck ����");
		String result = sql.selectOne("memberMapper.genreCheck", vo);
		return result;
	}

	public void updateTicket(MemberVO vo) throws Exception {
		System.out.println("dao updateTicket ����");
		sql.update("memberMapper.updateTicket", vo);
	}

	public void addinfo(MemberVO vo) throws Exception {
		System.out.println("dao addinfo ����");
		sql.update("memberMapper.addinfo", vo);
	}

	public void setGenre(MemberVO vo) throws Exception {
		System.out.println("Member���̺� genre Y�� �ٲ�");
		sql.update("memberMapper.setGenre", vo);
	}

	public MemberVO getMember(MemberVO vo) throws Exception {
		System.out.println("getMember DAO");
		return sql.selectOne("memberMapper.getMember", vo);
	}

	public void kakaoConnect(MemberVO vo) throws Exception {
		System.out.println("dao kakaoConnect ����");
		sql.update("memberMapper.kakaoConnect", vo);
	}

	public void naverConnect(MemberVO vo) throws Exception {
		System.out.println("dao naverConnect ����");
		sql.update("memberMapper.naverConnect", vo);
	}
}
