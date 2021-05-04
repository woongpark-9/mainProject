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
</head>
<body style="background: #141414;" id="body">
	<div class="position-relative" id="bodyContents" align="center" >
		<div class="col-md-12" style="width: 45%;">
			<div class="row justify-content-center" align="center" id="imgList">
				<script>
					var profileImgList = ['Netflix-avatar0.png','Netflix-avatar1.png','Netflix-avatar2.png','Netflix-avatar3.png','Netflix-avatar4.png','Netflix-avatar5.png','Netflix-avatar6.png','Netflix-avatar7.png',
						'Netflix-catoon0.png','Netflix-catoon1.png','Netflix-catoon2.png','Netflix-catoon4.png',
						'Netflix-character0.png','Netflix-character1.png','Netflix-character2.png','Netflix-character3.png','Netflix-character4.png','Netflix-character5.png','Netflix-character6.png','Netflix-character7.png']
					var tag = '';
					for (i=0; i<profileImgList.length; i++) {
						imgSrc = 'http://yonom.duckdns.org/images/profile/' + profileImgList[i];
						url = 'http://localhost:8080/nowflix/updateProfileEdit.do';
						id = ${profile.profile_id};
						name = '${profile.profile_name}';
						kids = '${profile.kids}';
						tag += "<div class='m-1'><a href='#' class='profile' onclick=\"acyncMovePage3('" + url + "'," + id + ",'" + name + "','" + imgSrc + "','" + kids + "')\"><img class='img-responsive img-rounded profileImg' src=" + imgSrc + "></a></div>";
					}
					$("#imgList").append(tag);
				</script>
			</div>
		</div>
	</div>
</body>
</html>