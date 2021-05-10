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
      System.out.println("DAO �۵� ---> MyBatis�� getTicketList() ��� ó��");
      return sqlSessionTemplate.selectList("AdminTicketDAO.getTicketList", ticketvo);
   }

   // TICKET INSERT
   public int insertTicket(AdminTicketVO ticketvo) {
      System.out.println("DAO�۵� ---> MyBatis�� insertTicket() ��� ó��");
      return sqlSessionTemplate.insert("AdminTicketDAO.insertTicket", ticketvo);
   }

   // TICKET DELETE
   public int deleteTicket(AdminTicketVO ticketvo) {
      System.out.println("DAO�۵� ---> MyBatis�� deleteTicket() ��� ó��");
      return sqlSessionTemplate.delete("AdminTicketDAO.deleteTicket", ticketvo);
   }

   // TICKET MODIFY PAGE
   public AdminTicketVO getTicketModifyInfo(AdminTicketVO ticketvo) {
      System.out.println("DAO �۵� ---> MyBatis�� getTicketModifyInfo() ��� ó��");
      return sqlSessionTemplate.selectOne("AdminTicketDAO.getTicketModifyInfo", ticketvo);
   }

   // TICKET MODIFY
   public int modifyTicket(AdminTicketVO ticketVO) {
      System.out.println("DAO�۵� ---> MyBatis�� modifyticket() ��� ó��");
      return sqlSessionTemplate.update("AdminTicketDAO.modifyTicket", ticketVO);
   }

   // PDF,EXCEL �����ϳ� (�ּ����ľ���)
   public List<AdminTicketVO> selectBoardList(AdminTicketVO ticketVO) {
      return sqlSessionTemplate.selectList("AdminTicketDAO.selectBoardList");
   }
}