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

	//�������� ����Ʈ ��������
	@Override
	public List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map) {
		return inquiryDAO.getInquiryList(map);
	}
	
	//�� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return inquiryDAO.getTotalCount(map);
	}

	//�������� �߰�
	@Override
	public int insertInquiry(AdminInquiryVO vo) {
		return inquiryDAO.insertInquiry(vo);
	}

	//�������� ����
	@Override
	public int deleteInquiry(AdminInquiryVO vo) {
		return inquiryDAO.deleteInquiry(vo);
	}
	
	//�������� ����
	@Override
	public int modifyInquiry(AdminInquiryVO vo) {
		return inquiryDAO.modifyInquiry(vo);
	}
	
	//EXCEL
	@Override
	public List<AdminInquiryVO> selectBoardList() throws Exception {
		return inquiryDAO.selectBoardList(null);
	}
	//PDF
	@Override
	public int createPdf(String newpdf) {
		int result = 0; // �ʱⰪ�� null�� ���� ������ �߻��ɼ� �ֱ� ������ ������ ����		
        try {    		
    		Document document = new Document(); // pdf������ ó���ϴ� ��ü
    		
    		String pdf_user_dir = System.getProperty("user.name");
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/"+ pdf_user_dir + "/Downloads/"+newpdf+".pdf"));
     
            // pdf������ �����θ� d����̺��� sample.pdf�� �Ѵٴ� ��
 
            document.open(); // ���������� �����ϴ� ��ü�� ����
            
            BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            // pdf�� �⺻������ �ѱ�ó���� �ȵǱ� ������ �ѱ���Ʈ ó���� ���� ���־�� �Ѵ�.
            // createFont�޼ҵ忡 ����� ��Ʈ�� ��� (malgun.ttf)������ ��θ� �������ش�.
            // ���࿡ �� ��ο� ���� ��쿣 java���Ϸ� ���� ����־�� �Ѵ�.
 
            Font font = new Font(baseFont, 9); // ��Ʈ�� ����� 12�ȼ��� �Ѵ�.
 
            PdfPTable table = new PdfPTable(4); // 4���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
            Chunk chunk = new Chunk("Inquiry_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
            Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)
 
            PdfPCell cell1 = new PdfPCell(new Phrase("�������� ��ȣ", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)
 
            PdfPCell cell2 = new PdfPCell(new Phrase("�������� ����", font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell3 = new PdfPCell(new Phrase("�������� ����", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("�����", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
            table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            
            List<AdminInquiryVO> list = inquiryService.selectBoardList();
            for (int i = 0; i < list.size(); i++) {
            	AdminInquiryVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
                PdfPCell cellId = new PdfPCell(new Phrase("" + vo.getInquiry_id(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ���� �ְ� ���̺�// �����Ѵ�.
 
                PdfPCell cellTitle = new PdfPCell(new Phrase("" + vo.getInquiry_title(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
 
                PdfPCell cellContent = new PdfPCell(new Phrase("" + vo.getInquiry_content(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellRegdate = new PdfPCell(new Phrase("" + vo.getInquiry_content(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                table.addCell(cellId); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
                table.addCell(cellTitle);
                table.addCell(cellContent);
                table.addCell(cellRegdate); 
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
