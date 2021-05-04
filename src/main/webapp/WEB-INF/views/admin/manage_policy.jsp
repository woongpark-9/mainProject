<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>이용약관</title>
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
						<h3 class="text-muted text-center mb-3">이용약관</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#insertPolicy">+약관추가</button>
							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>
							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='policyExcelDown.mdo'">EXCEL</button>
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
												onclick="acyncPolicyPdf('policyPdfDown.mdo')" value="PDF저장"
												data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal"
												onclick="acyncMovePage('manage_policy.mdo')">아니오</button>
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
											<option selected value="TITLE">제목</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_policy.mdo')">
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
									<th>제목</th>
									<th>등록일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="policyList" items="${policyList }">
									<tr>
										<th>${policyList.rownum }</th>
										<th>${policyList.policy_title }</th>
										<th>${policyList.policy_regdate }</th>
										<th>
											<button type="button" class="btn btn-primary btn-sm"
												data-toggle="modal" data-target="#modifyPolicy"
												data-modifyid="${policyList.policy_id }"
												data-modifytitle="${policyList.policy_title }"
												data-modifycontent="${policyList.policy_content }">수정</button>
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deletePolicy"
												data-delid="${policyList.policy_id }">삭제</button>
											<button type="button" class="btn btn-success btn-sm"
												data-toggle="modal" data-target="#detailPolicy"
												data-detailid="${policyList.policy_id }"
												data-detailtitle="${policyList.policy_title }"
												data-detailcontent="${policyList.policy_content }">약관보기</button>
										</th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!--modify modal -->
						<div class="modal fade" id="modifyPolicy">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">이용약관 수정</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<div>
												<label for="policy_title">제목</label> <input type="text"
													class="form-control modifyPolicyTitleInput"
													id="modifyPolicyTitleInput" name="policy_title">
											</div>
											<br>
											<div>
												<label for="policy_content">내용</label>
												<textarea
													class="form-control rounded-0 modifyPolicyContentInput"
													id="modifyPolicyContentInput" cols="100" rows="20"
													name="policy_content"></textarea>
												<br>
											</div>
											<button type="button" class="btn btn-success"
												data-dismiss="modal"
												onclick="acyncModifyPolicy('policyModify.mdo')">수정</button>
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">취소</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--detail modal -->
						<div class="modal fade" id="detailPolicy">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">이용약관 상세보기</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div>
											<label for="policy_title">제목</label> <input type="text"
												class="form-control detailPolicyTitleInput"
												id="detailPolicyTitleInput" name="policy_title"
												disabled="disabled">
										</div>
										<br>
										<div>
											<label for="policy_content">내용</label>
											<textarea
												class="form-control rounded-0 detailPolicyContentInput"
												id="detailPolicyContentInput" cols="100" rows="20"
												name="policy_content" disabled="disabled"></textarea>
											<br>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">닫기</button>
									</div>
								</div>
							</div>
						</div>
						<!--delete modal -->
						<div class="modal fade" id="deletePolicy">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">이용약관 삭제</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">해당 이용약관을(를) 정말 삭제하시겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success"
											data-dismiss="modal"
											onclick="acyncDeletePolicy('policyDelete.mdo')">예</button>
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">아니오</button>
									</div>
								</div>
							</div>
						</div>

						<!--insert modal -->
						<div class="modal fade" id="insertPolicy">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">이용약관 추가</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<form name="insertPolicyForm" id="insertPolicyForm">
											<div class="form-group">
												<div>
													<label for="policy_title">제목</label> <input type="text"
														class="form-control" id="policy_title" name="policy_title">
												</div>
												<br>
												<div>
													<label for="policy_content">내용</label>
													<textarea class="form-control rounded-0"
														id="policy_content" cols="100" rows="20"
														name="policy_content"></textarea>
												</div>
												<br>
												<div>
													<button type="button" class="btn btn-success"
														data-dismiss="modal"
														onclick="acyncInsertPolicy('policyInsert.mdo')">추가</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal"
														onclick="acyncMovePage('manage_policy.mdo')">취소</button>
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
												onclick="acyncNowPage1('manage_policy.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_policy.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
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
														onclick="acyncNowPage1('manage_policy.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_policy.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_policy.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_policy.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
														onclick="acyncNowPage1('manage_policy.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_policy.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_policy.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_policy.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
												onclick="acyncNowPage1('manage_policy.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_policy.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
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


