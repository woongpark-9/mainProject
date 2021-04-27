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
						<h3 class="text-muted text-center mb-3">이용약관</h3>
					</div>
					<div class="row">
						<div class="col-7">
								<button type="button" class="btn btn-primary btn-sm"
									onclick="acyncMovePage('movieInsert.mdo')">+영화추가</button>
								<button type="button" class="btn btn-info btn-sm">COPY</button>
								<button type="button" class="btn btn-info btn-sm">EXCEL</button>
						      	<button type="button" class="btn btn-info btn-sm">PDF</button>
								<button type="button" class="btn btn-info btn-sm">Print</button>
						</div>
						
						<div class="col-5">
							</div>
						</div>
						<div>
						<table class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>제목</th>
									<th>등록일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>1</th>
									<th>원플릭스 이용약관1</th>
									<th>2020-04-08</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#updateTerms">수정</button>
										<button type="button" class="btn btn-danger btn-sm"
											data-toggle="modal" data-target="#deleteTerms">삭제</button>
									</th>
								</tr>
								<tr>
									<th>2</th>
									<th>원플릭스 이용약관2</th>
									<th>2020-04-08</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#updateTerms">수정</button>
										<button type="button" class="btn btn-danger btn-sm"
											data-toggle="modal" data-target="#deleteTerms">삭제</button>
									</th>
								</tr>
								<tr>
									<th>3</th>
									<th>원플릭스 이용약관3</th>
									<th>2020-04-08</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#updateTerms">수정</button>
										<button type="button" class="btn btn-danger btn-sm"
											data-toggle="modal" data-target="#deleteTerms">삭제</button>
									</th>
								</tr>
							</tbody>
						</table>

						<!-- page 1번 2 번 3번 이동하는 거임.-->
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
					
					
					<!--delete modal -->
					<div class="modal fade" id="deleteTerms">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">이용약관 삭제</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">해당 이용약관을(를) 정말 삭제하시겠습니까?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success"
										data-dismiss="modal">예</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">아니오</button>
								</div>
							</div>
						</div>
					</div>
					
					<!--update modal -->
					<div class="modal fade" id="updateTerms">
						<div class="modal-dialog">
							<div class="modal-content">
								
								
								<div class="modal-header">
									<h4 class="modal-title">이용약관 수정</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								
								<div class="modal-body">

													<div class="card-body">
														<div class="d-flex">
															<div class="text-left text-secondary">
																<div>
																	<label for="title">제목</label>
																	<input type="text" class="form-control" id="title">
																</div>
																
																<br>
													
																<div class="form-group">
																		<label for="exampleFormControlTextarea2">내용</label>
																		<textarea class="form-control rounded-0" id="exampleFormControlTextarea2" cols="100" rows="20"  ></textarea>
																</div><br>
																
															</div>
														</div>
													</div>													
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success"
										data-dismiss="modal">등록</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">취소</button>
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


								