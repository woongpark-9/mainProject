package com.main.nowflix.admin.sales.controller;

import java.util.HashMap;
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

import com.main.nowflix.admin.sales.service.AdminSalesService;
import com.main.nowflix.admin.sales.vo.AdminSalesVO;

@Controller
public class AdminSalesController {
	
	@Autowired
	private AdminSalesService salesService;
	
	// 결제내역 관리 페이지(리스트)
	@RequestMapping("/manage_sales.mdo")
	public String getSales(Model model,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
			@RequestParam(value = "nowPage", defaultValue = "0") int nowPage) {
		int row = 4;
		int startPoint = nowPage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		map.put("startPoint", startPoint);
		map.put("row", row);

		int totalList = salesService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminSalesVO> salesList;
		salesList = salesService.getSalesList(map);

		model.addAttribute("salesList", salesList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_sales";
	}
	
	//PDF 기능
	@ResponseBody
	@RequestMapping("/salesPdfDown.mdo") //View에서 맵핑 url 주소
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = salesService.createPdf(newpdf); //createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
    }
	
	//EXCEL 기능
	@RequestMapping("/salesExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//결제내역 목록 조회
		List<AdminSalesVO> list = salesService.selectBoardList();
		
		// 워크북 생성
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("게시판");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;
		
		CreationHelper creationHelper = wb.getCreationHelper();
		sheet.setColumnWidth(2, 3000);
		
		// 테이블 헤더용 스타일
		CellStyle headStyle = wb.createCellStyle();
		// 가는 경계선을 가집니다.
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// 배경색은 노란색입니다.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터는 가운데 정렬합니다.
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 데이터용 경계 스타일
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		
		CellStyle dataStyle = wb.createCellStyle();
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("sales_id");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("cid");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("tid");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("member_email");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("ticket_id");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("sales_status");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("payment_date");
		cell = row.createCell(7);
		cell.setCellStyle(headStyle);
		cell.setCellValue("expiry_date");
		cell = row.createCell(8);
		cell.setCellStyle(headStyle);
		cell.setCellValue("payment_method_type");
		cell = row.createCell(9);
		cell.setCellStyle(headStyle);
		cell.setCellValue("sales_status");
		
	
		// 데이터 부분 생성
		for(AdminSalesVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getSales_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getCid());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getTid());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getEmail());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getTicket_id());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getSales_status());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getPayment_date());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getExpiry_date());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getPayment_method_type());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getSales_status());
		}
		
		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
	}
}
