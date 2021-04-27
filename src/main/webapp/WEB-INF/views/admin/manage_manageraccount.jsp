<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
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
						<div class="col-5">
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#insertManager">+관리자추가</button>

							<button type="button" class="btn btn-info btn-sm">PDF</button>
							<button type="button" class="btn btn-info btn-sm">EXCEL</button>
							<button type="button" class="btn btn-info btn-sm">PRINT</button>
						</div>
					</div>
					<div>
						<table class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>아이디</th>
									<th>등급</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>1</th>
									<th>admin</th>
									<th>최고 관리자</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modifyManager">수정</button>
										<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteManager">삭제</button>
									</th>
								</tr>
								<tr>
									<th>2</th>
									<th>submanager</th>
									<th>일반 관리자</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modifyManager">수정</button>
										<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteManager">삭제</button>
									</th>
								</tr>
							</tbody>
						</table>

						<!-- page -->
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item"><a href="#" class="page-link py-2 px-3"> <span>&laquo;</span>
								</a></li>

								<!-- 페이지 정보 추가 -->
								<li class="page-item active"><a href="#" class="page-link py-2 px-3">1</a></li>
								<li class="page-item"><a href="#" class="page-link py-2 px-3">2</a></li>
								<li class="page-item"><a href="#" class="page-link py-2 px-3">3</a></li>

								<li class="page-item"><a href="#" class="page-link py-2 px-3"> <span>&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
					<!-- modal -->
					<div class="modal fade" id="deleteManager">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">관리자 삭제</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">해당 관리자를 정말 삭제하시겠습니까?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success" data-dismiss="modal">예</button>
									<button type="button" class="btn btn-danger" data-dismiss="modal">아니오</button>
								</div>
							</div>
						</div>
					</div>
					<!-- modal -->
					<div class="modal fade" id="insertManager">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">관리자 추가</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form role="form" method="POST" action="">
										<input type="hidden" name="_token" value="">
										<div class="form-group">
											<label class="control-label">아이디</label>
											<div>
												<input type="text" class="form-control input-lg" name="newManagerName" value="">
											</div>
											<br> <label class="control-label">패스워드</label>
											<div>
												<input type="password" class="form-control input-lg" name="newManagerPassword" value="">
											</div>
											<br> <label class="control-label">등급</label>
											<div>
												<select class="form-control" name="newManagerAuthority">
													<option value="1">최고 관리자</option>
													<option value="2">일반 관리자</option>
												</select>
											</div>
											<br>
											<div>
												<button type="button" class="btn btn-success" data-dismiss="modal">등록</button>
												<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
											</div>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
					<!-- modal -->
					<div class="modal fade" id="modifyManager">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">관리자 수정</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form role="form" method="POST" action="">
										<input type="hidden" name="_token" value="">
										<div class="form-group">
											<label class="control-label">아이디</label>
											<div>
												<input type="text" class="form-control input-lg" name="managerName" value="">
											</div>
											<br> <label class="control-label">패스워드</label>
											<div>
												<input type="password" class="form-control input-lg" name="managerPassword" value="">
											</div>
											<br> <label class="control-label">등급</label>
											<div>
												<select class="form-control" name="newManagerAuthority">
													<option value="1">최고 관리자</option>
													<option value="2">일반 관리자</option>
												</select>
											</div>
											<br>
											<div>
												<button type="button" class="btn btn-success" data-dismiss="modal">수정</button>
												<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
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