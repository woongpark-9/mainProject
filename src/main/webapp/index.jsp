<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/member/index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Netflix</title>
<script>
	function fn_idCheck() {
		$.ajax({
			url : "idCheck.do",
			type : "post",
			dataType : "json",
			data : {
				"email" : $("#email").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 아이디 입니다.");

				} else if (data == 0) {
					$("#idCheck").attr("value", "Y");
					alert("사용가능한 아이디입니다");
					var emailtext = document.getElementById('email').value;
					location.href = "register.do?email=" + emailtext;
				}
			}
		})
	}
</script>
</head>
<body style="word-break: keepall; background-color: #212529;">
	<header class="showcase"
		style="background: url('http://yonom.duckdns.org/images/member/backcopy.jpg') no-repeat center center/cover;">
		<div class="showcase-top">
			<img src="http://yonom.duckdns.org/images/member/LOGO.png"
				alt="Netflix logo"> <a href="login.do" class="btn btn-rounded">로그인</a>

		</div>
		<div class="showcase-content">
			<h1>영화, TV 프로그램을 무제한으로.</h1>
			<h3>다양한 디바이스에서 시청하세요. 언제든 해지하실 수 있습니다.</h3>
			<p>시청할 준비가 되셨나요? 멤버십을 등록하거나 재시작하려면 이메일 주소를 입력하세요.</p><div>
			<input type="email" name="email" id="email" placeholder="이메일 주소">
			<a href="#" class="btn btn-lg" type="button" id="idCheck" onclick="fn_idCheck();" value="N">시작하기 ></a></div>
		</div>
	</header>

	<section class="style-cards">
		<div class="card-1">
			<div class="desc-1">
				<h1>TV로 즐기세요.</h1>
				<h3>스마트 TV, PlayStation, Xbox, Chromecast, Apple TV, 블루레이 플레이어
					등 다양한 디바이스에서 시청하세요.</h3>
			</div>
			<img src="http://yonom.duckdns.org/images/member/tv.png"
				alt="Netflix TV">
			<video class="video-1" autoplay="" playsinline="" muted="" loop="">
				<source
					src="http://yonom.duckdns.org/images/member/video-tv-0819.m4v"
					type="video/mp4">
			</video>
		</div>
		<div class="card-2">
			<img src="http://yonom.duckdns.org/images/member/mobile-0819.jpg"
				alt="Netflix Mobile">
			<div class="desc-2">
				<h1>즐겨 보는 콘텐츠를 저장해 오프라인으로 시청하세요.</h1>
				<h3>간편하게 저장하고 빈틈없이 즐겨보세요.</h3>
			</div>
		</div>
		<div class="card-3">
			<div class="desc-3">
				<h1>다양한 디바이스에서 시청하세요.</h1>
				<h3>각종 영화와 TV 프로그램을 스마트폰, 태블릿, 노트북, TV에서 무제한으로 스트리밍하세요. 추가 요금이
					전혀 없습니다.</h3>
			</div>
			<img src="http://yonom.duckdns.org/images/member/device-pile.png"
				alt="Device-Pile-In">
			<video class="video-2" autoplay="" playsinline="" muted="" loop="">
				<source
					src="http://yonom.duckdns.org/images/member/video-devices.m4v"
					type="video/mp4">
			</video>
		</div>
	</section>

	<section class="lastsec">
		<div class="faq">
			<h1>자주 묻는 질문</h1>
			<ul class="questions">
				<li>나우플릭스란 무엇인가요?</li>
				<li>나우플릭스 요금은 얼마인가요?</li>
				<li>어디에서 시청할 수 있나요?</li>
				<li>멤버십을 해지하려면 어떻게 하나요?</li>
				<li>나우플릭스에서 어떤 콘텐츠를 시청할 수 있나요?</li>
			</ul>
			<p>시청할 준비가 되셨나요? 멤버십을 등록하거나 재시작하려면 이메일 주소를 입력하세요.</p>
			<div class="input">
				<input type="email" name="email" placeholder="이메일 주소"
					style="width: 430px;"> <a href="#" class="btn-round"><button>시작하기
						></button></a>
			</div>

		</div>
	</section>

	<footer class="footer">
		<p>질문이 있으신가요? 문의 전화: 00-308-321-0058</p>
		<div class="footer-cols">
			<ul>
				<li><a href="#">자주 묻는 질문</a></li>
				<li><a href="#">투자 정보(IR)</a></li>
				<li><a href="#">개인정보</a></li>
				<li><a href="#">속도 테스트</a></li>
			</ul>
			<ul>
				<li><a href="#">고객 센터</a></li>
				<li><a href="#">입사 정보</a></li>
				<li><a href="#">쿠키 설정</a></li>
				<li><a href="#">법적 고지</a></li>
			</ul>
			<ul>
				<li><a href="#">계정</a></li>
				<li><a href="#">Netflix 지원 디바이스</a></li>
				<li><a href="#">회사 정보</a></li>
				<li><a href="#">Netflix 오리지널</a></li>
			</ul>
			<ul>
				<li><a href="#">미디어 센터</a></li>
				<li><a href="#">이용 약관</a></li>
				<li><a href="#">문의하기</a></li>
			</ul>
		</div>
	</footer>


</body>
</html>