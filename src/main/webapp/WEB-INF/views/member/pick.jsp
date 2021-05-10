<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="prefixAddr">http://yonom.duckdns.org/movie/</c:set>
	<div class="col-md-12 searchResult"><span class="searchRes">내가 찜한 컨텐츠 </span><br><br></div>
	<div class="col-md-12 pick-list">
		<c:forEach var="movieList" items="${pickMovieList }">
			<div class="col-md-2 pick-lists" style="cursor: pointer;">
			<a class="video3" data-toggle="modal"
			data-target="#detailMovie"
			data-detail="${movieList.seq }"
			data-summary="${movieList.summary }"
			data-title="${movieList.title }"
			data-genre="${movieList.genre_name }"
			data-actor="${movieList.actor_name }"
			data-director="${movieList.director_name }"
			data-profile_id="${profile.profile_id }"
			data-moviepath="http://yonom.duckdns.org/movie/${movieList.movie_path }/1080p.mp4"
			data-posterpath="http://yonom.duckdns.org/movie/${movieList.movie_path }/poster.png"
			data-releasedate="${movieList.movie_release_date }"
			data-webimage="http://yonom.duckdns.org/movie/${movieList.movie_path }/title.png" >
			<img src="${prefixAddr }${movieList.movie_path }/poster.png" style="width:17vw; height:10vw;">
			</a></div>
		</c:forEach>
	</div>