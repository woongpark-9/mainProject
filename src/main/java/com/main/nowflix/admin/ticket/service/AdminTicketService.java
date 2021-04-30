package com.main.nowflix.admin.ticket.service;


import java.util.List;

import com.main.nowflix.admin.ticket.vo.AdminTicketVO;

public interface AdminTicketService {
   //티켓 리스트 interface
   List<AdminTicketVO> getTicketList(AdminTicketVO ticketvo);
   
   //티켓 추가 interface
   int insertTicket(AdminTicketVO ticketvo);
   
   //티켓 삭제 interface
   int deleteTicket(AdminTicketVO ticketvo);
   
   //수정 페이지
   AdminTicketVO getTicketModifyInfo(AdminTicketVO ticketvo); 
   
   //수정
   int modifyTicket(AdminTicketVO ticketvo);
   
   //엑셀/pdf LIST 추출
   List<AdminTicketVO> selectBoardList() throws Exception; // EXCEL
   int ticketcreatePdf(String newticketpdf);
}