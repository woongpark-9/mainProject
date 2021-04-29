<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="position-relative" id="bodyContents" style="top: 25%;">
	<div class="page-header col-md-12" style="color: white; font-size: 3vw;" align="center">프로필 추가</div>
	<div class="page-header col-md-12" style="color: grey; font-size: 1.5vw;" align="center">Nowflix를 시청할 다른 사용자를 등록하시려면 프로필을 추가하세요.</div>
	<br>
	<form action="createProfile.do" method="post">
	<div class="row justify-content-center" align="center">
		<div class="kidAdd" style="position: relative;">
			<img class="img-responsive profileImg" src="http://yonom.duckdns.org/images/profile/Netflix-avatar0.png">
		</div>
		<div class="align-self-center">
			<input type="text" placeholder=" 이름" class="profile_name" name="profile_name" style="font-size: 1.5vw;">
			<input type="checkbox" id="kids" name="kids" value="Y">
			<label for="kidBox"></label> 
			<span class="kidBox" role="checkbox" aria-checked="false" tabindex="0" style="font-size: 1vw; color: white;">어린이인가요?</span>
			<script>
				$(document).ready(function(){
					$("#kids").change(function(){
						if($("#kids").is(":checked")){
							$(".kidAdd").append("<img class='kids3' src='http://yonom.duckdns.org/images/profile/kids.png'>");
						}else{
							$(".kids3").remove();
						}
					});
				});
			</script>
		</div>
	</div>
	<br>
	<br>
	<div align="center">
		<input type="submit" class="next" value="다음">
		<a href="#" class="cancel" onclick="acyncMovePage('http://localhost:8080/nowflix/profile.do')">취소</a>
		
	</div>
	</form>
	
</div>