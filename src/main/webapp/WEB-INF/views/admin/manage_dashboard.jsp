<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NowFlix Manager</title>
</head>
<body>
<section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="row pt-md-5 mt-md-3 mb-5">
					
						<div class="col-xl-3 col-sm-6 p-2">
							<div class="card card-common">
								<div class="card-body">
									<div class="d-flex justify-content-between">
										<i class="fas fa-video fa-3x text-waring"></i>
										<div class="text-left text-secondary">
											<h5>등록된 영화 수</h5>
											<h3>${all_movie_count}</h3>
										</div>
									</div>
									
								</div>
								<div class="card-footer text-secondary">
									<a href="#" onclick="acyncMovePage('manage_movie.mdo')"><i class="fas fa-arrow-circle-right mr-3"></i><span>자세히</span></a>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 p-2">
							<div class="card card-common">
								<div class="card-body">
									<div class="d-flex justify-content-between">
										<i class="fas fa-user fa-3x text-waring"></i>
										<div class="text-left text-secondary">
											<h5>가입된 회원 수</h5>
											<h3>${all_member_count}</h3>
										</div>
									</div>
									
								</div>
								<div class="card-footer text-secondary">
									<a href="#" onclick="acyncMovePage('manage_member.mdo')"><i class="fas fa-arrow-circle-right mr-3"></i><span>자세히</span></a>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 p-2">
							<div class="card card-common">
								<div class="card-body">
									<div class="d-flex justify-content-between">
										<i class="fas fa-chalkboard fa-3x text-waring"></i>
										<div class="text-left text-secondary">
											<h5>문의 건수</h5>
											<h3>총 15건</h3>
										</div>
									</div>
									
								</div>
								<div class="card-footer text-secondary">
									<a href="#" onclick="acyncMovePage('manage_cs.mdo')"><i class="fas fa-arrow-circle-right mr-3"></i><span>자세히</span></a>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 p-2">
							<div class="card card-common">
								<div class="card-body">
									<div class="d-flex justify-content-between">
										<i class="fas fa-money-check-alt fa-3x text-waring"></i>
										<div class="text-left text-secondary">
											<h5>월 매출</h5>
											<h3>&#8361;&nbsp;27,195,000</h3>
										</div>
									</div>
									
								</div>
								<div class="card-footer text-secondary">
									<a href="#" onclick="acyncMovePage('manage_sales.mdo')"><i class="fas fa-arrow-circle-right mr-3"></i><span>자세히</span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="row">
						<div class="col-6">
							<h3 class="text-muted text-center mb-3">신규 가입 회원 리스트</h3>
							<button type="button" class="btn btn-primary btn-sm float-right" onclick="acyncMovePage('manage_member.mdo')">more</button>
							<table class="table bg-light text-center table-bordered table-striped">
								<thead>
									<tr class="text-muted">
										<th>#</th>
										<th>이메일</th>
										<th>닉네임</th>
										<th>가입일</th>			
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>1</th>
										<th>nowflix@gmail.com</th>
										<th>홍길동</th>
										<th>2021-01-03</th>
									</tr>
									<tr>
										<th>2</th>
										<th>exam@naver.com</th>
										<th>둘리</th>
										<th>2020-06-27</th>
									</tr>
									<tr>
										<th>3</th>
										<th>test@hanmail.net</th>
										<th>또치</th>
										<th>2019-08-29</th>
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
						<div class="col-6">
							<h3 class="text-muted text-center mb-3">최근 결제 내역</h3>
							<button type="button" class="btn btn-primary btn-sm float-right" onclick="acyncMovePage('manage_sales.mdo')">more</button>
							<table class="table bg-light text-center table-bordered table-striped">
								<thead>
									<tr class="text-muted">
										<th>#</th>
										<th>이메일</th>
										<th>이용권</th>
										<th>결제일</th>			
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>1</th>
										<th>nowflix@gmail.com</th>
										<th>30일권</th>
										<th>2021-01-03</th>
									</tr>
									<tr>
										<th>2</th>
										<th>exam@naver.com</th>
										<th>정기권</th>
										<th>2020-06-27</th>
									</tr>
									<tr>
										<th>3</th>
										<th>test@hanmail.net</th>
										<th>15일권</th>
										<th>2019-08-29</th>
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
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div class="row">
						<div class="col-12">
							<h3 class="text-muted text-center mb-3">최근 등록된 영화</h3>
							<button type="button" class="btn btn-primary btn-sm float-right" onclick="acyncMovePage('manage_movie.mdo')">more</button>
							<table class="table bg-light text-center table-bordered table-striped">
							<thead>
								<tr class="text-muted">
									<th>#</th>
									<th>썸네일</th>
									<th>제목</th>
									<th>장르1</th>
									<th>장르2</th>
									<th>상영시간</th>
									<th>개봉일</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>1</th>
									<th>thumbnail1</th>
									<th>그랜드 부다페스트 호텔</th>
									<th>드라마</th>
									<th>코미디</th>
									<th>60분</th>
									<th>2021-04-01</th>
								</tr>
								<tr>
									<th>2</th>
									<th>thumbnail2</th>
									<th>클래식</th>
									<th>드라마</th>
									<th>로맨스</th>
									<th>80분</th>
									<th>2021-03-31</th>								
								</tr>
								<tr>
									<th>3</th>
									<th>thumbnail3</th>
									<th>태극기 휘날리며</th>
									<th>전쟁</th>
									<th>드라마</th>
									<th>120분</th>
									<th>2021-04-05</th>
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
				
						
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
