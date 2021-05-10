<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>

<body>
<script>
var now = new Date(); //현재 날짜 및 시간 
console.log(now);
var year = now.getFullYear();//연도
console.log("년도 : ",year);
var month = now.getMonth() + 1; //월
console.log("월" , month);
var date = now.getDate(); //일
console.log("일" , date);
var hours = now.getHours(); //시간
console.log("시간" ,hours);
var minutes = now.getMinutes();	// 분
console.log("분 : ", minutes);
var seconds = now.getSeconds();	// 초
console.log("초 : ", seconds);
var teststatus;


//기본적인 장르에 대한 데이터 
var movie_genre_data_chart_data = {
	    labels: [
	    	<c:forEach var="addgenreNameList" items="${addgenreNameList }">
				 '${addgenreNameList}',
			</c:forEach>	
	    ],
	    
	    datasets: [{
	    	label: 'DATA',
         data: [
         	<c:forEach var="MovieGenreListCount" items="${MovieGenreListCount }">
				 '${MovieGenreListCount}',
				</c:forEach>
         ], 
         backgroundColor: [  	
         	<c:forEach var="chart_color_random_genre" items="${chart_color_random_genre }">
				 '${chart_color_random_genre}',
				</c:forEach>
         	],
         fill: true,
         lineTension: 0
     }]
	};

//기본 DEFAULT값 차트 (LINE 차트를 생성해서 화면에 출력)
var ctx_myChart_line_genre_char_line = document.getElementById('myChart_line_genre_char_line');	
var myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
    type: 'line',
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
	
	
//버튼 클릭시 도넛으로 차트를 바꿔줌 	
$("#change_btn_doughnut").on("click", function() {
	if(myChart_1 != null){
		myChart_1.destroy();
	}
	myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
	    type: 'doughnut',
	    data:movie_genre_data_chart_data, 
	    options: {
	        title: {
	            display: true,
	            text: '영화 전체 장르(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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

//버튼 클릭시 pie 차트로 바꿔줌.
$("#change_btn_pie").on("click", function() {
	if(myChart_1 != null){
		myChart_1.destroy();
		
	}
	myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
	    type: 'pie',
	    data:movie_genre_data_chart_data,  
	    options: {
	        title: {
	            display: true,
	            text: '영화 전체 장르(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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

//버튼 클릭시 line 차트로 바꿔줌.
$("#change_btn_line").on("click", function() {
	if(myChart_1 != null){
		myChart_1.destroy();
		
	}
	myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
	    type: 'line',
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
		
});




//버튼 클릭시 rader 차트로 바꿔줌.
$("#change_btn_radar").on("click", function() {
	if(myChart_1 != null){
		myChart_1.destroy();
		
	}
	myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
	    type: 'radar',
	    data:movie_genre_data_chart_data,  
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 전체 장르(통계)'
	        },   
	        
	        tooltips: {
	            mode: 'index',
	            intersect: true,
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
		
});


//버튼 클릭시 bar 차트로 바꿔줌.
$("#change_btn_bar").on("click", function() {
	if(myChart_1 != null){
		myChart_1.destroy();
		
	}
	myChart_1 = new Chart(ctx_myChart_line_genre_char_line, {
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
		
});

//====================================================================================================================================
//영화 출시일에 대한 차트
var movie_release_date_chart_data = {
	    labels: [
	    	<c:forEach var="movie_year_list" items="${movie_year_list }">
				 '${movie_year_list}',
			</c:forEach>	
	    ],
	    
	    datasets: [{
	    	label: 'DATA',
            data: [
            	<c:forEach var="movie_year_list_count" items="${movie_year_list_count }">
				 '${movie_year_list_count}',
				</c:forEach>
            ], 
            backgroundColor: [  	
            	<c:forEach var="chart_color_random_release" items="${chart_color_random_release }">
				 '${chart_color_random_release}',
				</c:forEach>
            	],
//             	borderColor: "black",
                borderWidth: 1
//             fill: true,
//             lineTension: 0
        }]
	};


var ctx_myChart_doughnut_release_char_doughnut = document.getElementById('myChart_doughnut_release_char_doughnut');	
var myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
    type: 'doughnut',
    data:movie_release_date_chart_data, 
    options: {
        title: {
            display: true,
            text: '영화 출시일(통계)'
//	            position: 'top',
//	            fontSize: 25,
//	            fontColor: '#000'
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
		


//버튼 클릭시 도넛으로 차트를 바꿔줌 	
$("#change_btn_doughnut_release").on("click", function() {
	if(myChart_2 != null){
		myChart_2.destroy();
	}
	myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
	    type: 'doughnut',
	    data:movie_release_date_chart_data, 
	    options: {
	        title: {
	            display: true,
	            text: '영화 전체 장르(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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

//버튼 클릭시 pie 차트로 바꿔줌.
$("#change_btn_pie_release").on("click", function() {
	if(myChart_2 != null){
		myChart_2.destroy();
		
	}
	myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
	    type: 'pie',
	    data:movie_release_date_chart_data, 
	    options: {
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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


//버튼 클릭시 line 차트로 바꿔줌.
$("#change_btn_line_release").on("click", function() {
	if(myChart_2 != null){
		myChart_2.destroy();
		
	}
	myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
	    type: 'line',
	    data:movie_release_date_chart_data, 
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
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
		
});

//버튼 클릭시 rader 차트로 바꿔줌.	
$("#change_btn_rader_release").on("click", function() {
	if(myChart_2 != null){
		myChart_2.destroy();
		
	}
	myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
	    type: 'radar',
	    data:movie_release_date_chart_data, 
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
	        },   
	        
	        tooltips: {
	            mode: 'index',
	            intersect: true,
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
		
});


//버튼 클릭시 bar 차트로 바꿔줌.
$("#change_btn_bar_release").on("click", function() {
	if(myChart_2 != null){
		myChart_2.destroy();
		
	}
	myChart_2 = new Chart(ctx_myChart_doughnut_release_char_doughnut, {
	    type: 'bar',
	    data:movie_release_date_chart_data, 
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
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
		
});
//====================================================================================================================================	
//영화 관람등급 분포도에 대한 차트 
var ctx_movie_rating_chart = document.getElementById('movie_rating_chart');
var movie_rating_chart_data = {
    labels: ['전체', '12세' , '15세' , '19세'],
    datasets: [{
    	label: 'DATA',
        data: [${setMovieRating[0]},${setMovieRating[1]},${setMovieRating[2]},${setMovieRating[3]} ],
        backgroundColor: ['rgba(0, 0, 0, 0.4)','rgba(255, 255, 0, 0.4)',
        	'rgba(255, 102, 0, 0.4)','rgba(255, 0, 0, 0.4)'
        	],
// 		fill: false,
        borderWidth: 1
    }]
};


var movie_rating_chart_data_line = {
    labels: ['전체', '12세' , '15세' , '19세'],
    datasets: [{
    	label: 'DATA',
        data: [${setMovieRating[0]},${setMovieRating[1]},${setMovieRating[2]},${setMovieRating[3]} ],
        backgroundColor: ['rgba(0, 0, 0, 0.4)','rgba(255, 255, 0, 0.4)',
        	'rgba(255, 102, 0, 0.4)','rgba(255, 0, 0, 0.4)'
        	],
    	borderColor: "green",
    	fill: false,
    	borderWidth: 1
    }]
};

var myChart3 = new Chart(ctx_movie_rating_chart, {
    type: 'doughnut',
    data: movie_rating_chart_data,
    options: {
        title: {
            display: true,
            text: '영화 관람등급 분포도'+'(총'+${setMovieRating[4]}+'영화)',
            position: 'top',
//             fontSize: 10,
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
	


//버튼 클릭시 도넛으로 차트를 바꿔줌 	
$("#change_btn_doughnut_rating").on("click", function() {
	if(myChart3 != null){
		myChart3.destroy();
	}
	myChart3 = new Chart(ctx_movie_rating_chart, {
	    type: 'doughnut',
	    data: movie_rating_chart_data,
	    options: {
	        title: {
	            display: true,
	            text: '영화 전체 장르(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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

//버튼 클릭시 pie 차트로 바꿔줌.
$("#change_btn_pie_rating").on("click", function() {
	if(myChart3 != null){
		myChart3.destroy();
		
	}
	myChart3 = new Chart(ctx_movie_rating_chart, {
	    type: 'pie',
	    data: movie_rating_chart_data,
	    options: {
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
// 	            position: 'top',
// 	            fontSize: 25,
// 	            fontColor: '#000'
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


//버튼 클릭시 line 차트로 바꿔줌.
$("#change_btn_line_rating").on("click", function() {
	if(myChart3 != null){
		myChart3.destroy();
		
	}
	myChart3 = new Chart(ctx_movie_rating_chart, {
	    type: 'line',
	    data: movie_rating_chart_data_line,
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
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
		
});

//버튼 클릭시 rader 차트로 바꿔줌.	
$("#change_btn_rader_rating").on("click", function() {
	if(myChart3 != null){
		myChart3.destroy();
		
	}
	myChart3 = new Chart(ctx_movie_rating_chart, {
	    type: 'radar',
	    data: movie_rating_chart_data,
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
	        },   
	        
	        tooltips: {
	            mode: 'index',
	            intersect: true,
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
		
});


//버튼 클릭시 bar 차트로 바꿔줌.
$("#change_btn_bar_rating").on("click", function() {
	if(myChart3 != null){
		myChart3.destroy();
		
	}
	myChart3 = new Chart(ctx_movie_rating_chart, {
	    type: 'bar',
	    data: movie_rating_chart_data,
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '영화 출시일(통계)'
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
		
});	
//====================================================================================================================================	
//영화 전체 장르 차트 엑셀로 다운로드 하는 기능 
$(function() {
    $("#btn_chart_excel_download1").click(function() {
        // 캔버스에 그려진 이미지를 data url로 변환
        let base64Image = ctx_myChart_line_genre_char_line.toDataURL(1.0);

        // excel js 객체 생성
        let workbook = new ExcelJS.Workbook();

        // 워크시트 생성
        let worksheet =  workbook.addWorksheet('Sheet');
        worksheet.columns = [
        	<c:forEach var="MovieGenreListCount" items="${MovieGenreListCount }" varStatus="status">
        		{header: '${MovieGenreListCount}'+'개' , key: 'test' , width:10},
			</c:forEach>
		];
        // 흰 배경을 만들기 위해 셀 병합
        worksheet.mergeCells('A3:H35');

        // 가상의 파일 읽기
        workbook.xlsx.readFile("chartExample.xlsx");

        // 이미지 등록
        let imageId = workbook.addImage({
            base64: base64Image,
            extension: 'png',
        });

        // 병합했던 셀에 이미지 추가 (엑셀 파일 열면 위치 이동가능)
        worksheet.addImage(imageId, 'A3:H35');

        // 파일 다운로드
        workbook.xlsx.writeBuffer().then(function (movie_genre_data_chart_data) {
            let blob = new Blob([movie_genre_data_chart_data], {type: "application/vnd.ms-excel;charset=utf-8"});
            saveAs(blob, "장르_"+year+"_"+month+"월"+date+"일"+hours+"시"+minutes+"분"+seconds+"초"+".xlsx");
        });
    });
});	
	
//====================================================================================================================================		
//영화 출시일 차트 엑셀로 다운로드 하는 기능 
$(function() {
    $("#btn_chart_excel_download2").click(function() {
        // 캔버스에 그려진 이미지를 data url로 변환
        let base64Image = ctx_myChart_doughnut_release_char_doughnut.toDataURL(1.0);

        // excel js 객체 생성
        let workbook = new ExcelJS.Workbook();

        // 워크시트 생성
        let worksheet =  workbook.addWorksheet('Sheet');
        worksheet.columns = [
        	<c:forEach var="movie_year_list_count" items="${movie_year_list_count }" varStatus="status">
        		{header: '${movie_year_list_count}'+'개' , key: 'test' , width:10},
			</c:forEach>
		];

        
        // 흰 배경을 만들기 위해 셀 병합
        worksheet.mergeCells('A3:H35');

        // 가상의 파일 읽기
        workbook.xlsx.readFile("chartExample.xlsx");

        // 이미지 등록
        let imageId = workbook.addImage({
            base64: base64Image,
            extension: 'png',
        });

        // 병합했던 셀에 이미지 추가 (엑셀 파일 열면 위치 이동가능)
        worksheet.addImage(imageId, 'A3:H35');

        // 파일 다운로드
        workbook.xlsx.writeBuffer().then(function (movie_release_date_chart_data) {
            let blob = new Blob([movie_release_date_chart_data], {type: "application/vnd.ms-excel;charset=utf-8"});
            saveAs(blob, "출시일_"+year+"_"+month+"월"+date+"일"+hours+"시"+minutes+"분"+seconds+"초"+".xlsx");
        });
    });
});	
	
//====================================================================================================================================	
	
//영화 관랑등급  엑셀로 다운로드 하는 기능 
$(function() {
    $("#btn_chart_excel_download3").click(function() {
        // 캔버스에 그려진 이미지를 data url로 변환
        let base64Image = ctx_movie_rating_chart.toDataURL(1.0);

        // excel js 객체 생성
        let workbook = new ExcelJS.Workbook();

        // 워크시트 생성
        let worksheet =  workbook.addWorksheet('Sheet');
  		   worksheet.columns = [
 		    {header: '전체', key: 'ALL', width: 10},
    	    {header: '12세', key: 'AGE12', width: 10}, 
            {header: '15세', key: 'AGE15', width: 10,},
    	    {header: '19세', key: 'AGE19', width: 10,}
   			];
			 worksheet.addRow(
					 {	 
						 ALL:${setMovieRating[0]}, 
						 AGE12:${setMovieRating[1]}, 
						 AGE15:${setMovieRating[2]},
						 AGE19:${setMovieRating[3]}
					 }
			);

		//흰 배경을 만들기 위해 셀 병합
        worksheet.mergeCells('A3:H35');

        // 가상의 파일 읽기
        workbook.xlsx.readFile("chartExample.xlsx");

        // 이미지 등록
        let imageId = workbook.addImage({
            base64: base64Image,
            extension: 'png',
        });

        // 병합했던 셀에 이미지 추가 (엑셀 파일 열면 위치 이동가능)
        worksheet.addImage(imageId, 'A3:H35');

        // 파일 다운로드
        workbook.xlsx.writeBuffer().then(function (movie_rating_chart_data) {
            let blob = new Blob([movie_rating_chart_data], {type: "application/vnd.ms-excel;charset=utf-8"});
            saveAs(blob, "관람_"+year+"_"+month+"월"+date+"일"+hours+"시"+minutes+"분"+seconds+"초"+".xlsx");
        });
    });
});	

//====================================================================================================================================	
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
										<button type="button" id="change_btn_doughnut" class="btn btn-primary btn-sm"value="">그래프(도넛)</button>
										<button type="button" id="change_btn_pie" class="btn btn-primary btn-sm"value="">그래프(파이)</button>
										<button type="button" id="change_btn_line" class="btn btn-primary btn-sm"value="">그래프(라인)</button>	
										<button type="button" id="change_btn_radar" class="btn btn-primary btn-sm"value="">그래프(레이더)</button>	
										<button type="button" id="change_btn_bar" class="btn btn-primary btn-sm"value="">그래프(바)</button>	
										<input type="button"  id="btn_chart_excel_download1" class="btn btn-primary btn-sm" value="Excel다운" />
									</div>
									
									<div style="text-align: center; border: 1px solid;">
										<canvas id="myChart_doughnut_release_char_doughnut" width="700" height="700"></canvas>
										<button type="button" id="change_btn_doughnut_release" class="btn btn-primary btn-sm"value="">그래프(도넛)</button>
										<button type="button" id="change_btn_pie_release" class="btn btn-primary btn-sm"value="">그래프(파이)</button>
										<button type="button" id="change_btn_line_release" class="btn btn-primary btn-sm"value="">그래프(라인)</button>
										<button type="button" id="change_btn_rader_release" class="btn btn-primary btn-sm"value="">그래프(레이더)</button>
										<button type="button" id="change_btn_bar_release" class="btn btn-primary btn-sm"value="">그래프(바)</button>
										<input type="button"  id="btn_chart_excel_download2" class="btn btn-primary btn-sm" value="Excel다운" />
									</div>
									
									<div style="text-align: center; border: 1px solid;">
										<canvas id="movie_rating_chart" width="700" height="700"></canvas>
										<button type="button" id="change_btn_doughnut_rating" class="btn btn-primary btn-sm"value="">그래프(도넛)</button>
										<button type="button" id="change_btn_pie_rating" class="btn btn-primary btn-sm"value="">그래프(파이)</button>
										<button type="button" id="change_btn_line_rating" class="btn btn-primary btn-sm"value="">그래프(라인)</button>
										<button type="button" id="change_btn_rader_rating" class="btn btn-primary btn-sm"value="">그래프(레이더)</button>
										<button type="button" id="change_btn_bar_rating" class="btn btn-primary btn-sm"value="">그래프(바)</button>
										<input type="button"  id="btn_chart_excel_download3" class="btn btn-primary btn-sm" value="Excel다운" />
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