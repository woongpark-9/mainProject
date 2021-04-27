<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="css/member/select_ticket_step2.css">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script>

function add_info(){
	$.ajax({
		url : "addInfo.do",
		type:"post",
		dataType:"json",
		data :{"gender" : $("#gender").val() , "birthday" : $("#birthday").val()},
		success : function(data){
			
			if(data == 0){
				alert("추가정보가 등록되었습니다.")
			}
		}
		
		
			
	});
}




$(document).ready(function() {
	
	
});

$(document).on("click","[class=box]", function(){
	//alert($(this).index());
	var test = $("div[class=box]").length;
	

	
	for(var i=0; i<test; i++){
	
		if($("[class=box]").index(this) == i) {
			this.style.color="white";
			this.style.border = "1px solid red";
			
			var ticketprice = $('.second-right-second1').get(i).innerHTML.split('원');
			var ticketmonth = $('.first-left').get(i).innerHTML;
			var ticketType = "${ticketText}";
		    var ticket_id = $('.hidden_id').get(i).value;
		  	document.getElementById("ticket_id").value=ticket_id;
			document.getElementById("item_name").value=ticketType+ticketmonth;
			document.getElementById("total_amount").value=ticketprice[0];
			
		
			
			
			
			
		
			
			$(this).siblings(".box").css('color', 'grey');
			$(this).siblings(".box").css('border', '1px solid grey');
			$(this).siblings(".recommendbox").css('color', 'grey');
			$(this).siblings(".recommendbox").css('border', '1px solid grey');
			
		}
			
		
		
	}
	
	
});  



$(document).on("click","[class=recommendbox]", function(){
	//alert($(this).index());
	var test = $("div[class=recommendbox]").length;
	for(var i=0; i<test; i++){
	
	
		if($("[class=recommendbox]").index(this) == i) {
			this.style.color="white";
			this.style.border = "1px solid red";
		var ticketprice = $('.recommend-second-right-second1').get(i).innerHTML.split('원');
		var ticketmonth = $('.recommend-left').get(i).innerHTML;
		var ticketType = "${ticketText}";
		 var ticket_id = $('.recommend_hidden_id').get(i).value;
		   
		
			document.getElementById("item_name").value=ticketType+ticketmonth;
			document.getElementById("total_amount").value=ticketprice[0];
			document.getElementById("ticket_id").value=ticket_id;
			$(this).siblings(".recommendbox").css('color', 'grey');
			$(this).siblings(".recommendbox").css('border', '1px solid grey');
			$(this).siblings(".box").css('color', 'grey');
			$(this).siblings(".box").css('border', '1px solid grey');
			
		}
			
		
		
	}
	
	
});  





	
// 	$("#box1").click(function() {
// 			document.getElementById("box1").style.border = "1px solid red";
// 			document.getElementById("box1").style.color = "white";
// 			document.getElementById("box2").style.border = "1px solid grey";
// 			document.getElementById("box2").style.color = "grey";
// 			document.getElementById("box3").style.border = "1px solid grey";
// 			document.getElementById("box3").style.color = "grey";
// 			document.getElementById("box4").style.border = "1px solid grey";
// 			document.getElementById("box4").style.color = "grey";
// 			document.getElementById("month").value="${ticketType}1";
// 	});
	
// 	$("#box2").click(function() {
// 			document.getElementById("box1").style.border = "1px solid grey";
// 			document.getElementById("box1").style.color = "grey";
// 			document.getElementById("box2").style.border = "1px solid red";
// 			document.getElementById("box2").style.color = "white";
// 			document.getElementById("box3").style.border = "1px solid grey";
// 			document.getElementById("box3").style.color = "grey";
// 			document.getElementById("box4").style.border = "1px solid grey";
// 			document.getElementById("box4").style.color = "grey";
// 			document.getElementById("month").value="${ticketType}3";
// 	});
// 	$("#box3").click(function() {
// 		document.getElementById("box1").style.border = "1px solid grey";
// 		document.getElementById("box1").style.color = "grey";
// 		document.getElementById("box2").style.border = "1px solid grey";
// 		document.getElementById("box2").style.color = "grey";
// 		document.getElementById("box3").style.border = "1px solid red";
// 		document.getElementById("box3").style.color = "white";
// 		document.getElementById("box4").style.border = "1px solid grey";
// 		document.getElementById("box4").style.color = "grey";
// 		document.getElementById("month").value="${ticketType}6";
// 	});
// 	$("#box4").click(function() {
// 		document.getElementById("box1").style.border = "1px solid grey";
// 		document.getElementById("box1").style.color = "grey";
// 		document.getElementById("box2").style.border = "1px solid grey";
// 		document.getElementById("box2").style.color = "grey";
// 		document.getElementById("box3").style.border = "1px solid grey";
// 		document.getElementById("box3").style.color = "grey";
// 		document.getElementById("box4").style.border = "1px solid red";
// 		document.getElementById("box4").style.color = "white";	
// 		document.getElementById("month").value="${ticketType}12";
// 	});


</script>
<body>
	<div class="container" style="margin-bottom: 150px;">
		<div class="left-container">
			<div class="first-text-line">
				2단계 중 2단계
			</div>
			<div class="second-text-line">
				결제 주기를 선택해주세요
			</div>
			<div class="third-text-line">
				주기가 길수록 할인율이 더 커져요!
			</div>
			<div class="forth-text-line">
				${ticketText } 요금제
				<button type="button" onClick="window.location.reload()">다시 선택하기</button>
			</div>
			<div class="fifth-text-line" style="color: white">추천 이용권</div>
			<div class ="selectTick">
			
			<c:forEach var="recommendTicketList" items="${recommendTicketList }">
			<div class="recommendbox" id="box1" style="border: 1px solid red; color:white;">
				<div class="recommend-left">${recommendTicketList.ticket_period}개월</div>
				<div class="recommend-second">
					<span class="recommend-second-right" ><input type="hidden" class="recommend_hidden_id" value="${recommendTicketList.ticket_id }"></span>
					<div class="recommend-second">
						<span class="recommend-second-right-second1" >${recommendTicketList.ticket_price }원</span>
					</div>
				</div>
			</div>
</c:forEach>
				<div id="sixth-line" class="sixth-line" style="color: white">할인 이용권</div>
				
				<c:forEach var="ticketList" items="${ticketList }">
				
				<div class="box" id="box2">
				<div class="first-left" id="ticketList-period">${ticketList.ticket_period}개월</div>
				
					<div class="second">
						<span class="second-right"><input type="hidden" class="hidden_id" value="${ticketList.ticket_id }"></span>
						<div class="second-right-second">
							<span class="bar"></span>
							<span class="second-right-second1">${ticketList.ticket_price }원</span>
						</div>
					</div>
				</div>
				</c:forEach>
				
<!-- 				<div class="box" id="box3"> -->
<!-- 					<div class="first-left">6개월</div> -->
<!-- 					<div class="second"> -->
<!-- 						<span class="second-right">2주 무료 이용</span> -->
<!-- 						<div class="second-right-second"> -->
<!-- 							6개월 마다 39,900원 <span class="bar">|</span> <span -->
<!-- 								class="second-right-second1">월 6,650원</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				<div class="box" id="box4"> -->
<!-- 					<div class="first-left">12개월</div> -->
<!-- 					<div class="second"> -->
<!-- 						<span class="second-right">2주 무료 이용</span> -->
<!-- 						<div class="second-right-second"> -->
<!-- 							12개월 마다 73,900원 <span class="bar">|</span> <span -->
<!-- 								class="second-right-second1">월 6,158원</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
		
		<div class="right-container">
		<div class="right-top-container">
				<div class="info-box">
	

					<div class="line">
						<div class="card-number-wrapper">
							<div class="card-number">성별</div>
						</div>
						<div class="card-number-text">
							<select name="job" id="gender">
    <option value="">성별 선택</option>
    <option value="남">남</option>
    <option value="여">여</option>
</select>
						</div>
					</div>

					<div class="line">
						<div class="card-number-wrapper">
							<div class="card-number">생년월일</div>
						
						</div>
						<div class="card-number-text">
							<input type="date" id="birthday">
						</div>
					</div>
					<div class="company-number"></div>
					
					<div class="regist-card-button">
						<button class="red-button" onclick="add_info();">추가 정보 등록하기</button>
					</div>
					
					
				</div>
			</div>
			<form action="kakaoPay.do" method="post">
				<input type="hidden" value="${ticketText}${recommendTicketList.get(0).ticket_period}개월" id="item_name" name="item_name">
				<input type="hidden" value="${recommendTicketList.get(0).ticket_price }" id="total_amount" name="total_amount">
				<input type="hidden" value="${recommendTicketList.get(0).ticket_id }" id="ticket_id" name="ticket_id">
				<button type="submit" id="kakao" value="">
				<i class="css-1g4bnqq"></i><span class="css-1hu77l2">카카오페이로 결제하기</span></button>
			</form>
		</div>
	</div>
</body>
</html>