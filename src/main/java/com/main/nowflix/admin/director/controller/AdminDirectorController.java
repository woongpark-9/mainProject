package com.main.nowflix.admin.director.controller;

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

import com.main.nowflix.admin.director.service.AdminDirectorService;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;

@Controller
public class AdminDirectorController {

	@Autowired
	private AdminDirectorService directorService;
	
	// 감독 관리 페이지(리스트)
	@RequestMapping("/manage_director.mdo")
	public String getDirector(Model model,
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

		int totalList = directorService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminDirectorVO> directorList;
		directorList = directorService.getDirectorList(map);

		model.addAttribute("directorList", directorList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_director";
	}
	
	//감독 추가
	@ResponseBody
	@RequestMapping("/directorInsert.mdo")
	public int insertDirector(AdminDirectorVO vo) {
		System.out.println("AdminDirectorController load for inserting director");
		int result = directorService.insertDirector(vo); // 추가된 행의 개수(감독 개수) 반환
		return result;
	}
	
	
	//감독 삭제
	@ResponseBody
	@RequestMapping("/directorDelete.mdo")
	public int deleteDirector(AdminDirectorVO vo) {
		System.out.println("AdminDirectorController load for deleting director");
		int result = directorService.deleteDirector(vo); // 삭제된 행의 개수(감독 개수) 반환
		return result;
	}
	
	//감독 수정
	@ResponseBody
	@RequestMapping("/directorModify.mdo")
	public int modifyDirector(AdminDirectorVO vo) {
		System.out.println("AdminDirectorController load for modifying director");
		int result = directorService.modifyDirector(vo); // 수정된 행의 개수(감독 개수) 반환
		return result;
	}
	
	//PDF 기능
	@ResponseBody
	@RequestMapping("/directorPdfDown.mdo") //View에서 맵핑 url 주소
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = directorService.createPdf(newpdf); //createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
    }
	
	//EXCEL 기능
	@RequestMapping("/directorExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//감독 목록 조회
		List<AdminDirectorVO> list = directorService.selectBoardList();
		
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
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("감독 아이디");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("감독 이름");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("출생년도");
	
		// 데이터 부분 생성
		for(AdminDirectorVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getDirector_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getDirector_name());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getDirector_birthdate());
		}
		
		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
		
		
	}
}
