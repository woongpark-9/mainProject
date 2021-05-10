<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<title>Nowflix</title>

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

	var movieDeleteSeq = "";
	$(document).ready(function() {
		$('#deleteMovie').on('show.bs.modal', function(event) {
			movieDeleteSeq = $(event.relatedTarget).data('delseq');
			// alert(movieDeleteSeq);
			// console.log(movieDeleteSeq);
		});
		$('#detailMovie').on('show.bs.modal', function(event) {
			var title = $(event.relatedTarget).data('title');
			var summary = $(event.relatedTarget).data('summary');
			var actor = $(event.relatedTarget).data('actor');
			var director = $(event.relatedTarget).data('director');
			var genre = $(event.relatedTarget).data('genre');
			var moviepath = $(event.relatedTarget).data('moviepath');
			var posterpath = $(event.relatedTarget).data('posterpath');
			var releasedate = $(event.relatedTarget).data('releasedate');
			var webimage = $(event.relatedTarget).data('webimage');

			// alert(title);
			// console.log(title);
			var modal = $(this);
			modal.find('.modal-videoMetadata').text(title);
			modal.find('.modal-description').text(summary);
			modal.find('.modal-actor').text(actor);
			modal.find('.modal-director').text(director);
			modal.find('.modal-genre').text(genre);
			modal.find('.modal-video').attr('src', moviepath);
			modal.find('.modal-video').attr('poster', posterpath);
			modal.find('.modal-poster').attr('src', posterpath);
			modal.find('.modal-releasedate').text(releasedate);
			modal.find('.modal-webimage').attr('src', webimage);
			modal.find('.morelikethis-section').text(title + " 상세정보");
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

	// 	$(document).ready(function() {
	// 		$(".poster").each(function(i, obj) {
	// 			$(this).on("mouseenter", function() {
	// 				startVideo(i);
	// 			});
	// 			$(".caption").on("mouseleave", function() {
	// 				stopVideo(i);
	// 			})
	// 		});
	// 	});
	// 	function startVideo(i) {
	// 		$(".caption").css("display", "block");
	// 		$(".thevideo").css("display", "block");
	// 		$(".thevideo")[i].play();
	// 	}
	// 	function stopVideo(i) {
	// 		$(".caption").css("display", "none");
	// 		$(".thevideo")[i].pause();
	// 		$(".thevideo")[i].currentTime = 0;
	// 	}
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
		// 		$(".caption").css("display", "block");
		$(".caption").show();
		// 		$(".thevideo").css("display", "block");
		//$(".thevideo")[i].play();
	}

	function stopVideo(i) {
		// 		$(".caption").css("display", "none");
		$(".caption").hide();
		//$(".thevideo")[i].pause();
		//$(".thevideo")[i].currentTime = 0;
	}
	var profile_id = ${profile.profile_id};
	var title = new Array();
	var path = new Array();
	var genre = new Array();
	var actor = new Array();
	var director = new Array();
	var seq = new Array();
	var summary = new Array();
	var releasedate = new Array();

	$(document).ready(function() {
		<c:forEach items="${movieList}" var="movieList">
		title.push("${movieList.title}");
		path.push("${movieList.movie_path}");
		genre.push("${movieList.genre_name}");
		actor.push("${movieList.actor_name}");
		director.push("${movieList.director_name}");
		summary.push("${movieList.summary}");
		seq.push("${movieList.seq}");
		releasedate.push("${movieList.movie_release_date}");
		</c:forEach>
	});

	function startSuggest() {
		var words = $("#search-txt").val();
		var str = '';
		if (words != '') {
			str += '<div class="searchResult">다음과 관련된 콘텐츠: <span class="searchRes">'
					+ words
					+ '</span><br><br></div><div class="col-md-12 searchResult" align="center">';
			for (var i = 0; i < title.length; i++) {
				if (words != '') {
					if (title[i].includes(words) || genre[i].includes(words)
							|| actor[i].includes(words)
							|| director[i].includes(words)) {
						str += '<div class="col-md-2 searchPoster"><a class="video3" data-toggle="modal"'
						 + 'data-target="#detailMovie"'
						 + ' data-summary="' + summary[i]
						 + '" data-title="' + title[i]
						 + '" data-genre="' + genre[i]
						 + '" data-actor="' + actor[i]
						 + '" data-director="' + director[i]
						 + '" data-releasedate="' + releasedate[i]
						 + '" data-moviepath="http://yonom.duckdns.org/movie/' + path[i] + '/1080p.mp4"'
						 + ' data-posterpath="http://yonom.duckdns.org/movie/' + path[i] + '/poster.png"'
						 + 'data-webimage="http://yonom.duckdns.org/movie/' + path[i] + '/title.png">'
						 + '<img class="searchImg" src="'
	                     + 'http://yonom.duckdns.org/movie/'
	                     + path[i] + '/poster.png'
	                     + '" style="width:17vw; height:10vw;"></a></div>';
					}
				}
			}

			str += "</div>";

			//	          $(".test").css("display","none");
			//	          $(".bbbb").html(str);

			$(".test").hide();
			$(".bbbb").html(str);
		} else {
			//	          $(".test").css("display","");
			//	          $('.bbbb').children().remove();
			$(".test").show();
			$('.bbbb').children().remove();
		}
	}
</script>
</head>
<body>
	<c:set var="prefixAddr">http://yonom.duckdns.org/movie/</c:set>


	<div class="home">
		<div class="test">
			<video class="video1" id="video1"
				src="${prefixAddr }${mainMovie.movie_path }/1080p.mp4"
				poster="${prefixAdrr}${mainMovie.movie_path}/poster.png" autoplay
				muted>
			</video>
		</div>
		<div class="overlay">
			<div class="header">
				<!-- 	<div class="logo">NEFLIX</div> -->
				<a
					href="http://localhost:8080/nowflix/index.do?profile_id=${profile.profile_id }"><img
					class="logo" src="images/member/로고.png"
					style="width: 92px; margin-top: 10px;"></a>

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
						<input type="text" class="search-txt" placeholder="제목,사람,장르"
							id="search-txt" onkeyup="startSuggest()" /> <a
							class="search-btn" href="#"> <i class="fas fa-search"></i>
						</a>
					</div>


					<div class="menu-item">
						<div class="dropdown">
							<button class="bell-button">
								<i class="fas fa-bell"></i>
							</button>
							<div class="newlist-content"
								style="overflow-x: hidden; height: 20em;">
								<c:forEach var="recentList" items="${recentList }" varStatus="i">
									<div class="alarm-list">
										<a href="#">
											<div class="alarm-flex">
												<img
													src="${prefixAddr }${recentList.movie_path }/poster.png"
													style="width: 13em; margin-right: 1em; margin-left: 1em;">
												<div class="alarm-summary">
													<div class="new">신규 콘텐츠</div>
													<div class="new">${recentList.title }</div>
													<div class="new-two">${recentDate[i.index] }</div>

												</div>
											</div>
										</a>


									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- 프로필 드롭다운 부분 -->
					<div class="menu-item">
						<div class="dropdown">
							<button class="profile-button">
								<img src="${profile.profile_img }"
									style="width: 3em; height: 3em; margin-right: 1em;">
							</button>
							<div class="dropdown-content">
								<c:forEach var="profileList" items="${profileList }">
									<div class="profile-list">
										<a href="index.do?profile_id=${profileList.profile_id }">
											<img src="${profileList.profile_img }"
											style="width: 2em; height: 2em; margin-right: 1em;">${profileList.profile_name }</a>
									</div>
								</c:forEach>
								<div class="profile-manage">
									<a href="http://localhost:8080/nowflix/profile.do">프로필 관리</a>
								</div>
								<div class="margin"></div>
								<div class="profile-bottom">
									<a href="getSettings.do">계정</a> <a
										href="getInquiryList.do?email=${profile.email }">고객센터</a> <a
										href="logout.do">Nowflix에서 로그아웃하기</a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="bbbb"></div>
			<div class="test" id="test">
				<div class="banner">

					<div class="title">
						<img src="${prefixAddr }${mainMovie.movie_path }/title.png">
					</div>
					<div class="badge"></div>
					<div class="description">${mainMovie.summary }</div>

					<div class="buttons">
						<button
							style="background: 0 0; border: 0; border-radius: 4px; padding: 0;">
							<div class="white-button">
								<i class="fas fa-play"></i> 재생
							</div>
						</button>
						<button
							style="background: 0 0; border: 0; border-radius: 4px; padding: 0;"
							class="detailBtn" data-toggle="modal"
							data-video="https://clienti.dk/media/1140/friheden-video.mp4"
							data-target="#videoModal">


							<div class="gray-button">


								<i class="far fa-info-circle"></i> 상세정보
							</div>
						</button>
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
					</div>

				</div>
				<div class="category-list">
					<div class="category">

						<div class="title">${profile.profile_name }님의 취향저격 베스트 콘텐츠</div>
						<div class="favorite-list">
							<c:forEach var="movieList" items="${favoriteMovieList }">
								<div class="favorite-items">
									<div class="favoriteMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video></div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a type="button" class="video3" data-toggle="modal"
															data-target="#detailMovie"
															data-summary="${movieList.summary }"
															data-title="${movieList.title }"
															data-genre="${movieList.genre_name }"
															data-actor="${movieList.actor_name }"
															data-director="${movieList.director_name }"
															data-moviepath="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/1080p.mp4"
															data-posterpath="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/poster.png"
															data-releasedate="${movieList.movie_release_date }"
															data-webimage="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/title.png">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
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

				</div>
				<div class="category-list">
					<div class="category">
						<c:if test="${not empty watchMovieList}">
							<div class="title">${profile.profile_name }님이시청중인콘텐츠</div>
							<div class="watch-list">
								<c:forEach var="movieList" items="${watchMovieList }">
									<div class="watch-items">
										<div class="watchMovieList-item">
											<div class="poster">
												<img src="${prefixAddr }${movieList.movie_path }/poster.png"
													alt="">

												<c:forEach var="watchList" items="${watchList }">
													<c:if test="${movieList.seq eq watchList.movie_id}">
														<div class="progress">
															<span class="progress-bar"> <span
																role="presentation" class="progress-completed"
																style="width: ${(watchList.view_point + 0.0) / (watchList.duration + 0.0) * 100}%;"></span>
															</span>
														</div>
													</c:if>
												</c:forEach>
											</div>
											<div id="caption" class="caption" style="display: none;">
												<div class="preview">
													<div class=video>
														<!-- 													<video id="thevideo" style="display: none;" -->
														<!-- 														class="thevideo" -->
														<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
														<!-- 														muted> -->
														<!-- 														<source -->
														<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
														<!-- 													</video> -->
														<!-- 													<div class="thevideo" style="display: none;"> -->
														<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
													</div>
												</div>

												<div class="detail">
													<div class="detailFirst">
														<div class="play-button">
															<a
																href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
																<img
																src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
																width="40vw" height="auto">
															</a>
														</div>
														<div class="detail-button">
															<a href="#"> <img
																src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
																width="30vw" height="auto">
															</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

								</c:forEach>
							</div>
						</c:if>
					</div>


				</div>
				<div class="category-list">
					<div class="category">

						<div class="title">미국 영화</div>
						<div class="usa-list">
							<c:forEach var="movieList" items="${usaMovieList }">
								<div class="usa-items">
									<div class="usaMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

				</div>


				<div class="category-list">
					<div class="category">

						<div class="title">애니메이션 영화</div>
						<div class="ani-list">
							<c:forEach var="movieList" items="${animationList }">
								<div class="ani-items">
									<div class="aniMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

				</div>





				<div class="category-list">
					<div class="category">

						<div class="title">한국 영화</div>
						<div class="korea-list">
							<c:forEach var="movieList" items="${koreaMovieList }">
								<div class="korea-items">
									<div class="koreaMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>
											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

				</div>
				<div class="category-list">
					<div class="category">

						<div class="title">SF·미래 영화</div>
						<div class="sf-list">
							<c:forEach var="movieList" items="${sfMovieList }">
								<div class="sf-items">
									<div class="sfMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

				</div>
				<div class="category-list">
					<div class="category">

						<div class="title">로맨스 영화</div>
						<div class="romance-list">
							<c:forEach var="movieList" items="${romanceMovieList }">
								<div class="romance-items">
									<div class="romanceMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

				</div>
				<div class="category-list">
					<div class="category">

						<div class="title">액션 영화</div>
						<div class="action-list">
							<c:forEach var="movieList" items="${actionMovieList }">
								<div class="action-items">
									<div class="actionMovieList-item">

										<div class="poster">
											<img src="${prefixAddr }${movieList.movie_path }/poster.png"
												alt="">
										</div>
										<div id="caption" class="caption" style="display: none;">
											<div class="preview">
												<div class=video>
													<!-- 													<video id="thevideo" style="display: none;" -->
													<!-- 														class="thevideo" -->
													<%-- 														poster="${prefixAddr }${movieList.movie_path }/poster.png" --%>
													<!-- 														muted> -->
													<!-- 														<source -->
													<%-- 															src="${prefixAddr }${movieList.movie_path }/1080p.mp4"> --%>
													<!-- 													</video> -->
													<!-- 													<div class="thevideo" style="display: none;"> -->
													<%-- 													<img src="${prefixAddr }${movieList.movie_path }/poster.png" ></div> --%>
												</div>
											</div>

											<div class="detail">
												<div class="detailFirst">
													<div class="play-button">
														<a
															href="getPlayer.do?seq=${movieList.seq }&profile_id=${profile.profile_id}">
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/play-button.png"
															width="40vw" height="auto">
														</a>
													</div>
													<div class="detail-button">
														<a href="#"> <img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30vw" height="auto">
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

	<div class="modal fade" id="detailMovie" tabindex="-1" role="dialog"
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
					<!-- 					<div class="modal-progress"> -->
					<!-- 						<span class="modal-progress-bar"><span role="presentation" -->
					<!-- 							class="modal-progress-completed" style="width: 50%;"></span> -->
					<!-- 							<div class="modal-progress-text">총 55분 중 2분</div></span> -->
					<!-- 					</div> -->
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
					감독 :
					<div class="modal-director"></div>
					출연:
					<div class="modal-actor"></div>
					장르:
					<div class="modal-genre"></div>

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