package com.main.nowflix.admin.inquiry.controller;

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

import com.main.nowflix.admin.inquiry.service.AdminInquiryService;
import com.main.nowflix.admin.inquiry.vo.AdminInquiryVO;

@Controller
public class AdminInquiryController {
	
	@Autowired
	private AdminInquiryService inquiryService;
	
	// 1:1문의 관리 페이지(리스트)
	@RequestMapping("/manage_inquiry.mdo")
	public String getInquiry(Model model,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
			@RequestParam(value = "nowPage", defaultValue = "0") int nowPage) {
		int row = 8;
		int startPoint = nowPage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		map.put("startPoint", startPoint);
		map.put("row", row);

		int totalList = inquiryService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage; 
		int endPage = startPage + countPage - 1; 
		
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminInquiryVO> inquiryList;
		inquiryList = inquiryService.getInquiryList(map);

		model.addAttribute("inquiryList", inquiryList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("startPage", startPage); // startPage 정보저장
		model.addAttribute("endPage", endPage); // endPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_inquiry";
	}
	
	//공지사항 추가
	@ResponseBody
	@RequestMapping("/inquiryInsert.mdo")
	public int insertInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for inserting inquiry");
		int result = inquiryService.insertInquiry(vo); // 추가된 행의 개수(공지사항 개수) 반환
		return result;
	}
	
	
	//공지사항 삭제
	@ResponseBody
	@RequestMapping("/inquiryDelete.mdo")
	public int deleteInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for deleting inquiry");
		int result = inquiryService.deleteInquiry(vo); // 삭제된 행의 개수(공지사항 개수) 반환
		return result;
	}
	
	//공지사항 수정
	@ResponseBody
	@RequestMapping("/inquiryModify.mdo")
	public int modifyInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for modifying inquiry");
		int result = inquiryService.modifyInquiry(vo); // 수정된 행의 개수(공지사항 개수) 반환
		return result;
	}
	
	//PDF 기능
	@ResponseBody
	@RequestMapping("/inquiryPdfDown.mdo") //View에서 맵핑 url 주소
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = inquiryService.createPdf(newpdf); //createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
    }
	
	//EXCEL 기능
	@RequestMapping("/inquiryExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//공지사항 목록 조회
		List<AdminInquiryVO> list = inquiryService.selectBoardList();
		
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
		cell.setCellValue("공지사항 번호");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("공지사항 제목");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("공지사항 내용");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("등록일");
	
		// 데이터 부분 생성
		for(AdminInquiryVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getInquiry_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getInquiry_title());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getInquiry_content());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getInquiry_content());
		}
		
		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
	}
}
