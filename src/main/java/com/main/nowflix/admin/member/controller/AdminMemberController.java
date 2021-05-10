package com.main.nowflix.admin.member.controller;

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

import com.main.nowflix.admin.actor.vo.AdminActorVO;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;
import com.main.nowflix.admin.member.service.AdminMemberService;
import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.ticket.service.AdminTicketService;

@Controller
public class AdminMemberController {

	@Autowired
	private AdminMemberService memberService;

	@Autowired
	private AdminTicketService ticketService;

	// ȸ�� ���� ������
	@RequestMapping("/manage_member.mdo")
	public String getMember(Model model,
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

		int totalList = memberService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage;
		int endPage = startPage + countPage - 1;

		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminMemberVO> memberList;
		memberList = memberService.getMemberList(map);

		model.addAttribute("memberList", memberList); // memberList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("startPage", startPage); // startPage ��������
		model.addAttribute("endPage", endPage); // endPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_member";
	}

	// MEMBER �߰�
	@ResponseBody
	@RequestMapping("/memberInsert.mdo")
	public int insertMember(AdminMemberVO memberVO) {
		System.out.println("AdminMemberController load for inserting member");
		int result = memberService.insertMember(memberVO);
		return result;
	}

	// MEMBER �߰� ������
	@RequestMapping("/member_insert.mdo")
	public String getMember_insert(Model model) {
		model.addAttribute("ticketList", ticketService.getTicketList(null)); // ticketList ��������
		return "member_insert";
	}

	// MEMBER ���� ������
	@RequestMapping("/member_Modify.mdo")
	public String getMembermodify(AdminMemberVO memberVO, Model model) {
		model.addAttribute("ticketList", ticketService.getTicketList(null)); // ticketList ��������
		model.addAttribute("memberModifyInfo", memberService.getMemberModifyInfo(memberVO)); // Model ��������
		return "member_insert";
	}
	// ==================================================================================================================

	// ==================================================================================================================
	// MEMBER�� ������ �ϴ� ��Ʈ�ѷ� �Դϴ�.
	@ResponseBody
	@RequestMapping("/memberModify.mdo")
	public int modifyMember(AdminMemberVO memberVO) {
		int result = memberService.modifyMember(memberVO); // Model ��������
		return result;
	}

	// ==================================================================================================================
	// PDF�� ����ȭ�۾��ؼ� �ٿ�ε� ���ִ� �۾��Դϴ�.
	@ResponseBody
	@RequestMapping("/memberPdfDown.mdo")
	public int list(HttpServletRequest request, @RequestParam String newmemberpdf) throws Exception {
		int result = memberService.membercreatePdf(newmemberpdf);
		return result;
	}
	// ==================================================================================================================

	// =================================================================================================================
	// EXCEL�� ����ȭ�۾��ؼ� �ٿ¸��� ���ִ� �۾��Դϴ�.
	@RequestMapping("/memberExcelDown.mdo")
	public void memberexceldown(HttpServletResponse response) throws Exception {

		// �Խ����� ����� ��ȸ �ϱ����� selectBoardList �� ����.
		List<AdminMemberVO> list = memberService.selectBoardList();

		// WorkBook Create (��ũ���� �����մϴ�)
		Workbook wb = new HSSFWorkbook();
		// Sheet Create -> workBook Setting name "���" (���� ��Ʈ�� �̸��� �����մϴ�)
		Sheet sheet = wb.createSheet("���");
		// Row , Cell , rowNo ����. �� �ʱ�ȭ.
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// Date Type ������ ���� ��� creationHelper
		CreationHelper creationHelper = wb.getCreationHelper();

		// Cell ����� ��Ÿ���� ����.
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// ������ ������Դϴ�.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// �����ʹ� ��� �����մϴ�.
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// Cell bodyStyle�� ����.
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// Date (��¥) ���� �������Ͽ� ����ϱ����� ��Ÿ���� ���� ����(����) �մϴ�.
		CellStyle dataStyle = wb.createCellStyle();
		// dataStyle�� ������ �����͸� yyyy-dd-mm���� �������Ͽ� ����մϴ�.
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);

		// ��Ʈ�� �÷� 1�� Column width ����� 5000��ŭ ����.
		sheet.setColumnWidth(1, 5000);
		// ��Ʈ�� �÷� 8�� Column width ����� 3000��ŭ ����.
		sheet.setColumnWidth(8, 3000);

		// ��� �κ��� �����մϴ�.
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("#");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�̸���");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�г���");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("����");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�̿��");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("��������");
		cell = row.createCell(7);
		cell.setCellStyle(headStyle);
		cell.setCellValue("��������");
		cell = row.createCell(8);
		cell.setCellStyle(headStyle);
		cell.setCellValue("������");

		// ������ �κ��� ������ ��� �մϴ�.
		for (AdminMemberVO membervo : list) {
			row = sheet.createRow(rowNo++);

			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getSeq());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getEmail());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getNickname());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getAge());
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getGender());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getTicket_id());
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getCert());
			cell = row.createCell(7);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(membervo.getBan());
			cell = row.createCell(8);
			cell.setCellValue(membervo.getJoin_date());
			cell.setCellStyle(dataStyle);
		}

		// Excel export contentType Setting ( ������ �����ϰ� ������ xls�� �����մϴ�. )
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		// Excel output Download (������ ����մϴ�_�ٿ�ε�)
		wb.write(response.getOutputStream());

		// Excel workBook Close (������ ��ũ���� �����մϴ�.)
		wb.close();

	}

}