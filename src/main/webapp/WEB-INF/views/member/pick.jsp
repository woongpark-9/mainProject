<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="prefixAddr">http://yonom.duckdns.org/movie/</c:set>

	<div class="favorite-list">
							<c:forEach var="movieList" items="${pickMovieList }">
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
													<div class="detail-button">${movieList.seq }
														<button type="button" class="video3" data-toggle="modal"
															data-target="#detailMovie"
															data-detail="${movieList.seq }"
															data-summary="${movieList.summary }"
															data-title="${movieList.title }"
															data-genre="${movieList.genre_name }"
															data-actor="${movieList.actor_name }"
															data-director="${movieList.director_name }"
															data-profile_id="${profile.profile_id }"
															data-moviepath="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/1080p.mp4"
															data-posterpath="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/poster.png"
															data-releasedate="${movieList.movie_release_date }"
															data-webimage="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/title.png" ><%--                                  data-cardimg ="http://nowflix.yonom.duckdns.org:1510/movie/${movieList.movie_path }/poster.png" --%>
                                   
															<img
															src="http://nowflix.yonom.duckdns.org:1510/images/member/plus-button.png"
															width="30px" height="30px">
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>
						</div>
</body>
</html>