package com.main.nowflix.admin.manager.service;

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
import com.main.nowflix.admin.manager.vo.AdminManagerVO;
import com.main.nowflix.admin.manager.dao.AdminManagerDAO;
import com.main.nowflix.admin.manager.vo.AdminManagerVO;

@Service("adminMangerService")
public class AdminManagerServiceImpl implements AdminManagerService {

	@Autowired
	private AdminManagerDAO managerDAO;
	
	@Autowired
	private AdminManagerService managerService;
	
	@Override
	public List<AdminManagerVO> getManagerList(HashMap<String, Object> map) {
		return managerDAO.getManagerList(map);
	}
	
	//�� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return managerDAO.getTotalCount(map);
	}
	
	//������ �߰�
	@Override
	public int insertManager(AdminManagerVO vo) {
		return managerDAO.insertManager(vo);
	}

	//������ ����
	@Override
	public int deleteManager(AdminManagerVO vo) {
		return managerDAO.deleteManager(vo);
	}
	
	//������ ����
	@Override
	public int modifyManager(AdminManagerVO vo) {
		return managerDAO.modifyManager(vo);
	}
	
	//EXCEL
	@Override
	public List<AdminManagerVO> selectBoardList() throws Exception {
		return managerDAO.selectBoardList(null);
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
            Chunk chunk = new Chunk("Manager_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
            Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)
 
            PdfPCell cell1 = new PdfPCell(new Phrase("������ ���̵�", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)
 
            PdfPCell cell2 = new PdfPCell(new Phrase("������ �̸���", font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell3 = new PdfPCell(new Phrase("������ Ÿ��", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("�����", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
            table.addCell(cell1); // �׸��� ���̺��� ������ ������Ų ���� �ִ´�.
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
 
            List<AdminManagerVO> list = managerService.selectBoardList();
            for (int i = 0; i < list.size(); i++) {
            	AdminManagerVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
                PdfPCell cellId = new PdfPCell(new Phrase("" + vo.getManager_id(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ���� �ְ� ���̺���// �����Ѵ�.
 
                PdfPCell cellEmail = new PdfPCell(new Phrase("" + vo.getManager_email(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
 
                PdfPCell cellType = new PdfPCell(new Phrase("" + vo.getManager_type(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellRegdate = new PdfPCell(new Phrase("" + vo.getManager_regdate(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                table.addCell(cellId); // ���� �����͸� ���̺��� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
                table.addCell(cellEmail);
                table.addCell(cellType);
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