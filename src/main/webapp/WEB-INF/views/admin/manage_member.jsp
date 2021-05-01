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
					<div>
						<div class="col-12">
							<h3 class="text-muted text-center mb-3">회원 리스트</h3>
						</div>
						<div class="row">
							<div class="col-7">
								<button type="button" class="btn btn-primary btn-sm"
									onclick="acyncMovePage('member_insert.mdo')">+회원추가</button>

								<button type="button" class="btn btn-info btn-sm"
									data-toggle="modal" data-target="#memberpdf">PDF</button>

								<button type="button" class="btn btn-info btn-sm"
									onclick="location.href='memberExcelDown.mdo'">EXCEL</button>

								<div class="modal fade" id="memberpdf">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title">PDF 경로 지정</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<div class="modal-body">
												PDF파일 이름을 적어주세요 예)TEST <br> <input type="text"
													class="form-control input-lg" id="newmemberpdf" value="">
											</div>

											<div class="modal-footer">
												<input type="button" class="btn btn-success"
													onclick="acync_member_pdf('memberPdfDown.mdo')"
													value="PDF저장" data-dismiss="modal">
												<button type="button" class="btn btn-danger"
													data-dismiss="modal">아니오</button>
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
												<option selected value="email">이메일</option>
												<option value="nickname">닉네임</option>
											</select>
										</div>

										<input type="text" class="form-control search-input"
											name="searchKeyword" placeholder="검색어 입력">

										<button type="button" class="btn btn-light search-button"
											onclick="acyncConditionMovePage('manage_member.mdo')">
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
										<th>닉네임</th>
										<th>나이</th>
										<th>성별</th>
										<th>이용권</th>
										<th>본인인증</th>
										<th>계정상태</th>
										<th>가입일</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="memberList" items="${memberList }">
										<tr>
											<th class="align-middle">${memberList.rownum }</th>
											<th class="align-middle">${memberList.email }</th>
											<th class="align-middle">${memberList.nickname }</th>
											<th class="align-middle">${memberList.age }</th>
											<th class="align-middle">${memberList.gender }</th>
											<th class="align-middle">${memberList.ticket_id }</th>
											<th class="align-middle">${memberList.cert }</th>
											<th class="align-middle">${memberList.ban}</th>
											<th class="align-middle">${memberList.join_date}</th>


											<th><input type="button" class="btn btn-primary btn-sm"
												onclick="acyncModifyMemberPage('member_Modify.mdo', ${memberList.seq })"
												value="수정"></th>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<!-- page -->
							<nav>
								<ul class="pagination justify-content-center">
									<!-- 현재 페이지가 0보다 작아질 경우 이전 버튼을 disabled하는 조건문 -->
									<c:choose>
										<c:when test="${nowPage <= 0}">
											<li class="disabled page-item"><a href="#"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:when>
										<c:otherwise>
											<c:if test="${searchCondition eq null }">
												<li class="page-item"><a
													onclick="acyncNowPage1('manage_member.mdo', ${nowPage-1})"
													class="page-link py-2 px-3"> <span>&laquo;</span>
												</a></li>
											</c:if>
											<c:if test="${searchCondition ne null }">
												<li class="page-item"><a
													onclick="acyncNowPage2('manage_member.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
													class="page-link py-2 px-3"> <span>&laquo;</span>
												</a></li>
											</c:if>
										</c:otherwise>
									</c:choose>

									<!-- 해당하는 페이지로 갈 수 있는 버튼 -->
									<c:if test="${totalPage < 0}">
										<c:forEach var="i" begin="${startPage}" end="${totalPage+1}">
											<c:choose>
												<c:when test="${i eq nowPage}">
													<c:if test="${searchCondition eq null }">
														<li class="page-item active"><a
															onclick="acyncNowPage1('manage_member.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_member.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
																onclick="acyncNowPage1('manage_member.mdo', ${i})"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
														<c:if test="${searchCondition ne null }">
															<li class="page-item active"><a
																onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
													</c:when>
													<c:otherwise>
														<c:if test="${searchCondition eq null }">
															<li class="page-item"><a
																onclick="acyncNowPage1('manage_member.mdo', ${i})"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
														<c:if test="${searchCondition ne null }">
															<li class="page-item"><a
																onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
																onclick="acyncNowPage1('manage_member.mdo', ${i})"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
														<c:if test="${searchCondition ne null }">
															<li class="page-item active"><a
																onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
													</c:when>
													<c:otherwise>
														<c:if test="${searchCondition eq null }">
															<li class="page-item"><a
																onclick="acyncNowPage1('manage_member.mdo', ${i})"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
														<c:if test="${searchCondition ne null }">
															<li class="page-item"><a
																onclick="acyncNowPage2('manage_member.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
																class="page-link py-2 px-3">${i+1}</a></li>
														</c:if>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</c:if>


									<!-- 현재 페이지가 totalPage보다 커질 경우 다음 버튼을 disabled하는 조건문 -->
									<c:choose>
										<c:when test="${nowPage >= totalPage }">
											<li class="disabled page-item"><a href="#"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:when>
										<c:otherwise>
											<c:if test="${searchCondition eq null }">
												<li class="page-item"><a
													onclick="acyncNowPage1('manage_member.mdo', ${nowPage+1})"
													class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
											</c:if>
											<c:if test="${searchCondition ne null }">
												<li class="page-item"><a
													onclick="acyncNowPage2('manage_member.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
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
		</div>
	</section>
</body>
</html>