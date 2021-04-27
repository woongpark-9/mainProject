<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
								<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#insertTicket">+이용권추가</button>
							
								<button type="button" class="btn btn-info btn-sm">PDF</button>
								<button type="button" class="btn btn-info btn-sm">EXCEL</button>
							</div>
						</div>
						<div>
						<table class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>이용권명</th>
									<th>기간</th>
									<th>가격</th>
									<th>활성화여부</th>
									<th>추천여부</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>1</th>
									<th>정기권</th>
									<th>30일</th>
									<th>10000원</th>
									<th>활성화</th>
									<th>추천</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#modifyTicket">수정</button>
									</th>
								</tr>
								<tr>
									<th>2</th>
									<th>60권</th>
									<th>60일</th>
									<th>10000원</th>
									<th>활성화</th>
									<th>추천</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#modifyTicket">수정</button>
									</th>
								</tr>
								<tr>
									<th>3</th>
									<th>90일권</th>
									<th>90일</th>
									<th>10000원</th>
									<th>활성화</th>
									<th>추천</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#modifyTicket">수정</button>
									</th>
								</tr>
								
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
					<!-- modal -->
					<div class="modal fade" id="modifyTicket">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">이용권 수정</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form role="form" method="POST" action="">
										<input type="hidden" name="_token" value="">
										<div class="form-group">
											<div>
												<label for="ticketName">이용권명</label> 
												<select class="form-control" id="ticketName">
													<option selected value="1">정기권</option>
													<option value="2">60일권</option>
													<option value="3">90일권</option>
												</select>
											</div><br>
											<div>
												<label for="ticketPeriod">기간</label> 
												<input type="text" class="form-control input-lg" name="ticketPeriod" value="">
											</div><br>
											<div>
												<label for="ticketPrice">가격</label> 
												<input type="text" class="form-control input-lg" name="ticketPrice" value="">
											</div><br>
											<div>
												<label for="ticketActive">활성화여부</label> 
												<select class="form-control" id="ticketActive">
													<option selected value="1">비활성화</option>
													<option value="2">활성화</option>
												</select>
											</div><br>
											<div>
												<label for="ticketRecommend">추천</label> 
												<select class="form-control" id="ticketRecommend">
													<option selected value="1">비추천</option>
													<option value="2">추천</option>
												</select>
											</div><br>
											<div>
												<button type="button" class="btn btn-success btn-sm" data-dismiss="modal">수정</button>
												<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">취소</button>
											</div>
										</div>
									</form>
								</div>
								
							</div>
						</div>
					</div>
					<!-- modal -->
					<div class="modal fade" id="insertTicket">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">이용권 추가</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form role="form" method="POST" action="">
										<input type="hidden" name="_token" value="">
										<div class="form-group">
											<div>
												<label for="newTicketName">이용권명</label> 
												<input type="text" class="form-control input-lg" name="newTicketName" value="">
											</div><br>
											<div>
												<label for="newTicketPeriod">기간</label> 
												<input type="text" class="form-control input-lg" name="newTicketPeriod" value="">
											</div><br>
											<div>
												<label for="newTicketPrice">가격</label> 
												<input type="text" class="form-control input-lg" name="newTicketPrice" value="">
											</div><br>
											<div>
												<button type="button" class="btn btn-success btn-sm" data-dismiss="modal">추가</button>
												<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">취소</button>
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