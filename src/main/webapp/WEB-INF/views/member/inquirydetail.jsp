<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객문의 페이지</title>
</head>
<link rel="stylesheet" href="css/member/inquirydetail.css">
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
				<a href="#">문의등록</a>
				<a href="#">문의내역</a>
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
				<li class="inquery">내 활동</li>
			</ol>
		</nav>

		<div class="container">
			<h1 class="request-title">${inquiryDetailList[0].inquiry_title }</h1>
		

<div class="section-content">
	 			<div class="clearfix">
	 				<c:forEach var="inquiryDetailList" items="${inquiryDetailList }">
	 				<ul class="sales-table">
	 				
	 					<li class="sales-table-header">
	 					<div class="col-date">${member.nickname }</div>
	 					<div class="col-item">${inquiryDetailList.inquiry_content }</div>
	 			
	 					</li>
	 				</ul>
	 				
	 					<c:if test="${not empty inquiryDetailList.manager_email }">
	 					<ul class="sales-table">
	 					<li class="sales-table-header">
	 					<div class="col-date">${inquiryDetailList.manager_email }</div>
	 					<div class="col-item">${inquiryDetailList.reply_content }</div>
	 						</li>
	 						</ul>
	 					</c:if>
	 				
	 				
	 				
	 					</c:forEach>
	 				<ul class="sales-table">
	 					<li class="sales-table-header">
	 				
	 					</li>
	 				</ul>
	 			
	 				
	 		
	 			
	 		
	 		</div>
	 		<div class="comment-fields " style="display: block;">
            

            <textarea name="" id="request_comment_body" placeholder="" rows="7" aria-required="true" aria-label="답장 추가"></textarea>

            <div class="comment-attachments">





<ul id="request-attachments-pool" class="upload-pool" data-uploads="[]" data-template="upload-template"></ul>


            </div>
                <input type="submit" name="commit" value="제출" class="button button-large" disabled="">
          </div>
      
	 		
	 	</div>




				<footer class="footer">
					<a title="홈" href="#">Nowflix, Inc</a>
				</footer>









			</div>

		</div>
</body>
</html>