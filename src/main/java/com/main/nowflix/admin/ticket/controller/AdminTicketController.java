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

	// 이용권 리스트 출력
	@RequestMapping("/manage_ticket.mdo")
	public String getTicket(AdminTicketVO ticketvo, Model model) {
		model.addAttribute("ticketList", TicketService.getTicketList(ticketvo));
		return "manage_ticket";
	}

	// 티켓 추가
	@ResponseBody
	@RequestMapping("/ticketInsert.mdo")
	public int insertTicket(AdminTicketVO ticketvo) {
		System.out.println("AdminTiketController load for inserting ticket");
		int result = TicketService.insertTicket(ticketvo); // 추가된 행의 개수(티켓 개수) 반환
		return result;
	}

//	// 티켓 수정 페이지
//	@RequestMapping("/ticket_Modify.mdo")
//	public String getTicketModify(AdminTicketVO ticketvo, Model model) {
//		model.addAttribute("ticketModifyInfo", TicketService.getTicketModifyInfo(ticketvo)); // Model 정보저장
//		return "ticket_insert";
//	}

	// 티켓 수정
	@ResponseBody
	@RequestMapping("/ticketModify.mdo")
	public int modifyGenre(AdminTicketVO ticketvo) {
		System.out.println(ticketvo.getTicket_id());
		int result = TicketService.modifyTicket(ticketvo); // Model 정보저장
		return result;
	}

	// 티켓 삭제
	@ResponseBody
	@RequestMapping("/ticketDelete.mdo")
	public int deleteTicket(AdminTicketVO ticketvo) {
		int result = TicketService.deleteTicket(ticketvo); // 삭제한 행의 개수
		return result;
	}

	// PDF
	@ResponseBody
	@RequestMapping("/ticketPdfDown.mdo")
	public int list(HttpServletRequest request, @RequestParam String newticketpdf) throws Exception {
		int result = TicketService.ticketcreatePdf(newticketpdf);
		return result;
	}

	// EXCEL를 문서화작업해서 다온르도 해주는 작업입니다.
	@RequestMapping("/ticketExcelDown.mdo")
	public void ticketExcelDown(HttpServletResponse response) throws Exception {

		// 티켓 목록을 조회 하기위해 selectBoardList 를 실행.
		List<AdminTicketVO> list = TicketService.selectBoardList();

		// WorkBook Create (워크북을 생성합니다)
		Workbook wb = new HSSFWorkbook();
		// Sheet Create -> workBook Setting name "멤버" (엑셀 시트의 이름을 지정합니다)
		Sheet sheet = wb.createSheet("이용권");
		// Row , Cell , rowNo 선언. 및 초기화.
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// Date Type 편집을 위한 기능 creationHelper
		CreationHelper creationHelper = wb.getCreationHelper();

		// Cell 헤더용 스타일을 정의.
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// 배경색은 노란색입니다.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터는 가운데 정렬합니다.
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// Cell bodyStyle을 정의.
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// Date (날짜) 형을 포멧팅하여 출력하기위해 스타일을 따로 선언(설정) 합니다.
		CellStyle dataStyle = wb.createCellStyle();
		// dataStyle은 들어오는 데이터를 yyyy-dd-mm으로 포멧팅하여 출력합니다.
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);

		// 시트에 컬럼 1번 Column width 사이즈를 5000만큼 설정.
		sheet.setColumnWidth(1, 5000);
		// 시트에 컬럼 8번 Column width 사이즈를 3000만큼 설정.
		sheet.setColumnWidth(8, 3000);

		// 헤더 부분을 생성합니다.
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("seq");

		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("이용권ID");

		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("이용권명");

		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("기간");

		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("가격");

		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("활성화상태");

		// 데이터 부분을 생성및 출력 합니다.
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

		// Excel export contentType Setting ( 엑셀로 저장하고 엑셀을 xls로 지정합니다. )
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=TicketExcelFile.xls");

		// Excel output Download (엑셀을 출력합니다_다운로드)
		wb.write(response.getOutputStream());

		// Excel workBook Close (엑셀의 워크북을 종료합니다.)
		wb.close();

	}

}