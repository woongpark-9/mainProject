<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/gh/emn178/chartjs-plugin-labels/src/chartjs-plugin-labels.js"></script> -->
<%@ include file="header.jsp"%>
</head>
<body>


	<script>  
var ctx_man_girl_chart = document.getElementById('man_girl_chart');
var man_girl_chart_data = {
    labels: ['남자', '여자'],
    datasets: [{
        label: '# of household',
        data: [${age_count[11]}, ${age_count[10]}],
        backgroundColor: ['rgba(54, 162, 235, 0.2)','rgba(255, 99, 132, 0.2)'],
        borderWidth: 1
    }]
};

var ctx_kakao_naver_nowflix = document.getElementById('kakao_naver_nowflix_chart');
var kakao_naver_nowflix_chart_data = {
    labels: ['카카오', '네이버' , '나우플릭스' ],
    datasets: [{
        label: '# of household',
        data: [${age_count[13]}, ${age_count[14]} , ${age_count[15]}],
        backgroundColor: ['rgba(255, 255, 0, 0.4)','rgba(0, 255, 0, 0.4)','rgba(255, 0, 0, 0.4)'],
        borderWidth: 1
    }]
};

var ctx_age = document.getElementById("age_date").getContext('2d');



var ctx_cert = document.getElementById('cert');
var cert_date = {
    labels: ['인증회원', '인증비회원' ],
    datasets: [{
        label: '# of household',
        data: [${age_count[18]}, ${age_count[19]} ],
        backgroundColor: ['rgba(0, 255, 255, 0.4)','rgba(255, 51, 153, 0.4)'],
        borderWidth: 1
    }]
};


var ctx_ban = document.getElementById('ban');
var ban_date = {
    labels: ['정지회원', '비정지회원' ],
    datasets: [{
        label: '# of household',
        data: [${age_count[16]}, ${age_count[17]} ],
        backgroundColor: ['rgba(122, 51, 255, 0.4)','rgba(255,155, 51, 0.4)'],
        borderWidth: 1
    }]
};


var ctx_ticket_use = document.getElementById("ticket_use_chart").getContext('2d');
//=======================================================================================================================
	
var myChart = new Chart(ctx_man_girl_chart, {
    type: 'doughnut',
    data: man_girl_chart_data,
    options: {
        title: {
            display: true,
            text: '남/여 (통계)'+'(총 '+${age_count[12]}+'명)',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "명";
                    },
                    
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000',
                    position: 'outside',
                    outsidePadding: 40,
                    textMargin: 10
                },
                {
                    render: 'label',
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000'
                }
            ],
            colorschemes: {
                scheme: 'tableau.Tableau20'
            }
        }
    }
});

var myChart = new Chart(ctx_kakao_naver_nowflix, {
    type: 'doughnut',
    data: kakao_naver_nowflix_chart_data,
    options: {
        title: {
            display: true,
            text: '가입유형 (통계)'+'(총 '+${age_count[12]}+'명)',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "명";
                    },
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000',
                    position: 'outside',
                    outsidePadding: 40,
                    textMargin: 10
                },
                {
                    render: 'label',
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000'
                }
            ],
            colorschemes: {
                scheme: 'tableau.Tableau20'
            }
        }
    }
});



//우선 컨텍스트를 가져옵니다. 
var age_date = new Chart(ctx_age, {
	type : 'bar',
	data : {
		labels : [ "10대", "20대", "30대", "40대", "50대", "60대", "70대", "80대" , "90대" , '100대'],
		
		datasets : [ {
//				label : '회원 나이 분포도',
			data : [ ${age_count[0]},${age_count[1]},${age_count[2]},
				${age_count[3]},${age_count[4]},${age_count[5]},
				${age_count[6]},${age_count[7]},${age_count[8]},${age_count[9]}],
			backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)',
					'rgba(0, 255, 0, 0.2)',
					'rgba(255, 0, 255, 0.2)',
					'rgba(192, 192, 192, 0.2)',
					'rgba(0, 0, 0, 0.2)'
					],
			borderColor : [ 
					'rgba(255,99,132,1)',
					
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)', 
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)',
					'rgba(0, 255, 0, 1)',
					'rgba(255, 0, 255, 1)',
					'rgba(192, 192, 192, 1)',
					'rgba(0, 0, 0, 1)'
					],
			borderWidth : 1
		} ]
	},
	options : {
		maintainAspectRatio : true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
		scales : {
			yAxes : [ {
				ticks : {
					beginAtZero : true
				}
			} ]
		},
	legend:{
		display:false,
	},
	title : {
		display: true,
		text:'회원 나이(연령) 분포도',
		 position: 'top',
		 fontSize: 25,
		 fontColor: '#000'
	}
	}
});



var myChart = new Chart(ctx_cert, {
    type: 'doughnut',
    data: cert_date,
    options: {
        title: {
            display: true,
            text: '본인 인증 통계',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "명";
                    },
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000',
                    position: 'outside',
                    outsidePadding: 40,
                    textMargin: 10
                },
                {
                    render: 'label',
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000'
                }
            ],
            colorschemes: {
                scheme: 'tableau.Tableau20'
            }
        }
    }
});



var myChart = new Chart(ctx_ban, {
    type: 'doughnut',
    data: ban_date,
    options: {
        title: {
            display: true,
            text: '정지 여부 통계',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "명";
                    },
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000',
                    position: 'outside',
                    outsidePadding: 40,
                    textMargin: 10
                },
                {
                    render: 'label',
                    fontSize: 10,
                    fontStyle: 'bold',
                    fontColor: '#000'
                }
            ],
            colorschemes: {
                scheme: 'tableau.Tableau20'
            }
        }
    }
});


var myChart = new Chart(ctx_ticket_use, {
    type: 'radar',
    data: {
        labels: ["B_0011", "B_0013", "B_0016", "B_00112", 
        	"P_0021" , "P_0023" , "P_0026" , "P_00212"],
        datasets: [{
//             label: '# of Votes',
            data: [${age_count[20]},${age_count[21]},${age_count[22]},${age_count[23]}, 
            	${age_count[24]}, ${age_count[25]} , ${age_count[26]} , ${age_count[27]}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
    	legend:{
    		display:false,
    	},
    	title: {
    	    display: true,
    	    text: ['이용권소유('+${age_count[29]}+')'+'명','이용권미소유('+${age_count[28]}+')'+'명'],
    	    
    	    position: 'top',
    	    fontSize: 20,
    	    fontColor: '#000'
    	},
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
 
//========================================================================================================================================




var ctx_kakao_naver_nowflix2 = document.getElementById('kakao_naver_nowflix_chart2');
var kakao_naver_nowflix_chart_data2 = {
	    labels: ['ddd', 'ddd' , 'ddd' ],
	    datasets: [{
	        label: '# of household',
	        data: [${age_count[13]}, ${age_count[14]} , ${age_count[15]}],
	        backgroundColor: ['rgba(255, 255, 0, 1)','rgba(0, 255, 0, 1)','rgba(255, 0, 0, 1)'],
	        borderWidth: 1
	    }]
	};

$("#btn1").on("click", function() {
    var context1 = document.querySelector('#kakao_naver_nowflix_chart').getContext('2d');
//     new Chart(context1).Line(kakao_naver_nowflix_chart_data2);
    
    new Chart(context1, {
        type: 'doughnut',
        data: kakao_naver_nowflix_chart_data2,
        options: {
            title: {
                display: true,
                text: 'zzzzz (통계)'+'(총 '+${age_count[12]}+'명)',
                position: 'top',
                fontSize: 25,
                fontColor: '#000'
            },
            plugins: {
                labels: [
                    {
                        render: function (options) {
                            var value = options.value;
                            return value + "명";
                        },
                        fontSize: 10,
                        fontStyle: 'bold',
                        fontColor: '#000',
                        position: 'outside',
                        outsidePadding: 40,
                        textMargin: 10
                    },
                    {
                        render: 'label',
                        fontSize: 10,
                        fontStyle: 'bold',
                        fontColor: '#000'
                    }
                ],
                colorschemes: {
                    scheme: 'tableau.Tableau20'
                }
            }
        }
    });
 });



</script>

	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div>
						<div class="col-12">
							<h3 class="text-muted text-center mb-3">(멤버)통계</h3>
						</div>
						<div class="row">
							<div class="col-7">
								<button type="button" class="btn btn-primary btn-sm"
									onclick="<canvas id="testingChart" width="400" height="400"></canvas>">+new</button>


								<div style="width: 400px" class="line_1">
									<canvas id="man_girl_chart" width="400" height="400"></canvas>
									<canvas id="kakao_naver_nowflix_chart" width="400" height="400"></canvas>
									<canvas id="age_date" width="400" height="400"></canvas>

									<!-- 									<button id="btn1" type="button">test</button> -->
								</div>
								<div style="width: 400px" class="line_1">
									<canvas id="cert" width="400" height="400"></canvas>
									<canvas id="ban" width="400" height="400"></canvas>
									<canvas id="ticket_use_chart" width="400" height="400"></canvas>
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

