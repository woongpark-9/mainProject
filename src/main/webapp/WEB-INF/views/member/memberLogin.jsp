<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="http://yonom.duckdns.org/css/member/reset.css">
<link type="text/css" rel="stylesheet" href="css/member/memberLogin.css">
</head>
<body>
<div class="root" style="background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url(http://yonom.duckdns.org/images/member/backcopy.jpg)"> 
	
		<div class="header">
				 <a><img class="logo" src="http://yonom.duckdns.org/images/member/LOGO.png"></a>
				 </div>
	<div class="center_porm" style="margin: 10px auto 50px;">
		<div class="center_login_text_div">
			<p>로그인<p>
		</div>
		<form action="login.do" method="post" >
		<div class="center_login_id">
			<div class="center_login_id_label">
				<label for="id">이메일 주소 또는 전화번호 </label><br>	
			</div>
			<input type="text" size="20" value="" name="email">
		</div>
		
		<div class="center_login_pw">
			<div class="center_login_pw_label">
				<label for="pw">비밀번호 </label><br>	
			</div>
			<input type="password" size="20" value="" name="pass">
		</div>
		
		<div class="center_login_button">
			<input type="submit" value="로그인"/>
		</div>
		
		<div class="center_login_info_check">
			<input type="checkbox" 
			name="login_info_check" /> 
			<p>로그인 정보 저장</p> 
			<div>
				<a href="#">비밀번호 찾기</a>
			</div>
		</div>
		
		
		
		<div class="center_login_button_naver">
			<a href ="${naver_url }"><img src="http://yonom.duckdns.org/images/member/naverLogin.PNG" alt="네이버로그인" style="width:314px;  height:58px; margin-left: 70px; margin-bottom: 10px;" ></a>
		</div>
		
		<div class="center_login_button_kakao">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=6282ec2ffbb4c314d17b7d5478824418
&redirect_uri=http://localhost:8080/nowflix/kakaoController.do
&response_type=code"><img src="http://yonom.duckdns.org/images/member/kakao_login_large_narrow.png" style="width:314px; height:64px; margin-left: 70px; margin-bottom: 10px;"></a>
		</div>
		</form>
		
		<div class="center_new_member_go">
			<p>Nowflix 회원이 아닌가요? <a href="index.jsp">지금 가입하세요</a></p>
		</div>
		<div>
		
		</div>
	
	</div>
	
	<div class="bottom_porm">
		<div>
			<p class="quition">
			질문이 있으신가요? 문의 전화: 00-308-321-0058
			</p>
		</div>
		
		<div class="login_page_info">
			<ul>
				<li>자주 묻는 질문</li>
				<li>고객 센터</li>
				<li>이용 약관</li>
				<li>개인정보</li>
				<li>쿠키 설정</li>
				<li>회사 정보</li>
			</ul>
		</div>

		<div class="login_language_select">
			<select>
				<option>ⓚ 한국어</option>
				<option>ⓔ English</option>
			</select>
		</div>
		
		<div class="login_netfilx_info">
			<ul>
				<li>나우플릭스서비시스코리아 유한회사 통신판매업신고번호:제2018-서울종로-0426호
					전화번호:00-308-321-0058</li>
				<li>대표: 영웅</li>
				<li>이메일 주소: kg@itbank.com</li>
				<li>주소: 대한민국 서울특별시 종로구 아이티뱅크</li>
				<li>클라우드 호스팅: Amazon Web Services Inc.</li>
				<a
					href="http://www.ftc.go.kr/www/bizCommView.do?key=232&amp;apv_perm_no=2018300016930200431&amp;pageUnit=10&amp;
									searchCnd=bup_nm&amp;searchKrwd=%EB%84%B7%ED%94%8C%EB%A6%AD%EC%8A%A4&amp;pageIndex=1">공정거래위원회웹사이트
						링크 </a>
			</ul>
		</div>
		
	</div>
	</div>
</body>
</html>