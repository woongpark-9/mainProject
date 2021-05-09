package com.main.nowflix.admin.analysis.controller;

import java.sql.Date;
import java.text.DateFormat;
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
	public String movie_count(Model model, AdminMovieVO movievo, AdminAnalysis_Age_VO analysis_age_VO, AdminGenreVO genreVO) {
				
		//�뿬湲곗꽌 媛��졇�삤�뒗 �뜲�씠�꽣�뒗 �옣瑜큕b�뿉 �엳�뒗 �씠由꾩쓣 由ъ뒪�듃濡� 諛쏆븘�샂
		List setgenreNameList = genreService.genreNameList(genreVO);
		List<String> addgenreNameList = new ArrayList<String>();
		
		for(int i = 0; i < setgenreNameList.size(); i++) {
			AdminGenreVO copy_genreVO = (AdminGenreVO) setgenreNameList.get(i);
			
			if(!(copy_genreVO.getGenre_name() == null)){
				addgenreNameList.add(copy_genreVO.getGenre_name());
			}	
			
		}
	
		//�뿬湲곗꽌 媛��졇�삤�뒗 �뜲�씠�꽣�뒗 movie_db�뿉 �엳�뒗 �옣瑜� (�룷�븿�맂)由ъ뒪�듃瑜� 諛쏆븘�샂 
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

		
		//愿��엺�벑湲� 由ъ뒪�듃瑜� 留뚮뱾�뼱�꽌 議곗젙.
		ArrayList<Integer> setMovieRating = new ArrayList<Integer>(); // �쁺�솕 �젅�씠�똿�쓣 媛�吏�怨좎엳�뒗 �젅�씠�똿由ъ뒪�듃 
		List<String> setMovieReleaseDate = new ArrayList<String>(); // �쁺�솕 由대━�뒪 �뜲�씠�꽣媛믩쭔 ���옣�븯�뒗 由ъ뒪�듃
		
		
		int movieRatingCountAll = 0;	//�쟾泥� 愿��엺 移댁슫�듃 ���옣 蹂��닔 
		int movieRatingCount12 = 0;	//12�꽭 愿��엺 移댁슫�듃 ���옣 蹂��닔 
		int movieRatingCount15 = 0;	//15�꽭 愿��엺 移댁슫�듃 ���옣 蹂��닔 
		int movieRatingCount19 = 0;	//19�꽭  愿��엺 移댁슫�듃 ���옣 蹂��닔 
		int movieAllCount = setmovieGenreList.size(); //setmovieGenreList.size 媛믪쑝濡� �쁺�솕�쟾泥� 由ъ뒪�듃 媛��닔瑜� 媛�吏�.
		
		for (int i = 0; i < setmovieGenreList.size(); i++) {
			AdminMovieVO testVO = (AdminMovieVO) setmovieGenreList.get(i);
			
			//movie rating�씠 all�씠�씪硫� movieRatingCountAll 移댁슫�듃媛� 利앷�.
			if (testVO.getMovie_rating().equals("All")) {
				movieRatingCountAll++;
			}
			
			//movie rating�씠 12 �씠�씪硫�  movieRatingCount12 移댁슫�듃媛� 利앷�.
			if (testVO.getMovie_rating().equals("12")) {
				movieRatingCount12++;
			}
			
			//movie rating�씠 15�씠�씪硫� movieRatingCount15  移댁슫�듃媛� 利앷�.
			if (testVO.getMovie_rating().equals("15")) {
				movieRatingCount15++;
			}

			//movie rating�씠 19�씠�씪硫� movieRatingCount19 移댁슫�듃媛� 利앷�.
			if (testVO.getMovie_rating().equals("19")) {
				movieRatingCount19++;
			}
			
			//movie release �뜲�씠�꽣媛� �꼸�씠 �븘�땲�씪硫� setMovieReleaseDate�뿉 由ъ뒪�듃瑜� 異붽��븿.
			if(testVO.getMovie_release_date() != null) {
				setMovieReleaseDate.add(testVO.getMovie_release_date());
			}
		}
		
		//setMovieRating 由ъ뒪�듃�뿉�떎媛� 蹂��닔(移댁슫�듃)媛믪쓣 ADD 
		setMovieRating.add((Integer) movieRatingCountAll); // INDEX[0]
		setMovieRating.add((Integer) movieRatingCount12); // INDEX[1]
		setMovieRating.add((Integer) movieRatingCount15); // INDEX[2]
		setMovieRating.add((Integer) movieRatingCount19); // INDEX[3]
		setMovieRating.add((Integer) movieAllCount); // INDEX[4]

	
		
		List<String> movieReleaseList = new ArrayList<String>(); //2000�뀈�룄遺��꽣 �쁽�옱�궇吏� 源뚯��쓽 由ъ뒪�듃瑜� 諛쏆쓣 由ъ뒪�듃 蹂��닔
		List<Integer> movieReleaseRatingList = new ArrayList<Integer>(); //�뀈�룄蹂� 移댁슫�듃媛믪쓣 媛�吏��뒗 由ъ뒪�듃 蹂��닔
		
		Calendar cal = Calendar.getInstance();	//Calendar�겢�옒�뒪�뿉  cal媛앹껜 �깮�꽦
		int year = cal.get(Calendar.YEAR); //蹂��닔 year�뿉 �삤�뒛 �궇吏쒕�� ���옣. �삁)2021
		
		//<�씪踰⑥뿉 �벐湲곗쐞�븳 �뀈�룄蹂� 由ъ뒪�듃媛� �뾾湲곗뿉 由ъ뒪�듃濡쒕쭔�뱶�뒗 �옉�뾽!>
		//諛섎났臾� �떎�뻾 i媛믪쓣 2000�뀈�룄遺��꽣 �떆�옉
		//�쁽�옱�궇吏� 源뚯� 諛섎났臾� �떎�뻾. 利앷� 媛� 移댁슫�듃 ++
		for(int i = 2000; i < year+1; i++) {
			String str = String.valueOf(i); //String str�뿉�떎媛� i�쓽 媛믪쓣 �삎蹂��솚 �떆耳쒖쨲. 
			movieReleaseList.add(str); //由ъ뒪�듃�뿉�떎媛� str�쓽 媛믪쓣 add �빐以�.
		}
		
		
		//1.�뀈�룄蹂� 由ъ뒪�듃媛� �뱾�뼱�엳�뒗 媛믩쭔�겮 諛섎났 �떆�옉
		//2.movie�뿉�엳�뒗 release�뜲�씠�꽣 由ъ뒪�듃�쓽 泥ル쾲吏� 媛� 遺��꽣 �걹媛�吏� 諛섎났
		//3.議곌굔臾몄쑝濡� movie�뿉�엳�뒗 release�쓽 �뜲�씠�꽣 j踰덉㎏�뿉. contains(�룷�븿) �릺�깘? | �뀈�룄蹂� 由ъ뒪�듃�뿉 ?
		//4.議곌굔�씠 留욌뒗�떎硫� counting�쓣 ++ 
		//5.留덉�留됱뿉 movieReleaseRatingList.add (泥섏쓬 for臾몄씠 �걹�궇�븣留덈떎 由ъ뒪�듃�뿉 add�빐以�)
		for(int i = 0;  i < movieReleaseList.size(); i++) {
			int counting = 0;
			for(int j = 0; j < setMovieReleaseDate.size(); j++) {
				if(setMovieReleaseDate.get(j).contains(movieReleaseList.get(i))) {
					counting++;
				}
			}
			movieReleaseRatingList.add(counting);
		}
		
		// 臾대퉬 洹몃옒�봽�뿉�꽌 �옣瑜� �넻怨� �뜲�씠�꽣瑜� �룞�쟻�쑝濡� �깋源붿쓣 �옖�뜡�쑝濡� �뜲�씠�꽣瑜� �꽔�뼱二쇰뒗 湲곕뒫.
		List<String> chartColorRandomGenre = new ArrayList<String>();
		for (int i = 0; i < addgenreNameList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomGenre.add(put);
		}

		// 臾대퉬 洹몃옒�봽�뿉�꽌 異쒖떆�씪 �넻怨� �뜲�씠�꽣瑜� �룞�쟻�쑝濡� �깋源붿쓣 �옖�뜡�쑝濡� �뜲�씠�꽣瑜� �꽔�뼱二쇰뒗 湲곕뒫.
		List<String> chartColorRandomRelease = new ArrayList<String>();
		for (int i = 0; i < movieReleaseList.size(); i++) {
			int r = (int) Math.floor(Math.random() * 255);
			int g = (int) Math.floor(Math.random() * 255);
			int b = (int) Math.floor(Math.random() * 255);
			String put = "rgba(" + r + "," + g + "," + b + ",0.3)";
			chartColorRandomRelease.add(put);
		}
		
		//�옣瑜� �뜲�씠�꽣踰좎씠�뒪�뿉 �엳�뒗 �옣瑜� �씠由꾩쓣 媛�吏�怨좎엳�뒗 由ъ뒪�듃 媛�.
		model.addAttribute("addgenreNameList" , addgenreNameList);
		
		//�쟾泥� �쁺�솕�뿉 �룷�븿�맂 �옣瑜댁쓽 媛��닔瑜� 媛�吏�怨좎엳�뒗 由ъ뒪�듃 媛�.
		model.addAttribute("MovieGenreListCount" , MovieGenreListCount);
		
		//�옖�뜡 �깋源붿쓣 由ы꽩�빐以�.(�옣瑜� �넻怨�)
		model.addAttribute("chart_color_random_genre" , chartColorRandomGenre); 
		
		//�옖�뜡 �깋源붿쓣 由ы꽩�빐以�.(異쒖떆�씪 �넻怨�)
		model.addAttribute("chart_color_random_release" , chartColorRandomRelease); 
		
		//愿��엺�벑湲� 由ъ뒪�듃 移댁슫�듃媛믪쓣 媛�吏��뒗 由ъ뒪�듃.
		model.addAttribute("setMovieRating" , setMovieRating); 
		
		//�쁺�솕 由대━�뒪 �뜲�씠�꽣�쓽 由ъ뒪�듃瑜� 媛�吏��뒗 由ъ뒪�듃
		model.addAttribute("movie_year_list" , movieReleaseList); 
		
		//�뼇�솕 由대━�뒪 �뜲�씠�꽣�쓽 移댁슫�듃瑜� 媛�吏��뒗 由ъ뒪�듃 
		model.addAttribute("movie_year_list_count" , movieReleaseRatingList); 
		
		
		return "manage_analysis_movie";
	}
	
	@RequestMapping("/manage_analysis_sale.mdo")
	public String test_sale(AdminSalesVO salesVO, AdminTicketVO ticketvo, Model model) {
		
		List setSalesList = salesService.SalesList(salesVO);
		List<String> salesSucessList = new ArrayList<String>();
		List<String> salesTicketidList = new ArrayList<String>();
		List<Date> salesPaymentList = new ArrayList<Date>();
		List<Date> salesExpiryList = new ArrayList<Date>();
		List<String> salesCardList = new ArrayList<String>();
		List<String> salesCardNameList = new ArrayList<String>();
		
		for(int i = 0; i < setSalesList.size(); i++) {
			AdminSalesVO copy_salesVO = (AdminSalesVO) setSalesList.get(i);
			
			if(!(copy_salesVO.getSales_status() == null)){
				salesSucessList.add(copy_salesVO.getSales_status());
			}	
			
			if(!(copy_salesVO.getTicket_id() == null)){
				salesTicketidList.add(copy_salesVO.getTicket_id());
			}
			
			if(!(copy_salesVO.getPayment_date() == null)){
				salesPaymentList.add(copy_salesVO.getPayment_date());
			}
			
			if(!(copy_salesVO.getExpiry_date() == null)){
				salesExpiryList.add(copy_salesVO.getExpiry_date());
			}
			
			if(!(copy_salesVO.getPayment_method_type() == null)){
				salesCardList.add(copy_salesVO.getPayment_method_type());
			}
			
			if(!(copy_salesVO.getCard_name() == null)){
				salesCardNameList.add(copy_salesVO.getCard_name());
			}
		}
		
		System.out.println("�꽍�꽭�뒪由ъ뒪�듃 = " +salesSucessList);
		System.out.println("�떚耳볦븘�씠�뵒由ъ뒪�듃 = " +salesTicketidList);
		System.out.println("�씠�슜沅뚭껐�젣�씪 = " +salesPaymentList);
		System.out.println("�씠�슜沅뚮쭔猷뚯씪 = " +salesExpiryList);
		System.out.println("寃곗젣諛⑹떇由ъ뒪�듃 = " +salesCardList);
		System.out.println("寃곗젣�븳移대뱶�씠由꾨━�뒪�듃 = " +salesCardNameList);
		
		
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
		
		System.out.println("�씠由� = " +ticketListid);
		System.out.println("媛�寃� = " +ticketListprice);
		
		for(int i = 0; i < ticketListid.size(); i++) {
			for(int j = 0; j < salesTicketidList.size(); j++) {
				if(salesTicketidList.get(j).contains(ticketListid.get(i))) {
					totalMoney = totalMoney + ticketListprice.get(i);
				}
			}
		}
		
		System.out.println("珥� 湲덉븸 = " + totalMoney);
		List<String> ticketyearList = new ArrayList<String>(); 
		
		Calendar calnow = Calendar.getInstance();
		int yearnow = calnow.get(Calendar.YEAR);
		for(int i = 2018; i < yearnow+1; i++) {
			String strnow = String.valueOf(i);
			ticketyearList.add(strnow);
		}
		
		System.out.println(ticketyearList);
		
//		for(int i = 0; i < ticketListid.size(); i++) {
//			for(int j = 0; j < salesTicketidList.size(); i++) {
//				if(salesTicketidList.get(j).contains(ticketyearList.get(index)))
//			}
//		}
		
		List getPaymentDataList = salesService.selectPaymentDataList(salesVO);
		List<Date> setPaymentDataList = new ArrayList<Date>();
		List<String> setPaymentTicketList = new ArrayList<String>();
		
		int yearTotal = 0;
		for(int i = 0; i < getPaymentDataList.size(); i++) {
			AdminSalesVO copy_SalesVO = (AdminSalesVO) getPaymentDataList.get(i);
			
			if(!(copy_SalesVO.getPayment_date() == null)){
				setPaymentDataList.add(copy_SalesVO.getPayment_date());
				setPaymentTicketList.add(copy_SalesVO.getTicket_id());
			}		
		}
	

		
		System.out.println("吏��젙�븳 �뀈�룄"+setPaymentDataList);
		System.out.println("吏��젙�븳 �뀈�룄 �떚耳� 媛�"+setPaymentTicketList);
		Date selectYearStart;
		Date selectYearEnd;
		
		int setSize = setPaymentDataList.size();
//		System.out.println(setPaymentDataList.get(setSize - setSize + 1));
//		System.out.println(setPaymentDataList.get(setSize-1));
		
//		selectYearStart = setPaymentDataList.get(1);
//		selectYearEnd = setPaymentDataList.get(setPaymentDataList.size());
				

		
		for(int i = 0;  i < ticketListid.size(); i++) {
			for(int j = 0; j < setPaymentTicketList.size(); j++) {
				if(setPaymentTicketList.get(j).contains(ticketListid.get(i)))
					yearTotal = yearTotal + ticketListprice.get(i);
			}
		}
		
		System.out.println("吏��젙�븳 �뀈�룄 珥앹븸 = " + yearTotal);
//		System.out.println(selectYearStart);
//		System.out.println(selectYearEnd);
		
		model.addAttribute("totalMoney",totalMoney);
		model.addAttribute("yearTotal",yearTotal);
		return "manage_analysis_sale";
	}
}
