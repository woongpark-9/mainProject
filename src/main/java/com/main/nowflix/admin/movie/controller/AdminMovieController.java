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

	// ��ȭ ���� ������
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
		int startPage = ((nowPage) / countPage) * countPage; // 1�� ������ ������ startPage = 0, 6�� ������ ������ startPage = 5
		int endPage = startPage + countPage - 1; // endPage = 4, endPage = 9

		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminMovieVO> movieList;
		movieList = movieService.getMovieList(map);

		model.addAttribute("movieList", movieList); // movieList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("startPage", startPage); // startPage ��������
		model.addAttribute("endPage", endPage); // endPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_movie";
	}

	// ��ȭ ����
	@ResponseBody
	@RequestMapping("/movieDelete.mdo")
	public int deleteMovie(AdminMovieVO vo) {
		int result = movieService.deleteMovie(vo); // ������ ���� ����
		return result;
	}

	// ��ȭ �߰�
	@ResponseBody
	@RequestMapping("/movieInsert.mdo")
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieController load for inserting movie");
		int result = movieService.insertMovie(vo); // �߰��� ���� ����(��ȭ ����) ��ȯ
		return result;
	}

	// ��ȭ ���� ������
	@RequestMapping("/movie_Modify.mdo")
	public String getMovieModify(AdminMovieVO vo, AdminDirectorVO directorVO, AdminActorVO actorVO, Model model) {
		model.addAttribute("movieModifyInfo", movieService.getMovieModifyInfo(vo)); // Model ��������
		model.addAttribute("directorList", directorService.getDirectorListWithoutPaging(directorVO));
		model.addAttribute("actorList", actorService.getActorListWithoutPaging(actorVO));
		model.addAttribute("genreList", genreService.getGenreList(null));
		return "movie_insert";
	}

	// ��ȭ �߰� ������
	@RequestMapping("/movie_insert.mdo")
	public String getMovie_insert(AdminDirectorVO directorVO, AdminActorVO actorVO, Model model) {
		model.addAttribute("directorList", directorService.getDirectorListWithoutPaging(directorVO)); // Model ��������
		model.addAttribute("actorList", actorService.getActorListWithoutPaging(actorVO)); // Model ��������
		model.addAttribute("genreList", genreService.getGenreList(null));
		return "movie_insert";
	}

	// ��ȭ ����
	@ResponseBody
	@RequestMapping("/movieModify.mdo")
	public int modifyMovie(AdminMovieVO vo) {
		int result = movieService.modifyMovie(vo); // Model ��������
		return result;
	}

	// ��ȭ �� ����
	@RequestMapping("/movieDetail.mdo")
	public String getMovieDetail(AdminMovieVO vo, Model model) {
		model.addAttribute("movieDetail", movieService.getMovieDetail(vo));
		return "manage_movie";
	}

	// PDF ���
	@ResponseBody
	@RequestMapping("/moviePdfDown.mdo") // View���� ���� url �ּ�
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {
		int result = movieService.createPdf(newpdf); // createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
	}

	// EXCEL ���
	@RequestMapping("/movieExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// �Խ��� �����ȸ
		List<AdminMovieVO> list = movieService.selectBoardList();

		// ��ũ�� ����
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("�Խ���");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// ���̺� ����� ��Ÿ��
		CellStyle headStyle = wb.createCellStyle();
		// ���� ��輱�� �����ϴ�.
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// ������ ������Դϴ�.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// �����ʹ� ��� �����մϴ�.
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// �����Ϳ� ��� ��Ÿ��
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		// �����ʹ� ��� �����մϴ�.
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// ��Ʈ�� �÷� 1�� �ʺ����� 5000��ŭ ����.
		sheet.setColumnWidth(1, 9000);
		sheet.setColumnWidth(2, 5200);
		sheet.setColumnWidth(3, 12000);
		sheet.setColumnWidth(4, 9000);
		
		
		// ��� ����
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("#");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("���");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�帣");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�󿵽ð�");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("��������");

		// ������ �κ� ����
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
			cell.setCellValue(vo.getMovie_runningtime()+"��");
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getMovie_release_date()+"��");
		}

		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}