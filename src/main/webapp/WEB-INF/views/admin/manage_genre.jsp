<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
						<h3 class="text-muted text-center mb-3">장르</h3>
					</div>
					<div class="row">
						<div class="col-5">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#insertGenre">+장르추가</button>

							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>

							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='genreExcelDown.mdo'">EXCEL</button>

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
												onclick="acyncGenrePdf('genrePdfDown.mdo')" value="PDF저장"
												data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal" onclick="acyncMovePage('manage_genre.mdo')">아니오</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div>
						<table
							class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>장르 ID</th>
									<th>장르명</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="genreList" items="${genreList }">
									<tr>
										<th class="align-middle">${genreList.genre_id }</th>
										<th class="align-middle">${genreList.genre_name }</th>
										<th class="align-middle">
											<button type="button" class="btn btn-primary btn-sm"
												data-toggle="modal" data-target="#modifyGenre"
												data-modid="${genreList.genre_id }"
												data-gname="${genreList.genre_name }">수정</button>
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deleteGenre"
												data-delid="${genreList.genre_id }">삭제</button>
										</th>
									</tr>

									<!-- delete modal -->
									<div class="modal fade" id="deleteGenre">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">장르 삭제</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">해당 장르를 정말 삭제하시겠습니까?</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-success"
														onclick="acyncDeleteGenre('genreDelete.mdo')"
														data-dismiss="modal">예</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">아니오</button>
												</div>
											</div>
										</div>
									</div>
									<!-- insert modal -->
									<div class="modal fade" id="insertGenre">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">새로운 장르 등록</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<form role="form" method="POST" action="">
														<input type="hidden" name="_token" value="">
														<div class="form-group">
															<label class="control-label">장르명</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ins_genre_name" value="">
															</div>
															<br>
															<div>
																<button type="button" class="btn btn-success btn-sm"
																	data-dismiss="modal"
																	onclick="acyncInsertGenre('genreInsert.mdo')">등록</button>
																<button type="button" class="btn btn-danger btn-sm"
																	data-dismiss="modal" onclick="acyncMovePage('manage_genre.mdo')">취소</button>
															</div>
														</div>
													</form>
												</div>

											</div>
										</div>
									</div>
									<!-- modify modal -->
									<div class="modal fade" id="modifyGenre">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">장르명 수정</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<form role="form" method="POST" action="">
														<input type="hidden" name="_token" value="">
														<div class="form-group">
															<label class="control-label">장르명</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="mod_genre_name" value="">
															</div>
															<br>
															<div>
																<button type="button" class="btn btn-success btn-sm"
																	data-dismiss="modal"
																	onclick="acyncModifyGenre('genreModify.mdo')">수정</button>
																<button type="button" class="btn btn-danger btn-sm"
																	data-dismiss="modal">취소</button>
															</div>
														</div>
													</form>
												</div>

											</div>
										</div>
									</div>

								</c:forEach>
							</tbody>
						</table>

					</div>
					
				</div>


			</div>
		</div>
	</section>
</body>
</html>