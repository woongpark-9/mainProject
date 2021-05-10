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

	// 배우 관리 페이지
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
		int startPage = ((nowPage) / countPage) * countPage; // 1번 페이지 누르면 startPage = 0, 6번 페이지 누르면 startPage = 5
		int endPage = startPage + countPage - 1; // endPage = 4, endPage = 9

		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminActorVO> actorList;
		actorList = actorService.getActorList(map);

		model.addAttribute("actorList", actorList); // actorList 정보저장
		model.addAttribute("nowPage", nowPage); // nowPage 정보저장
		model.addAttribute("totalPage", totalPage); // totalPage 정보저장
		model.addAttribute("startPage", startPage); // startPage 정보저장
		model.addAttribute("endPage", endPage); // endPage 정보저장
		model.addAttribute("searchCondition", searchCondition); // searchCondition 정보저장
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword 정보저장
		return "manage_actor";
	}

	// 배우 삭제
	@ResponseBody
	@RequestMapping("/actorDelete.mdo")
	public int deleteActor(AdminActorVO vo) {
		int result = actorService.deleteActor(vo); // 삭제한 행의 개수
		return result;
	}

	// 배우 추가
	@ResponseBody
	@RequestMapping("/actorInsert.mdo")
	public int insertActor(AdminActorVO vo) {
		System.out.println("AdminActorController load for inserting actor");
		int result = actorService.insertActor(vo); // 추가된 행의 개수(배우 개수) 반환
		return result;
	}

	// 배우 수정 페이지
	@RequestMapping("/actor_Modify.mdo")
	public String getActorModify(AdminActorVO vo, Model model) {
		model.addAttribute("actorModifyInfo", actorService.getActorModifyInfo(vo)); // Model 정보저장
		return "actor_insert";
	}

	// 배우 수정
	@ResponseBody
	@RequestMapping("/actorModify.mdo")
	public int modifyActor(AdminActorVO vo) {
		int result = actorService.modifyActor(vo); // Model 정보저장
		return result;
	}

	// 배우 상세 보기
	@RequestMapping("/actorDetail.mdo")
	public String getActorDetail(AdminActorVO vo, Model model) {
		model.addAttribute("actorDetail", actorService.getActorDetail(vo));
		System.out.println(model.getAttribute("actorDetail").toString());
		return "manage_actor";
	}

	// PDF 기능
	@ResponseBody
	@RequestMapping("/actorPdfDown.mdo") // View에서 맵핑 url 주소
	public int list(HttpServletRequest request, @RequestParam String newpdf) throws Exception {

		int result = actorService.createPdf(newpdf); // createPdf()메소드에서 pdf파일이 생성되었는지 결과가 result에 담긴다.
		return result;
	}

	// EXCEL 기능
	@RequestMapping("/actorExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {

		// 게시판 목록조회
		List<AdminActorVO> list = actorService.selectBoardList();

		// 워크북 생성
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("배우");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// 테이블 헤더용 스타일
		CellStyle headStyle = wb.createCellStyle();
		CreationHelper creationHelper = wb.getCreationHelper();
		// 가는 경계선을 가집니다.
		sheet.setColumnWidth(0, 5000);
		sheet.setColumnWidth(1, 8000);
		sheet.setColumnWidth(2, 5000);
		
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
		cell.setCellValue("배우ID");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("배우이름");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("생년월일");

		// 데이터 부분 생성
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

		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=ActorExcelFile.xls");

		wb.write(response.getOutputStream());
		wb.close();

	}
}
