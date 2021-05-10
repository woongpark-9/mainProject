<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link type="text/css" rel="stylesheet" href="http://yonom.duckdns.org/css/member/reset.css">
<link type="text/css" rel="stylesheet" href="css/admin/adminLogin.css">
</head>
<body>
<div class="root" style="background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url(http://yonom.duckdns.org/images/member/backcopy.jpg)"> 
	
		<div class="header">
				 <a><img class="logo" src="http://yonom.duckdns.org/images/member/LOGO.png"></a>
				 </div>
	<div class="center_porm" style="margin: 10px auto 50px;">
		<div class="center_login_text_div">
			<p>관리자 로그인<p>
		</div>
		<form action="adminLoginCheck.mdo" method="post" >
			<div class="center_login_id">
				<div class="center_login_id_label">
					<label for="id">이메일 주소</label><br>	
				</div>
				<input type="text" size="20" name="manager_email">
			</div>
			
			<div class="center_login_pw">
				<div class="center_login_pw_label">
					<label for="pw">비밀번호 </label><br>	
				</div>
				<input type="password" size="20" name="manager_pass">
			</div>
			
			<div class="center_login_button">
				<input type="submit" value="로그인"/>
			</div>
		</form>
	</div>
	
	<div class="bottom_porm">
		<div class="login_netfilx_info">
			<ul>
				<li>나우플릭스서비시스코리아 유한회사 통신판매업신고번호 : 제2018-서울종로-0426호
					전화번호 : 00-308-321-0058</li>
				<li>대표 : 영웅</li>
				<li>이메일 주소 : kg@itbank.com</li>
				<li>주소 : 대한민국 서울특별시 종로구 아이티뱅크</li>
				<li>클라우드 호스팅 : Amazon Web Services Inc.</li>
			</ul>
		</div>
		
	</div>
	</div>
</body>
</html>