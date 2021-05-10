package com.main.nowflix.admin.ticket.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.ticket.vo.AdminTicketVO;

@Repository
public class AdminTicketDAO {
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;

   // TICKET LIST
   public List<AdminTicketVO> getTicketList(AdminTicketVO ticketvo) {
      System.out.println("DAO 작동 ---> MyBatis로 getTicketList() 기능 처리");
      return sqlSessionTemplate.selectList("AdminTicketDAO.getTicketList", ticketvo);
   }

   // TICKET INSERT
   public int insertTicket(AdminTicketVO ticketvo) {
      System.out.println("DAO작동 ---> MyBatis로 insertTicket() 기능 처리");
      return sqlSessionTemplate.insert("AdminTicketDAO.insertTicket", ticketvo);
   }

   // TICKET DELETE
   public int deleteTicket(AdminTicketVO ticketvo) {
      System.out.println("DAO작동 ---> MyBatis로 deleteTicket() 기능 처리");
      return sqlSessionTemplate.delete("AdminTicketDAO.deleteTicket", ticketvo);
   }

   // TICKET MODIFY PAGE
   public AdminTicketVO getTicketModifyInfo(AdminTicketVO ticketvo) {
      System.out.println("DAO 작동 ---> MyBatis로 getTicketModifyInfo() 기능 처리");
      return sqlSessionTemplate.selectOne("AdminTicketDAO.getTicketModifyInfo", ticketvo);
   }

   // TICKET MODIFY
   public int modifyTicket(AdminTicketVO ticketVO) {
      System.out.println("DAO작동 ---> MyBatis로 modifyticket() 기능 처리");
      return sqlSessionTemplate.update("AdminTicketDAO.modifyTicket", ticketVO);
   }

   // PDF,EXCEL 둘중하나 (주석고쳐야함)
   public List<AdminTicketVO> selectBoardList(AdminTicketVO ticketVO) {
      return sqlSessionTemplate.selectList("AdminTicketDAO.selectBoardList");
   }
}