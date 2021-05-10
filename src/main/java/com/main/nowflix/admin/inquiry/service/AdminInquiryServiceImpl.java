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

	// ���� ����Ʈ ��������
	@Override
	public List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map) {
		return inquiryDAO.getInquiryList(map);
	}

	// �� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return inquiryDAO.getTotalCount(map);
	}

	// ���� ���� ��������
	public int getInquiryCount() {
		return inquiryDAO.getInquiryCount();
	}

	// ���� �߰�
	@Override
	public int insertInquiry(AdminInquiryVO vo) {
		return inquiryDAO.insertInquiry(vo);
	}

	// ���� ����
	@Override
	public int deleteInquiry(AdminInquiryVO vo) {
		return inquiryDAO.deleteInquiry(vo);
	}

	// ���� ����
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
		int result = 0; // �ʱⰪ�� null�� ���� ������ �߻��ɼ� �ֱ� ������ ������ ����
		try {
			Document document = new Document(); // pdf������ ó���ϴ� ��ü

			String pdf_user_dir = System.getProperty("user.name");

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:/Users/" + pdf_user_dir + "/Downloads/" + newpdf + ".pdf"));

			// pdf������ �����θ� d����̺��� sample.pdf�� �Ѵٴ� ��

			document.open(); // ���������� �����ϴ� ��ü�� ����

			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			// pdf�� �⺻������ �ѱ�ó���� �ȵǱ� ������ �ѱ���Ʈ ó���� ���� ���־�� �Ѵ�.
			// createFont�޼ҵ忡 ����� ��Ʈ�� ��� (malgun.ttf)������ ��θ� �������ش�.
			// ���࿡ �� ��ο� ���� ��쿣 java���Ϸ� ���� ����־�� �Ѵ�.

			Font font = new Font(baseFont, 9); // ��Ʈ�� ����� 12�ȼ��� �Ѵ�.

			PdfPTable table = new PdfPTable(9); // 4���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
			Chunk chunk = new Chunk("INQUIRY_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)

			PdfPCell cell1 = new PdfPCell(new Phrase("#", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)

			PdfPCell cell2 = new PdfPCell(new Phrase("ī�װ�", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("�� �̸���", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell4 = new PdfPCell(new Phrase("���� ����", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell5 = new PdfPCell(new Phrase("���� ����", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6 = new PdfPCell(new Phrase("���� ��¥", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell7 = new PdfPCell(new Phrase("�亯 ����", font));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell8 = new PdfPCell(new Phrase("�亯 ����", font));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell9 = new PdfPCell(new Phrase("�亯 ��¥", font));
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
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
				AdminInquiryVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
				PdfPCell cellRownum = new PdfPCell(new Phrase("" + vo.getRownum(), font)); 
				// �ݺ����� ����ؼ� ��ǰ������ �ϳ��� //																// ����ؼ� ���� �ְ� ���̺�// �����Ѵ�.

				PdfPCell cellInqType = new PdfPCell(new Phrase("" + vo.getInquiry_type(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellEmail = new PdfPCell(new Phrase("" + vo.getEmail(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellInqTitle = new PdfPCell(new Phrase("" + vo.getInquiry_title(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
				
				PdfPCell cellInqContent = new PdfPCell(new Phrase("" + vo.getInquiry_content(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
				
				PdfPCell cellInqDate = new PdfPCell(new Phrase("" + vo.getInquiry_date(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
				
				PdfPCell cellReplyTitle = new PdfPCell(new Phrase("" + vo.getReply_title(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
				
				PdfPCell cellReplyContent = new PdfPCell(new Phrase("" + vo.getReply_content(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
				
				PdfPCell cellReplyDate = new PdfPCell(new Phrase("" + vo.getReply_date(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				table.addCell(cellRownum); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
				table.addCell(cellInqType);
				table.addCell(cellEmail);
				table.addCell(cellInqTitle);
				table.addCell(cellInqContent);
				table.addCell(cellInqDate);
				table.addCell(cellReplyTitle);
				table.addCell(cellReplyContent);
				table.addCell(cellReplyDate);
			}
			document.add(table); // ������ ��ü�� table�� �����Ѵ�.
			document.close(); // ������ �������� document��ü�� �ݴ´�.
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
