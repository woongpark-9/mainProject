package com.main.nowflix.admin.sales.service;

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
import com.main.nowflix.admin.sales.dao.AdminSalesDAO;
import com.main.nowflix.admin.sales.service.AdminSalesService;
import com.main.nowflix.admin.sales.vo.AdminSalesVO;

@Service("adminSalesService")
public class AdminSalesServiceImpl implements AdminSalesService {
	@Autowired
	private AdminSalesDAO salesDAO;
	
	@Autowired
	private AdminSalesService salesService;

	//�������� ����Ʈ ��������
	@Override
	public List<AdminSalesVO> getSalesList(HashMap<String, Object> map) {
		return salesDAO.getSalesList(map);
	}
	
	//�� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return salesDAO.getTotalCount(map);
	}
	
	//EXCEL
	@Override
	public List<AdminSalesVO> selectBoardList() throws Exception {
		return salesDAO.selectBoardList(null);
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
 
            PdfPTable table = new PdfPTable(10); // 10���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
            Chunk chunk = new Chunk("Sales_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
            Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)
 
            PdfPCell cell1 = new PdfPCell(new Phrase("sales_id", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)
 
            PdfPCell cell2 = new PdfPCell(new Phrase("cid", font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell3 = new PdfPCell(new Phrase("tid", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("member_email", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell5 = new PdfPCell(new Phrase("ticket_id", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell6 = new PdfPCell(new Phrase("sales_status", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell7 = new PdfPCell(new Phrase("payment_date", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell8 = new PdfPCell(new Phrase("expiry_date", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell9 = new PdfPCell(new Phrase("payment_method_type", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell10 = new PdfPCell(new Phrase("card_name", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
            table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            
            
            List<AdminSalesVO> list = salesService.selectBoardList();
            for (int i = 0; i < list.size(); i++) {
            	AdminSalesVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
 
                PdfPCell cellSales_id = new PdfPCell(new Phrase("" + vo.getSales_id(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
 
                PdfPCell cellCid = new PdfPCell(new Phrase("" + vo.getCid(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellTid = new PdfPCell(new Phrase("" + vo.getTid(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellMember_email = new PdfPCell(new Phrase("" + vo.getEmail(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellTicket_id = new PdfPCell(new Phrase("" + vo.getTicket_id(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellSales_status = new PdfPCell(new Phrase("" + vo.getSales_status(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                          
                PdfPCell cellPayment_date = new PdfPCell(new Phrase("" + vo.getPayment_date(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellExpiry_date = new PdfPCell(new Phrase("" + vo.getExpiry_date(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellPayment_method_type = new PdfPCell(new Phrase("" + vo.getPayment_method_type(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                PdfPCell cellSales_cardname = new PdfPCell(new Phrase("" + vo.getCard_name(), font));
                // PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.
                
                table.addCell(cellSales_id); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
                table.addCell(cellCid);
                table.addCell(cellTid);
                table.addCell(cellMember_email); 
                table.addCell(cellTicket_id);
                table.addCell(cellSales_status);
                table.addCell(cellPayment_date); 
                table.addCell(cellExpiry_date);
                table.addCell(cellPayment_method_type);
                table.addCell(cellSales_cardname); 
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
	
	@Override
	public List<AdminSalesVO> SalesList(AdminSalesVO salesVO) {
		List salesList = salesDAO.SalesList(salesVO);
		return salesList;
	}
	
	@Override
	public List<AdminSalesVO> selectPaymentDataList(AdminSalesVO salesVO) {
		List PaymentDataList = salesDAO.selectPaymentDataList(salesVO);
		return PaymentDataList;
	}

	// ���� ��ҽ� ���� ���� ����
	@Override
	public int updateSalesStatus(AdminSalesVO vo) {
		return salesDAO.updateSalesStatus(vo);
	}
}
