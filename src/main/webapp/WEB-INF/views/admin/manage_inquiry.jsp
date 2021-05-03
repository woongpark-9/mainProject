<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">1:1 문의</h3>
					</div>
					<div class="row">
						<div class="col-7">
							<!-- 							<button type="button" class="btn btn-primary btn-sm" -->
							<!-- 								data-toggle="modal" data-target="#insertInquiry">+추가</button> -->
							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#testpdf">PDF</button>
							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='inquiryExcelDown.mdo'">EXCEL</button>
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
												onclick="acyncInquiryPdf('inquiryPdfDown.mdo')"
												value="PDF저장" data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal"
												onclick="acyncMovePage('manage_inquiry.mdo')">아니오</button>
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
											<option value="CONTENT">내용</option>
										</select>
									</div>
									<input type="text" class="form-control search-input"
										name="searchKeyword" placeholder="검색어 입력">
									<button type="button" class="btn btn-light search-button"
										onclick="acyncConditionMovePage('manage_inquiry.mdo')">
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
									<th>카테고리</th>
									<th>고객 이메일</th>
									<th>문의 제목</th>
									<th>문의 날짜</th>
									<th>답변 날짜</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="inquiryList" items="${inquiryList }">
									<tr>
										<th>${inquiryList.inquiry_id }</th>
										<th>${inquiryList.inquiry_type }</th>
										<th>${inquiryList.email }</th>
										<th>${inquiryList.inquiry_title }</th>
										<th>${inquiryList.inquiry_date }</th>
										<c:if test="${inquiryList.reply_date eq null }">
											<th>미답변</th>
										</c:if>
										<c:if test="${inquiryList.reply_date ne null }">
											<th>${inquiryList.reply_date }</th>
										</c:if>
										<th><c:if test="${inquiryList.reply_date eq null }">
												<button type="button" class="btn btn-primary btn-sm"
													data-toggle="modal" data-target="#modifyInquiry"
													data-modifyid="${inquiryList.inquiry_id }"
													data-modifytype="${inquiryList.inquiry_type }"
													data-modifytitle="${inquiryList.inquiry_title }"
													data-modifycontent="${inquiryList.inquiry_content }"
													data-modifyreplytitle="${inquiryList.reply_title }"
													data-modifyreplycontent="${inquiryList.reply_content }">답변하기</button>
												<button type="button" class="btn btn-danger btn-sm"
													data-toggle="modal" data-target="#deleteInquiry"
													data-delid="${inquiryList.inquiry_id }">삭제</button>
											</c:if> <c:if test="${inquiryList.reply_date ne null }">
												<button type="button" class="btn btn-success btn-sm"
													data-toggle="modal" data-target="#detailInquiry"
													data-detailid="${inquiryList.inquiry_id }"
													data-detailtype="${inquiryList.inquiry_type }"
													data-detailtitle="${inquiryList.inquiry_title }"
													data-detailcontent="${inquiryList.inquiry_content }"
													data-detailreplytitle="${inquiryList.reply_title }"
													data-detailreplycontent="${inquiryList.reply_content }">상세보기</button>
												<button type="button" class="btn btn-primary btn-sm"
													data-toggle="modal" data-target="#modifyInquiry"
													data-modifyid="${inquiryList.inquiry_id }"
													data-modifytype="${inquiryList.inquiry_type }"
													data-modifytitle="${inquiryList.inquiry_title }"
													data-modifycontent="${inquiryList.inquiry_content }"
													data-modifyreplytitle="${inquiryList.reply_title }"
													data-modifyreplycontent="${inquiryList.reply_content }">수정하기</button>
												<button type="button" class="btn btn-danger btn-sm"
													data-toggle="modal" data-target="#deleteInquiry"
													data-delid="${inquiryList.inquiry_id }">삭제</button>
											</c:if></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!--modify modal -->
						<div class="modal fade" id="modifyInquiry">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">답변하기</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<div>
												<label for="faq_title">카테고리</label> <input type="text"
													class="form-control modifyInquiryTypeInput"
													id="modifyInquiryTypeInput" name="inquiry_type"
													disabled="disabled">
											</div>
											<div>
												<label for="inquiry_title">문의 제목</label> <input type="text"
													class="form-control modifyInquiryTitleInput"
													id="modifyInquiryTitleInput" name="inquiry_title"
													disabled="disabled">
											</div>
											<br>
											<div>
												<label for="inquiry_content">문의 내용</label>
												<textarea
													class="form-control rounded-0 modifyInquiryContentInput"
													id="modifyInquiryContentInput" cols="100" rows="20"
													name="inquiry_content" disabled="disabled"></textarea>
												<br>
											</div>
											<div>
												<label for="reply_title">답변 제목</label> <input type="text"
													class="form-control modifyReplyTitleInput"
													id="modifyReplyTitleInput" name="reply_title">
											</div>
											<br>
											<div>
												<label for="reply_content">답변 내용</label>
												<textarea
													class="form-control rounded-0 modifyReplyContentInput"
													id="modifyReplyContentInput" cols="100" rows="20"
													name="reply_content"></textarea>
												<br>
											</div>
											<button type="button" class="btn btn-success"
												data-dismiss="modal"
												onclick="acyncModifyInquiry('inquiryModify.mdo')">답변
												하기</button>
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">취소</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--detail modal -->
						<div class="modal fade" id="detailInquiry">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">상세보기</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div>
											<label for="faq_title">카테고리</label> <input type="text"
												class="form-control detailInquiryTypeInput"
												id="detailInquiryTypeInput" name="inquiry_type"
												disabled="disabled">
										</div>
										<div>
											<label for="inquiry_title">문의 제목</label> <input type="text"
												class="form-control detailInquiryTitleInput"
												id="detailInquiryTitleInput" name="inquiry_title"
												disabled="disabled">
										</div>
										<br>
										<div>
											<label for="inquiry_content">문의 내용</label>
											<textarea
												class="form-control rounded-0 detailInquiryContentInput"
												id="detailInquiryContentInput" cols="100" rows="20"
												name="inquiry_content" disabled="disabled"></textarea>
											<br>
										</div>
										<div>
											<label for="reply_title">답변 제목</label> <input type="text"
												class="form-control detailReplyTitleInput"
												id="detailReplyTitleInput" name="reply_title"
												disabled="disabled">
										</div>
										<br>
										<div>
											<label for="reply_content">답변 내용</label>
											<textarea
												class="form-control rounded-0 detailReplyContentInput"
												id="detailReplyContentInput" cols="100" rows="20"
												name="reply_content" disabled="disabled"></textarea>
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
						<div class="modal fade" id="deleteInquiry">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">공지사항 삭제</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">해당 공지사항을(를) 정말 삭제하시겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success"
											data-dismiss="modal"
											onclick="acyncDeleteInquiry('inquiryDelete.mdo')">예</button>
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">아니오</button>
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
												onclick="acyncNowPage1('manage_inquiry.mdo', ${nowPage-1})"
												class="page-link py-2 px-3"> <span>&laquo;</span>
											</a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_inquiry.mdo', ${nowPage-1}, '${searchCondition }', '${searchKeyword}')"
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
														onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item active"><a
														onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${searchCondition eq null }">
													<li class="page-item"><a
														onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
														class="page-link py-2 px-3">${i+1}</a></li>
												</c:if>
												<c:if test="${searchCondition ne null }">
													<li class="page-item"><a
														onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
															onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
															onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item active"><a
															onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${searchCondition eq null }">
														<li class="page-item"><a
															onclick="acyncNowPage1('manage_inquiry.mdo', ${i})"
															class="page-link py-2 px-3">${i+1}</a></li>
													</c:if>
													<c:if test="${searchCondition ne null }">
														<li class="page-item"><a
															onclick="acyncNowPage2('manage_inquiry.mdo', ${i}, '${searchCondition }', '${searchKeyword}')"
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
												onclick="acyncNowPage1('manage_inquiry.mdo', ${nowPage+1})"
												class="page-link py-2 px-3"><span>&raquo;</span> </a></li>
										</c:if>
										<c:if test="${searchCondition ne null }">
											<li class="page-item"><a
												onclick="acyncNowPage2('manage_inquiry.mdo', ${nowPage+1}, '${searchCondition }', '${searchKeyword}')"
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