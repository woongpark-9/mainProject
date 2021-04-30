package com.main.nowflix.admin.policy.service;

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
import com.main.nowflix.admin.policy.dao.AdminPolicyDAO;
import com.main.nowflix.admin.policy.service.AdminPolicyService;
import com.main.nowflix.admin.policy.vo.AdminPolicyVO;

@Service("adminPolicyService")
public class AdminPolicyServiceImpl implements AdminPolicyService {
	@Autowired
	private AdminPolicyDAO policyDAO;
	
	@Autowired
	private AdminPolicyService policyService;

	//�̿��� ����Ʈ ��������
	@Override
	public List<AdminPolicyVO> getPolicyList(HashMap<String, Object> map) {
		return policyDAO.getPolicyList(map);
	}
	
	//�� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return policyDAO.getTotalCount(map);
	}

	//�̿��� �߰�
	@Override
	public int insertPolicy(AdminPolicyVO vo) {
		return policyDAO.insertPolicy(vo);
	}

	//�̿��� ����
	@Override
	public int deletePolicy(AdminPolicyVO vo) {
		return policyDAO.deletePolicy(vo);
	}
	
	//�̿��� ����
	@Override
	public int modifyPolicy(AdminPolicyVO vo) {
		return policyDAO.modifyPolicy(vo);
	}
	
	//EXCEL
	@Override
	public List<AdminPolicyVO> selectBoardList() throws Exception {
		return policyDAO.selectBoardList(null);
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
            Chunk chunk = new Chunk("Policy_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
            Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)
 
            PdfPCell cell1 = new PdfPCell(new Phrase("�̿��� ���̵�", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)
 
            PdfPCell cell2 = new PdfPCell(new Phrase("�̿��� ����", font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell3 = new PdfPCell(new Phrase("�̿��� ����", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("�����", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
            table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            
            List<AdminPolicyVO> list = policyService.selectBoardList();
            for (int i = 0; i < list.size(); i++) {
            	AdminPolicyVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
                PdfPCell cellId = new PdfPCell(new Phrase("" + vo.getPolicy_id(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ���� �ְ� ���̺�// �����Ѵ�.
 
                PdfPCell cellTitle = new PdfPCell(new Phrase("" + vo.getPolicy_title(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
 
                PdfPCell cellContent = new PdfPCell(new Phrase("" + vo.getPolicy_content(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellRegdate = new PdfPCell(new Phrase("" + vo.getPolicy_regdate(), font));
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
