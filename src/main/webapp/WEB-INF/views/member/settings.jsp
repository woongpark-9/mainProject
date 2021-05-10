<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://yonom.duckdns.org/css/member/settings.css" />

</head>
<body style="margin:0;">
<div class="wrap">
<header class="header">
	<div class="hdspace">
	<a class="logo"><img class="logo" src="http://yonom.duckdns.org/images/logo/nowflix.png" style="width: 8vw; margin: 13px 0 15px 0;"></a>
	</div>
</header>
	<div class="bd">


	 	<div class="account-container">
	 		<div class="inner">
	 			<div class="account-header">계정</div>
	 			<div class="account-section-membersince--svg"></div>
	 			<div class="member-since">
	 				멤버십 시작 : 	<fmt:formatDate pattern="yyyy-MM-dd" value="${salesList[0].payment_date }"/>
	 			</div>
	 			<div class="member-since">
	 				멤버십 종료 : 	<fmt:formatDate pattern="yyyy-MM-dd" value="${salesList[0].expiry_date }"/>
	 			</div>
	 		</div>
	 		<div class="account-section-wrapper">
	 			<header class="account-section-header"><div class="account-section-header-text">멤버십&결제 정보</div></header>
	 		<div class="section-content">
	 			<div class="clearfix">
	 				<c:forEach var="salesList" items="${salesList }">
	 				<div class="emailtext">${salesList.email }</div>
	 				
	 				<div class="salesinfo"><div class="salestext">카카오페이  ${salesList.payment_method_type} 결제 </div></div>
	 				</c:forEach>
	 			</div>
	 			
	 		
	 		</div>
	 		</div>
	 		<div class="account-section-mid-wrapper">
	 		<header class="account-section-header"><div class="account-section-header-text">멤버십 상세 정보</div></header>
	 		<div class="section-content">
	 			<div class="clearfix">
	 				<div class="membership-info">
	 				<div class="membership-text">${ticketType }	</div>
	 			
	 				<a class="membership-a" href="#"></a></div>
	 				
	 			</div>
	 			
	 		
	 		</div>
	 		</div>
	 			
	 		<div class="account-section-bottom-wrapper">
	 		<header class="account-section-header"><div class="account-section-header-text">결제 상세 정보</div></header>
	 		</div>
	 	
	 			<div class="section-content">
	 			<div class="clearfix">
	 				<ul class="sales-table">
	 					<li class="sales-table-header">
	 					<div class="col-date">날짜</div>
	 					<div class="col-item">구매한이용권</div>
	 					<div class="col-expirydate">서비스기간</div>
	 					<div class="col-paymenttype">결제방법</div>
	 					<div class="col-cardname">카드명</div>
	 					</li>
	 					<li class="sales-table-content">
	 					<c:forEach var="salesList" items="${salesList }">
	 					<div class="col-date-content"><fmt:formatDate pattern="yyyy-MM-dd" value="${salesList.payment_date }"/></div>
	 					<div class="col-item-content">${ticketText }</div>
	 					<div class="col-expirydate-content">	<fmt:formatDate pattern="yyyy-MM-dd" value="${salesList.payment_date }"/> ~ 	<fmt:formatDate pattern="yyyy-MM-dd" value="${salesList.expiry_date }"/></div>
	 					<div class="col-paymenttype-content">${salesList.payment_method_type }</div>
	 					<div class="col-cardname-content">${salesList.card_name }</div>
	 					</c:forEach>
	 					</li>
	 				</ul>
	 			
	 			
	 				
	 		
	 			
	 		
	 		</div>
	 		
	 	</div>
	 		</div>
	
	
	</div>
</div>

</body>
</html>