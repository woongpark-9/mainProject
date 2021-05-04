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

	// 관리자 관리 페이지(리스트)
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

		model.addAttribute("managerList", managerList); // movieList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_manager";
	}

	// 관리자 추가
	@ResponseBody
	@RequestMapping("/managerInsert.mdo")
	public int insertManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for inserting manager");
		int result = managerService.insertManager(vo); // 추가된 행의 개수(관리자 개수) 반환
		return result;
	}

	// 관리자 삭제
	@ResponseBody
	@RequestMapping("/managerDelete.mdo")
	public int deleteManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for deleting manager");
		int result = managerService.deleteManager(vo); // 삭제된 행의 개수(관리자 개수) 반환
		return result;
	}

	// 관리자 수정
	@ResponseBody
	@RequestMapping("/managerModify.mdo")
	public int modifyManager(AdminManagerVO vo) {
		System.out.println("AdminManagerController load for modifying manager");
		int result = managerService.modifyManager(vo); // 수정된 행의 개수(관리자 개수) 반환
		return result;
	}

	// PDF 기능
	@ResponseBody
	@RequestMapping("/managerPdfDown.mdo") // View에서 맵핑 url 주소
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {
		int result = managerService.createPdf(newpdf); // createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
	}

	// EXCEL 기능
	@RequestMapping("/managerExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// 관리자 목록 조회
		List<AdminManagerVO> list = managerService.selectBoardList();

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
		cell.setCellValue("관리자 아이디");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("관리자 이메일");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("관리자 타입");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("등록일");

		// 데이터 부분 생성
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

		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();
	}
	
	// 관리자 로그인 창
	@RequestMapping("/adminLogin.mdo")
	public String getAdminLogin() {
		return "adminLogin";
	}
	
	// 관리자 로그인
	@RequestMapping("/adminLoginCheck.mdo")
	public String adminLogin(AdminManagerVO vo, HttpSession session, RedirectAttributes rttr, 
			Model model, HttpServletResponse response) throws Exception {
		//System.out.println(vo.getManager_email());
		
		String page = "adminLogin";
		AdminManagerVO adminLogin = managerService.adminLogin(vo); // 로그인한 관리자 정보 vo
		//System.out.println(managerService.adminLogin(vo));
		
		if(adminLogin != null) {
			if(vo.getManager_pass().equals(adminLogin.getManager_pass())) { // 비밀번호가 일치한다면
				System.out.println("관리자 " + adminLogin.getManager_email() + " 로그인 성공");
				session.setAttribute("manager", adminLogin);
				page = "manage_template";
			}
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				ScriptUtils.alert(response, "비밀번호가 일치하지 않습니다");
			}
		}
		
		else { // 가져온 vo가 null일 때, 즉 로그인 시도한 아이디가 존재하지 않을 때
			System.out.println("해당 아이디가 존재하지 않습니다");
			ScriptUtils.alert(response, "해당 아이디가 존재하지 않습니다");
		}
		
		return page;
	}
	
	// 관리자 로그아웃
	@RequestMapping("/adminLogout.mdo") 
	public String adminLogout(HttpSession session) throws Exception {
		if(session != null) {
			session.invalidate(); // 세션이 존재하면 세션 무효화 => 로그아웃
		}
		return "redirect:/adminLogin.mdo";
	}
}

























