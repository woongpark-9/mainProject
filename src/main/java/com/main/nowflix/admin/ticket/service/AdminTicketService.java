package com.main.nowflix.admin.ticket.service;


import java.util.List;

import com.main.nowflix.admin.ticket.vo.AdminTicketVO;

public interface AdminTicketService {
   //Ƽ�� ����Ʈ interface
   List<AdminTicketVO> getTicketList(AdminTicketVO ticketvo);
   
   //Ƽ�� �߰� interface
   int insertTicket(AdminTicketVO ticketvo);
   
   //Ƽ�� ���� interface
   int deleteTicket(AdminTicketVO ticketvo);
   
   //���� ������
   AdminTicketVO getTicketModifyInfo(AdminTicketVO ticketvo); 
   
   //����
   int modifyTicket(AdminTicketVO ticketvo);
   
   //����/pdf LIST ����
   List<AdminTicketVO> selectBoardList() throws Exception; // EXCEL
   int ticketcreatePdf(String newticketpdf);
}