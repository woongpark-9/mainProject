<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nowflix</title>

<link type="text/css" rel="stylesheet" href="css/member/reset.css">
<link type="text/css" rel="stylesheet" href="css/member/memberLogin.css">
<script>

//유효성 검사 메서드
function checkAll() {
	if(!checkEmail()){
		return false;
	}else if(!checkPassword(form.email.value,form.pass.value)){
		return false;
	}
	return true;
}
//공백확인 메서드
function checkExistData(value, dataName) {
    if (value == "") {
        alert(dataName + " 입력해주세요!");
        return false;
    }
    return true;
}


function checkEmail(){
	
	if(document.getElementById("email").value.length <= 0){
		alert("이메일을 입력해주세요!");
		return false;
	}
	return true;
}
function checkPassword(email,pass){
	//비밀번호가 입력되었는지 확인하기
	if(!checkExistData(pass,"비밀번호를")){
		return false;
	}else if(document.getElementById("pass").value.length <=0){
		alert("비밀번호를 입력해주세요!");
		return false;
	}
	return true;
}







</script>
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
	<form name="form" action="login.do" method="post" onsubmit="return checkAll()" >
		<div class="center_login_id">
			<div class="center_login_id_label">
				<label for="id" class="id_label">이메일</label><br>	
			</div>
			<input class="email" id="email" type="text" size="20" value="" name="email">
		</div>
		
		<div class="center_login_pw">
			<div class="center_login_pw_label">
				<label for="pw">비밀번호 </label><br>	
			</div>
			<input id="pass" type="password" size="20" value="" name="pass">
		</div>
		
		<div class="center_login_button">
			<input type="submit" value="로그인"/>
		</div>
		
		<div class="center_login_info_check">
			<input type="checkbox" 
			name="login_info_check" /> 
			<p>로그인 정보 저장</p> 
			<div class="find_password">
				<a href="#">비밀번호 찾기</a>
			</div>
		</div>
		
		

		<ul class="list">
			<li class="naver">
			<a href ="${naver_url }"><span>네이버 로그인</span></a>
			</li>
			<li class="kakao">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=6282ec2ffbb4c314d17b7d5478824418&redirect_uri=http://ec2-3-141-23-230.us-east-2.compute.amazonaws.com/nowflix/kakaoController.do&response_type=code"><span>카카오 로그인</span></a>
			</li>
		</ul>
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