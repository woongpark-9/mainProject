package com.main.nowflix.admin.template;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.nowflix.admin.inquiry.service.AdminInquiryService;
import com.main.nowflix.admin.member.service.AdminMemberService;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.sales.service.AdminSalesService;


@Controller
public class AdminController {
	
	@Autowired
	private AdminInquiryService inquiryService;
	
	@Autowired
	private AdminMovieService movieService;
	
	@Autowired
	private AdminMemberService memberService;
	
	@Autowired
	private AdminSalesService salesService;
	
	// ���ø�(����) ������
	@RequestMapping("/manage_template.mdo")
	public String getTemplate(Model model,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
//			@RequestParam(value = "nowPage_mem", defaultValue = "0") int nowPage_mem,
//			@RequestParam(value = "nowPage_sal", defaultValue = "0") int nowPage_sal,
			@RequestParam(value = "nowPage", defaultValue = "0") int nowPage) {
		
		System.out.println("Get Template");	
		
		
		int row = 3;
		int startPoint = nowPage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		map.put("startPoint", startPoint);
		map.put("row", row);

		int totalList = movieService.getTotalCount(map);
		int totalPage = totalList / row - 1;
		int countPage = 3;
		int startPage = ((nowPage) / countPage) * countPage; // 1�� ������ ������ startPage = 0, 6�� ������ ������ startPage = 5
		int endPage = startPage + countPage - 1; // endPage = 4, endPage = 9

		if ((totalList % row) > 0) {
			totalPage++;
		};
		
		model.addAttribute("inquiryCount", inquiryService.getInquiryCount()); // inquiryCount ��������
		model.addAttribute("movieCount", movieService.getTotalCount(null)); // movieCount ��������
		model.addAttribute("memberCount", memberService.getTotalCount(null)); // memberCount ��������
		model.addAttribute("inquiryAllCount", inquiryService.getTotalCount(null)); // inquiryAllCount ��������
		
		model.addAttribute("memberList", memberService.getMemberList(map)); // memberList ��������		
		model.addAttribute("salesList", salesService.getSalesList(map)); // salesList ��������
		model.addAttribute("movieList", movieService.getMovieList(map)); // movieList ��������
		
		model.addAttribute("nowPage", nowPage); // nowPage ��������
		model.addAttribute("totalPage", totalPage); // totalPage ��������
		model.addAttribute("startPage", startPage); // startPage ��������
		model.addAttribute("endPage", endPage); // endPage ��������
		
		return "manage_template";
	}

	// Ƽ�� �߰� ������
	@RequestMapping("/ticket_insert.mdo")
	public String getTicket_insert() {

		return "ticket_insert";
	}

	@RequestMapping("/manage_analysis.mdo")
	public String getAnalysis() {

		return "manage_analysis";
	}

	@RequestMapping("/manage_cs.mdo")
	public String getCs() {

		return "manage_cs";
	}

//	@RequestMapping("/manage_sales.mdo")
//	public String getSales() {
//
//		return "manage_sales";
//	}

	@RequestMapping("/manage_screen.mdo")
	public String getScreen() {

		return "manage_screen";
	}

	@RequestMapping("/member_insert.mdo")
	public String getMemberInsert() {

		return "member_insert";
	}
}
