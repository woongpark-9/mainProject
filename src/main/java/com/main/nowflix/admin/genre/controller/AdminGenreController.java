package com.main.nowflix.admin.genre.controller;

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

	// �帣 ���� ������
	@RequestMapping("/manage_genre.mdo")
	public String getGenre(Model model) {		
		List<AdminGenreVO> genreList = genreService.getGenreList();
		model.addAttribute("genreList", genreList); // genreList ��������		
		return "manage_genre";
	}

	// �帣 ����
	@ResponseBody
	@RequestMapping("/genreDelete.mdo")
	public int deleteGenre(AdminGenreVO vo) {
		int result = genreService.deleteGenre(vo); // ������ ���� ����
		return result;
	}

	// �帣 �߰�
	@ResponseBody
	@RequestMapping("/genreInsert.mdo")
	public int insertGenre(AdminGenreVO vo) {
		System.out.println("AdminGenreController load for inserting genre");
		int result = genreService.insertGenre(vo); // �߰��� ���� ����(�帣 ����) ��ȯ
		return result;
	}

//	// �帣 ���� ������
//	@RequestMapping("/genre_Modify.mdo")
//	public String getGenreModify(AdminGenreVO vo, Model model) {
//		model.addAttribute("genreModifyInfo", genreService.getGenreModifyInfo(vo)); // Model ��������
//		return "genre_insert";
//	}

	// �帣 ����
	@ResponseBody
	@RequestMapping("/genreModify.mdo")
	public int modifyGenre(AdminGenreVO vo) {
		int result = genreService.modifyGenre(vo); // Model ��������
		return result;
	}

	// PDF ���
	@ResponseBody
	@RequestMapping("/genrePdfDown.mdo") // View���� ���� url �ּ�
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {

		int result = genreService.createPdf(newpdf); // createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
	}

	// EXCEL ���
	@RequestMapping("/genreExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// �Խ��� �����ȸ
		List<AdminGenreVO> list = genreService.selectBoardList();

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

		// ��� ����
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�帣_ID");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�帣_�̸�");

		// ������ �κ� ����
		for (AdminGenreVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getGenre_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getGenre_name());			
		}

		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=GenreExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}