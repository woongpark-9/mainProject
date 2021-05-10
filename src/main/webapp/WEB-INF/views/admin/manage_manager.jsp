<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>관리자 관리</title>
<%@ include file="header.jsp"%>
</head>

<body>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">관리자 목록</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#insertManager">+관리자추가</button>

							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>
							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='managerExcelDown.mdo'">EXCEL</button>
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
												onclick="acyncManagerPdf('managerPdfDown.mdo')"
												value="PDF저장" data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal"
												onclick="acyncMovePage('manage_manager.mdo')">아니오</button>
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
											<option selected value="EMAIL">이메일</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_manager.mdo')">
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
									<th>이메일</th>
									<th>등급</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="managerList" items="${managerList }">
									<tr>
										<th>${managerList.rownum }</th>
										<th>${managerList.manager_email }</th>
										<th>${managerList.manager_type }</th>
										<th>${managerList.manager_regdate }</th>
										<th>
											<button type="button" class="btn btn-primary btn-sm"
												data-toggle="modal" data-target="#modifyManager"
												data-modifyid="${managerList.manager_id }"
												data-modifyemail="${managerList.manager_email }"
												data-modifypass="${managerList.manager_pass}"
												data-modifytype="${managerList.manager_type }">수정</button>
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deleteManager"
												data-delid="${managerList.manager_id }">삭제</button>
										</th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- modify modal -->
						<div class="modal fade" id="modifyManager">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">관리자 수정</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											
											<div>
												<label for="manager_email">이메일</label>
													<input type="text"
													class="form-control input-lg modifyManagerEmailInput"
													id="modifyManagerEmailInput" name="manager_email">
											</div>
											<br> 
											
											<div>
												<label for="manager_pass">패스워드</label>
													<input type="password"
														class="form-control input-lg modifyManagerPassInput"
														id="modifyManagerPassInput" name="manager_pass">
											</div>
											<br> 
											
											<div>
												<label for="manager_type">등급</label>
												<select class="form-control"
													id="modifyManagerTypeInput" name="manager_type" title="등급">
													<option value="일반 관리자">일반 관리자</option>
													<option value="최고 관리자">최고 관리자</option>
												</select>
											</div>
											<br>
											<div>
												<button type="button" class="btn btn-success"
													data-dismiss="modal"
													onclick="acyncModifyManager('managerModify.mdo')">수정</button>
												<button type="button" class="btn btn-danger"
													data-dismiss="modal">취소</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- delete modal -->
						<div class="modal fade" id="deleteManager">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">관리자 삭제</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">해당 관리자를 정말 삭제하시겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success"
											data-dismiss="modal"
											onclick="acyncDeleteManager('managerDelete.mdo')">예</button>
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">아니오</button>
									</div>
								</div>
							</div>
						</div>
						<!-- insert modal -->
						<div class="modal fade" id="insertManager">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">관리자 추가</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<form name="insertManagerForm" id="insertManagerForm">
											<div class="form-group">
												
												<div>
													<label for="manager_email">이메일</label>
													<input type="text" class="form-control input-lg"
														name="manager_email">
												</div>
												<br> 
												<div>
													<label for="manager_pass">패스워드</label>
													<input type="password" class="form-control input-lg"
														name="manager_pass">
												</div>
												<br> 
												<div>
													<label for="manager_type">등급</label>
													<select class="form-control" id="manager_type" name="manager_type" title="등급">
														<option value="일반 관리자">일반 관리자</option>
														<option value="최고 관리자 ">최고 관리자</option>
													</select>
												</div>
												<br>
												<div>
													<button type="button" class="btn btn-success"
														data-dismiss="modal"
														onclick="acyncInsertManager('managerInsert.mdo')">등록</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal"
														onclick="acyncMovePage('manage_manager.mdo')">취소</button>
												</div>
											</div>
										</form>
									</div>

								</div>
							</div>
						</div>
						
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
												onclick="acyncNowPage1('manage_manager.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_manager.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
									</c:otherwise>
								</c:choose>

								<!--해당하는 페이지로 갈 수 있는 버튼 -->
								<c:if test="${totalPage < 0}">
									<c:forEach var="i" begin="0" end="${totalPage+1}">
										<c:choose>
											<c:when test="${i eq nowPage}">
												<c:if test="${searchCondition eq null }">
													<li class="page-item active"><a
														onclick="acyncNowPage1('manage_manager.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_manager.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_manager.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_manager.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>


								<c:if test="${totalPage >= 0}">
									<c:forEach var="i" begin="0" end="${totalPage}">
										<c:choose>
											<c:when test="${i eq nowPage}">
												<c:if test="${searchCondition eq null }">
													<li class="page-item active"><a
														onclick="acyncNowPage1('manage_manager.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_manager.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_manager.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_manager.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:forEach>
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
												onclick="acyncNowPage1('manage_manager.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_manager.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
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