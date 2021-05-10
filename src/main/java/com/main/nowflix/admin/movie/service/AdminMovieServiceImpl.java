package com.main.nowflix.admin.movie.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
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
import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.movie.dao.AdminMovieDAO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Service("adminMovieService")
public class AdminMovieServiceImpl implements AdminMovieService {
	@Autowired
	private AdminMovieDAO movieDAO;
	@Autowired
	private AdminMovieService movieService;

	// ��ȭ ����Ʈ ��������
	@Override
	public List<AdminMovieVO> getMovieList(HashMap<String, Object> map) {
		return movieDAO.getMovieList(map);
	}

	// �� ���� ��������
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return movieDAO.getTotalCount(map);
	}

	// ��ȭ ����
	@Override
	public int deleteMovie(AdminMovieVO vo) {
		return movieDAO.deleteMovie(vo);
	}

	// ��ȭ �߰�
	@Override
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for inserting movie");
		return movieDAO.insertMovie(vo);
	}

	// ��ȭ ���� ���� ��������
	@Override
	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for getting modifying movie info");
		return movieDAO.getMovieModifyInfo(vo);
	}

	// ��ȭ ����
	@Override
	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for modifying movie");
		return movieDAO.modifyMovie(vo);
	}

	// ��ȭ �� ����
	@Override
	public AdminMovieVO getMovieDetail(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for getting movie details");
		return movieDAO.getMovieDetail(vo);
	}

	// EXCEL
	@Override
	public List<AdminMovieVO> selectBoardList() throws Exception {
		return movieDAO.selectBoardList(null);
	}

	// PDF

	@Override
	public int createPdf(String newpdf) {
		int result = 0; // �ʱⰪ�� null�� ���� ������ �߻��ɼ� �ֱ� ������ ������ ����
//      AdminMovieController t = new AdminMovieController();

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

			PdfPTable table = new PdfPTable(7); // 7���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
			Chunk chunk = new Chunk("FAQ_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)

			PdfPCell cell1 = new PdfPCell(new Phrase("seq", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)

			PdfPCell cell2 = new PdfPCell(new Phrase("����", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("����", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell4 = new PdfPCell(new Phrase("���", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell5 = new PdfPCell(new Phrase("�帣", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell6 = new PdfPCell(new Phrase("�󿵽ð�", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell7 = new PdfPCell(new Phrase("��������", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // �׸��� ���̺� ������ ������Ų ���� �ִ´�.
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);
			table.addCell(cell7);

			List<AdminMovieVO> list = movieService.selectBoardList();
			for (int i = 0; i < list.size(); i++) {
				AdminMovieVO vo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����
				PdfPCell cellSeq = new PdfPCell(new Phrase("" + vo.getSeq(), font)); // �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ����
																						// �ְ� ���̺�// �����Ѵ�.

				PdfPCell cellTitle = new PdfPCell(new Phrase("" + vo.getTitle(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellDirector_name = new PdfPCell(new Phrase("" + vo.getDirector_name(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellActor_name = new PdfPCell(new Phrase("" + vo.getActor_name(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellGenre_name = new PdfPCell(new Phrase("" + vo.getGenre_name(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellMovie_runningtime = new PdfPCell(new Phrase("" + vo.getMovie_runningtime(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cellMovie_release = new PdfPCell(new Phrase("" + vo.getMovie_release_date(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				table.addCell(cellSeq); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
				table.addCell(cellTitle);
				table.addCell(cellDirector_name);
				table.addCell(cellActor_name);
				table.addCell(cellGenre_name);
				table.addCell(cellMovie_runningtime);
				table.addCell(cellMovie_release);

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

	// DASHBOARD ȸ�� ��
	@Override
	public int get_all_movie_count(AdminMovieVO movieVO) {
		return movieDAO.get_all_movie_count(movieVO);
	}

	public List<String> movieList(AdminMovieVO movieVO, AdminAnalysis_Age_VO analysis_age_VO) {
		List test1 = movieDAO.movieList(movieVO);
		return test1;

	}
}