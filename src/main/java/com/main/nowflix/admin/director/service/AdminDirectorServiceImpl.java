package com.main.nowflix.admin.director.service;

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
import com.main.nowflix.admin.actor.vo.AdminActorVO;
import com.main.nowflix.admin.director.dao.AdminDirectorDAO;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;

@Service("adminDirectorService")
public class AdminDirectorServiceImpl implements AdminDirectorService {
	@Autowired
	private AdminDirectorDAO directorDAO;

	@Autowired
	private AdminDirectorService directorService;

	// ���� ����Ʈ ��������
	@Override
	public List<AdminDirectorVO> getDirectorList(HashMap<String, Object> map) {
		return directorDAO.getDirectorList(map);
	}

	// ���� ����Ʈ �������� WithoutPaging
	@Override
	public List<AdminDirectorVO> getDirectorListWithoutPaging(AdminDirectorVO vo) {
		return directorDAO.getDirectorListWithoutPaging(vo);
	}		

	// �� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return directorDAO.getTotalCount(map);
	}

	// ���� �߰�
	@Override
	public int insertDirector(AdminDirectorVO vo) {
		return directorDAO.insertDirector(vo);
	}

	// ���� ����
	@Override
	public int deleteDirector(AdminDirectorVO vo) {
		return directorDAO.deleteDirector(vo);
	}

	// ���� ����
	@Override
	public int modifyDirector(AdminDirectorVO vo) {
		return directorDAO.modifyDirector(vo);
	}

	// EXCEL
	@Override
	public List<AdminDirectorVO> selectBoardList() throws Exception {
		return directorDAO.selectBoardList(null);
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

			PdfPTable table = new PdfPTable(3); // 4���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
			Chunk chunk = new Chunk("Director_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)

			PdfPCell cell1 = new PdfPCell(new Phrase("���� ���̵�", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)

			PdfPCell cell2 = new PdfPCell(new Phrase("���� �̸�", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("���� �������", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // �׸��� ���̺��� ������ ������Ų ���� �ִ´�.
			table.addCell(cell2);
			table.addCell(cell3);

			List<AdminDirectorVO> list = directorService.selectBoardList();
			for (int i = 0; i < list.size(); i++) {
				AdminDirectorVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
				PdfPCell cellId = new PdfPCell(new Phrase("" + vo.getDirector_id(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� //
																							// ����ؼ� ���� �ְ� ���̺���// �����Ѵ�.

				PdfPCell cellName = new PdfPCell(new Phrase("" + vo.getDirector_name(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellBirthdate = new PdfPCell(new Phrase("" + vo.getDirector_birthdate(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				table.addCell(cellId); // ���� �����͸� ���̺��� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
				table.addCell(cellName);
				table.addCell(cellBirthdate);

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