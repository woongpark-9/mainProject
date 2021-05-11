
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<body style="background: #141414;"id="body">
	<div class="position-relative" id="bodyContents" style="top: 25%;">
		<div class="page-header col-md-12" style="color: white; font-size: 3vw;" align="center">이메일 인증을 완료해주세요!</div>
		<br>
		<div class="row justify-content-center" align="center">
			<div class="ml-3 mr-3" style="font-size: 2vw; color: grey;">
				인증을 완료하셔야 서비스 이용이 가능합니다.
				<br>
				<br>
				혹시 이메일을 받지 못하셨나요? <a href="reSend.do?email=${member.email}" class="col-mb-4 mt-6 resend">다시 보내기</a>
				<br>
				<br>
			</div>
		</div>
		<div class="text-center mt-5" style="font-size: 1vw; color:grey;">
    		<a href="index.jsp" class="col-mb-4 mt-6 editProfile">
    		<img class="img-responsive img-rounded" src="http://yonom.duckdns.org/images/logo/nowflix.png"><br>
    		메인 페이지로 가기
    		</a>
		</div>
	</div>
</body>
</html>