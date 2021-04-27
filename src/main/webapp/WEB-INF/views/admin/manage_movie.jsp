<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="header.jsp" %>
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
								<button type="button" class="btn btn-info btn-sm">PDF</button>
								<button type="button" class="btn btn-info btn-sm">EXCEL</button>
							</div>

							<div class="col-5">
								<form action="">

									<div class="input-group">
										<div>
											<select class="form-control">
												<option selected value="1">영화</option>
												<option value="2">감독</option>
												<option value="3">장르</option>
											</select>
										</div>
										<input type="text" class="form-control search-input"
											placeholder="검색어 입력">
										<button type="button" class="btn btn-light search-button">
											<i class="fas fa-search text-danger"></i>
										</button>
									</div>

								</form>

							</div>
						</div>
						<div>
						<table class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>썸네일</th>
									<th>제목</th>
									<th>감독</th>
									<th>장르1</th>
									<th>장르2</th>
									<th>상영시간</th>
									<th>개봉일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="movieList" items="${movieList }">
									<tr>
										<th class="align-middle">${movieList.seq }</th>
										<th class="align-middle"><img src="${movieList.poster_path }" alt="" width="130px"></th>
										<th class="align-middle">${movieList.title }</th>
										<th class="align-middle">${movieList.director }</th>
										<th class="align-middle">${movieList.genre1 }</th>
										<th class="align-middle">${movieList.genre2 }</th>
										<th class="align-middle">${movieList.movie_runningtime }분</th>
										<th class="align-middle">${movieList.movie_release_date}</th>
										
										<th class="align-middle"><input type="button" class="btn btn-primary btn-sm" onclick="acyncModifyMoviePage('movie_Modify.mdo', ${movieList.seq })" value="수정">
											<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteMovie" data-seq="${movieList.seq }">삭제</button>
											<button type="button" class="btn btn-success btn-sm">상세보기</button>
										</th>
									</tr>

									<!-- modal -->
									<div class="modal fade" id="deleteMovie">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">영화 삭제</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">해당 영화를 정말 삭제하시겠습니까?</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-success" onclick="acyncDeleteMovie('movieDelete.mdo')" data-dismiss="modal">예</button>
													<button type="button" class="btn btn-danger" data-dismiss="modal">아니오</button>
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
								<li class="page-item"><a href="#"
									class="page-link py-2 px-3"> <span>&laquo;</span>
								</a></li>

								<!-- 페이지 정보 추가 -->
								<li class="page-item active"><a href="#"
									class="page-link py-2 px-3">1</a></li>
								<li class="page-item"><a href="#"
									class="page-link py-2 px-3">2</a></li>
								<li class="page-item"><a href="#"
									class="page-link py-2 px-3">3</a></li>

								<li class="page-item"><a href="#"
									class="page-link py-2 px-3"> <span>&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
					  
					
				</div>


				</div>
			</div>
	</section>
</body>
</html>