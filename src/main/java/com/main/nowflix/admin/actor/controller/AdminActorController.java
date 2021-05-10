package com.main.nowflix.admin.actor.controller;
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

import com.main.nowflix.admin.actor.service.AdminActorService;
import com.main.nowflix.admin.actor.vo.AdminActorVO;
@Controller
public class AdminActorController {

	@Autowired
	private AdminActorService actorService;

	// ��� ���� ������
	@RequestMapping("/manage_actor.mdo")
	public String getActor(Model model,
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

		int totalList = actorService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage; // 1�� ������ ������ startPage = 0, 6�� ������ ������ startPage = 5
		int endPage = startPage + countPage - 1; // endPage = 4, endPage = 9

		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminActorVO> actorList;
		actorList = actorService.getActorList(map);

		model.addAttribute("actorList", actorList); // actorList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("startPage", startPage); // startPage ��������
		model.addAttribute("endPage", endPage); // endPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_actor";
	}

	// ��� ����
	@ResponseBody
	@RequestMapping("/actorDelete.mdo")
	public int deleteActor(AdminActorVO vo) {
		int result = actorService.deleteActor(vo); // ������ ���� ����
		return result;
	}

	// ��� �߰�
	@ResponseBody
	@RequestMapping("/actorInsert.mdo")
	public int insertActor(AdminActorVO vo) {
		System.out.println("AdminActorController load for inserting actor");
		int result = actorService.insertActor(vo); // �߰��� ���� ����(��� ����) ��ȯ
		return result;
	}

	// ��� ���� ������
	@RequestMapping("/actor_Modify.mdo")
	public String getActorModify(AdminActorVO vo, Model model) {
		model.addAttribute("actorModifyInfo", actorService.getActorModifyInfo(vo)); // Model ��������
		return "actor_insert";
	}

	// ��� ����
	@ResponseBody
	@RequestMapping("/actorModify.mdo")
	public int modifyActor(AdminActorVO vo) {
		int result = actorService.modifyActor(vo); // Model ��������
		return result;
	}

	// ��� �� ����
	@RequestMapping("/actorDetail.mdo")
	public String getActorDetail(AdminActorVO vo, Model model) {
		model.addAttribute("actorDetail", actorService.getActorDetail(vo));
		System.out.println(model.getAttribute("actorDetail").toString());
		return "manage_actor";
	}

	// PDF ���
	@ResponseBody
	@RequestMapping("/actorPdfDown.mdo") // View���� ���� url �ּ�
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {

		int result = actorService.createPdf(newpdf); // createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
	}

	// EXCEL ���
	@RequestMapping("/actorExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// �Խ��� �����ȸ
		List<AdminActorVO> list = actorService.selectBoardList();

		// ��ũ�� ����
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("���");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// ���̺� ����� ��Ÿ��
		CellStyle headStyle = wb.createCellStyle();
		CreationHelper creationHelper = wb.getCreationHelper();
		// ���� ��輱�� �����ϴ�.
		sheet.setColumnWidth(0, 5000);
		sheet.setColumnWidth(1, 8000);
		sheet.setColumnWidth(2, 5000);
		
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
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle dataStyle = wb.createCellStyle();
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);
		// ��� ����
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("���ID");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����̸�");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�������");

		// ������ �κ� ����
		for (AdminActorVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getActor_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getActor_name());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getActor_birth());

		}

		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=ActorExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}
