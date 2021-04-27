package com.main.nowflix.client.kakao.pay.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.main.nowflix.client.kakao.pay.vo.KakaoPayApprovalVO;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayCancelVO;

public interface KakaoPayService {
	public String kakaopayReady(String total_amount, String item_name,Model model , String partner_order_id,String partner_user_id);
	 public KakaoPayApprovalVO kakaoPayInfo(String pg_token,HttpSession session);
	 public KakaoPayCancelVO kakaoPayCancle();
	 
}
 