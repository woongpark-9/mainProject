package com.main.nowflix.admin.notice.controller;

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

import com.main.nowflix.admin.notice.service.AdminNoticeService;
import com.main.nowflix.admin.notice.vo.AdminNoticeVO;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService noticeService;
	
	// �������� ���� ������(����Ʈ)
	@RequestMapping("/manage_notice.mdo")
	public String getNotice(Model model,
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

		int totalList = noticeService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminNoticeVO> noticeList;
		noticeList = noticeService.getNoticeList(map);

		model.addAttribute("noticeList", noticeList); // movieList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_notice";
	}
	
	//�������� �߰�
	@ResponseBody
	@RequestMapping("/noticeInsert.mdo")
	public int insertNotice(AdminNoticeVO vo) {
		System.out.println("AdminNoticeController load for inserting notice");
		int result = noticeService.insertNotice(vo); // �߰��� ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	
	//�������� ����
	@ResponseBody
	@RequestMapping("/noticeDelete.mdo")
	public int deleteNotice(AdminNoticeVO vo) {
		System.out.println("AdminNoticeController load for deleting notice");
		int result = noticeService.deleteNotice(vo); // ������ ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	//�������� ����
	@ResponseBody
	@RequestMapping("/noticeModify.mdo")
	public int modifyNotice(AdminNoticeVO vo) {
		System.out.println("AdminNoticeController load for modifying notice");
		int result = noticeService.modifyNotice(vo); // ������ ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	//PDF ���
	@ResponseBody
	@RequestMapping("/noticePdfDown.mdo") //View���� ���� url �ּ�
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = noticeService.createPdf(newpdf); //createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
    }
	
	//EXCEL ���
	@RequestMapping("/noticeExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//�������� ��� ��ȸ
		List<AdminNoticeVO> list = noticeService.selectBoardList();
		
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
		cell.setCellValue("�������� ��ȣ");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�������� ����");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�������� ����");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("�����");
	
		// ������ �κ� ����
		for(AdminNoticeVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getNotice_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getNotice_title());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getNotice_content());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getNotice_regdate());
		}
		
		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
	}
}