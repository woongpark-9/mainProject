package com.main.nowflix.admin.analysis.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Director_count_VO;
import com.main.nowflix.admin.genre.service.AdminGenreService;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;
import com.main.nowflix.admin.member.service.AdminMemberService;
import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;
import com.main.nowflix.admin.sales.service.AdminSalesService;
import com.main.nowflix.admin.sales.vo.AdminSalesVO;
import com.main.nowflix.admin.ticket.service.AdminTicketService;
import com.main.nowflix.admin.ticket.vo.AdminTicketVO;

@Controller
public class AdminAnalysisController {
	@Autowired
	private AdminMemberService memberService;
	@Autowired
	private AdminTicketService ticketService;
	@Autowired
	private AdminMovieService movieService;
	@Autowired
	private AdminGenreService genreService;
	@Autowired
	private AdminSalesService salesService;
	
	
	@RequestMapping("/manage_analysis_member.mdo")
	public String man_count(AdminMemberVO membervo, AdminAnalysis_Age_VO analysis_age_VO, Model model) {
		model.addAttribute("age_count", memberService.ageList(membervo,analysis_age_VO));
		return "manage_analysis_member";
	}

	
	@RequestMapping("manage_analysis_movie.mdo")
	public String movie_count(Model model, AdminMovieVO movievo, AdminAnalysis_Age_VO analysis_age_VO, AdminAnalysis_Director_count_VO adminAnalysis_Director_count_VO , AdminGenreVO genreVO) {
				
		//���⼭ �������� �����ʹ� �帣db�� �ִ� �̸��� ����Ʈ�� �޾ƿ�
		List setgenreNameList = genreService.genreNameList(genreVO);
		List<String> addgenreNameList = new ArrayList<String>();
		
		for(int i = 0; i < setgenreNameList.size(); i++) {
			AdminGenreVO copy_genreVO = (AdminGenreVO) setgenreNameList.get(i);
			
			if(!(copy_genreVO.getGenre_name() == null)){
				addgenreNameList.add(copy_genreVO.getGenre_name());
			}	
			
		}
	
		//���⼭ �������� �����ʹ� movie_db�� �ִ� �帣 (���Ե�)����Ʈ�� �޾ƿ� 
		List setmovieGenreList = movieService.movieList(movievo, analysis_age_VO);
		List<String> addMovieGenreList = new ArrayList<String>();
		
		for(int i = 0; i < setmovieGenreList.size(); i++) {
			AdminMovieVO copy_movieVO = (AdminMovieVO) setmovieGenreList.get(i);
				
			if(!(copy_movieVO.getGenre_name() == null)) {
				addMovieGenreList.add(copy_movieVO.getGenre_name());
			}
		}
			
		int addgenreNameListCount = addgenreNameList.size();
		int addMovieGenreListCount = addMovieGenreList.size();
		
		ArrayList<Integer> MovieGenreListCount = new ArrayList<Integer>();	
		
		for(int i = 0; i < addgenreNameListCount; i++) {
			int count = 0;
			for (int j = 0; j < addMovieGenreListCount; j++) {
				if(addMovieGenreList.get(j).contains(addgenreNameList.get(i))){
					count++;
				}
				
			}
			MovieGenreListCount.add(count);		
		}

		
		//������� ����Ʈ�� ���� ����.
		ArrayList<Integer> setMovieRating = new ArrayList<Integer>(); // ��ȭ �������� �������ִ� �����ø���Ʈ 
		List<String> setMovieReleaseDate = new ArrayList<String>(); // ��ȭ ������ �����Ͱ��� �����ϴ� ����Ʈ
		
		
		int movieRatingCountAll = 0;	//��ü ���� ī��Ʈ ���� ���� 
		int movieRatingCount12 = 0;	//12�� ���� ī��Ʈ ���� ���� 
		int movieRatingCount15 = 0;	//15�� ���� ī��Ʈ ���� ���� 
		int movieRatingCount19 = 0;	//19��  ���� ī��Ʈ ���� ���� 
		int movieAllCount = setmovieGenreList.size(); //setmovieGenreList.size ������ ��ȭ��ü ����Ʈ ������ ����.
		
		for (int i = 0; i < setmovieGenreList.size(); i++) {
			AdminMovieVO testVO = (AdminMovieVO) setmovieGenreList.get(i);
			
			//movie rating�� all�̶�� movieRatingCountAll ī��Ʈ�� ����.
			if (testVO.getMovie_rating().equals("All")) {
				movieRatingCountAll++;
			}
			
			//movie rating�� 12 �̶��  movieRatingCount12 ī��Ʈ�� ����.
			if (testVO.getMovie_rating().equals("12")) {
				movieRatingCount12++;
			}
			
			//movie rating�� 15�̶�� movieRatingCount15  ī��Ʈ�� ����.
			if (testVO.getMovie_rating().equals("15")) {
				movieRatingCount15++;
			}

			//movie rating�� 19�̶�� movieRatingCount19 ī��Ʈ�� ����.
			if (testVO.getMovie_rating().equals("19")) {
				movieRatingCount19++;
			}
			
			//movie release �����Ͱ� ���� �ƴ϶�� setMovieReleaseDate�� ����Ʈ�� �߰���.
			if(testVO.getMovie_release_date() != null) {
				setMovieReleaseDate.add(testVO.getMovie_release_date());
			}
		}
		
		//setMovieRating ����Ʈ���ٰ� ����(ī��Ʈ)���� ADD 
		setMovieRating.add((Integer) movieRatingCountAll); // INDEX[0]
		setMovieRating.add((Integer) movieRatingCount12); // INDEX[1]
		setMovieRating.add((Integer) movieRatingCount15); // INDEX[2]
		setMovieRating.add((Integer) movieRatingCount19); // INDEX[3]
		setMovieRating.add((Integer) movieAllCount); // INDEX[4]

	
		
		List<String> movieReleaseList = new ArrayList<String>(); //2000�⵵���� ���糯¥ ������ ����Ʈ�� ���� ����Ʈ ����
		List<Integer> movieReleaseRatingList = new ArrayList<Integer>(); //�⵵�� ī��Ʈ���� ������ ����Ʈ ����
		
		Calendar cal = Calendar.getInstance();	//CalendarŬ������  cal��ü ����
		int year = cal.get(Calendar.YEAR); //���� year�� ���� ��¥�� ����. ��)2021
		
		//<�󺧿� �������� �⵵�� ����Ʈ�� ���⿡ ����Ʈ�θ���� �۾�!>
		//�ݺ��� ���� i���� 2000�⵵���� ����
		//���糯¥ ���� �ݺ��� ����. ���� �� ī��Ʈ ++
		for(int i = 2000; i < year+1; i++) {
			String str = String.valueOf(i); //String str���ٰ� i�� ���� ����ȯ ������. 
			movieReleaseList.add(str); //����Ʈ���ٰ� str�� ���� add ����.
		}
		
		
		//1.�⵵�� ����Ʈ�� ����ִ� ����ŭ �ݺ� ����
		//2.movie���ִ� release������ ����Ʈ�� ù��° �� ���� ������ �ݺ�
		//3.���ǹ����� movie���ִ� release�� ������ j��°��. contains(����) �ǳ�? | �⵵�� ����Ʈ�� ?
		//4.������ �´´ٸ� counting�� ++ 
		//5.�������� movieReleaseRatingList.add (ó�� for���� ���������� ����Ʈ�� add����)
		for(int i = 0;  i < movieReleaseList.size(); i++) {
			int counting = 0;
			for(int j = 0; j < setMovieReleaseDate.size(); j++) {
				if(setMovieReleaseDate.get(j).contains(movieReleaseList.get(i))) {
					counting++;
				}
			}
			movieReleaseRatingList.add(counting);
		}
		
		// ���� �׷������� �帣 ��� �����͸� �������� ������ �������� �����͸� �־��ִ� ���.
		List<String> chartColorRandomGenre = new ArrayList<String>();
		for (int i = 0; i < addgenreNameList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomGenre.add(put);
		}

		// ���� �׷������� ����� ��� �����͸� �������� ������ �������� �����͸� �־��ִ� ���.
		List<String> chartColorRandomRelease = new ArrayList<String>();
		for (int i = 0; i < movieReleaseList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomRelease.add(put);
		}
		
		//�帣 �����ͺ��̽��� �ִ� �帣 �̸��� �������ִ� ����Ʈ ��.
		model.addAttribute("addgenreNameList" , addgenreNameList);
		
		//��ü ��ȭ�� ���Ե� �帣�� ������ �������ִ� ����Ʈ ��.
		model.addAttribute("MovieGenreListCount" , MovieGenreListCount);
		
		//���� ������ ��������.(�帣 ���)
		model.addAttribute("chart_color_random_genre" , chartColorRandomGenre); 
		
		//���� ������ ��������.(����� ���)
		model.addAttribute("chart_color_random_release" , chartColorRandomRelease); 
		
		//������� ����Ʈ ī��Ʈ���� ������ ����Ʈ.
		model.addAttribute("setMovieRating" , setMovieRating); 
		
		//��ȭ ������ �������� ����Ʈ�� ������ ����Ʈ
		model.addAttribute("movie_year_list" , movieReleaseList); 
		
		//��ȭ ������ �������� ī��Ʈ�� ������ ����Ʈ 
		model.addAttribute("movie_year_list_count" , movieReleaseRatingList); 
		
		
		return "manage_analysis_movie";
	}
	
	@RequestMapping("/manage_analysis_sale.mdo")
	public String test_sale(AdminSalesVO salesVO, AdminTicketVO ticketvo, Model model) throws ParseException {
		
		List setSalesList = salesService.SalesList(salesVO);
		List<String> salesSucessList = new ArrayList<String>();
		List<String> salesTicketidList = new ArrayList<String>();
		List<Date> salesPaymentList = new ArrayList<Date>();
		List<Date> salesExpiryList = new ArrayList<Date>();
		List<String> salesCardList = new ArrayList<String>();
		List<String> salesCardNameList = new ArrayList<String>();
		List<String> salesEmailList = new ArrayList<String>();
		
		
		for(int i = 0; i < setSalesList.size(); i++) {
			AdminSalesVO copy_salesVO = (AdminSalesVO) setSalesList.get(i);
			
			if((copy_salesVO.getSales_status().equals("SUCCESS"))){
				salesSucessList.add(copy_salesVO.getSales_status());
			}	
			
			if(copy_salesVO.getTicket_id() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesTicketidList.add(copy_salesVO.getTicket_id());
			}
			
			if(copy_salesVO.getPayment_date() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesPaymentList.add(copy_salesVO.getPayment_date());
			}
			
			if(copy_salesVO.getExpiry_date() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesExpiryList.add(copy_salesVO.getExpiry_date());
			}
			
			if(copy_salesVO.getPayment_method_type() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesCardList.add(copy_salesVO.getPayment_method_type());
			}
			
			if(copy_salesVO.getCard_name() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesCardNameList.add(copy_salesVO.getCard_name());
			}
			if(copy_salesVO.getEmail() != null && copy_salesVO.getSales_status().equals("SUCCESS")){
				salesEmailList.add(copy_salesVO.getEmail());
			}
		}
		
		System.out.println("����������Ʈ = " +salesSucessList);
		System.out.println("�̸��ϸ���Ʈ = " +salesEmailList);
		System.out.println("Ƽ�Ͼ��̵𸮽�Ʈ = " +salesTicketidList);
		System.out.println("�̿�ǰ����� = " +salesPaymentList);
		System.out.println("�̿�Ǹ����� = " +salesExpiryList);
		System.out.println("������ĸ���Ʈ = " +salesCardList);
		System.out.println("������ī���̸�����Ʈ = " +salesCardNameList);
		
		
		List setticketList = ticketService.getTicketList(ticketvo);
		List<String> ticketListid = new ArrayList<String>();
		List<Integer> ticketListprice = new ArrayList<Integer>();
		
		int totalMoney = 0;
		
		for(int i = 0; i < setticketList.size(); i ++) {
			AdminTicketVO copy_ticketVO = (AdminTicketVO) setticketList.get(i);
			
			if(!(copy_ticketVO.getTicket_id() == null)) {
				ticketListid.add(copy_ticketVO.getTicket_id());
			}
			
			if(!(copy_ticketVO.getTicket_price() == 0)) {
				ticketListprice.add((Integer)copy_ticketVO.getTicket_price());
			}
		}
		
		System.out.println("�̸� = " +ticketListid);
		System.out.println("���� = " +ticketListprice);
		
		for(int i = 0; i < ticketListid.size(); i++) {
			for(int j = 0; j < salesTicketidList.size(); j++) {
				if(salesTicketidList.get(j).contains(ticketListid.get(i))) {
					totalMoney = totalMoney + ticketListprice.get(i);
				}
			}
		}
		
		System.out.println("�� �ݾ� = " + totalMoney);
		List<String> ticketyearList = new ArrayList<String>(); 
		List<Integer> ticketyearCount = new ArrayList<Integer>();
		
		Calendar calnow = Calendar.getInstance();
		int yearnow = calnow.get(Calendar.YEAR);

		for(int i = 2010; i < yearnow+1; i++) {
			String strnow = String.valueOf(i);
			ticketyearList.add(strnow);
		}
		
//		for(int i = 2018; i < yearnow+1; i++) {
//			ticketyearCount.add((Integer)0);
//		}
		
		
		
//		for(int i = 0; i < ticketListid.size(); i++) {
//			for(int j = 0; j < salesTicketidList.size(); i++) {
//				if(salesTicketidList.get(j).contains(ticketyearList.get(index)))
//			}
//		}
		
		List getPaymentDataList = salesService.selectPaymentDataList(salesVO);
		List<Date> setPaymentDataList = new ArrayList<Date>();
		List<String> setPaymentTicketList = new ArrayList<String>();
		List<String> setPaymentemailList = new ArrayList<String>();
		
		int yearTotal = 0;
		for(int i = 0; i < getPaymentDataList.size(); i++) {
			AdminSalesVO copy_SalesVO = (AdminSalesVO) getPaymentDataList.get(i);
			
			if(copy_SalesVO.getPayment_date() != null && copy_SalesVO.getSales_status().equals("SUCCESS")){
				setPaymentDataList.add(copy_SalesVO.getPayment_date());
				setPaymentTicketList.add(copy_SalesVO.getTicket_id());
				setPaymentemailList.add(copy_SalesVO.getEmail());
			}		
		}
	

		
		System.out.println("������ �⵵"+setPaymentDataList);
		System.out.println("������ �⵵ Ƽ�� ��"+setPaymentTicketList);
		System.out.println("������ �⵵ �̸��� ��"+setPaymentemailList);
		Date selectYearStart = null;
		Date selectYearEnd = null;
		
		int setSize = setPaymentDataList.size();
//		System.out.println(setPaymentDataList.get(setSize - setSize + 1));
//		System.out.println(setPaymentDataList.get(setSize-1));
		
//		selectYearStart = setPaymentDataList.get(1);
//		selectYearEnd = setPaymentDataList.get(setPaymentDataList.size());
				
		for(int i = 0; i < setPaymentDataList.size(); i++) {
			if(setPaymentDataList.get(i) == setPaymentDataList.get(0)) {
				selectYearStart = setPaymentDataList.get(i);
			}
		}
		
		for(int i = 0;  i < ticketListid.size(); i++) {
			for(int j = 0; j < setPaymentTicketList.size(); j++) {
				if(setPaymentTicketList.get(j).contains(ticketListid.get(i)))
					yearTotal = yearTotal + ticketListprice.get(i);
			}
		}
		
		System.out.println("������ �⵵ �Ѿ� = " + yearTotal);
				
		if(salesVO.getDate1() != null) {
			selectYearStart = salesVO.getDate1();
		}
		if(salesVO.getDate2() != null) {
			selectYearEnd = salesVO.getDate2();
		}
		
		System.out.println(selectYearStart);
		System.out.println(selectYearEnd);
	
		String formatyearStart = null;
		String formatyearEnd = null;
		String yearStartEndAdd = null;
		
		if(selectYearStart != null && selectYearEnd != null) {
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			formatyearStart = dateformat.format(selectYearStart);
			formatyearEnd = dateformat.format(selectYearEnd);
			yearStartEndAdd = formatyearStart +   "~"   +  formatyearEnd;
		}
		
		System.out.println(yearStartEndAdd);
		
		List<String> testList = new ArrayList<String>();
		for(Date date : salesPaymentList) {
			String dateStr = String.valueOf(date);
			testList.add(dateStr);
		}
		
		for(int i = 0; i < ticketyearList.size(); i++) {
		int count = 0;
		for(int j = 0; j < testList.size(); j++) {
			if(testList.get(j).contains(ticketyearList.get(i))) {
				count++;	
			}			
		}
		ticketyearCount.add((Integer)count);
	}
		System.out.println("Ƽ�� ����Ʈ �� = " +  ticketyearList);
		System.out.println("�⵵�� ī��Ʈ�� = "+ticketyearCount);
		
		System.out.println("�׽�Ʈ����Ʈ = " + testList);
		
//		System.out.println(ticketyearList);
//		System.out.println(ticketyearCount);
		
		// �Ǹ� �׷������� ����� ��� �����͸� �������� ������ �������� �����͸� �־��ִ� ���.
		List<String> chartColorRandomsalse = new ArrayList<String>();
		for (int i = 0; i < ticketyearList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomsalse.add(put);
		}
//		System.out.println("������ �⵵"+setPaymentDataList);
//		System.out.println("������ �⵵ Ƽ�� ��"+setPaymentTicketList);
//		System.out.println("������ �⵵ �̸��� ��"+setPaymentemailList);


		
		model.addAttribute("totalMoney",totalMoney);
		model.addAttribute("yearTotal",yearTotal);
		model.addAttribute("yearStartEndAdd",yearStartEndAdd);
		model.addAttribute("ticketyearList",ticketyearList);
		model.addAttribute("ticketyearCount",ticketyearCount);
		model.addAttribute("chartColorRandomsalse",chartColorRandomsalse);
		
		model.addAttribute("setPaymentDataList",setPaymentDataList);
		model.addAttribute("setPaymentTicketList",setPaymentTicketList);
		model.addAttribute("setPaymentemailList",setPaymentemailList);
		
		model.addAttribute("salesEmailList",salesEmailList);
		model.addAttribute("salesTicketidList",salesTicketidList);
		model.addAttribute("salesPaymentList",salesPaymentList);
		
		return "manage_analysis_sale";
	}
}
