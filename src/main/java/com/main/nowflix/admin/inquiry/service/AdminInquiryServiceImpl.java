package com.main.nowflix.admin.inquiry.service;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.main.nowflix.admin.inquiry.dao.AdminInquiryDAO;
import com.main.nowflix.admin.inquiry.vo.AdminInquiryVO;

@Service("adminInquiryService")
public class AdminInquiryServiceImpl implements AdminInquiryService {
	@Autowired
	private AdminInquiryDAO inquiryDAO;

	@Autowired
	private AdminInquiryService inquiryService;

	// 문의 리스트 가져오기
	@Override
	public List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map) {
		return inquiryDAO.getInquiryList(map);
	}

	// 행 개수 가져오기
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return inquiryDAO.getTotalCount(map);
	}

	// 문의 개수 가져오기
	public int getInquiryCount() {
		return inquiryDAO.getInquiryCount();
	}

	// 문의 추가
	@Override
	public int insertInquiry(AdminInquiryVO vo) {
		return inquiryDAO.insertInquiry(vo);
	}

	// 문의 삭제
	@Override
	public int deleteInquiry(AdminInquiryVO vo) {
		return inquiryDAO.deleteInquiry(vo);
	}

	// 문의 수정
	@Override
	public int modifyInquiry(AdminInquiryVO vo) {
		return inquiryDAO.modifyInquiry(vo);
	}

	// EXCEL
	@Override
	public List<AdminInquiryVO> selectBoardList() throws Exception {
		return inquiryDAO.selectBoardList(null);
	}

	// PDF
	@Override
	public int createPdf(String newpdf) {
		int result = 0; // 초기값이 null이 들어가면 오류가 발생될수 있기 때문에 공백을 지정
		try {
			Document document = new Document(); // pdf문서를 처리하는 객체

			String pdf_user_dir = System.getProperty("user.name");

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:/Users/" + pdf_user_dir + "/Downloads/" + newpdf + ".pdf"));

			// pdf파일의 저장경로를 d드라이브의 sample.pdf로 한다는 뜻

			document.open(); // 웹페이지에 접근하는 객체를 연다

			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			// pdf가 기본적으로 한글처리가 안되기 때문에 한글폰트 처리를 따로 해주어야 한다.
			// createFont메소드에 사용할 폰트의 경로 (malgun.ttf)파일의 경로를 지정해준다.
			// 만약에 이 경로에 없을 경우엔 java파일로 만들어서 집어넣어야 한다.

			Font font = new Font(baseFont, 9); // 폰트의 사이즈를 12픽셀로 한다.

			PdfPTable table = new PdfPTable(9); // 4개의 셀을 가진 테이블 객체를 생성 (pdf파일에 나타날 테이블)
			Chunk chunk = new Chunk("INQUIRY_INFO", font); // 타이틀 객체를 생성 (타이틀의 이름을 장바구니로 하고 위에 있는 font를 사용)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // 문단을 만들어서 가운데 정렬 (타이틀의 이름을 가운데 정렬한다는 뜻)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // 줄바꿈 (왜냐하면 타이틀에서 두줄을 내린후에 셀(테이블)이 나오기 때문)

			PdfPCell cell1 = new PdfPCell(new Phrase("#", font)); // 셀의 이름과 폰트를 지정해서 셀을 생성한다.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 셀의 정렬방식을 지정한다. (가운데정렬)

			PdfPCell cell2 = new PdfPCell(new Phrase("카테고리", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("고객 이메일", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell4 = new PdfPCell(new Phrase("문의 제목", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell5 = new PdfPCell(new Phrase("문의 내용", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6 = new PdfPCell(new Phrase("문의 날짜", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell7 = new PdfPCell(new Phrase("답변 제목", font));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell8 = new PdfPCell(new Phrase("답변 내용", font));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell9 = new PdfPCell(new Phrase("답변 날짜", font));
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // 그리고 테이블에 위에서 생성시킨 셀을 넣는다.
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);
			table.addCell(cell7);
			table.addCell(cell8);
			table.addCell(cell9);

			List<AdminInquiryVO> list = inquiryService.selectBoardList();
			for (int i = 0; i < list.size(); i++) {
				AdminInquiryVO vo = list.get(i); // 레코드에 값들을 꺼내서 dto에 저장
				PdfPCell cellRownum = new PdfPCell(new Phrase("" + vo.getRownum(), font)); 
				// 반복문을 사용해서 상품정보를 하나씩 //																// 출력해서 셀에 넣고 테이블에// 저장한다.

				PdfPCell cellInqType = new PdfPCell(new Phrase("" + vo.getInquiry_type(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.

				PdfPCell cellEmail = new PdfPCell(new Phrase("" + vo.getEmail(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.

				PdfPCell cellInqTitle = new PdfPCell(new Phrase("" + vo.getInquiry_title(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
				
				PdfPCell cellInqContent = new PdfPCell(new Phrase("" + vo.getInquiry_content(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
				
				PdfPCell cellInqDate = new PdfPCell(new Phrase("" + vo.getInquiry_date(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
				
				PdfPCell cellReplyTitle = new PdfPCell(new Phrase("" + vo.getReply_title(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
				
				PdfPCell cellReplyContent = new PdfPCell(new Phrase("" + vo.getReply_content(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
				
				PdfPCell cellReplyDate = new PdfPCell(new Phrase("" + vo.getReply_date(), font));
				// Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.

				table.addCell(cellRownum); // 셀의 데이터를 테이블에 저장한다. (장바구니안에 들어있는 갯수만큼 테이블이 만들어진다)
				table.addCell(cellInqType);
				table.addCell(cellEmail);
				table.addCell(cellInqTitle);
				table.addCell(cellInqContent);
				table.addCell(cellInqDate);
				table.addCell(cellReplyTitle);
				table.addCell(cellReplyContent);
				table.addCell(cellReplyDate);
			}
			document.add(table); // 웹접근 객체에 table를 저장한다.
			document.close(); // 저장이 끝났으면 document객체를 닫는다.
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
