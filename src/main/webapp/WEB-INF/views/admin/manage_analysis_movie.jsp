<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
<script>
var ctx_movie_rating_chart = document.getElementById('movie_rating_chart');
var movie_rating_chart_data = {
    labels: ['전체', '12세' , '15세' , '19세'],
    datasets: [{
        label: '# of household',
        data: [${movie_count[0]},${movie_count[1]},${movie_count[2]},${movie_count[3]} ],
        backgroundColor: ['rgba(192, 192, 192, 0.4)','rgba(255, 255, 0, 0.4)',
        	'rgba(255, 102, 0, 0.4)','rgba(255, 0, 0, 0.4)'
        	],
        borderWidth: 1
    }]
};

var myChart = new Chart(ctx_movie_rating_chart, {
    type: 'doughnut',
    data: movie_rating_chart_data,
    options: {
        title: {
            display: true,
            text: '영화 관람등급 분포도'+'(총'+${movie_count[4]}+'영화)',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "개";
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




var ctx_movie_country_chart = document.getElementById('movie_country_chart');
var movie_country_chart_data = {
    labels: ['한국', '미국' , '일본', '스페인' , '캐나다'],
    datasets: [{
        label: '# of household',
        data: [${movie_count[5]} , ${movie_count[6]} , ${movie_count[7]}, 
        	${movie_count[8]}, ${movie_count[9]} ],
        backgroundColor: ['rgba(192, 192, 192, 0.4)','rgba(255, 255, 0, 0.4)',
        	'rgba(255, 102, 0, 0.4)','rgba(255, 0, 0, 0.4)','rgba(0, 255, 255, 0.4)'
        	],
        borderWidth: 1
    }]
};

var myChart = new Chart(ctx_movie_country_chart, {
    type: 'doughnut',
    data: movie_country_chart_data,
    options: {
        title: {
            display: true,
            text: '영화 국적 분포도'+'(총'+${movie_count[4]}+'개)',
            position: 'top',
            fontSize: 25,
            fontColor: '#000'
        },
        plugins: {
            labels: [
                {
                    render: function (options) {
                        var value = options.value;
                        return value + "개";
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

</script>


	<section>
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
					<div>
						<div class="col-12">
							<h3 class="text-muted text-center mb-3">(티켓)통계</h3>
						</div>
						<div class="row">
							<div class="col-7">

								<div style="width: 450px" class="line_1">
								<canvas id="movie_rating_chart" width="600" height="600"></canvas>
								<canvas id="movie_country_chart" width="600" height="600"></canvas>

								</div>
								<div style="width: 400px" class="line_1"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



</body>
</html>