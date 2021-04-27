<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script.js"></script>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="dashboard.css" rel="stylesheet" type="text/css">

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
									<button type="button" class="btn btn-info btn-sm">PDF</button>
									<button type="button" class="btn btn-info btn-sm">EXCEL</button>
								</div>
								<form action="" class="col-5">
									<div class="input-group">
										<div>
											<select class="form-control">
												<option selected value="1">회원명</option>
												<option value="2">이메일</option>
												<option value="3">닉네임</option>
											</select>
										</div>
										<input type="text" class="form-control search-input"
											placeholder="검색어 입력">
										<button type="button" class="btn btn-light search-button">
											<i class="fas fa-search text-danger"></i>
										</button>										
									</div>

								</form>
							</div>

						<div>
						<table class="table bg-light text-center table-bordered table-striped">
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
								<tr>
									<th>1</th>
									<th>exam@naver.com</th>
									<th>둘리</th>
									<th>23</th>
									<th>남</th>
									<th>30일권</th>
									<th>Y</th>
									<th>활성화</th>
									<th>2020-06-27</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm" onclick="acyncMovePage('memberModify.mdo')">수정</button>
									</th>
								</tr>
								<tr>
									<th>2</th>
									<th>test@hanmail.net</th>
									<th>또치</th>
									<th>50</th>
									<th>여</th>
									<th>60일권</th>
									<th>Y</th>
									<th>활성화</th>
									<th>2019-08-29</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm" onclick="acyncMovePage('memberModify.mdo')">수정</button>
									</th>
								</tr>
								<tr>
									<th>3</th>
									<th>nowflix@gmail.com</th>
									<th>홍길동</th>
									<th>33</th>
									<th>남</th>
									<th>15일권</th>
									<th>N</th>
									<th>활성화</th>
									<th>2021-01-03</th>
									<th>
										<button type="button" class="btn btn-primary btn-sm" onclick="acyncMovePage('memberModify.mdo')">수정</button>
									</th>
								</tr>
							</tbody>
						</table>
						
						<!-- page -->
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item">
									<a href="#" class="page-link py-2 px-3">
										<span>&laquo;</span>
									</a>
								</li>
								
								<!-- 페이지 정보 추가 -->
								<li class="page-item active">
									<a href="#" class="page-link py-2 px-3">1</a>
								</li>
								<li class="page-item">
									<a href="#" class="page-link py-2 px-3">2</a>
								</li>
								<li class="page-item">
									<a href="#" class="page-link py-2 px-3">3</a>
								</li>
								
								<li class="page-item">
									<a href="#" class="page-link py-2 px-3">
										<span>&raquo;</span>
									</a>
								</li>
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