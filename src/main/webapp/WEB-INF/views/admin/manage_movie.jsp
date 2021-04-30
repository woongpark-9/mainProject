<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="header.jsp"%>
</head>

<body>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">영화 리스트</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<button type="button" class="btn btn-primary btn-sm"
								onclick="acyncMovePage('movie_insert.mdo')">+영화추가</button>

							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>

							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='movieExcelDown.mdo'">EXCEL</button>

							<div class="modal fade" id="testpdf">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">PDF 경로 지정</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<div class="modal-body">
											PDF파일 이름을 적어주세요 예)TEST <br> <input type="text"
												class="form-control input-lg" id="newpdf" value="">
										</div>

										<div class="modal-footer">
											<input type="button" class="btn btn-success"
												onclick="acyncpdf('moviePdfDown.mdo')" value="PDF저장"
												data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal"
												onclick="acyncMovePage('manage_movie.mdo')">아니오</button>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-5">
							<form name="insertConditionForm" id="insertConditionForm">

								<div class="input-group">
									<div>

										<select class="form-control" name="searchCondition">
											<option selected value="TITLE">영화</option>
											<option value="DIRECTOR">감독</option>
											<option value="GENRE">장르</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_movie.mdo')">
										<i class="fas fa-search text-danger"></i>
									</button>
								</div>

							</form>

						</div>
					</div>
					<div>
						<table
							class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>썸네일</th>
									<th>제목</th>
									<th>감독</th>
									<th>장르</th>
									<th>상영시간</th>
									<th>개봉일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="movieList" items="${movieList }">
									<tr>
										<th class="align-middle">${movieList.seq }</th>
										<th class="align-middle"><img
											src="http://yonom.duckdns.org/movie/${movieList.movie_path }/poster.png"
											alt="" width="130px"></th>
										<th class="align-middle">${movieList.title }</th>
										<th class="align-middle">${movieList.director_name }</th>
										<th class="align-middle">${movieList.genre_name }</th>
										<th class="align-middle">${movieList.movie_runningtime }분</th>
										<th class="align-middle">${movieList.movie_release_date}년</th>
										<th class="align-middle"><input type="button"
											class="btn btn-primary btn-sm"
											onclick="acyncModifyMoviePage('movie_Modify.mdo', ${movieList.seq })"
											value="수정">
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deleteMovie"
												data-delseq="${movieList.seq }">삭제</button>

											<button type="button" class="btn btn-success btn-sm"
												class="video" data-toggle="modal" data-target="#detailMovie"
												data-summary="${movieList.summary }"
												data-title="${movieList.title }"
												data-genre="${movieList.genre_name }"
												data-actor="${movieList.actor_name }"
												data-director="${movieList.director_name }"
												data-moviepath="http://yonom.duckdns.org/movie/${movieList.movie_path }/1080p.mp4"
												data-posterpath="http://yonom.duckdns.org/movie/${movieList.movie_path }/poster.png"
												data-releasedate="${movieList.movie_release_date }">상세보기</button>

										</th>

									</tr>

									<!-- delete modal -->
									<div class="modal fade" id="deleteMovie">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">영화 삭제</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">해당 영화를 정말 삭제하시겠습니까?</div>
												<div class="modal-footer">
													<input type="button" class="btn btn-success"
														onclick="acyncDeleteMovie('movieDelete.mdo')" value="예"
														data-dismiss="modal">
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">아니오</button>
												</div>
											</div>
										</div>
									</div>

									<!-- detail modal -->
									<div class="modal fade" id="detailMovie" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">

										<div class="modal-dialog modal-fullsize">
											<div class="modal-body" id="detailMovieBody">
												<div class="modal-content modal-fullsize" style="background-color: black">
													<div>
														<div class="content-right" id="closingBtn">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>

													</div>

													<video class="modal-video" poster="" autoplay muted width="1080px">
														<source src="" type="video/mp4">
													</video>
													<div class="modal-btn-over"></div>
													<div class="modal-over"></div>
<!-- 													<div> -->
<!-- 														<img class="modal-poster" width="400px" alt="" src=""> -->
<!-- 													</div> -->
													<div class="modal-detailMetadata"
														style="background-color: black">

														<div class="modal-detailMetadata-left">

															<div class="modal-videoMetadata"></div>
															<div class="modal-todayrank"></div>
															<div class="modal-description"></div>
														</div>
														<div class="modal-detailMetadata-right">
															<div>
																개봉일 : <strong class="modal-releasedate"></strong>
															</div>
															<div>
																출연 : <strong class="modal-actor"></strong>
															</div>
															<div>
																감독 : <strong class="modal-director"></strong>
															</div>
															<div>
																장르 : <strong class="modal-genre"></strong>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>

							</tbody>
						</table>

						<!-- page -->
						<nav>
							<ul class="pagination justify-content-center">
								<!--현재 페이지가 0보다 작아질 경우 이전 버튼을 disabled하는 조건문 -->
								<c:choose>
									<c:when test="${nowPage <= 0}">
										<li class="disabled page-item"><a href="#"
											class="page-link py-2 px-3"> <span>&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<c:if test="${searchCondition eq null }">
											<li class="page-item"><a
												onclick="acyncNowPage1('manage_movie.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_movie.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
									</c:otherwise>
								</c:choose>

								<!--해당하는 페이지로 갈 수 있는 버튼 -->
								<c:if test="${totalPage < 0}">
									<c:forEach var="i" begin="${startPage}" end="${totalPage+1}">
										<c:choose>
											<c:when test="${i eq nowPage}">
												<c:if test="${searchCondition eq null }">
													<li class="page-item active"><a
														onclick="acyncNowPage1('manage_movie.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_movie.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>


								<c:if test="${totalPage >= 0}">
									<c:if test="${totalPage >= endPage }">
										<c:forEach var="i" begin="${startPage}" end="${endPage}">
											<c:choose>
												<c:when test="${i eq nowPage}">
													<c:if test="${searchCondition eq null }">
														<li class="page-item active"><a
															onclick="acyncNowPage1('manage_movie.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_movie.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>

									<c:if test="${totalPage < endPage }">
										<c:forEach var="i" begin="${startPage}" end="${totalPage}">
											<c:choose>
												<c:when test="${i eq nowPage}">
													<c:if test="${searchCondition eq null }">
														<li class="page-item active"><a
															onclick="acyncNowPage1('manage_movie.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_movie.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_movie.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>
								</c:if>


								<!--현재 페이지가 totalPage보다 커질 경우 다음 버튼을 disabled하는 조건문 -->
								<c:choose>
									<c:when test="${nowPage >= totalPage }">
										<li class="disabled page-item"><a href="#"
											class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
									</c:when>
									<c:otherwise>
										<c:if test="${searchCondition eq null }">
											<li class="page-item"><a
												onclick="acyncNowPage1('manage_movie.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_movie.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>