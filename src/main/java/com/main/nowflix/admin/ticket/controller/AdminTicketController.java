package com.main.nowflix.admin.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.nowflix.admin.ticket.service.AdminTicketService;
import com.main.nowflix.admin.ticket.vo.AdminTicketVO;

@Controller
public class AdminTicketController {

	@Autowired
	AdminTicketService TicketService;
	AdminTicketVO ticketvo;

	// �̿�� ����Ʈ ���
	@RequestMapping("/manage_ticket.mdo")
	public String getTicket(AdminTicketVO ticketvo, Model model) {
		model.addAttribute("ticketList", TicketService.getTicketList(ticketvo));
		return "manage_ticket";
	}

	// Ƽ�� �߰�
	@ResponseBody
	@RequestMapping("/ticketInsert.mdo")
	public int insertTicket(AdminTicketVO ticketvo) {
		System.out.println("AdminTiketController load for inserting ticket");
		int result = TicketService.insertTicket(ticketvo); // �߰��� ���� ����(Ƽ�� ����) ��ȯ
		return result;
	}

//	// Ƽ�� ���� ������
//	@RequestMapping("/ticket_Modify.mdo")
//	public String getTicketModify(AdminTicketVO ticketvo, Model model) {
//		model.addAttribute("ticketModifyInfo", TicketService.getTicketModifyInfo(ticketvo)); // Model ��������
//		return "ticket_insert";
//	}

	// Ƽ�� ����
	@ResponseBody
	@RequestMapping("/ticketModify.mdo")
	public int modifyGenre(AdminTicketVO ticketvo) {
		System.out.println(ticketvo.getTicket_id());
		int result = TicketService.modifyTicket(ticketvo); // Model ��������
		return result;
	}

	// Ƽ�� ����
	@ResponseBody
	@RequestMapping("/ticketDelete.mdo")
	public int deleteTicket(AdminTicketVO ticketvo) {
		int result = TicketService.deleteTicket(ticketvo); // ������ ���� ����
		return result;
	}

	// PDF
	@ResponseBody
	@RequestMapping("/ticketPdfDown.mdo")
	public int list(HttpServletRequest request, @RequestParam String newticketpdf) throws Exception {
		int result = TicketService.ticketcreatePdf(newticketpdf);
		return result;
	}

	// EXCEL�� ����ȭ�۾��ؼ� �ٿ¸��� ���ִ� �۾��Դϴ�.
	@RequestMapping("/ticketExcelDown.mdo")
	public void ticketExcelDown(HttpServletResponse response) throws Exception {

		// Ƽ�� ����� ��ȸ �ϱ����� selectBoardList �� ����.
		List<AdminTicketVO> list = TicketService.selectBoardList();

		// WorkBook Create (��ũ���� �����մϴ�)
		Workbook wb = new HSSFWorkbook();
		// Sheet Create -> workBook Setting name "���" (���� ��Ʈ�� �̸��� �����մϴ�)
		Sheet sheet = wb.createSheet("�̿��");
		// Row , Cell , rowNo ����. �� �ʱ�ȭ.
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// Date Type ������ ���� ��� creationHelper
		CreationHelper creationHelper = wb.getCreationHelper();

		// Cell ����� ��Ÿ���� ����.
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// ������ ������Դϴ�.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// �����ʹ� ��� �����մϴ�.
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// Cell bodyStyle�� ����.
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// Date (��¥) ���� �������Ͽ� ����ϱ����� ��Ÿ���� ���� ����(����) �մϴ�.
		CellStyle dataStyle = wb.createCellStyle();
		// dataStyle�� ������ �����͸� yyyy-dd-mm���� �������Ͽ� ����մϴ�.
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);

		// ��Ʈ�� �÷� 1�� Column width ����� 5000��ŭ ����.
		sheet.setColumnWidth(1, 5000);
		// ��Ʈ�� �÷� 8�� Column width ����� 3000��ŭ ����.
		sheet.setColumnWidth(8, 3000);

		// ��� �κ��� �����մϴ�.
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("seq");

		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�̿��ID");

		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�̿�Ǹ�");

		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�Ⱓ");

		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����");

		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("Ȱ��ȭ����");

		// ������ �κ��� ������ ��� �մϴ�.
		for (AdminTicketVO ticketvo : list) {
			row = sheet.createRow(rowNo++);

			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getSeq());

			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getTicket_id());

			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getTicket_name());

			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getTicket_period());

			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getTicket_price());

			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(ticketvo.getTicket_status());
		}

		// Excel export contentType Setting ( ������ �����ϰ� ������ xls�� �����մϴ�. )
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=TicketExcelFile.xls");

		// Excel output Download (������ ����մϴ�_�ٿ�ε�)
		wb.write(response.getOutputStream());

		// Excel workBook Close (������ ��ũ���� �����մϴ�.)
		wb.close();

	}

}