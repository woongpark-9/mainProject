package com.main.nowflix.admin.faq.controller;

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

import com.main.nowflix.admin.faq.service.AdminFaqService;
import com.main.nowflix.admin.faq.vo.AdminFaqVO;

@Controller
public class AdminFaqController {
	
	@Autowired
	private AdminFaqService faqService;
	
	// FAQ 관리 페이지(리스트)
	@RequestMapping("/manage_faq.mdo")
	public String getFaq(Model model,
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

		int totalList = faqService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminFaqVO> faqList;
		faqList = faqService.getFaqList(map);

		model.addAttribute("faqList", faqList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_faq";
	}
	
	//FAQ 추가
	@ResponseBody
	@RequestMapping("/faqInsert.mdo")
	public int insertFaq(AdminFaqVO vo) {
		System.out.println("AdminFaqController load for inserting faq");
		int result = faqService.insertFaq(vo); // 추가된 행의 개수(FAQ 개수) 반환
		return result;
	}
	
	
	//FAQ 삭제
	@ResponseBody
	@RequestMapping("/faqDelete.mdo")
	public int deleteFaq(AdminFaqVO vo) {
		System.out.println("AdminFaqController load for deleting faq");
		int result = faqService.deleteFaq(vo); // 삭제된 행의 개수(FAQ 개수) 반환
		return result;
	}
	
	//FAQ 수정
	@ResponseBody
	@RequestMapping("/faqModify.mdo")
	public int modifyFaq(AdminFaqVO vo) {
		System.out.println("AdminFaqController load for modifying faq");
		int result = faqService.modifyFaq(vo); // 수정된 행의 개수(FAQ 개수) 반환
		return result;
	}
	
	//PDF 기능
	@ResponseBody
	@RequestMapping("/faqPdfDown.mdo") //View에서 맵핑 url 주소
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = faqService.createPdf(newpdf); //createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
    }
	
	//EXCEL 기능
	@RequestMapping("/faqExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//FAQ 목록 조회
		List<AdminFaqVO> list = faqService.selectBoardList();
		
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
		cell.setCellValue("FAQ 번호");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("카테고리");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("내용");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("등록일");
	
		// 데이터 부분 생성
		for(AdminFaqVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getFaq_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getFaq_category());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getFaq_title());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getFaq_content());
			cell = row.createCell(4);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getFaq_regdate());
			
		}
		
		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
	}
}
