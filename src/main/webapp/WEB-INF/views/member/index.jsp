<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="plugin/slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="plugin/slick/slick-theme.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="plugin/slick/slick.js"></script>

<!-- <link type="text/css" rel="stylesheet" href="https://codex.nflxext.com/%5E3.0.0/truthBundle/webui/1.22.5-shakti-css-v616377ac/css/css/less%7Ccore%7Cerror-page.less/1/a80CwJ4HKsvEj9BGI/none/true/none" data-uia="botLink"> -->
<!-- <link type="text/css" rel="stylesheet" href="https://codex.nflxext.com/%5E3.0.0/truthBundle/webui/1.22.5-shakti-css-v616377ac/css/css/less%7Cpages%7CakiraClient.less/1/a80CwJ4HKsvEj9BGI/none/true/none" data-uia="botLink"> -->
<!-- <link type="text/css" rel="stylesheet" href="https://codex.nflxext.com/%5E3.0.0/truthBundle/webui/1.22.5-shakti-css-v616377ac/css/css/less%7Ccommon%7CkoreanLineBreak.less/1/a80CwJ4HKsvEj9BGI/none/true/none" data-uia="botLink"> -->
<link rel="shortcut icon"
	href="https://assets.nflxext.com/us/ffe/siteui/common/icons/nficon2016.ico">
<link href="css/member/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/member/search.css">
<script type="text/javascript" src="js/member/search.js"></script>
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/member/lovebell.css" />
<script type="text/javascript" src="js/member/lovebell.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/member/detail.css" />
<title>Insert title here</title>

<script>
	$(function() {
		$(".video1").click(
				function() {
					document.querySelector('video1').load();
					console.log('안녕하세요')
					var theModal = $(this).data("target"), videoSRC = $(this)
							.attr("data-video"), videoSRCauto = videoSRC + "";
					$(theModal + ' source').attr('src', videoSRCauto);
					$(theModal + ' button.close').click(function() {
						console.log('몰라요')
						$(theModal + ' source').attr('src', videoSRC);
					});
				});
	});

	/* 	$(document).on("click", ".detailBtn", function(e) {
		alert("상세정보 모달 오픈");

		$('#videoModal').modal('show');
	}); */

	$(document).ready(function() {
		$("#button").click(function() {
			if (more_content.style.display == 'none') {
				$("#more_content").show("flex");
				document.getElementById("img").src = "images/member/up.png";

			} else {
				$("#more_content").hide("flex");
				document.getElementById("img").src = "images/member/more.png";
			}
		});

	});

	$(document).ready(function() {
		$("#button2").click(function() {
			if (morelikethis.style.display == 'none') {
				$('#morelikethis').css('display', 'flex');
				document.getElementById("img2").src = "images/member/up.png";

			} else {
				$("#morelikethis").hide("flex");
				document.getElementById("img2").src = "images/member/more.png";
			}
		});

	});

	/* 	$(document).ready(function() {
	 $(".poster").mouseenter(function() {
	 console.log(2);
	 //			$("#caption").show();
	 //			$("#video").show();
	 $("#caption").css("display", "block");
	 $("#video").css("display", "block");
	 $("#video").get(0).play();
	 console.log($(".preview").get(1));
	 });

	 $(".caption").mouseleave(function() {
	 $("#caption").css("display", "none");
	 $("#video").get(0).pause();
	 $("#video").get(0).currentTime = 0;
	 //$("#video").get.pause();
	 //$("#video").get.currentTime = 0;

	 //	$("#video").css("display", "none");
	 });

	 }); */

	$(document).ready(function() {
		$(".poster").each(function(i, obj) {
			$(this).on("mouseenter", function() {
				startVideo(i);
			});
			$(".caption").on("mouseleave", function() {
				stopVideo(i);
			})
		});
	});

	function startVideo(i) {
		$(".caption").css("display", "block");
		$(".thevideo").css("display", "block");
		$(".thevideo")[i].play();
	}

	function stopVideo(i) {
		$(".caption").css("display", "none");
		$(".thevideo")[i].pause();
		$(".thevideo")[i].currentTime = 0;
	}
</script>
</head>
<body>
<c:set var="prefixAddr">http://yonom.duckdns.org/movie/</c:set>

	<div class="home">
		<video class="video1" src="images/member/love.mp4"
			poster="https://occ-0-2218-1009.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABYlW4dC81I67OWWpvjybrMQfxgF-nMCuPzZb_K7RIYsRV1_QEuYtYJ2tuSelUR57nV_E-MsiNW8IxhEZtzXLCdTycBUN.webp?r=c49"
			autoplay muted>
		</video>
		<div class="overlay">
			<div class="header">
				<!-- 	<div class="logo">NEFLIX</div> -->
				<a href="http://localhost:8080/nowflix/index.do"><img class="logo" src="images/member/로고.png" style="width: 92px; margin-top: 10px;"></a>

				<div class="nav">
					<div class="nav-item">
						<a href="#">홈</a>
					</div>
					<div class="nav-item">
						<a href="#">TV프로그램</a>
					</div>
					<div class="nav-item">
						<a href="#">영화</a>
					</div>
					<div class="nav-item">
						<a href="#">NEW! 요즘 대세 영화</a>
					</div>
					<div class="nav-item">
						<a href="#">내가 찜한 콘텐츠</a>
					</div>
					<div class="nav-item">
						<a href="#">다시 보기 콘텐츠</a>
					</div>
				</div>
				<div class="menu">
					<div class="search-box">
                     <input type="text" class="search-txt" placeholder="제목,사람,장르" id="search-txt" onkeydown="startSuggest()" />
                     <a class="search-btn" href="#">
                       <i class="fas fa-search"></i>
                     </a>
                  </div>
					<div class="menu-item">키즈</div>
					<div class="menu-item">
						<i class="fas fa-gift"></i>
					</div>

					<div class="menu-item">
						<div class="dropdown">
							<button class="bell-button">
								<i class="fas fa-bell"></i>
							</button>
							<div class="dropdown-content">
								<a href="#">연애의 참견</a> <a href="#">진격의 거인</a>
							</div>
						</div>
					</div>

					<!-- 프로필 드롭다운 부분 -->
					<div class="menu-item">
						<div class="dropdown">
							<button class="profile-button">유저</button>
							<div class="dropdown-content">
								<c:forEach var="profileList" items="${profileList }">
									<a href="#">${profileList.profile_name }</a>
								</c:forEach>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="banner">

				<div class="title">
					<img
						src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/tx1O544a9T7n8Z_G12qaboulQQE/AAAABf2KuOLYvCA8ZctYlCbwe-wvuYjMhhxAWrl1ULZVkFm1q3Npbdcm6t0Kp6qPe-PZM3lLBYBqKL9LUxSz8vLAs-9CJHeVSYIpJnA7TwWt1_0G60764vxN2J9-DDv1eUsw5NACZkEjmju1YCkd3dbBjSauZfB1w_-7OOaQHF2--ocm.webp?r=94c">
				</div>
				<div class="badge">오늘 한국에서 콘텐츠 순위 7위</div>
				<div class="description">"짝사랑 상대의 마음을 알 수 있다면 어떨까? 혼자 밤새워 고민하던
					시대는 끝났다. ‘좋알람’ 앱을 켜고 그 사람의 반경 10m 안에 들어가라. 좋아하면 반드시 울린다."</div>

				<div class="buttons">
					<button
						style="background: 0 0; border: 0; border-radius: 4px; padding: 0;">
						<div class="white-button">
							<i class="fas fa-play"></i> 재생
						</div>
					</button>
					<button
						style="background: 0 0; border: 0; border-radius: 4px; padding: 0;"
						class="detailBtn" data-toggle="modal" data-video="https://clienti.dk/media/1140/friheden-video.mp4" data-target="#videoModal">
						
						
						<div class="gray-button">
						
						
							<i class="far fa-info-circle"></i> 상세정보
						</div>
					</button>
				</div>
				<div class="extra">
					<button aria-label="다시 재생" onclick="replay()"
						class="color-supplementary hasIcon ltr-pjs1vp" type="button">
						<i class="fas fa-undo-alt"></i>
						<div class="ltr-1ksxkn9">
							<div class="small ltr-dguo2f" role="presentation">
								<svg viewBox="0 0 24 24">
									<path
										d="M20 12.35l1.919-1.371 1.162 1.627-4.08 2.915-4.082-2.915 1.162-1.627L18 12.349V12c0-3.87-3.13-7-7-7s-7 3.13-7 7 3.13 7 7 7c1.93 0 3.68-.79 4.94-2.06l1.42 1.42A8.954 8.954 0 0 1 11 21a9 9 0 1 1 9-9v.35z"
										fill="currentColor"></path></svg>
							</div>
						</div>
					</button>
					<div class="rating">15+</div>
				</div>
				<div class="category-list">
					<div class="category">
						<div class="title">Netflix 인기 콘텐츠</div>
						<div class="list">
							<c:forEach var="movieList" items="${usaMovieList }">
								<div class="items">
									<div class="item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png" alt="">


											<div class="progress">
												<span class="progress-bar"><span role="presentation"
													class="progress-completed" style="width: 50%;"></span></span>
											</div>
											
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<video id="thevideo" style="display: none;"
														class="thevideo" poster="${prefixAddr }${movieList.movie_path }/poster.png" muted>
														<source src="${prefixAddr }${movieList.movie_path }/1080p.mp4">
													</video>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}"> <img
															src="http://yonom.duckdns.org/images/member/play-button.png"
															width="40px" height="40px">
														</a>
													</div>
													<div class="title-name">${movieList.title }</div>
													<div class="movie-summary">${movieList.summary}</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://yonom.duckdns.org/images/member/plus-button.png"
															width="30px" height="30px">
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						
						
					</div>


					<div class="category">
						<div class="title">박영웅 님이 시청 중인 콘텐츠</div>
						<div class="list">
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABRDH13VvVc4aJ96XHn0AawDgS470J9tz3bpixc3ElJ42dV1eIZQwrf3pxeL19PV4iWKVzz1vjEVwC1AsQAAY-Ez7k6w_0O2W3L0onM5rgIV_ALq5hqQoJGW868I2e6rk9AM5r4aykCQY6Qw8t0IrjxI-d0w.webp?r=e1e"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 50%;"></span></span>
								</div>
							</div>


							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABYOt1G8AZuGVcnuHnZTMhwS8_HIes6zdivNuMLTZuYtpvnLwNHdm9B-9457q-TAjtGiFpTzugSjOmiCI2ZKm0kSIn_7dOXg5YpG46dqnUO2wprzjfv9UzmoyXLkRad7UfdXnVWuexeIabfWeGnT9gyRiY-yn6dnEx0_mqxQKs3ijmkzdmp2P7U7FEgii.webp?r=aef"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 33%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABSyKKo6YI0tqk776fHGQEPezj43pT5u2vVxlgnO351aJ6jcjs81ho6GhSEXduEfSTZtl2lQxxKPERRytTTH8QAYGa7XWDfa_8XpxDEW8aPDeh3DngeuAc1EE2PEB4JI66Q.webp?r=c4e"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 13%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABbRimFoshBDFc5ebs3TXbgMP9qctTPHLzPQ7O2i2LLWdBz7zFhO9Ms5cPZPWmF133AYpF1aDId1zPUClOgQLqs7pMUA.webp?r=c75"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 53%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABbbcHE-dy148R9njiMEgj6EKyGB2sfJTOCVaKVArIWj9BXZKHtAJbkjz_9oWC5M4O-6v8TndPbcncMUefuZFOv9BjQJn56UGmH3DJd9CYQq7FUUFX04HMRyhqRR7TKsGfnfX9SxsOcJNKUeMpXj0Z6LnEmi8OvCGvMWSUKjtW5ixqR7d0mlBBZ91utp-V5daJreOVUxFLuqFPR4s8DSkFDq_.jpg?r=21e"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 23%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUhRCfVdKDRPk5Lw6ObULYqJWyPQ3FBYppCrkalohCc9bQT-m_-F3CfYcLu-4_b_d_kHZAquHLc9zdiGhyEHr_9llQR69LhyJNtdKITHI_zxK06IFCdw5ricIc8H.jpg?r=158"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 43%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABRDH13VvVc4aJ96XHn0AawDgS470J9tz3bpixc3ElJ42dV1eIZQwrf3pxeL19PV4iWKVzz1vjEVwC1AsQAAY-Ez7k6w_0O2W3L0onM5rgIV_ALq5hqQoJGW868I2e6rk9AM5r4aykCQY6Qw8t0IrjxI-d0w.webp?r=e1e"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 50%;"></span></span>
								</div>
							</div>
							<div class="movie">
								<img
									src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABRDH13VvVc4aJ96XHn0AawDgS470J9tz3bpixc3ElJ42dV1eIZQwrf3pxeL19PV4iWKVzz1vjEVwC1AsQAAY-Ez7k6w_0O2W3L0onM5rgIV_ALq5hqQoJGW868I2e6rk9AM5r4aykCQY6Qw8t0IrjxI-d0w.webp?r=e1e"
									alt="">
								<div class="progress">
									<span class="progress-bar"><span role="presentation"
										class="progress-completed" style="width: 50%;"></span></span>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>



	</div>


	<!-- detail  -->


	<!-- 	<button class="video" -->
	<!-- 		data-video="https://clienti.dk/media/1140/friheden-video.mp4" -->
	<!-- 		data-toggle="modal" data-target="#videoModal">Play Video</button> -->

	<div class="modal fade" id="videoModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">



		<div class="modal-body">
			<div class="modal-content">


				<video class="modal-video" src="images/member/love.mp4"
					poster="https://occ-0-2218-1009.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABYlW4dC81I67OWWpvjybrMQfxgF-nMCuPzZb_K7RIYsRV1_QEuYtYJ2tuSelUR57nV_E-MsiNW8IxhEZtzXLCdTycBUN.webp?r=c49"
					autoplay muted>
				</video>
				<div class="test"></div>
				<div class="modal-btn-over"></div>
				<div class="modal-over">
					<button type="button" class="close " data-dismiss="modal"
						aria-label="Close">
						<img alt="" src="images/member/iconmonstr-x-mark-11-240 (1).png">
					</button>
					<img class="modal-webimage"
						src="https://occ-0-988-325.1.nflxso.net/dnm/api/v6/tx1O544a9T7n8Z_G12qaboulQQE/AAAABf2KuOLYvCA8ZctYlCbwe-wvuYjMhhxAWrl1ULZVkFm1q3Npbdcm6t0Kp6qPe-PZM3lLBYBqKL9LUxSz8vLAs-9CJHeVSYIpJnA7TwWt1_0G60764vxN2J9-DDv1eUsw5NACZkEjmju1YCkd3dbBjSauZfB1w_-7OOaQHF2--ocm.webp?r=94c">
					<div class="modal-progress">
						<span class="modal-progress-bar"><span role="presentation"
							class="modal-progress-completed" style="width: 50%;"></span>
							<div class="modal-progress-text">총 55분 중 2분</div></span>
					</div>
					<div class="modal-icon">
						<div class="modal-white-button">
							<i class="fas fa-play"></i> 재생
						</div>
						<div class="modal-icon-position">
							<div class="modal-check-button">
								<i class="fal fa-plus-circle"></i>
							</div>
							<div class="modal-thumbs-up-button">
								<img src="images/member/iconmonstr-thumb-14-240 (1).png">
							</div>
							<div class="modal-thumbs-down-button">
								<img src="images/member/iconmonstr-thumb-20-240.png">
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal-detailMetadata">
				<div class="modal-detailMetadata-left">
					<div class="modal-videoMetadata">92% 일치 2021 A 시즌 2개 A</div>
					<div class="modal-todayrank">A 오늘 한국에서 콘텐츠 순위 9위</div>
					<div class="modal-description">누군가 나를 좋아한다. 그 사람이 나에게 다가오면
						알람이 울린다. 마음을 알려주는 앱 ‘좋알람’의 시대, 힘겹게 살아가는 소녀 조조에게도 풋풋한 사랑이 찾아온다.</div>
				</div>
				<div class="modal-detailMetadata-right">
					<p class="actor">출연: 김소현,정가람,송강,더보기</p>
					<p class="genre">장르: 웹툰 원작 한국 드라마,TV 드라마 , 로맨스,한국 드라마</p>
					<p class="character">프로그램 특징:감상적,풍부한 감정,로맨스</p>

				</div>
			</div>
			<div class="modal-selectHeader">
				<p class="modal-previewsection">회차</p>
				<button class="modal-select-btn">시즌 7</button>
			</div>

			<div class="cardList">
				<div class="section" id="section1">
					<div class="index">1</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">1화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">2</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">2화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">3</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">3화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">4</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">4화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">5</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">5화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">6</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">6화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">7</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">7화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">8</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">8화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">9</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">9화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>
				<div class="section">
					<div class="index">10</div>
					<div class="imageWrapper">
						<img
							src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
						<progress class="titleCard-progress" max="1"
							value="0.03736920777279522"></progress>
					</div>
					<div class="cardtitle">
						<div class="titletext">10화</div>
						<div class="movietime">66분</div>
					</div>
					<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
						고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

				</div>

				<div id="more_content" style="display: none;">
					<div class="section">
						<div class="index">11</div>
						<div class="imageWrapper">
							<img
								src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
							<progress class="titleCard-progress" max="1"
								value="0.03736920777279522"></progress>
						</div>
						<div class="cardtitle">
							<div class="titletext">11화</div>
							<div class="movietime">66분</div>
						</div>
						<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
							고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

					</div>
					<div class="section">
						<div class="index">12</div>
						<div class="imageWrapper">
							<img
								src="https://occ-0-4796-988.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABQppOpQocTc6QS2Jhq-OmFj29ROuwcc0crYP-9zMzImKQ7kg84e5sHUF6HCFao-lztSL8O-0qdJlgE5DAoIOMrYv_GFxWrLb23QKc1_Aa4snXIeO.webp?r=cad">
							<progress class="titleCard-progress" max="1"
								value="0.03736920777279522"></progress>
						</div>
						<div class="cardtitle">
							<div class="titletext">12화</div>
							<div class="movietime">66분</div>
						</div>
						<div class="cardvalue">누가 내 좋알람을 울려줄까? 설레는 친구들과 달리 조조의 하루는
							고단하고 바쁘다. 미국에서 돌아온 선오는 곧바로 혜영을 찾아가지만, 낯선 친구의 모습을 보게 된다.</div>

					</div>
				</div>
				<div class="section-divider collapsed">
					<button class="more_btn" id="button">
						<img id="img" src="images/member/images/more.png">
					</button>

				</div>
			</div>
			<div class="morelikethis-section">비슷한 콘텐츠</div>
			<div class="morelikethis-root">
				<div class="morelikethis-container">
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
					<div class="morelikethis-card-container">
						<img class="cardimg" src="images/member/sisyphus.png">
						<div class="morelikethis-metadata">
							<div class="metadata-left">
								<div class="matchscore">96% 일치</div>
								<div class="rating-year">
									<div class="maturity-rating">15+</div>
									<div class="movie-year">2019</div>
								</div>
							</div>
							<div class="wish-list-button">
								<button aria-label="내가 찜한 콘텐츠에 추가">
									<img src="images/member/plus.png">
								</button>
							</div>
						</div>
						<div class="wish-button"></div>
						<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한 비밀을
							밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
					</div>
				</div>

				<div class="morelikethis-root2">
					<div class="morelikethis-container2">
						<div id="morelikethis" style="display: none;">
							<table>
								<tr>

									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
								</tr>
								<tr>
									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
									<td><div class="morelikethis-card-container">
											<img class="cardimg" src="images/member/sisyphus.png">
											<div class="morelikethis-metadata">
												<div class="metadata-left">
													<div class="matchscore">96% 일치</div>
													<div class="rating-year">
														<div class="maturity-rating">15+</div>
														<div class="movie-year">2019</div>
													</div>
												</div>
												<div class="wish-list-button">
													<button aria-label="내가 찜한 콘텐츠에 추가">
														<img src="images/member/plus.png">
													</button>
												</div>
											</div>
											<div class="wish-button"></div>
											<div class="smalltext">이 세계에 우리가 모르는 존재들이 숨어 살고 있다. 위험한
												비밀을 밝히려는 천재 공학자. 그를 구하기 위해 미래에서 온 여자. 그들이 세상을 바꿀 싸움에 뛰어든다.</div>
										</div></td>
							</table>
						</div>
					</div>
				</div>





				<div class="morelikethis-divider collapsed">
					<button class="more_btn" id="button2">
						<img id="img2" src="images/member/more.png">
					</button>

				</div>
			</div>
			<div class="morelikethis-section" style="padding-bottom: 20px;">좋아하면
				울리는 상세 정보</div>
			<div class="modal-about-container">
				<div class="modal-tags">
					<div class="tag">제작자:</div>
					<div class="tagitem">
						<a href="#">김진우,</a>
					</div>
					<div class="tagitem">
						<a href="#">이나정,</a>
					</div>
					<div class="tagitem">
						<a href="#">공작소 류,</a>
					</div>
					<div class="tagitem">
						<a href="#">이아연,</a>
					</div>
					<div class="tagitem">
						<a href="#">서보라</a>
					</div>
				</div>
				<div class="modal-tags">
					<div class="tag">출연:</div>
					<div class="tagitem">
						<a href="#">김진우,</a>
					</div>
					<div class="tagitem">
						<a href="#">이나정,</a>
					</div>
					<div class="tagitem">
						<a href="#">공작소 류,</a>
					</div>
					<div class="tagitem">
						<a href="#">이아연,</a>
					</div>
					<div class="tagitem">
						<a href="#">서보라</a>
					</div>
				</div>
				<div class="modal-tags">
					<div class="tag">장르:</div>
					<div class="tagitem">
						<a href="#">김진우,</a>
					</div>
					<div class="tagitem">
						<a href="#">이나정,</a>
					</div>
					<div class="tagitem">
						<a href="#">공작소 류,</a>
					</div>
					<div class="tagitem">
						<a href="#">이아연,</a>
					</div>
					<div class="tagitem">
						<a href="#">서보라</a>
					</div>
				</div>
				<div class="modal-tags">
					<div class="tag">프로그램 특징:</div>
					<div class="tagitem">
						<a href="#">김진우,</a>
					</div>
					<div class="tagitem">
						<a href="#">이나정,</a>
					</div>
					<div class="tagitem">
						<a href="#">공작소 류,</a>
					</div>
					<div class="tagitem">
						<a href="#">이아연,</a>
					</div>
					<div class="tagitem">
						<a href="#">서보라</a>
					</div>
				</div>
				<div class="modal-rating-wrapper">
					<div class="tag">관람등급:</div>
					<div class="inline-rating">
						<div class="rating-tags">

							<div class="modal-rating-imgae">
								<img src="images/member/15세이용가.png">
							</div>
							<div class="modal-rating-text">15세이상관람가</div>
						</div>
						<div class="modal-maturity-wrapper">
							<div class="maturity-wrapper">
								<div class="modal-maturity">
									<div class="maturity-img">
										<img src="images/member/선정성1.png">
										<div class="maturity-text">보통</div>
									</div>
								</div>
								<div class="modal-maturity">
									<div class="maturity-img">
										<img src="images/member/폭력성.png">
										<div class="maturity-text">보통</div>
									</div>
								</div>
							</div>
							<div class="maturity-wrapper">
								<div class="modal-maturity">
									<div class="maturity-img">
										<img src="images/member/공포.png">
										<div class="maturity-text">보통</div>
									</div>
								</div>
								<div class="modal-maturity">
									<div class="maturity-img">
										<img src="images/member/모방위험.png">
										<div class="maturity-text">보통</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
</body>
</html>