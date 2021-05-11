<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객문의 페이지</title>
</head>
<link rel="stylesheet" href="css/member/inqueryList.css">
<body>
	<div class="header">
		<a title="홈" href="#"> <img
			src="http://nowflix.yonom.duckdns.org:1510/images/logo/nowflix.png"
			style="width: 8vw;">
		</a>

		<div class="user-info">
		
		<div class="dropdown">
		<span class="user-name">${member.nickname }</span> <img
					src="http://nowflix.yonom.duckdns.org:1510/images/member/dropdown.png"
					style="width: 15px;">
			<button class="dropdown-togle" aria-haspopup="true"></button>
			<div class="dropdown-content">
			<a href="getInsertInquiry.do">문의등록</a>
				<a href="getInquiryList.do">문의내역</a>
				<a href="getInquiryFAQ.do">자주묻는질문</a>
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
				<li class="inquery">문의 내역</li>
			</ol>
		</nav>

		<div class="container">
			<h1>문의 내역</h1>
			<p>문의하신 내역은 확인 후 답변드리겠습니다</p>

<div class="section-content">
	 			<div class="clearfix">
	 				<ul class="sales-table">
	 					<li class="sales-table-header">
	 					<div class="col-date">문의유형</div>
	 					<div class="col-item">제목</div>
	 					<div class="col-expirydate">문의 날짜</div>
	 					<div class="col-paymenttype">답변 날짜</div>
	 				
	 					</li>
	 					<c:forEach var="inquiryList" items="${inquiryList }">
	 					<li class="sales-table-content">
	 					<div class="col-date-content">${inquiryList.inquiry_type }</div>
	 					<div class="col-item-content"><a href="inquiryDetail.do?inquiry_id=${inquiryList.inquiry_id }">${inquiryList.inquiry_title }</a></div>
	 					<div class="col-expirydate-content">${inquiryList.inquiry_date }</div>
	 					<div class="col-paymenttype-content">${inquiryList.reply_date }</div>
	 				
	 						
	 					</li>
	 				
	 					</c:forEach>
	 				</ul>
	 		
	 		</div>
	 		
	 	</div>




				<footer class="footer">
					<a title="홈" href="#">Nowflix, Inc</a>
				</footer>









			</div>

		</div>
</body>
</html>