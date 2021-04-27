package com.main.nowflix.client.kakao.pay.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.main.nowflix.client.kakao.pay.vo.AmountVO;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayApprovalVO;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayCancelVO;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayReadyVO;

@Service

public class KakaoPayServiceImpl implements KakaoPayService {
	
	
	// 호스트 url
    private static final String HOST = "https://kapi.kakao.com";
    // 결제 정보 vo 객체
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    // 결제 준비 vo 객체
    private KakaoPayReadyVO kakaoPayReadyVO;
    // 결제 취소 vo 객체
    private KakaoPayCancelVO kakaoPayCancelVO;
    // 최종 결제 금액
    private String total_amount;

    //결제준비 메서드
  
    @Override 
	public String kakaopayReady(String total_amount, String item_name,Model model, String partner_order_id,String partner_user_id) {
    	//restapi 호출후 응답받을 객체
        RestTemplate restTemplate = new RestTemplate();
    
        this.total_amount = total_amount;
        System.out.println("----kakaopayReady----");
        System.out.println(this.total_amount);
        System.out.println(item_name);
        System.out.println(partner_order_id);
        System.out.println(partner_user_id);
      
        kakaoPayApprovalVO = new KakaoPayApprovalVO();
        kakaoPayApprovalVO.setItem_name(item_name);
        kakaoPayApprovalVO.setPartner_order_id(partner_order_id);
        kakaoPayApprovalVO.setPartner_user_id(partner_user_id);
        
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "49a135ac006e06594458c5a0f4d65f1a");
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
    
        // 서버로 요청할 Body 사용자가 요청한 값 변수로 처리하면 될듯
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", partner_order_id);
        params.add("partner_user_id", partner_user_id);
        params.add("item_name", item_name);
        params.add("quantity", "1");
        params.add("total_amount", total_amount);
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8080/nowflix/kakaoPaySuccess.do");
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel.do");
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail.do");
      
        
        //바디와 헤더 합치기
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
         	//포스트 방식으로 보내기 uri + 데이터 + 응답받을형식
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
           
      
          
            
            return  kakaoPayReadyVO.getNext_redirect_pc_url();
            
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay.do";
        
    }
    
    //결제 승인 후 정보리턴 메서드
    @Override
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token,HttpSession session) {
    	 
    	KakaoPayReadyVO vo = (KakaoPayReadyVO) session.getAttribute("kakaoPayReadyVO");
    	
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "49a135ac006e06594458c5a0f4d65f1a");
        
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        System.out.println("----kakaoPayInfo----");
        System.out.println(kakaoPayApprovalVO.getPartner_order_id());
        System.out.println(kakaoPayApprovalVO.getPartner_user_id());
        System.out.println(total_amount);
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id",kakaoPayApprovalVO.getPartner_order_id() );
        params.add("partner_user_id", kakaoPayApprovalVO.getPartner_user_id());
        params.add("pg_token", pg_token);
        params.add("total_amount", total_amount);
      
      
        System.out.println("1tid : "+kakaoPayReadyVO.getTid());
        // 헤더와 바디 합치기
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        // 포스트 방식으로 요청
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
        
          
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public KakaoPayCancelVO kakaoPayCancle() {
    	  RestTemplate restTemplate = new RestTemplate();
    	  
          // 서버로 요청할 Header
          HttpHeaders headers = new HttpHeaders();
          headers.add("Authorization", "KakaoAK " + "49a135ac006e06594458c5a0f4d65f1a");
          
          headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

       // 서버로 요청할 Body
          MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
          params.add("cid", "TC0ONETIME");
          params.add("tid", "T2888909039385480257");
          params.add("cancel_amount", "2200");
          params.add("cancel_tax_free_amount", "0");

     
          
          System.out.println("2tid : T2886904041277538608");
          
          // 헤더와 바디 합치기
          HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
          
        
        	  try {
				kakaoPayCancelVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/cancel"), body, KakaoPayCancelVO.class);
			} catch (RestClientException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  
        	  return kakaoPayCancelVO;
          
    
    
    
    }
    
}
    
