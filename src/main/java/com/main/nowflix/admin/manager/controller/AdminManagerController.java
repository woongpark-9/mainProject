package com.main.nowflix.admin.manager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.nowflix.admin.manager.service.AdminManagerService;
import com.main.nowflix.admin.manager.vo.AdminManagerVO;
import com.main.nowflix.util.ScriptUtils;

@Controller
public class AdminManagerController {

	@Autowired
	private AdminManagerService managerService;

	// ������ ���� ������(����Ʈ)
	@RequestMapping("/manage_manager.mdo")
	public String getManager(Model model,
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

		int totalList = managerService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminManagerVO> managerList;
		managerList = managerService.getManagerList(map);

		model.addAttribute("managerList", managerList); // movieList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_manager";
	}

	// ������ �߰�
	@ResponseBody
	@RequestMapping("/managerInsert.mdo")
	public int insertManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for inserting manager");
		int result = managerService.insertManager(vo); // �߰��� ���� ����(������ ����) ��ȯ
		return result;
	}

	// ������ ����
	@ResponseBody
	@RequestMapping("/managerDelete.mdo")
	public int deleteManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for deleting manager");
		int result = managerService.deleteManager(vo); // ������ ���� ����(������ ����) ��ȯ
		return result;
	}

	// ������ ����
	@ResponseBody
	@RequestMapping("/managerModify.mdo")
	public int modifyManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for modifying manager");
		int result = managerService.modifyManager(vo); // ������ ���� ����(������ ����) ��ȯ
		return result;
	}

	// PDF ���
	@ResponseBody
	@RequestMapping("/managerPdfDown.mdo") // View���� ���� url �ּ�
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {
		int result = managerService.createPdf(newpdf); // createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
	}

	// EXCEL ���
	@RequestMapping("/managerExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// ������ ��� ��ȸ
		List<AdminManagerVO> list = managerService.selectBoardList();

		// ��ũ�� ����
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("�Խ���");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		CreationHelper creationHelper = wb.getCreationHelper();
		sheet.setColumnWidth(2, 3000);

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

		CellStyle dataStyle = wb.createCellStyle();
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);

		// ��� ����
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("������ ���̵�");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("������ �̸���");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("������ Ÿ��");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�����");

		// ������ �κ� ����
		for (AdminManagerVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getManager_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getManager_email());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getManager_type());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getManager_regdate());
		}

		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();
	}
	
	// ������ �α��� â
	@RequestMapping("/adminLogin.mdo")
	public String getAdminLogin() {
		return "adminLogin";
	}
	
	// ������ �α���
	@RequestMapping("/adminLoginCheck.mdo")
	public String adminLogin(AdminManagerVO vo, HttpSession session, RedirectAttributes rttr, 
			Model model, HttpServletResponse response) throws Exception {
		//System.out.println(vo.getManager_email());
		
		String page = "adminLogin";
		AdminManagerVO adminLogin = managerService.adminLogin(vo); // �α����� ������ ���� vo
		//System.out.println(managerService.adminLogin(vo));
		
		if(adminLogin != null) {
			if(vo.getManager_pass().equals(adminLogin.getManager_pass())) { // ��й�ȣ�� ��ġ�Ѵٸ�
				System.out.println("������ " + adminLogin.getManager_email() + " �α��� ����");
				session.setAttribute("manager", adminLogin);
				page = "manage_template";
			}
			else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				ScriptUtils.alert(response, "��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			}
		}
		
		else { // ������ vo�� null�� ��, �� �α��� �õ��� ���̵� �������� ���� ��
			System.out.println("�ش� ���̵� �������� �ʽ��ϴ�");
			ScriptUtils.alert(response, "�ش� ���̵� �������� �ʽ��ϴ�");
		}
		
		return page;
	}
	
	// ������ �α׾ƿ�
	@RequestMapping("/adminLogout.mdo") 
	public String adminLogout(HttpSession session) throws Exception {
		if(session != null) {
			session.invalidate(); // ������ �����ϸ� ���� ��ȿȭ => �α׾ƿ�
		}
		return "redirect:/adminLogin.mdo";
	}
}

























