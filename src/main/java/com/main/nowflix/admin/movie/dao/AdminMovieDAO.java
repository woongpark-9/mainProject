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
		System.out.println("DAO 작동 ---> MyBatis로 getMovieList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminMovieDAO.getMovieList", map);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getTotalCount", map);
	}

	public int deleteMovie(AdminMovieVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteMovie() 기능 처리");
		return sqlSessionTemplate.delete("AdminMovieDAO.deleteMovie", vo);
	}

	public int insertMovie(AdminMovieVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertMovie() 기능 처리");
		return sqlSessionTemplate.insert("AdminMovieDAO.insertMovie", vo);
	}

	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getMovieModifyInfo", vo);
	}

	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 modifyMovie() 기능 처리");
		return sqlSessionTemplate.update("AdminMovieDAO.modifyMovie", vo);
	}

	// 영화 상세 정보
	public AdminMovieVO getMovieDetail(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieDetail() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getMovieDetail", vo);
	}

	// PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminMovieVO> selectBoardList(AdminMovieVO vo) {
		return sqlSessionTemplate.selectList("AdminMovieDAO.selectBoardList");
	}

	// DASHBOARD 회원 수 때문에.
	public int get_all_movie_count(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 get_all_movie_count() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.get_all_movie_count", vo);
	}

	public List<AdminMemberVO> movieList(AdminMovieVO movieVO) {
		System.out.println("DAO 실행--> MyBatis 로 실행 movieList()");
		return sqlSessionTemplate.selectList("AdminMovieDAO.movieList", movieVO);
	}	
}