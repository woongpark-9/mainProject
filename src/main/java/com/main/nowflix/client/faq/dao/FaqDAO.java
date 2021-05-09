package com.main.nowflix.client.faq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.faq.vo.FaqVO;

@Repository
public class FaqDAO {
	

	@Autowired
	private SqlSession sql;
	

	// FaqList ¸Þ¼­µå
	public List<FaqVO> getFaqList(FaqVO vo) throws Exception {
		return sql.selectList("faqMapper.getFaqList", vo);
	}

}
