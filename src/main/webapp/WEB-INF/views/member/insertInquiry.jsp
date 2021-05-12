<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객문의 페이지</title>
</head>
<link rel="stylesheet" href="css/member/inquery_custom.css">
<body>
	<div class="header">
		<a title="홈" href="index.do?profile_id=${profile.profile_id }"> <img
			src="http://yonom.duckdns.org/images/logo/nowflix.png"
			style="width: 119px;">
		</a>

		<div class="user-info">
		
		<div class="dropdown">
		<span class="user-name">${member.nickname }</span> <img
					src="http://yonom.duckdns.org/images/member/dropdown.png"
					style="width: 15px;">
			<button class="dropdown-togle" aria-haspopup="true"></button>
			<div class="dropdown-content">
			<a href="getInsertInquiry.do?profile_id=${profile.profile_id}">문의등록</a>
				<a href="getInquiryList.do?profile_id=${profile.profile_id}">문의내역</a>
				<a href="getInquiryFAQ.do?profile_id=${profile.profile_id}">자주묻는질문</a>
				<a href="logout.do">로그아웃</a>
			</div>
			
			</div>
		</div>
	</div>


	<div class="main">
		<div class="container-divider"></div>


		<nav class="sub-nav">
			<ol class="breadcrumbs">
				<li class="NOWFLIX"><a href="#">NOWFLIX</a></li>
				<li class=">">></li>
				<li class="inquery">문의 등록</li>
			</ol>
		</nav>

		<div class="container">
			<h1>문의 등록</h1>
			<p>
				문의주신 내용은 고객센터에서 확인 후 영업일 기준 3일 이내에 답변 드리도록 하겠습니다.<br> * 운영 시간:
				평일 (월 ~ 금) 10:00 ~ 18:00<br> <br> 최근 사회적 거리두기 격상과 함께 문의량이
				급증하여, 문의에 대한 답변이 평소보다 지연될 수 있는 점 너른 양해 부탁드립니다.<br>
			</p>

			<div class="form">
				<form id="new_request" class="request-form" action="insertInquiry.do">
					<br> 아래에서 문의 유형을 선택해주세요.<br> <select name="inquiry_type">
						<option value="">-</option>
						<option value="로그인/계정관리">로그인/계정 관리</option>
						<option value="사용문의">사용문의</option>
						<option value="제안하기">Nowflix에 제안하기</option>
						<option value="쿠폰">쿠폰</option>
						<option value="콘텐츠">콘텐츠</option>
						<option value="환불">환불</option>
						<option value="해지">해지</option>
						<option value="결제">결제</option>
						<option value="재생 및 사용오류">재생 및 사용오류</option>
						<option value="탈퇴">탈퇴</option>
					</select><br> <br> 제목<br> <input type="text" class="title" name="inquiry_title">
					<br> <br> 설명<br>
					
					<textarea name="inquiry_content" rows="10" cols="30"></textarea>
					<input type="hidden" name="email" value="${member.email }">
					
					<br> <br> <br> <input type="submit">
				</form>

				<footer class="footer">
					<a title="홈" href="#">Nowflix, Inc</a>
				</footer>









			</div>

		</div>
</body>
</html>