package com.main.nowflix.admin.inquiry.controller;

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

import com.main.nowflix.admin.inquiry.service.AdminInquiryService;
import com.main.nowflix.admin.inquiry.vo.AdminInquiryVO;

@Controller
public class AdminInquiryController {
	
	@Autowired
	private AdminInquiryService inquiryService;
	
	// 1:1���� ���� ������(����Ʈ)
	@RequestMapping("/manage_inquiry.mdo")
	public String getInquiry(Model model,
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

		int totalList = inquiryService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 5;
		int startPage = ((nowPage) / countPage) * countPage; 
		int endPage = startPage + countPage - 1; 
		
		if ((totalList % row) > 0) {
			totalPage++;
		}

		List<AdminInquiryVO> inquiryList;
		inquiryList = inquiryService.getInquiryList(map);

		model.addAttribute("inquiryList", inquiryList); // movieList ��������
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("startPage", startPage); // startPage ��������
		model.addAttribute("endPage", endPage); // endPage ��������
		model.addAttribute("searchCondition", searchCondition); // searchCondition ��������
		model.addAttribute("searchKeyword", searchKeyword); // searchKeyword ��������
		return "manage_inquiry";
	}
	
	//�������� �߰�
	@ResponseBody
	@RequestMapping("/inquiryInsert.mdo")
	public int insertInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for inserting inquiry");
		int result = inquiryService.insertInquiry(vo); // �߰��� ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	
	//�������� ����
	@ResponseBody
	@RequestMapping("/inquiryDelete.mdo")
	public int deleteInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for deleting inquiry");
		int result = inquiryService.deleteInquiry(vo); // ������ ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	//�������� ����
	@ResponseBody
	@RequestMapping("/inquiryModify.mdo")
	public int modifyInquiry(AdminInquiryVO vo) {
		System.out.println("AdminInquiryController load for modifying inquiry");
		int result = inquiryService.modifyInquiry(vo); // ������ ���� ����(�������� ����) ��ȯ
		return result;
	}
	
	//PDF ���
	@ResponseBody
	@RequestMapping("/inquiryPdfDown.mdo") //View���� ���� url �ּ�
    public int list(HttpServletRequest request , @RequestParam String newpdf) throws Exception { 
		int result = inquiryService.createPdf(newpdf); //createPdf()�޼ҵ忡�� pdf������ �����Ǿ����� ����� result�� ����.
		return result;
    }
	
	//EXCEL ���
	@RequestMapping("/inquiryExcelDown.mdo")
	public void excelDown(HttpServletResponse response) throws Exception {
		
		//�������� ��� ��ȸ
		List<AdminInquiryVO> list = inquiryService.selectBoardList();
		
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
		for(AdminInquiryVO vo : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getInquiry_id());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(vo.getInquiry_title());
			cell = row.createCell(2);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getInquiry_content());
			cell = row.createCell(3);
			cell.setCellStyle(dataStyle);
			cell.setCellValue(vo.getInquiry_content());
		}
		
		// ���� ���
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MovieExcelFile.xls");
		
		wb.write(response.getOutputStream());
		wb.close();
	}
}
