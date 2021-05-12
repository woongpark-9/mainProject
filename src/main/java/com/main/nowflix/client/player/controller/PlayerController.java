package com.main.nowflix.client.player.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.player.service.PlayerService;
import com.main.nowflix.client.watch.service.WatchService;
import com.main.nowflix.client.watch.vo.WatchVO;


@SessionAttributes("member")
@Controller
public class PlayerController {
	
	@Autowired
	private WatchService service;
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/getPlayer.do")
	public ModelAndView getPlayer(MovieVO movieVO, WatchVO vo, ModelAndView mav, int seq, int profile_id,HttpSession session,MemberVO member) throws Exception {
		vo.setMovie_id(seq);
		vo.setProfile_id(profile_id);
		member = (MemberVO)session.getAttribute("member");
		System.out.println("영화 플레이어로 이동 controller");
		mav.addObject("movie", playerService.getMovie(movieVO));
		mav.addObject("watch", service.getWatchVo(vo));
		session.setAttribute("member", member);
		mav.setViewName("views/player/player");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/saveTime.do")
	public String saveTime(WatchVO vo, Model model) throws Exception {
		service.updateWatch(vo);
		return " ";
	}
}
