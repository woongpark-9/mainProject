<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역</title>

</head>
<body>

	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">결제 내역</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<button type="button" class="btn btn-info btn-sm">EXCEL</button>
							<button type="button" class="btn btn-info btn-sm">PDF</button>
						</div>

						<div class="col-5">
							<form name="insertConditionForm" id="insertConditionForm">
								<div class="input-group">
									<div>
										<select class="form-control" name="searchCondition">
											<option selected value="EMAIL">이메일</option>
											<option value="TICKET">이용권</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_sales.mdo')">
										<i class="fas fa-search text-danger"></i>
									</button>
								</div>
							</form>
						</div>
					</div>
					<table
						class="table bg-light text-center table-bordered table-striped">
						<thead>
							<tr class="text-muted">
								<th>#</th>
								<th>회원 이메일</th>
								<th>이용권</th>
								<th>이용권 만료일</th>
								<th>결제 상태</th>
								<th>결제일</th>
								<th>결제 방식</th>
								<th>결제 카드</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="salesList" items="${salesList }">
								<tr>
									<th>${salesList.rownum }</th>
									<th>${salesList.email }</th>
									<th>${salesList.ticket_id }</th>
									<th>${salesList.expiry_date }</th>
									<th>${salesList.sales_status }</th>
									<th>${salesList.payment_date }</th>
									<th>${salesList.payment_method_type }</th>
									<th>${salesList.card_name }</th>
									<th class="align-middle">											
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="" data-target="">결제 취소</button>
									</th>
								</tr>
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
												onclick="acyncNowPage1('manage_sales.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_sales.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
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
														onclick="acyncNowPage1('manage_sales.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_sales.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword }')"
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
															onclick="acyncNowPage1('manage_sales.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_sales.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
															onclick="acyncNowPage1('manage_sales.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_sales.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_sales.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
												onclick="acyncNowPage1('manage_sales.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_sales.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

