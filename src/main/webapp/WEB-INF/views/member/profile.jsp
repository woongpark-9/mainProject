<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href=css/member/profile.css>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
 <script type="text/javascript" language="javascript"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
   href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
   integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
   crossorigin="anonymous" />	
<script src="js/member/profile.js"></script>
<title>Nowflix</title>
</head>
<body style="background: #141414;"id="body">
	<div class="position-relative" id="bodyContents" style="top: 25%;">
		<div class="page-header col-md-12" style="color: white; font-size: 3vw;" align="center">Nowflix를 시청할 프로필을 선택하세요.</div>
		<br>
		<div class="row justify-content-center" align="center">
		<c:forEach var="profile" items="${profile }">
			<div class="ml-3 mr-3 proImg">
				<a href="#" class="profile" onclick="">
					<img class="img-responsive img-rounded" src="${profile.profile_img }">
					<br>${profile.profile_name }
					<c:if test="${profile.kids  == 'Y'}">
						<img class="kids" src="http://yonom.duckdns.org/images/profile/kids.png">
					</c:if>
				</a>
			</div>
		</c:forEach>
		<c:if test="${fn:length(profile) <= 5}" >
			<div class="ml-3 mr-3">
				<a href="#" class="profile" onclick="acyncMovePage('http://localhost:8080/nowflix/profileAdd.do')">
					<img class="img-responsive addProfileImg" src="http://yonom.duckdns.org/images/profile/add3.png">
					<br>프로필 추가
				</a>
			</div>
		</c:if>	
		</div>
		<div class="text-center mt-5">
    		<a href="#" class="col-mb-4 mt-6 editProfile" onclick="acyncMovePage('http://localhost:8080/nowflix/manageProfiles.do')">프로필 관리</a>
		</div>
	</div>
</body>
</html>