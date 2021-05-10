package com.main.nowflix.admin.genre.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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

import com.main.nowflix.admin.genre.service.AdminGenreService;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;

@Controller
public class AdminGenreController {

	@Autowired
	private AdminGenreService genreService;

	// 장르 관리 페이지
	@RequestMapping("/manage_genre.mdo")
	public String getGenre(Model model, 
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

		int totalList = genreService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage; 
		int endPage = startPage + countPage - 1; 
		
		if ((totalList % row) > 0) {
			totalPage++;
		}
		
		List<AdminGenreVO> genreList = genreService.getGenreList(map);		

		model.addAttribute("genreList", genreList); // genreList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("startPage", startPage); // startPage 정보저장
		model.addAttribute("endPage", endPage); // endPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_genre";
	}

	// 장르 삭제
	@ResponseBody
	@RequestMapping("/genreDelete.mdo")
	public int deleteGenre(AdminGenreVO vo) {
		int result = genreService.deleteGenre(vo); // 삭제한 행의 개수
		return result;
	}

	// 장르 추가
	@ResponseBody
	@RequestMapping("/genreInsert.mdo")
	public int insertGenre(AdminGenreVO vo) {
		System.out.println("AdminGenreController load for inserting genre");
		int result = genreService.insertGenre(vo); // 추가된 행의 개수(장르 개수) 반환
		return result;
	}

//	// 장르 수정 페이지
//	@RequestMapping("/genre_Modify.mdo")
//	public String getGenreModify(AdminGenreVO vo, Model model) {
//		model.addAttribute("genreModifyInfo", genreService.getGenreModifyInfo(vo)); // Model 정보저장
//		return "genre_insert";
//	}

	// 장르 수정
	@ResponseBody
	@RequestMapping("/genreModify.mdo")
	public int modifyGenre(AdminGenreVO vo) {
		int result = genreService.modifyGenre(vo); // Model 정보저장
		return result;
	}

	// PDF 기능
	@ResponseBody
	@RequestMapping("/genrePdfDown.mdo") // View에서 맵핑 url 주소
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {

		int result = genreService.createPdf(newpdf); // createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
	}

	// EXCEL 기능
	@RequestMapping("/genreExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// 게시판 목록조회
		List<AdminGenreVO> list = genreService.selectBoardList();

		// 워크북 생성
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("장르");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;
		
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(1, 3000);

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
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("장르_ID");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("장르_이름");

		// 데이터 부분 생성
		for (AdminGenreVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getGenre_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getGenre_name());			
		}

		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=GenreExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}
