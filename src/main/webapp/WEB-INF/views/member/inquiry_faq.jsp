<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			style="width: 119px;">
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
			
			<div id="main-content" class="section-tree">
				<section class="section">
					<div class="section-tree-title"><a>로그인/계정관리</a></div>
					<ul class="article-list"></ul>
				</section>
			</div>
				<footer class="footer">
					<a title="홈" href="#">Nowflix, Inc</a>
				</footer>









			</div>

		</div>
</body>
</html>