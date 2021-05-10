<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배우 관리</title>
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
						<h3 class="text-muted text-center mb-3">영화배우</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#insertActor">+배우추가</button>
							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>
							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='actorExcelDown.mdo'">EXCEL</button>

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
												onclick="acyncActorPdf('actorPdfDown.mdo')" value="PDF저장"
												data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal" onclick="acyncMovePage('manage_actor.mdo')">아니오</button>
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
											<option selected value="actor_name">이름</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_actor.mdo')">
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
									<th>이름</th>
									<th>생년월일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="actorList" items="${actorList }">

									<tr>
										<th class="align-middle">${actorList.actor_id }</th>
										<th class="align-middle">${actorList.actor_name }</th>
										<th class="align-middle">${actorList.actor_birth }</th>
										<th class="align-middle">
											<button type="button" class="btn btn-primary btn-sm"
												data-toggle="modal" data-target="#modifyActor"
												data-modid="${actorList.actor_id }" 
												data-aname="${actorList.actor_name }"
												data-abirth="${actorList.actor_birth }">수정</button>
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deleteActor"
												data-delid="${actorList.actor_id }">삭제</button>
										</th>
									</tr>

									<!-- delete modal -->
									<div class="modal fade" id="deleteActor">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">배우 삭제</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">해당 배우를 정말 삭제하시겠습니까?</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-success"
														onclick="acyncDeleteActor('actorDelete.mdo')"
														data-dismiss="modal">예</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">아니오</button>
												</div>
											</div>
										</div>
									</div>
									<!-- insert modal -->
									<div class="modal fade" id="insertActor">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">배우 추가</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<form role="form" method="POST" action="">
														<input type="hidden" name="_token" value="">
														<div class="form-group">
															<label class="control-label">배우명</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ins_actor_name">
															</div>
															<br> <label class="control-label">생년월일</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ins_actor_birth">
															</div>
															<br>
															<div>
																<button type="button" class="btn btn-success"
																	data-dismiss="modal"
																	onclick="acyncInsertActor('actorInsert.mdo')">등록</button>
																<button type="button" class="btn btn-danger"
																	data-dismiss="modal" onclick="acyncMovePage('manage_actor.mdo')">취소</button>
															</div>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
									<!-- modify modal -->
									<div class="modal fade" id="modifyActor">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">배우 수정</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<form role="form" method="POST" action="">
														<input type="hidden" name="_token" value="">
														<div class="form-group">
															<label class="control-label">배우명</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="mod_actor_name" value="">
															</div>
															<br> <label class="control-label">생년월일</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="mod_actor_birth" value="">
															</div>
															<br>
															<div>
																<button type="button" class="btn btn-success"
																	data-dismiss="modal"
																	onclick="acyncModifyActor('actorModify.mdo')">수정</button>
																<button type="button" class="btn btn-danger"
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
												onclick="acyncNowPage1('manage_actor.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_actor.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
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
														onclick="acyncNowPage1('manage_actor.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_actor.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
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
															onclick="acyncNowPage1('manage_actor.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_actor.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
															onclick="acyncNowPage1('manage_actor.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_actor.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_actor.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
												onclick="acyncNowPage1('manage_actor.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_actor.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
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