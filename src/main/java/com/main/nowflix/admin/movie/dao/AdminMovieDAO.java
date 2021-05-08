package com.main.nowflix.admin.movie.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Repository
public class AdminMovieDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<AdminMovieVO> getMovieList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getMovieList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminMovieDAO.getMovieList", map);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getMovieModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getTotalCount", map);
	}

	public int deleteMovie(AdminMovieVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteMovie() ��� ó��");
		return sqlSessionTemplate.delete("AdminMovieDAO.deleteMovie", vo);
	}

	public int insertMovie(AdminMovieVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertMovie() ��� ó��");
		return sqlSessionTemplate.insert("AdminMovieDAO.insertMovie", vo);
	}

	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getMovieModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getMovieModifyInfo", vo);
	}

	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� modifyMovie() ��� ó��");
		return sqlSessionTemplate.update("AdminMovieDAO.modifyMovie", vo);
	}

	// ��ȭ �� ����
	public AdminMovieVO getMovieDetail(AdminMovieVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getMovieDetail() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getMovieDetail", vo);
	}

	// PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminMovieVO> selectBoardList(AdminMovieVO vo) {
		return sqlSessionTemplate.selectList("AdminMovieDAO.selectBoardList");
	}

	// DASHBOARD ȸ�� �� ������.
	public int get_all_movie_count(AdminMovieVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� get_all_movie_count() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.get_all_movie_count", vo);
	}

	public List<AdminMemberVO> movieList(AdminMovieVO movieVO) {
		System.out.println("DAO ����--> MyBatis �� ���� movieList()");
		return sqlSessionTemplate.selectList("AdminMovieDAO.movieList", movieVO);
	}	
}