<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객문의 페이지</title>
</head>
<link rel="stylesheet" href="css/member/faq.css">
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
				<li class="inquery">FAQ</li>
			</ol>
		</nav>

		<div class="container">
			<h1>FAQ</h1>
			
			<div id="main-content" class="section-tree" style="display:flex; ">
			
				<section class="section" style="display:flex; margin-right:10vw;">
					<div class="section-tree-title" style=" margin-right:10vw;">
				
					<a>${registList[0].faq_category }</a>
				
					<c:forEach var="faqList" items="${registList }" >
					<div class="article-list">${faqList.faq_title }${faqList.faq_content }</div>
					</c:forEach>
					
					</div>
							<div class="section-tree-title">
				
					<a>${payList[0].faq_category }</a>
				
					<c:forEach var="faqList" items="${payList }" >
					<div class="article-list">${faqList.faq_title }${faqList.faq_content }</div>
					</c:forEach>
					
					</div>
				</section>
			
					
				
			</div>
				<footer class="footer">
					<a title="홈" href="#">Nowflix, Inc</a>
				</footer>









			</div>

		</div>
</body>
</html>