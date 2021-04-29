<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <html xmlns:th="http://www.thymeleaf.org"> -->
<html style="height: 100%;">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="refresh" content="5; url=http://localhost:8080/nowflix/favorite.do">
<link rel="stylesheet" href="http://yonom.duckdns.org/css/emailCheck/style.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
 <script type="text/javascript" language="javascript">	</script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
   href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
   integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
   crossorigin="anonymous" />	
<script src="script.js"></script>
<title>Nowflix</title>
</head>
<title>Insert title here</title>
</head>

 
<!-- 카카오페이 결제가 정상적으로 완료되었습니다. -->
 
<%-- 결제일시:     [[${info.approved_at}]]<br/> --%>
<%-- 주문번호:    [[${info.partner_order_id}]]<br/> --%>
<%-- 상품명:    [[${info.item_name}]]<br/> --%>
<%-- 상품수량:    [[${info.quantity}]]<br/> --%>
<%-- 결제금액:    [[${info.amount.total}]]<br/> --%>
<%-- 결제방법:    [[${info.payment_method_type}]]<br/> --%>
<%-- 결제카드:    [[${info.card_info.purchase_corp }]]<br/> --%>
 
<body style="background: #141414;     height: 100%;"id="body">
	<div class="position-relative" id="bodyContents" style="top: 25%;">
		<div class="page-header col-md-12" style="color: white; font-size: 3vw;" align="center">결제완료!</div>
		<br>
		<div class="row justify-content-center" align="center">
			<div class="ml-3 mr-3" style="font-size: 2vw; color: grey;">
				<br>
				해당 이메일로 결제내역을 보내드렸습니다. 결제 이후 취소 등 관련 사항은 문의하여 주세요.
			</div>
		</div>
		<div class="text-center mt-5" style="font-size: 1vw; color:grey;">
    		<a href="" class="col-mb-4 mt-6 editProfile">
    		<img class="img-responsive img-rounded" src="http://yonom.duckdns.org/images/logo/nowflix.png"><br>
    		<br><br>
    		5초 후에 메인페이지로 이동합니다.
    		</a>
		</div>
	</div>
</body>
</html>