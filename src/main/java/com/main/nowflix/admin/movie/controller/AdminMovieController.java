package com.main.nowflix.admin.movie.controller;

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

import com.main.nowflix.admin.actor.service.AdminActorService;
import com.main.nowflix.admin.actor.vo.AdminActorVO;
import com.main.nowflix.admin.director.service.AdminDirectorService;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;
import com.main.nowflix.admin.genre.service.AdminGenreService;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Controller
public class AdminMovieController {

	@Autowired
	private AdminMovieService movieService;

	@Autowired
	private AdminDirectorService directorService;

	@Autowired
	private AdminActorService actorService;

	@Autowired
	private AdminGenreService genreService;

	// 영화 관리 페이지
	@RequestMapping("/manage_movie.mdo")
	public String getMovie(Model model,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
			@RequestParam(value = "nowPage", defaultValue = "0") int nowPage) {

		int row = 5;
		int startPoint = nowPage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		map.put("startPoint", startPoint);
		map.put("row", row);

		int totalList = movieService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage; // 1번 페이지 누르면 startPage = 0, 6번 페이지 누르면 startPage = 5
		int endPage = startPage + countPage - 1; // endPage = 4, endPage = 9

		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminMovieVO> movieList;
		movieList = movieService.getMovieList(map);

		model.addAttribute("movieList", movieList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("startPage", startPage); // startPage 정보저장
		model.addAttribute("endPage", endPage); // endPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_movie";
	}

	// 영화 삭제
	@ResponseBody
	@RequestMapping("/movieDelete.mdo")
	public int deleteMovie(AdminMovieVO vo) {
		int result = movieService.deleteMovie(vo); // 삭제한 행의 개수
		return result;
	}

	// 영화 추가
	@ResponseBody
	@RequestMapping("/movieInsert.mdo")
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieController load for inserting movie");
		int result = movieService.insertMovie(vo); // 추가된 행의 개수(영화 개수) 반환
		return result;
	}

	// 영화 수정 페이지
	@RequestMapping("/movie_Modify.mdo")
	public String getMovieModify(AdminMovieVO vo, AdminDirectorVO directorVO, AdminActorVO actorVO, Model model) {
		model.addAttribute("movieModifyInfo", movieService.getMovieModifyInfo(vo)); // Model 정보저장
		model.addAttribute("directorList", directorService.getDirectorListWithoutPaging(directorVO));
		model.addAttribute("actorList", actorService.getActorListWithoutPaging(actorVO));
		model.addAttribute("genreList", genreService.getGenreList(null));
		return "movie_insert";
	}

	// 영화 추가 페이지
	@RequestMapping("/movie_insert.mdo")
	public String getMovie_insert(AdminDirectorVO directorVO, AdminActorVO actorVO, Model model) {
		model.addAttribute("directorList", directorService.getDirectorListWithoutPaging(directorVO)); // Model 정보저장
		model.addAttribute("actorList", actorService.getActorListWithoutPaging(actorVO)); // Model 정보저장
		model.addAttribute("genreList", genreService.getGenreList(null));
		return "movie_insert";
	}

	// 영화 수정
	@ResponseBody
	@RequestMapping("/movieModify.mdo")
	public int modifyMovie(AdminMovieVO vo) {
		int result = movieService.modifyMovie(vo); // Model 정보저장
		return result;
	}

	// 영화 상세 보기
	@RequestMapping("/movieDetail.mdo")
	public String getMovieDetail(AdminMovieVO vo, Model model) {
		model.addAttribute("movieDetail", movieService.getMovieDetail(vo));
		return "manage_movie";
	}

	// PDF 기능
	@ResponseBody
	@RequestMapping("/moviePdfDown.mdo") // View에서 맵핑 url 주소
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {
		int result = movieService.createPdf(newpdf); // createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
	}

	// EXCEL 기능
	@RequestMapping("/movieExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// 게시판 목록조회
		List<AdminMovieVO> list = movieService.selectBoardList();

		// 워크북 생성
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("게시판");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

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
		// 데이터는 가운데 정렬합니다.
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 시트에 컬럼 1번 너비폭을 5000만큼 설정.
		sheet.setColumnWidth(1, 9000);
		sheet.setColumnWidth(2, 5200);
		sheet.setColumnWidth(3, 12000);
		sheet.setColumnWidth(4, 9000);
		
		
		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("#");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("감독");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("배우");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("장르");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("상영시간");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("개봉연도");

		// 데이터 부분 생성
		for (AdminMovieVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getRownum());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getTitle());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getDirector_name());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getActor_name());
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getGenre_name());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getMovie_runningtime()+"분");
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getMovie_release_date()+"년");
		}

		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}