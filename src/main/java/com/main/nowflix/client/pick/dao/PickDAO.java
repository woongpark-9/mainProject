package com.main.nowflix.client.pick.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.pick.vo.PickVO;

@Repository
public class PickDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public PickVO getPick(PickVO pickVO) {
		System.out.println("getPick DAO 角青");
		return sqlSessionTemplate.selectOne("getPick", pickVO);
	}
	
	public void insertPick(PickVO pickVO) {
		System.out.println("setPick DAO 角青");
		sqlSessionTemplate.insert("insertPick", pickVO);
	}
	
	public void deletePick(PickVO pickVO) {
		System.out.println("deletePick DAO 角青");
		sqlSessionTemplate.delete("deletePick", pickVO);
	}
	
	public List<PickVO> getPickList(PickVO pickVO){
		System.out.println("getPickList DAO 角青");
		System.out.println(pickVO.toString());
		return sqlSessionTemplate.selectList("getPickList", pickVO);
	}
}
