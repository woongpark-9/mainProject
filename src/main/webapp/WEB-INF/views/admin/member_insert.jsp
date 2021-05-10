<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="header.jsp"%>
<script>
	var opt_gender = [];
	var opt_ticket_id = [];
	var opt_cert = [];
	var opt_ban = [];

	var str_gender = '${memberModifyInfo.gender }';
	var str_ticket_id = '${memberModifyInfo.ticket_id }';
	var str_cert = '${memberModifyInfo.cert }';
	var str_ban = '${memberModifyInfo.ban }';

	opt_gender.push(str_gender);
	opt_ticket_id.push(str_ticket_id);
	opt_cert.push(str_cert);
	opt_ban.push(str_ban);

	$(document).ready(function() {
		$('#gender').selectpicker('val', opt_gender);
		
		$('#ticket_id').selectpicker('val', opt_ticket_id);
		
		$('#cert').selectpicker('val', opt_cert);
		
		$('#ban').selectpicker('val', opt_ban);
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
							onclick="acyncMovePage('manage_member.mdo')">뒤로가기</button>

						<section>
							<div class="col-12 justify-content-center">
								<h3 class="text-muted text-center mb-3">
									신규회원
									<c:if test="${memberModifyInfo eq null }"> 등록</c:if>
									<c:if test="${memberModifyInfo ne null }"> 수정</c:if>
								</h3>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-xl-12 col-lg-9 col-md-8 ml-auto">

										<!-- card 전체 div -->
										<form name="insertMemberForm" id="insertMemberForm">
											<c:if test="${memberModifyInfo ne null }">
												<input type="hidden" id=seq name="seq"
													value="${memberModifyInfo.seq }">
											</c:if>

											<div class="row pt-md-5 mt-md-3 mb-5 justify-content-center">
												<div class="col-xl-3 col-sm-6 p-2">
													<div class="card card-common">
														<div class="card-body">
															<div class="d-flex">
																<div class="text-left text-secondary">
																	<div>
																		<label for="email">이메일</label> <input type="text"
																			class="form-control" id="email" name="email"
																			value="${memberModifyInfo.email }">
																	</div>
																	<br>
																	<div>
																		<label for="nickname">닉네임</label> <input type="text"
																			class="form-control" id="nickname" name="nickname"
																			value="${memberModifyInfo.nickname }">

																	</div>
																	<br>
																	<div>
																		<label for="age">나이</label> <input type="text"
																			class="form-control" id="age" name="age"
																			value="${memberModifyInfo.age }">

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
																		<label for="gender">성별</label> <select
																			class="form-control" id="gender" name="gender"
																			title="선택해 주세요">
																			<option value="남자">남자</option>
																			<option value="여자">여자</option>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="ticket_id">이용권</label> <select
																			class="form-control" id="ticket_id" name="ticket_id"
																			title="선택해 주세요">
																			<c:forEach var="ticketList" items="${ticketList }">
																				<option value="${ticketList.ticket_id }">${ticketList.ticket_name } ${ticketList.ticket_period }일권</option>
																			</c:forEach>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="cert">본인인증</label> <select
																			class="form-control" id="cert" name="cert"
																			title="선택해 주세요">
																			<option value="Y">Yes</option>
																			<option value="N">No</option>
																		</select>
																	</div>
																	<br>
																	<div>
																		<label for="ban">계정상태</label> <select
																			class="form-control" id="ban" name="ban"
																			title="선택해 주세요">
																			<option value="N">비활성화</option>
																			<option value="Y">활성화</option>
																		</select>
																	</div>
																	<!-- 																	<br> -->
																	<!-- 																	<div> -->
																	<!-- 																		<label for="join_date">가입일</label> <input type="text" -->
																	<!-- 																			class="form-control" id="join_date" name="join_date" -->
																	<%-- 																			value="${memberModifyInfo.join_date }"> --%>
																	<!-- 																	</div> -->
																	<br>
																	<div>
																		<c:if test="${memberModifyInfo == null}">
																			<button type="button" class="btn btn-success btn-sm"
																				onclick="acyncInsertMember('memberInsert.mdo')">등록하기</button>
																		</c:if>
																		<c:if test="${memberModifyInfo != null}">
																			<button type="button" class="btn btn-success btn-sm"
																				onclick="acyncModifyMember('memberModify.mdo')">수정하기</button>
																		</c:if>
																		<button type="button" class="btn btn-danger btn-sm"
																			onclick="acyncMovePage('manage_member.mdo')">뒤로가기</button>
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