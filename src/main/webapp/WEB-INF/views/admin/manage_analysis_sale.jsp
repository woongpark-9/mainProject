<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<script>
	var setPaymentTicketList = ${setPaymentTicketList };
	var setPaymentemailList = ${setPaymentemailList };

	var salesTicketidList ${salesTicketidList};
	var salesEmailList = ${salesEmailList};
	
	var ticketyearCount = ${ticketyearCount};
</script>

	<style type="text/css">
.main {
	padding-top: 34px;
}

.box {
	width: 530px;
	height: 300px;
	overflow-y: scroll;
}

table {
	width: 100%;
	text-align: center;
	border-collapse: collapse;
}

tr.title {
	background-color: #5dcafc;
	text-align: center;
	border-collapse: collapse;
}

th, td {
	padding: 6px;
}
</style>

	<section>

		<div class="row mb-5">
			<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
				<div>
					<div class="col-12">
						<h3 class="text-muted text-center mb-3">(영화)통계</h3>
					</div>
					<div class="row">
						<div class="col-12">
							<div>
								<div style="display: flex;">


									<div class="col-xl-4 col-sm-6 p-2">
										<div class="card card-common">
											<div class="card-body">
												<div class="d-flex justify-content-between">
													<i class="fas fa-money-check-alt fa-3x text-waring"></i>
													<div class="text-left">

														<div class="text-right">
															<h5>총 매출</h5>
														</div>
														<div class="text-right">
															<h3>&#8361;&nbsp;${totalMoney} 원</h3>
														</div>
													</div>
												</div>

											</div>
											<div class="card-footer text-secondary">
												<h4>옆에서 상세하게 조회 가능----></h4>
											</div>
										</div>


									</div>



									<div class="col-xl-4 col-sm-6 p-2">
										<div class="card card-common">
											<div class="card-body">
												<div class="d-flex justify-content-between">
													<i class="fas fa-money-check-alt fa-3x text-waring"></i>
													<div class="text-left">
														<c:if test="${empty yearStartEndAdd}">
															<div class="text-right">
																<h5>매출</h5>
															</div>
														</c:if>

														<c:if test="${yearTotal ne null}">
															<div class="text-right">
																<h5>${yearStartEndAdd }</h5>
															</div>
														</c:if>

														<div class="text-right">
															<h3>&#8361;&nbsp;${yearTotal} 원</h3>
														</div>
													</div>
												</div>

											</div>
											<div class="card-footer text-secondary">
												<div class="text-center">
													<form action="#">
														<input type="date" id='t1' name="t1" value=""> <input
															type="date" id='t2' name="t2" value=""> <input
															type="button" value="조회"
															onclick="acyncDateParmeter('manage_analysis_sale.mdo')">
													</form>
												</div>
											</div>
										</div>


									</div>

									<div class="col-xl-4 col-sm-6 p-2">
										<div class="card card-common">
											<div class="card-body">
												<div class="d-flex justify-content-between">
													<i class="fas fa-money-check-alt fa-3x text-waring"></i>
													<div class="text-left">
														<div class="text-right">
															<h3>총 매출 = &#8361;&nbsp;${totalMoney} 원</h3>
															<h3>지정 매출 = &#8361;&nbsp;${yearTotal} 원</h3>
														</div>
													</div>
												</div>
											</div>

											<div class="text-left">
												<div class="card-footer text-secondary">
													<div class="text-right">
														<h5>매출 차익 = &#8361; ${totalMoney - yearTotal} 원</h5>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>

								<div style="display: flex;">
									<div class="main">
										<div class="box">
												<h6 align="center">전체(매출) 테이블 [상시조회]</h6>
											<table>
												<tr class="title">
													<th>EMAIL</th>
													<th>TICKET</th>
													<th>PAYMANT</th>
												</tr>
												<c:forEach var="salesPaymentList"
													items="${salesPaymentList }" varStatus="status">
													<tr>
														<td>${salesEmailList[status.index] }</td>
														<td>${salesTicketidList[status.index] }</td>
														<td>${salesPaymentList }</td>
													</tr>
												</c:forEach>

											</table>
										</div>
									</div>

									<div class="main">
										<div class="box">
											<c:if test="${empty yearStartEndAdd}">
												<h6 align="center">조회(매출) 테이블 [조건조회]</h6>
											</c:if>
											<c:if test="${yearStartEndAdd ne null}">
												<h6 align="center">조회완료 [ "${yearStartEndAdd }" ]</h6>
											</c:if>
											<table>
												<tr class="title">
													<th>EMAIL</th>
													<th>TICKET</th>
													<th>PAYMANT</th>
												</tr>
												<c:if test="${empty yearStartEndAdd}">
													<tr>
														<td>조회하세요!</td>
														<td>조회하세요!</td>
														<td>조회하세요!</td>
													</tr>
												</c:if>
												<c:forEach var="setPaymentDataList"
													items="${setPaymentDataList }" varStatus="status">
													<tr>
														<td>${setPaymentemailList[status.index] }</td>
														<td>${setPaymentTicketList[status.index] }</td>
														<td>${setPaymentDataList }</td>
													</tr>
												</c:forEach>

											</table>
										</div>
									</div>

									<div class="main">
										<div class="box">
											<h6 align="center">년도별 결제(건) [상시조회]</h6>
											<table>
												<tr class="title">
													<th>년도</th>
													<th>결제건수(환불미포함)</th>

												</tr>

												<c:forEach var="ticketyearList" items="${ticketyearList }"
													varStatus="status">
													<tr>
														<td>${ticketyearList }년</td>
														<td>${ticketyearCount[status.index] }건</td>
													</tr>
												</c:forEach>

											</table>
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

</body>
</html>