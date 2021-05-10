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

	// 회원 관리 페이지
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

		model.addAttribute("memberList", memberList); // memberList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("startPage", startPage); // startPage 정보저장
		model.addAttribute("endPage", endPage); // endPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_member";
	}

	// MEMBER 추가
	@ResponseBody
	@RequestMapping("/memberInsert.mdo")
	public int insertMember(AdminMemberVO memberVO) {
		System.out.println("AdminMemberController load for inserting member");
		int result = memberService.insertMember(memberVO);
		return result;
	}

	// MEMBER 추가 페이지
	@RequestMapping("/member_insert.mdo")
	public String getMember_insert(Model model) {
		model.addAttribute("ticketList", ticketService.getTicketList(null)); // ticketList 정보저장
		return "member_insert";
	}

	// MEMBER 수정 페이지
	@RequestMapping("/member_Modify.mdo")
	public String getMembermodify(AdminMemberVO memberVO, Model model) {
		model.addAttribute("ticketList", ticketService.getTicketList(null)); // ticketList 정보저장
		model.addAttribute("memberModifyInfo", memberService.getMemberModifyInfo(memberVO)); // Model 정보저장
		return "member_insert";
	}
	// ==================================================================================================================

	// ==================================================================================================================
	// MEMBER를 수정을 하는 컨트롤러 입니다.
	@ResponseBody
	@RequestMapping("/memberModify.mdo")
	public int modifyMember(AdminMemberVO memberVO) {
		int result = memberService.modifyMember(memberVO); // Model 정보저장
		return result;
	}

	// ==================================================================================================================
	// PDF를 문서화작업해서 다운로드 해주는 작업입니다.
	@ResponseBody
	@RequestMapping("/memberPdfDown.mdo")
	public int list(HttpServletRequest request, @RequestParam String newmemberpdf) throws Exception {
		int result = memberService.membercreatePdf(newmemberpdf);
		return result;
	}
	// ==================================================================================================================

	// =================================================================================================================
	// EXCEL를 문서화작업해서 다온르도 해주는 작업입니다.
	@RequestMapping("/memberExcelDown.mdo")
	public void memberexceldown(HttpServletResponse response) throws Exception {

		// 게시판의 목록을 조회 하기위해 selectBoardList 를 실행.
		List<AdminMemberVO> list = memberService.selectBoardList();

		// WorkBook Create (워크북을 생성합니다)
		Workbook wb = new HSSFWorkbook();
		// Sheet Create -> workBook Setting name "멤버" (엑셀 시트의 이름을 지정합니다)
		Sheet sheet = wb.createSheet("멤버");
		// Row , Cell , rowNo 선언. 및 초기화.
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// Date Type 편집을 위한 기능 creationHelper
		CreationHelper creationHelper = wb.getCreationHelper();

		// Cell 헤더용 스타일을 정의.
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// 배경색은 노란색입니다.
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터는 가운데 정렬합니다.
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// Cell bodyStyle을 정의.
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// Date (날짜) 형을 포멧팅하여 출력하기위해 스타일을 따로 선언(설정) 합니다.
		CellStyle dataStyle = wb.createCellStyle();
		// dataStyle은 들어오는 데이터를 yyyy-dd-mm으로 포멧팅하여 출력합니다.
		dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-dd-mm"));
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.CENTER);

		// 시트에 컬럼 1번 Column width 사이즈를 5000만큼 설정.
		sheet.setColumnWidth(1, 5000);
		// 시트에 컬럼 8번 Column width 사이즈를 3000만큼 설정.
		sheet.setColumnWidth(8, 3000);

		// 헤더 부분을 생성합니다.
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("#");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("이메일");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("닉네임");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("나이");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("성별");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("이용권");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("본인인증");
		cell = row.createCell(7);
		cell.setCellStyle(headStyle);
		cell.setCellValue("계정상태");
		cell = row.createCell(8);
		cell.setCellStyle(headStyle);
		cell.setCellValue("가입일");

		// 데이터 부분을 생성및 출력 합니다.
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

		// Excel export contentType Setting ( 엑셀로 저장하고 엑셀을 xls로 지정합니다. )
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		// Excel output Download (엑셀을 출력합니다_다운로드)
		wb.write(response.getOutputStream());

		// Excel workBook Close (엑셀의 워크북을 종료합니다.)
		wb.close();

	}

}