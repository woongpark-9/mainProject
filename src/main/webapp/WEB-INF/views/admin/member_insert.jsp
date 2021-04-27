<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#fileInput").on('change', function() {
			if(window.FileReader) {
				var fileName = $(this)[0].files[0].name;
			} else {
				var fileName = $(this).val().split('/').pop().split('\\').pop();
			}
			$("#posterFile").val(fileName);
		});
	});
</script>
</head>
<body>
<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div>
						<button type="button" class="btn btn-info btn-sm" onclick="acyncMovePage('manage_member.mdo')">뒤로가기</button>
						
						<section>
							<div class="col-12 justify-content-center">
								<h3 class="text-muted text-center mb-3">신규 회원 등록</h3>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
										<div class="row pt-md-5 mt-md-3 mb-5">
										<div class="col-xl-3 col-sm-6 p-2">
												<div class="card card-common">
													<div class="card-body">
														<div class="d-flex">
															<div class="text-left text-secondary">
																<div>
																	<label for="email">이메일</label> 
																	<input type="text" class="form-control" id="email">
																</div><br>
																<div>
																	<label for="nickName">닉네임</label> 
																	<input type="text" class="form-control" id="nickName">
																</div><br>
																<div>
																	<label for="age">나이</label> 
																	<input type="text" class="form-control" id="age">
																</div><br>
																<div>
																	<label for="sex">성별</label> 
																	<select class="form-control" id="sex">
																		<option selected value="1">남</option>
																		<option value="2">여</option>
																	</select>
																</div><br>
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
																	<label for="ticket">이용권</label> 
																	<select class="form-control" id="ticket">
																		<option selected value="1">30일</option>
																		<option value="2">60일</option>
																		<option value="3">90일</option>
																	</select>
																</div><br>
																<div>
																	<label for="certification">본인인증</label> 
																	<select class="form-control" id="certification">
																		<option selected value="1">Y</option>
																		<option value="2">N</option>
																	</select>
																</div><br>
																<div>
																	<label for="status">계정상태</label> 
																	<select class="form-control" id="status">
																		<option selected value="1">비활성화</option>
																		<option value="2">활성화</option>
																	</select>
																</div><br>
																<div>
																	<label for="regDate">가입일</label> 
																	<input type="text" class="form-control" id="regDate">
																</div><br>
																<div>
																	<button type="button" class="btn btn-success btn-sm" onclick="acyncMovePage('manage_member.mdo')">등록하기</button>
																	<button type="button" class="btn btn-danger btn-sm" onclick="acyncMovePage('manage_member.mdo')">뒤로가기</button>
																</div>
															</div>
														</div>
														
													</div>
													
												</div>
											</div>
											
										</div>
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