package com.main.nowflix.admin.genre.service;

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
import com.main.nowflix.admin.genre.dao.AdminGenreDAO;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;

@Service("adminGenreService")
public class AdminGenreServiceImpl implements AdminGenreService {
	@Autowired
	private AdminGenreDAO genreDAO;
	@Autowired
	private AdminGenreService genreService;

	// �帣 ����Ʈ ��������
	@Override
	public List<AdminGenreVO> getGenreList(HashMap<String, Object> map) {
		return genreDAO.getGenreList(map);
	}
	
	// �帣 ���� ��������
		@Override
		public int getTotalCount(HashMap<String, Object> map) {
			return genreDAO.getTotalCount(map);
		}

	// �帣 ����
	@Override
	public int deleteGenre(AdminGenreVO vo) {
		return genreDAO.deleteGenre(vo);
	}

	// �帣 �߰�
	@Override
	public int insertGenre(AdminGenreVO vo) {
		System.out.println("AdminGenreServiceImpl load for inserting genre");
		return genreDAO.insertGenre(vo);
	}

	// �帣 ���� ���� ��������
	@Override
	public AdminGenreVO getGenreModifyInfo(AdminGenreVO vo) {
		System.out.println("AdminGenreServiceImpl load for getting modifying genre info");
		return genreDAO.getGenreModifyInfo(vo);
	}

	// �帣 ����
	@Override
	public int modifyGenre(AdminGenreVO vo) {
		System.out.println("AdminGenreServiceImpl load for modifying genre");
		return genreDAO.modifyGenre(vo);
	}

	// EXCEL
	@Override
	public List<AdminGenreVO> selectBoardList() throws Exception {
		return genreDAO.selectBoardList(null);
	}

	// PDF

	@Override
	public int createPdf(String newpdf) {
		int result = 0; // �ʱⰪ�� null�� ���� ������ �߻��ɼ� �ֱ� ������ ������ ����
//		AdminMovieController t = new AdminMovieController();

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

			PdfPTable table = new PdfPTable(2); // 4���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
			Chunk chunk = new Chunk("Genre_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)

			PdfPCell cell1 = new PdfPCell(new Phrase("�帣_ID", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)

			PdfPCell cell2 = new PdfPCell(new Phrase("�帣_�̸�", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
			table.addCell(cell2);

			List<AdminGenreVO> list = genreService.selectBoardList();
			for (int i = 0; i < list.size(); i++) {
				AdminGenreVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
				PdfPCell cellGenre_id = new PdfPCell(new Phrase("" + vo.getGenre_id(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� //
																								// ����ؼ� ���� �ְ� ���̺�//
																								// �����Ѵ�.

				PdfPCell cellGenre_name = new PdfPCell(new Phrase("" + vo.getGenre_name(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				table.addCell(cellGenre_id); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
				table.addCell(cellGenre_name);

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
	public List<String> genreNameList(AdminGenreVO genreVO) {
		List genre_data_list = genreDAO.getGenreList2(genreVO);
		
		return genre_data_list;
	}	
}
