<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="header.jsp"%>
<script>
	var opt_genre_name = [];
	var opt_director_name = [];
	var opt_movie_rating = [];
	var opt_actor_name = [];
	var opt_country = [];
	var opt_is_active = [];
	var opt_is_main = [];

	var str_genre_name = '${movieModifyInfo.genre_name }';
	var str_director_name = '${movieModifyInfo.director_name }';
	var str_movie_rating = '${movieModifyInfo.movie_rating }';
	var str_actor_name = '${movieModifyInfo.actor_name }';
	var str_country = '${movieModifyInfo.country }';
	var str_is_active = '${movieModifyInfo.is_active }';
	var str_is_main = '${movieModifyInfo.is_main }';	
	

	var arr_genre_name = str_genre_name.split(','); // ','을 기준으로 나눠서 배열을 반환
	for (a in arr_genre_name)
		opt_genre_name.push(arr_genre_name[a]);

	opt_director_name.push(str_director_name);

	opt_movie_rating.push(str_movie_rating);

	var arr_actor_name = str_actor_name.split(','); // ','을 기준으로 나눠서 배열을 반환
	for (a in arr_actor_name)
		opt_actor_name.push(arr_actor_name[a]);

	opt_country.push(str_country);

	opt_is_active.push(str_is_active);

	opt_is_main.push(str_is_main);

	$(document).ready(function() {		
		$('#genre_name').selectpicker('val', opt_genre_name);
		$('#director_name').selectpicker('val', opt_director_name);
		$('#movie_rating').selectpicker('val', opt_movie_rating);
		$('#actor_name').selectpicker('val', opt_actor_name);
		$('#country').selectpicker('val', opt_country);
		$('#is_active').selectpicker('val', opt_is_active);
		$('#is_main').selectpicker('val', opt_is_main);
	});

</script>
</head>
<body>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div>
						<button type="button" class="btn btn-info btn-sm"
							onclick="acyncMovePage('manage_movie.mdo')">뒤로가기</button>

						<section>
							<div class="col-12 justify-content-center">
								<h3 class="text-muted text-center mb-3">
									영화
									<c:if test="${movieModifyInfo eq null }"> 등록</c:if>
									<c:if test="${movieModifyInfo ne null }"> 수정</c:if>
								</h3>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">

										<!-- card 전체 div -->
										<form name="insertMovieForm" id="insertMovieForm">
											<c:if test="${movieModifyInfo ne null }">
												<input type="hidden" id="seq" name="seq"
													value="${movieModifyInfo.seq }">
											</c:if>

											<div class="row pt-md-5 mt-md-3 mb-5">
												<div class="col-xl-3 col-sm-6 p-2">
													<div class="card card-common">
														<div class="card-body">
															<div class="d-flex">
																<div class="text-left text-secondary">
																	<div>
																		<label for="title">제목</label> <input type="text"
																			class="form-control" id="title" name="title"
																			value="${movieModifyInfo.title }">
																	</div>
																	<br>
																	<div>
																		<label for="subtitle">소제목</label> <input type="text"
																			class="form-control" id="subtitle" name="subtitle"
																			value="${movieModifyInfo.subtitle }">
																	</div>
																	<br>

																	<div class="form-group">
																		<label for="summary">줄거리</label>
																		<textarea class="form-control rounded-0" id="summary"
																			name="summary" rows="3">${movieModifyInfo.summary }</textarea>
																	</div>

																	<div>
																		<label for="movie_path">영화 폴더</label> <input
																			type="text" class="form-control" id="movie_path"
																			name="movie_path"
																			value="${movieModifyInfo.movie_path }">
																	</div>
																	<br>

																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="col-xl-4 col-sm-6 p-2">
													<div class="card card-common">
														<div class="card-body">
															<div class="d-flex">
																<div class="text-left text-secondary">
																	<div>
																		<label for="genre_name">장르</label> <select
																			class="form-control" id="genre_name"
																			name="genre_name" multiple data-live-search="true"
																			data-size="5" title="선택해 주세요" data-width="330px"
																			data-max-options="3">
																			<c:forEach var="genreList" items="${genreList }">
																				<option value="${genreList.genre_name }">${genreList.genre_name }</option>
																			</c:forEach>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="director_name">감독</label> <select
																			class="form-control" id="director_name"
																			name="director_name" data-live-search="true"
																			data-size="5" title="선택해 주세요" >
																			<c:forEach var="directorList" items="${directorList }">
																				<option value="${directorList.director_name }">${directorList.director_name }</option>
																			</c:forEach>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="actor_name">배우</label> <select
																			class="form-control" id="actor_name"
																			name="actor_name" multiple data-live-search="true"
																			data-size="5" title="선택해 주세요" data-max-options="3">
																			<c:forEach var="actorList" items="${actorList }">
																				<option value="${actorList.actor_name }">${actorList.actor_name }</option>
																			</c:forEach>
																		</select>
																	</div>
																	<br>


																	<div>
																		<label for="movie_rating">연령 제한</label> <select
																			class="form-control" id="movie_rating"
																			name="movie_rating" title="선택해 주세요">
																			<option value="전체">전체 관람가</option>
																			<option value="12">12세 이상 관람가</option>
																			<option value="15">15세 이상 관람가</option>
																			<option value="19">19세 이상 관람가</option>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="country">국가</label> <select
																			class="form-control" id="country" name="country"
																			title="선택해 주세요">
																			<option value="한국">한국</option>
																			<option value="미국">미국</option>
																			<option value="영국">영국</option>
																			<option value="일본">일본</option>
																		</select>
																	</div>
																	<br>


																</div>
															</div>

														</div>

													</div>
												</div>
												<div class="col-xl-3 col-sm-6 p-2">
													<div class="card card-common">
														<div class="card-body">
															<div class="d-flex">
																<div class="text-left text-secondary">
																	<div>
																		<label for="movie_release_date">개봉연도</label> <input
																			type="text" class="form-control"
																			id="movie_release_date" name="movie_release_date"
																			value="${movieModifyInfo.movie_release_date }">
																	</div>
																	<br>
																	<div>
																		<label for="movie_runningtime">상영 시간</label> <input
																			type="text" class="form-control"
																			id="movie_runningtime" name="movie_runningtime"
																			value="${movieModifyInfo.movie_runningtime }">
																	</div>
																	<br>
																	<div>
																		<label for="is_active">활성화 여부</label> <select
																			class="form-control" id="is_active" name="is_active" title="선택해 주세요">
																			<option value="1">비활성화</option>
																			<option value="2">활성화</option>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="is_main">메인 지정 여부</label> <select
																			class="form-control" id="is_main" name="is_main" title="선택해 주세요">
																			<option value="1">NO</option>
																			<option value="2">YES</option>
																		</select>
																	</div>
																	<br>

																	<div>
																		<c:if test="${movieModifyInfo == null}">
																			<button type="button" class="btn btn-success btn-sm"
																				onclick="acyncInsertMovie('movieInsert.mdo')">등록하기</button>
																		</c:if>
																		<c:if test="${movieModifyInfo != null}">
																			<button type="button" class="btn btn-success btn-sm"
																				onclick="acyncModifyMovie('movieModify.mdo')">수정하기</button>
																		</c:if>
																		<button type="button" class="btn btn-danger btn-sm"
																			onclick="acyncMovePage('manage_movie.mdo')">취소</button>
																	</div>
																</div>
															</div>

														</div>

													</div>
												</div>

											</div>
										</form>
										<!-- card 전체 div 끝 -->
									</div>
								</div>
							</div>
						</section>
					</div>

				</div>
			</div>
		</div>
	</section>

</body>
</html>