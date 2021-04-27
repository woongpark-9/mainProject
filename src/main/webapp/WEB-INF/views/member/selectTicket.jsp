<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/member/selectTicket.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$("#third-line").click(function() {
		var thirdline = document.getElementById("third-line");	
		if (thirdline.style.color == 'rgb(51, 51, 51)') {
			document.getElementById("third-line").style.color = "red";
			document.getElementById("basic-button").style.color="rgb(51, 51, 51)";
			document.getElementById("basic-button").style.border="1px solid gray";
			document.getElementById("second-line").style.color ="rgb(51, 51, 51)";
			document.getElementById("premium-button").style.border="1px solid red"
			document.getElementById("premium-button").style.color="red"
			document.getElementById("hidden-message").value="002";
		} else {
			
		}
	});
	
	$("#second-line").click(function() {
		var secondline = document.getElementById("second-line");
		if (secondline.style.color == 'rgb(51, 51, 51)') {
			document.getElementById("basic-button").style.color="red";
			document.getElementById("basic-button").style.border="1px solid red";
			document.getElementById("second-line").style.color = "red";
			document.getElementById("third-line").style.color ="rgb(51, 51, 51)";
			document.getElementById("premium-button").style.border="1px solid gray";
			document.getElementById("premium-button").style.color="rgb(51, 51, 51)";
			document.getElementById("hidden-message").value="001";
		} else {
			
		}
	});

});


//페이지 이동
function acyncMovePage(url,ticketType) {
	   console.log("안녕하세요");
	   console.log(ticketType);
   $.ajax({
	
      url : url,
      type : "POST",
      //data : JSON.stringify(json),
//       contentType : "application/json",
		dataType:"html",
       data: {"ticketType" : ticketType},
      success : function(data) {
         $('#bodyContents').children().remove();
         $('#bodyContents').html(data);
      },
      error : function(data) {
         alert("error"+data);
      }
   });
}

//다음 단계로
function acyncSetTicketType() {
   var value = document.getElementById("hidden-message").value;
   $.ajax({
      url : "setTicketType.do",
      type : "POST",
      dataType:"json",
      data: {"ticketType" : $("#hidden-message").val()},
      success : function(data) {
         if(0 == data) {
            acyncMovePage('ticket_step2.do',value);
         } else {
            alert("[Error] 서버 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}




	
	
</script>

</head> 
<body >
	<div class="root" >

				 <div class="overlay" style="background: url('http://yonom.duckdns.org/images/member/backcopy.jpg') no-repeat center center/cover; z-index: 0;">
				 		<div class="showcase-top">
			<img src="http://yonom.duckdns.org/images/member/LOGO.png" alt="Netflix logo"> 

		</div>
			<div class="messageText">이용권이 없으시군요 ! 먼저 이용권을 구매해주세요.</div>
		<div class= "explanation">언제든지 해지할 수 있고, 무료 이용 기간에는 과금이 되지 않습니다.</div>
		</div>
		<div id="bodyContents" class="ticket-body">
		
		<div class="content-over" style="display:flex;">
		<div class="left-ticket-body">
		<div class="stepMessage">
			<div class="stepText">2단계중 1단계</div>
			<div class="selectText">이용권을 선택해주세요</div>
			
			
		</div>
		<div class="plantable">
			<ul class="first-line">
				<li class="first-line-first"></li>
				<c:forEach var="period" items="${basicticketList}">
				<li class="first-line-second">${period.ticket_period}일 요금</li>	
				</c:forEach>
<!-- 				<li class="first-line-third">60일 요금</li> -->
<!-- 				<li class="first-line-fourth">120일 요금</li> -->
<!-- 				<li class="first-line-fifth">360일 요금</li> -->
				<li class="first-line-sixth">지원하는 화질</li>
			</ul>
			<ul class="second-line" style="color:red;" id="second-line">
				<li class="second-line-first"><button class="basic-button" id="basic-button" style="color:red;   border: 1px solid red;">베이직</button></li>
				<c:forEach var="basicticketList" items="${basicticketList}">
					<li class="second-line-second">${basicticketList.ticket_price }원</li>
				</c:forEach> 
<!-- 				<li class="second-line-third">10000원</li> -->
<!-- 				<li class="second-line-fourth">10000원</li> -->
<!-- 				<li class="second-line-fifth">10000원</li> -->
				<li class="second-line-sixth">720P</li>
			</ul>
			<ul class="third-line" id="third-line" style="color:rgb(51, 51, 51);">
				<li class="third-line-first"><button class="premium-button" id="premium-button" style="border:1px solid gray;">프리미엄</button></li>
				<c:forEach var="premiumticketList" items="${premiumticketList}">
					<li class="third-line-second">${premiumticketList.ticket_price }원</li>
				
				</c:forEach>
				
<!-- 				<li class="third-line-third">10000</li> -->
<!-- 				<li class="third-line-fourth">10000</li> -->
<!-- 				<li class="third-line-fifth">10000</li> -->
				<li class="third-line-sixth">1080P</li>
			</ul>
			
		</div>
		</div>
		<div class="right-ticket-body">	
			<div class="right-banner">
				<ul class="title-list">
					<li class="title-item">
						<div class="title-text-first">9만여 편의 작품 무제한 감상</div>
						<div class="title-text-second">인기 영화,드라마,예능,다큐를 추가 지불 없이 감상하세요</div>
					</li>
				</ul>
			</div>
			<div class="right-content">
			<ul class="css-61jffl"><li class="css-wzmjfs">결제 금액에는 VAT가 포함되어있습니다.</li><li class="css-wzmjfs">무료 이용 혜택은 최초 1회만 제공됩니다.</li><li class="css-wzmjfs">무료 이용 기간이 끝난 후, 등록해놓으신 결제 수단으로 요금이 부과됩니다.</li><li class="css-wzmjfs">이용 기간이 종료되기 24시간 이내에 다음 이용에 대한 비용이 결제됩니다. 즉, 이용 기간 종료 시점으로부터 최소 23시간 전에 이용을 취소하지 않으시면 이용권이 자동으로 갱신됩니다.</li><li class="css-wzmjfs">결제취소는 결제 후 7일 내 서비스 미 이용 시 가능하며, 결제 후 7일 경과 또는 서비스 이용 시에는 환불이 불가능합니다.</li><li class="css-wzmjfs">저작권자의 요청에 따라 일부 콘텐츠의 동시 재생이 제한될 수 있습니다.</li><li class="css-wzmjfs">최대 화질의 이용 가능 여부는 이용권 종류, 네트워크 환경, 콘텐츠 계약 조건, 디바이스의 물리적 사양에 따라 제한될 수 있습니다.</li><li class="css-wzmjfs">한국 외 국가에서는 감상이 제한되며, 일부 영상은 저작권자의 요청에 따라 도중에 제공이 중단될 수 있습니다.</li><li class="css-wzmjfs"><span>지원 TV 목록을 확인해주세요.</span></li><li class="css-wzmjfs">엣지, 크롬, 파이어폭스, 웨일 브라우저를 지원합니다.</li><li class="css-wzmjfs">구매하신 이용권 종류 혹은 결제 상태(제휴상품, 쿠폰 등)에 따라 이용권 변경이 제한될 수 있습니다.</li></ul>
		</div>
		</div>
		</div>
		
		<input type="hidden" id="hidden-message" value="001">
		<div class="css-ty0gcz"><button class="css-z6cg4t" onclick="acyncSetTicketType()">다음 단계로</button></div>
		
	
		</div>
		
	</div>
		
</body>
</html>