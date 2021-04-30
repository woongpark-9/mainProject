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

<script>
	$('html').click(function(e) {
		if ($(e.target).hasClass("test_tt")) {
			acyncMovePage("manage_ticket.mdo")
		}
	});
</script>


</head>
<body>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">이용권</h3>
					</div>
					<div class="row">
						<div class="col-5">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#insertTicket">+이용권추가</button>

							<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#ticketpdf">PDF</button>

							<button type="button" class="btn btn-info btn-sm"
								onclick="location.href='ticketExcelDown.mdo'">EXCEL</button>

							<div class="modal fade" id="ticketpdf">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">PDF 경로 지정</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<div class="modal-body">
											PDF파일 이름을 적어주세요 예)TEST <br> <input type="text"
												class="form-control input-lg" id="newticketpdf" value="">
										</div>

										<div class="modal-footer">
											<input type="button" class="btn btn-success"
												onclick="acync_ticket_pdf('ticketPdfDown.mdo')"
												value="PDF저장" data-dismiss="modal">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal"
												onclick="acyncMovePage('manage_ticket.mdo')">아니오</button>
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
									<th>#</th>
									<th>이용권아이디</th>
									<th>이용권이름</th>
									<th>기간</th>
									<th>가격</th>
									<th>활성화여부</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ticketList" items="${ticketList }">
									<tr>
										<th class="align-middle">${ticketList.rownum }</th>
										<th class="align-middle">${ticketList.ticket_id }</th>
										<th class="align-middle">${ticketList.ticket_name }</th>
										<th class="align-middle">${ticketList.ticket_period }</th>
										<th class="align-middle">${ticketList.ticket_price }</th>
										<th class="align-middle">${ticketList.ticket_status }</th>

										<th><button type="button" class="btn btn-primary btn-sm"
												data-toggle="modal" data-target="#modifyTicket"
												data-modify_ticket_id="${ticketList.ticket_id }"
												data-modify_ticket_name="${ticketList.ticket_name }"
												data-modify_ticket_period="${ticketList.ticket_period }"
												data-modify_ticket_price="${ticketList.ticket_price }"
												data-modify_ticket_status="${ticketList.ticket_status }">수정</button>
											<button type="button" class="btn btn-danger btn-sm"
												data-toggle="modal" data-target="#deleteTicket"
												data-delseq="${ticketList.seq }">삭제</button></th>

									</tr>
									<!-- insert modal -->
									<div class="modal fade test_tt" id="insertTicket">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">이용권 추가</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<form id="insertTicketForm" name="insertTicketForm"
														action="">
														<input type="hidden" name="_token" value="">
														<div class="form-group">
															<label class="control-label">이용권ID</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ticket_id" name="ticket_id" value="">
															</div>
															<br> <label class="control-label">이용권이름</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ticket_name" name="ticket_name" value="">
															</div>
															<br> <label class="control-label">기간</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ticket_period" name="ticket_period" value="">
															</div>

															<label class="control-label">가격</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ticket_price" name="ticket_price" value="">
															</div>
															<br> <label class="control-label">활성화여부</label>
															<div>
																<input type="text" class="form-control input-lg"
																	id="ticket_status" name="ticket_status" value="">
															</div>

															<br>
															<div>
																<input type="button" class="btn btn-success"
																	onclick="acyncInsertTicket('ticketInsert.mdo')"
																	value="추가" data-dismiss="modal">
																<button type="button" class="btn btn-danger"
																	data-dismiss="modal">취소</button>
															</div>
														</div>
													</form>
												</div>

											</div>
										</div>
									</div>
									<!-- delete modal -->
									<div class="modal fade" id="deleteTicket">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">이용권 삭제</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">해당 이용권을 정말 삭제하시겠습니까?</div>
												<div class="modal-footer">
													<input type="button" class="btn btn-success"
														onclick="acyncDeleteTicket('ticketDelete.mdo')" value="예"
														data-dismiss="modal">
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">아니오</button>
												</div>
											</div>
										</div>
									</div>

									<!-- modify modal -->
									<div class="modal fade" id="modifyTicket">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">티켓 수정</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<div class="form-group">

														<label class="ticket_name">이용권이름</label>
														<div>
															<input type="text" class="form-control input-lg"
																id="mod_ticket_name" name="ticket_name" value="">
														</div>

														<br> <label class="ticket_period">기간</label>
														<div>
															<input type="text" class="form-control input-lg"
																id="mod_ticket_period" name="ticket_period" value="">
														</div>

														<br> <label class="ticket_price">가격</label>
														<div>
															<input type="text" class="form-control input-lg"
																id="mod_ticket_price" name="ticket_price" value="">
														</div>

														<br> <label class="ticket_status">활성화 여부</label>
														<div>
															<input type="text" class="form-control input-lg"
																id="mod_ticket_status" name="ticket_status" value="">
														</div>

														<br>

														<div>
															<button type="button" class="btn btn-success"
																data-dismiss="modal"
																onclick="acyncModifyTicket('ticketModify.mdo')">수정</button>
															<button type="button" class="btn btn-danger"
																data-dismiss="modal">취소</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</tbody>
						</table>

					</div>

					<!-- insert modal -->
					<div class="modal fade" id="insertTicket">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">이용권 추가</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form id="insertTicketForm" name="insertTicketForm" role="form"
										method="POST" action="">
										<input type="hidden" name="_token" value="">
										<div class="form-group">
											<div>
												<label for="newTicketid">이용권 아이디</label> <input type="text"
													class="form-control input-lg" id="ticket_id" value="">
											</div>
											<br>
											<div>
												<label for="newTicketName">이용권명</label> <input type="text"
													class="form-control input-lg" id="ticket_name" value="">
											</div>
											<br>
											<div>
												<label for="newTicketPeriod">기간</label> <input type="text"
													class="form-control input-lg" id="ticket_period" value="">
											</div>
											<br>
											<div>
												<label for="newTicketPrice">가격</label> <input type="text"
													class="form-control input-lg" id="ticket_price" value="">
											</div>
											<br>
											<div>
												<label for="newTicketStatus">활성화 여부</label> <input
													type="text" class="form-control input-lg"
													id="ticket_status" value="">
											</div>
											<br>
											<div>
												<label for="newTicketRecommend">추천 여부</label> <input
													type="text" class="form-control input-lg"
													id="ticket_recommend" value="">
											</div>
											<br>
											<div>
												<button type="button" class="btn btn-success btn-sm"
													onclick="acyncticketInsert('ticket_insert.mdo')"
													data-dismiss="modal">추가</button>
												<button type="button" class="btn btn-danger btn-sm"
													data-dismiss="modal">취소</button>
											</div>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</section>
</body>
</html>