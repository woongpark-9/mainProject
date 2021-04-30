package com.main.nowflix.admin.member.service;

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
import com.main.nowflix.admin.member.dao.AdminMemberDAO;
import com.main.nowflix.admin.member.vo.AdminMemberVO;

@Service("adminMemberService")

public class AdminMemberServiceImpl implements AdminMemberService {

	
	
	@Autowired
	private AdminMemberDAO MemberDAO;
	@Autowired
	private AdminMemberService memberService;
	
	// =====================================================�������ʿ��մϴ�===========================================================
	// =====================================================�������ʿ��մϴ�===========================================================
	// =====================================================�������ʿ��մϴ�===========================================================
	// =====================================================�������ʿ��մϴ�===========================================================
	// =====================================================�������ʿ��մϴ�===========================================================
	
//	@Override
//	public int get_all_member_count(AdminMemberVO memberVO) {
//
//		return MemberDAO.get_all_member_count(memberVO);
//	}
	
	// =====================================================��ȭ ����Ʈ ��������===========================================================
	@Override
	public List<AdminMemberVO> getMemberList(HashMap<String, Object> map) {
		return MemberDAO.getMemberList(map);
	}
	
	// =====================================================�� ���� ��������===========================================================
	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return MemberDAO.getTotalCount(map);
	}

	// =====================================================MEMBER-INSERT===========================================================
	@Override
	public int insertMember(AdminMemberVO memberVO) {
		System.out.println("AdminMovieServiceImpl load for inserting movie");
		return MemberDAO.insertMember(memberVO);
	}

	// =====================================================MEMBER MODIFY PAGE===========================================================
	@Override
	public AdminMemberVO getMemberModifyInfo(AdminMemberVO memberVO) {
		System.out.println("AdminMemberServiceImpl load for getting modifying movie info");
		System.out.println(MemberDAO.getMemberModifyInfo(memberVO).toString());
		return MemberDAO.getMemberModifyInfo(memberVO);
	}

	// =====================================================MEMBER MODIFY===========================================================
	@Override
	public int modifyMember(AdminMemberVO memberVO) {
		System.out.println("AdminMovieServiceImpl load for modifying movie");
		System.out.println(MemberDAO.getMemberModifyInfo(memberVO).toString());
		return MemberDAO.modifyMember(memberVO);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	// =====================================================EXCEL===========================================================
	// =====================================================EXCEL===========================================================
	// =====================================================EXCEL===========================================================
	// =====================================================EXCEL===========================================================
	// =====================================================EXCEL===========================================================
	// =====================================================EXCEL===========================================================
	@Override
	public List<AdminMemberVO> selectBoardList() throws Exception {
		return MemberDAO.selectBoardList(null);
	}
	
	
	// =====================================================PDF===========================================================
	// =====================================================PDF===========================================================
	// =====================================================PDF===========================================================
	// =====================================================PDF===========================================================
	// =====================================================PDF===========================================================
	// =====================================================PDF===========================================================
	@Override
	public int membercreatePdf(String newmemberpdf) {
		int result = 0; // �ʱⰪ�� null�� ���� ������ �߻��ɼ� �ֱ� ������ ������ ����
		try {
			Document document = new Document(); // pdf������ ó���ϴ� ��ü

			String pdf_user_dir = System.getProperty("user.name");

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:/Users/" + pdf_user_dir + "/Downloads/" + newmemberpdf + ".pdf"));

			// pdf������ �����θ� d����̺��� sample.pdf�� �Ѵٴ� ��

			document.open(); // ���������� �����ϴ� ��ü�� ����

			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			// pdf�� �⺻������ �ѱ�ó���� �ȵǱ� ������ �ѱ���Ʈ ó���� ���� ���־�� �Ѵ�.
			// createFont�޼ҵ忡 ����� ��Ʈ�� ��� (malgun.ttf)������ ��θ� �������ش�.
			// ���࿡ �� ��ο� ���� ��쿣 java���Ϸ� ���� ����־�� �Ѵ�.

			Font font = new Font(baseFont, 9); // ��Ʈ�� ����� 12�ȼ��� �Ѵ�.

			PdfPTable table = new PdfPTable(9); // 4���� ���� ���� ���̺� ��ü�� ���� (pdf���Ͽ� ��Ÿ�� ���̺�)
//			table.setWidthPercentage(50);
//			table.setWidths(new float[] { 8, 3 });
			Chunk chunk = new Chunk("MOVIE_INFO", font); // Ÿ��Ʋ ��ü�� ���� (Ÿ��Ʋ�� �̸��� ��ٱ��Ϸ� �ϰ� ���� �ִ� font�� ���)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // ������ ���� ��� ���� (Ÿ��Ʋ�� �̸��� ��� �����Ѵٴ� ��)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // �ٹٲ� (�ֳ��ϸ� Ÿ��Ʋ���� ������ �����Ŀ� ��(���̺�)�� ������ ����)

			PdfPCell cell1 = new PdfPCell(new Phrase("rownum", font)); // ���� �̸��� ��Ʈ�� �����ؼ� ���� �����Ѵ�.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // ���� ���Ĺ���� �����Ѵ�. (�������)

			PdfPCell cell2 = new PdfPCell(new Phrase("�̸���", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("�г���", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell4 = new PdfPCell(new Phrase("����", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell5 = new PdfPCell(new Phrase("����", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell6 = new PdfPCell(new Phrase("�̿��", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell7 = new PdfPCell(new Phrase("��������", font));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell8 = new PdfPCell(new Phrase("��������", font));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell9 = new PdfPCell(new Phrase("������", font));
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

			List<AdminMemberVO> list = memberService.selectBoardList();

			for (int i = 0; i < list.size(); i++) {
				AdminMemberVO membervo = list.get(i); // ���ڵ忡 ������ ������ dto�� ����

				PdfPCell cell_rownum = new PdfPCell(new Phrase("" + membervo.getSeq(), font));
				// �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ���� // �ְ� ���̺�// �����Ѵ�.

				PdfPCell cell_email = new PdfPCell(new Phrase("" + membervo.getEmail(), font));
				// �ݺ����� ����ؼ� ��ǰ������ �ϳ��� // ����ؼ� ���� // �ְ� ���̺�// �����Ѵ�.

				PdfPCell cell_nickname = new PdfPCell(new Phrase("" + membervo.getNickname(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_age = new PdfPCell(new Phrase("" + membervo.getAge(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_gender = new PdfPCell(new Phrase("" + membervo.getGender(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_ticket_id = new PdfPCell(new Phrase("" + membervo.getTicket_id(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_cert = new PdfPCell(new Phrase("" + membervo.getCert(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_ban = new PdfPCell(new Phrase("" + membervo.getBan(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				PdfPCell cell_joindate = new PdfPCell(new Phrase("" + membervo.getJoin_date(), font));
				// PhraseŸ���� ������(int�� ����Ÿ��)���� �ϸ� ������ �߻��Ǳ� ������ dto�տ� ����("")�־ StringŸ������ �����Ѵ�.

				table.addCell(cell_rownum); // ���� �����͸� ���̺� �����Ѵ�. (��ٱ��Ͼȿ� ����ִ� ������ŭ ���̺��� ���������)
				table.addCell(cell_email);
				table.addCell(cell_nickname);
				table.addCell(cell_age);
				table.addCell(cell_gender);
				table.addCell(cell_ticket_id);
				table.addCell(cell_cert);
				table.addCell(cell_ban);
				table.addCell(cell_joindate);

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
	
	   public ArrayList<Integer> ageList(AdminMemberVO memberVO , AdminAnalysis_Age_VO analysis_age_VO){
		      List test1 = MemberDAO.ageList(memberVO);
		      ArrayList<Integer> return_list = new ArrayList<Integer>();
		      
		      int age_10 = 0;
		      int age_20 = 0;
		      int age_30 = 0;
		      int age_40 = 0;
		      int age_50 = 0;
		      int age_60 = 0;
		      int age_70 = 0;
		      int age_80 = 0;
		      int age_90 = 0;
		      int age_100 = 0;
		      int man_count = 0;
		      int girl_count = 0;
		      int total_count = test1.size();
		      
		      int kakao_count = 0;
		      int naver_count = 0;
		      int nowflix_count = 0;
		      
		      int member_cert_y = 0;
		      int member_cert_n = 0;
		      int member_ban_y = 0;
		      int member_ban_n = 0;
		      
		      int ticket_0011 = 0;
		      int ticket_0013 = 0;
		      int ticket_0016 = 0;
		      int ticket_00112 = 0;
		      int ticket_0021 = 0;
		      int ticket_0023 = 0;
		      int ticket_0026 = 0;
		      int ticket_00212 = 0;
		      
		      int ticket_not = 0;
		      int ticket_no_not = 0;
		      
//		      int member_join_date = 0;
		      
		      for(int i = 0; i < test1.size(); i++) {
		         AdminMemberVO testVO = (AdminMemberVO)test1.get(i);
//		         System.out.print("������ü"+testVO.getAge());
//		         System.out.println();
//		         System.out.print("������ü"+testVO.getGender());
//		         System.out.println();
//		         System.out.println("īī����ü "+testVO.getKakao());
//		         System.out.println();
//		         System.out.println("īī����ü "+testVO.getNaver());
//		         System.out.println();
//		         System.out.println("����ü "+testVO.getBan());
//		         System.out.println();
//		         System.out.println("������ü"+testVO.getCert());
		         
		         if(testVO.getTicket_id().equals("N")) {
		            ticket_not++;
		         }
		         
		         if(!(testVO.getTicket_id().equals("N"))) {
		            ticket_no_not++;
		         }
		         
		         if(testVO.getTicket_id().equals("0011")) {
		            ticket_0011++;
		         }
		         
		         if(testVO.getTicket_id().equals("0013")) {
		            ticket_0013++;
		         }
		         
		         if(testVO.getTicket_id().equals("0016")) {
		            ticket_0016++;
		         }
		         
		         if(testVO.getTicket_id().equals("00112")) {
		            ticket_00112++;
		         }
		         
		         if(testVO.getTicket_id().equals("0021")) {
		            ticket_0021++;
		         }
		         
		         if(testVO.getTicket_id().equals("0023")) {
		            ticket_0023++;
		         }
		         
		         if(testVO.getTicket_id().equals("0026")) {
		            ticket_0026++;
		         }
		         
		         if(testVO.getTicket_id().equals("00212")) {
		            ticket_00212++;
		         }
		         
		         if(testVO.getBan().equals("Y")) {
		            member_ban_y++;
		         }
		         
		         if(testVO.getBan().equals("N")) {
		            member_ban_n++;
		         }
		         
		         if(testVO.getCert().equals("Y")) {
		            member_cert_y++;
		         }
		         
		         if(testVO.getCert().equals("N")) {
		            member_cert_n++;
		         }

		         if(!(testVO.getNaver() == null)) {
		            naver_count++;
		         }
		         
		         if(!(testVO.getKakao() == null)) {
		            kakao_count++;
		         }
		         
		         if((testVO.getKakao() == null && testVO.getNaver() == null)) {
		            nowflix_count++;
		         }
		         
		         if(testVO.getGender().equals("G")) {
		            girl_count++;
		         }
		         
		         if(testVO.getGender().equals("M")) {
		            man_count++;
		         }
		         
		         if(testVO.getAge() >= 10 && testVO.getAge() < 20) {
		            age_10++;
		         }else if(testVO.getAge() >= 20 && testVO.getAge() < 30) {
		            age_20++;
		         }else if(testVO.getAge() >= 30 && testVO.getAge() < 40) {
		            age_30++;
		         }else if(testVO.getAge() >= 40 && testVO.getAge() < 50) {
		            age_40++;
		         }else if(testVO.getAge() >= 50 && testVO.getAge() < 60) {
		            age_50++;
		         }else if(testVO.getAge() >= 60 && testVO.getAge() < 70) {
		            age_60++;
		         }else if(testVO.getAge() >= 70 && testVO.getAge() < 80) {
		            age_70++;
		         }else if(testVO.getAge() >= 80 && testVO.getAge() < 90) {
		            age_80++;
		         }else if(testVO.getAge() >= 90 && testVO.getAge() < 100) {
		            age_90++;
		         }else if(testVO.getAge() >= 100 && testVO.getAge() < 101) {
		            age_100++;
		         }
		         
		      }
		      
		      System.out.println("tick_0011"+ticket_0011);
		      System.out.println("ticket_0013"+ticket_0013);
		      System.out.println("ticket_0016"+ticket_0016);
		      System.out.println("ticket_00112"+ticket_00112);
		      System.out.println("ticket_0021"+ticket_0021);
		      System.out.println("ticket_0023"+ticket_0023);
		      System.out.println("ticket_0026"+ticket_0026);
		      System.out.println("ticket_00212"+ticket_00212);
		      
		      
		      return_list.add((Integer)age_10); //INDEX[0]
		      return_list.add((Integer)age_20); //INDEX[1]
		      return_list.add((Integer)age_30); //INDEX[2]
		      return_list.add((Integer)age_40); //INDEX[3]
		      return_list.add((Integer)age_50); //INDEX[4]
		      return_list.add((Integer)age_60); //INDEX[5]
		      return_list.add((Integer)age_70); //INDEX[6]
		      return_list.add((Integer)age_80); //INDEX[7]
		      return_list.add((Integer)age_90); //INDEX[8]
		      return_list.add((Integer)age_100); //INDEX[9]
		      return_list.add((Integer)girl_count); //INDEX[10]
		      return_list.add((Integer)man_count); //INDEX[11]
		      return_list.add((Integer)total_count); //INDEX[12]
		      return_list.add((Integer)kakao_count); //INDEX[13]
		      return_list.add((Integer)naver_count); //INDEX[14]
		      return_list.add((Integer)nowflix_count); //INDEX[15]
		      return_list.add((Integer)member_ban_y); //INDEX[16]
		      return_list.add((Integer)member_ban_n); //INDEX[17]
		      return_list.add((Integer)member_cert_y); //INDEX[18]
		      return_list.add((Integer)member_cert_n); //INDEX[19]
		      
		      return_list.add((Integer)ticket_0011); //INDEX[20]
		      return_list.add((Integer)ticket_0013); //INDEX[21]
		      return_list.add((Integer)ticket_0016); //INDEX[22]
		      return_list.add((Integer)ticket_00112); //INDEX[23]
		      return_list.add((Integer)ticket_0021); //INDEX[24]
		      return_list.add((Integer)ticket_0023); //INDEX[25]
		      return_list.add((Integer)ticket_0026); //INDEX[26]
		      return_list.add((Integer)ticket_00212); //INDEX[27]
		      
		      return_list.add((Integer)ticket_not); //INDEX[28]
		      return_list.add((Integer)ticket_no_not); //INDEX[29]
		      
		      System.out.println("return_list"+return_list);
		      
		      return return_list;
		      
		   }
	
}
