<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
<script>
//기본적인 장르에 대한 데이터 
var movie_genre_data_chart_data = {
	    labels: [
// 	    	<c:forEach var="setPaymentDataList" items="${setPaymentDataList }">
// 			 '${setPaymentDataList}',
// 			</c:forEach>
			
	    ],
	    
	    datasets: [{
//          label: '테스트 데이터셋',
         data: [
         	'${yearTotal}'
         ], 
         backgroundColor: [  	
        	 'rgba(54, 162, 235, 1)',
				'rgba(255, 206, 86, 1)',
         	],
         fill: true,
         lineTension: 0
     }]
	};
	
	
//기본 DEFAULT값 차트 (LINE 차트를 생성해서 화면에 출력)
var ctx_myChart_line_genre_char_line = document.getElementById('myChart_line_genre_char_line');	
var myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
    type: 'bar',
    data:movie_genre_data_chart_data, 
    options: {
        responsive: true,
        title: {
            display: true,
            text: '영화 전체 장르(통계)'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        }, 
        legend:{
        	display:false,
        },
        scales: {
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                },
                scaleLabel: {
                    display: true,
                    labelString: 'DATA'
                }
            }]
        }
    }
});
	


</script>


<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div>
						<div class="col-12">
							<h3 class="text-muted text-center mb-3">(영화)통계</h3>
						</div>
						<div class="row">
							<div class="col-12">
								<div style="display: flex;">
									<div style="text-align: center; border: 1px solid;">
										<canvas id="myChart_line_genre_char_line" width="700" height="700"></canvas>
										<form action="#">
											<input type="date" id='t1' name="t1" value="">
											<input type="date" id='t2' name="t2" value="">
											<input type="button" value="조회" onclick="acyncDateParmeter('manage_analysis_sale.mdo')">
										</form> 
										
									</div>
									
								</div>
<!-- 								<div style="width: 1000px" class="line_1"></div> -->
									
<%-- 								<canvas id="ctx_director_count_data" width="400" height="400"></canvas> --%>
	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>