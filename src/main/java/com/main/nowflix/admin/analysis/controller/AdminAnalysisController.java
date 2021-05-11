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
				
		//여기서 가져오는 데이터는 장르db에 있는 이름을 리스트로 받아옴
		List setgenreNameList = genreService.genreNameList(genreVO);
		List<String> addgenreNameList = new ArrayList<String>();
		
		for(int i = 0; i < setgenreNameList.size(); i++) {
			AdminGenreVO copy_genreVO = (AdminGenreVO) setgenreNameList.get(i);
			
			if(!(copy_genreVO.getGenre_name() == null)){
				addgenreNameList.add(copy_genreVO.getGenre_name());
			}	
			
		}
	
		//여기서 가져오는 데이터는 movie_db에 있는 장르 (포함된)리스트를 받아옴 
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

		
		//관람등급 리스트를 만들어서 조정.
		ArrayList<Integer> setMovieRating = new ArrayList<Integer>(); // 영화 레이팅을 가지고있는 레이팅리스트 
		List<String> setMovieReleaseDate = new ArrayList<String>(); // 영화 릴리스 데이터값만 저장하는 리스트
		
		
		int movieRatingCountAll = 0;	//전체 관람 카운트 저장 변수 
		int movieRatingCount12 = 0;	//12세 관람 카운트 저장 변수 
		int movieRatingCount15 = 0;	//15세 관람 카운트 저장 변수 
		int movieRatingCount19 = 0;	//19세  관람 카운트 저장 변수 
		int movieAllCount = setmovieGenreList.size(); //setmovieGenreList.size 값으로 영화전체 리스트 갯수를 가짐.
		
		for (int i = 0; i < setmovieGenreList.size(); i++) {
			AdminMovieVO testVO = (AdminMovieVO) setmovieGenreList.get(i);
			
			//movie rating이 all이라면 movieRatingCountAll 카운트값 증가.
			if (testVO.getMovie_rating().equals("All")) {
				movieRatingCountAll++;
			}
			
			//movie rating이 12 이라면  movieRatingCount12 카운트값 증가.
			if (testVO.getMovie_rating().equals("12")) {
				movieRatingCount12++;
			}
			
			//movie rating이 15이라면 movieRatingCount15  카운트값 증가.
			if (testVO.getMovie_rating().equals("15")) {
				movieRatingCount15++;
			}

			//movie rating이 19이라면 movieRatingCount19 카운트값 증가.
			if (testVO.getMovie_rating().equals("19")) {
				movieRatingCount19++;
			}
			
			//movie release 데이터가 널이 아니라면 setMovieReleaseDate에 리스트를 추가함.
			if(testVO.getMovie_release_date() != null) {
				setMovieReleaseDate.add(testVO.getMovie_release_date());
			}
		}
		
		//setMovieRating 리스트에다가 변수(카운트)값을 ADD 
		setMovieRating.add((Integer) movieRatingCountAll); // INDEX[0]
		setMovieRating.add((Integer) movieRatingCount12); // INDEX[1]
		setMovieRating.add((Integer) movieRatingCount15); // INDEX[2]
		setMovieRating.add((Integer) movieRatingCount19); // INDEX[3]
		setMovieRating.add((Integer) movieAllCount); // INDEX[4]

	
		
		List<String> movieReleaseList = new ArrayList<String>(); //2000년도부터 현재날짜 까지의 리스트를 받을 리스트 변수
		List<Integer> movieReleaseRatingList = new ArrayList<Integer>(); //년도별 카운트값을 가지는 리스트 변수
		
		Calendar cal = Calendar.getInstance();	//Calendar클래스에  cal객체 생성
		int year = cal.get(Calendar.YEAR); //변수 year에 오늘 날짜를 저장. 예)2021
		
		//<라벨에 쓰기위한 년도별 리스트가 없기에 리스트로만드는 작업!>
		//반복문 실행 i값을 2000년도부터 시작
		//현재날짜 까지 반복문 실행. 증가 값 카운트 ++
		for(int i = 2000; i < year+1; i++) {
			String str = String.valueOf(i); //String str에다가 i의 값을 형변환 시켜줌. 
			movieReleaseList.add(str); //리스트에다가 str의 값을 add 해줌.
		}
		
		
		//1.년도별 리스트가 들어있는 값만큼 반복 시작
		//2.movie에있는 release데이터 리스트의 첫번째 값 부터 끝가지 반복
		//3.조건문으로 movie에있는 release의 데이터 j번째에. contains(포함) 되냐? | 년도별 리스트에 ?
		//4.조건이 맞는다면 counting을 ++ 
		//5.마지막에 movieReleaseRatingList.add (처음 for문이 끝날때마다 리스트에 add해줌)
		for(int i = 0;  i < movieReleaseList.size(); i++) {
			int counting = 0;
			for(int j = 0; j < setMovieReleaseDate.size(); j++) {
				if(setMovieReleaseDate.get(j).contains(movieReleaseList.get(i))) {
					counting++;
				}
			}
			movieReleaseRatingList.add(counting);
		}
		
		// 무비 그래프에서 장르 통계 데이터를 동적으로 색깔을 랜덤으로 데이터를 넣어주는 기능.
		List<String> chartColorRandomGenre = new ArrayList<String>();
		for (int i = 0; i < addgenreNameList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomGenre.add(put);
		}

		// 무비 그래프에서 출시일 통계 데이터를 동적으로 색깔을 랜덤으로 데이터를 넣어주는 기능.
		List<String> chartColorRandomRelease = new ArrayList<String>();
		for (int i = 0; i < movieReleaseList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomRelease.add(put);
		}
		
		//장르 데이터베이스에 있는 장르 이름을 가지고있는 리스트 값.
		model.addAttribute("addgenreNameList" , addgenreNameList);
		
		//전체 영화에 포함된 장르의 갯수를 가지고있는 리스트 값.
		model.addAttribute("MovieGenreListCount" , MovieGenreListCount);
		
		//랜덤 색깔을 리턴해줌.(장르 통계)
		model.addAttribute("chart_color_random_genre" , chartColorRandomGenre); 
		
		//랜덤 색깔을 리턴해줌.(출시일 통계)
		model.addAttribute("chart_color_random_release" , chartColorRandomRelease); 
		
		//관람등급 리스트 카운트값을 가지는 리스트.
		model.addAttribute("setMovieRating" , setMovieRating); 
		
		//영화 릴리스 데이터의 리스트를 가지는 리스트
		model.addAttribute("movie_year_list" , movieReleaseList); 
		
		//양화 릴리스 데이터의 카운트를 가지는 리스트 
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
		
		System.out.println("석세스리스트 = " +salesSucessList);
		System.out.println("이메일리스트 = " +salesEmailList);
		System.out.println("티켓아이디리스트 = " +salesTicketidList);
		System.out.println("이용권결제일 = " +salesPaymentList);
		System.out.println("이용권만료일 = " +salesExpiryList);
		System.out.println("결제방식리스트 = " +salesCardList);
		System.out.println("결제한카드이름리스트 = " +salesCardNameList);
		
		
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
		
		System.out.println("이름 = " +ticketListid);
		System.out.println("가격 = " +ticketListprice);
		
		for(int i = 0; i < ticketListid.size(); i++) {
			for(int j = 0; j < salesTicketidList.size(); j++) {
				if(salesTicketidList.get(j).contains(ticketListid.get(i))) {
					totalMoney = totalMoney + ticketListprice.get(i);
				}
			}
		}
		
		System.out.println("총 금액 = " + totalMoney);
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
	

		
		System.out.println("지정한 년도"+setPaymentDataList);
		System.out.println("지정한 년도 티켓 값"+setPaymentTicketList);
		System.out.println("지정한 년도 이메일 값"+setPaymentemailList);
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
		
		System.out.println("지정한 년도 총액 = " + yearTotal);
				
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
		System.out.println("티켓 리스트 값 = " +  ticketyearList);
		System.out.println("년도별 카운트값 = "+ticketyearCount);
		
		System.out.println("테스트리스트 = " + testList);
		
//		System.out.println(ticketyearList);
//		System.out.println(ticketyearCount);
		
		// 판매 그래프에서 출시일 통계 데이터를 동적으로 색깔을 랜덤으로 데이터를 넣어주는 기능.
		List<String> chartColorRandomsalse = new ArrayList<String>();
		for (int i = 0; i < ticketyearList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomsalse.add(put);
		}
//		System.out.println("지정한 년도"+setPaymentDataList);
//		System.out.println("지정한 년도 티켓 값"+setPaymentTicketList);
//		System.out.println("지정한 년도 이메일 값"+setPaymentemailList);


		
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
