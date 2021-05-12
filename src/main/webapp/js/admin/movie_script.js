//페이지 이동
function acyncMovePage(url) {

	$.ajax({
		url : url,
		type : "POST",
		// data : JSON.stringify(json),
		contentType : "application/json",
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function() {
			alert("error");
		}
	});
}

// 현재 페이지 번호 가지고 이동
function acyncNowPage1(url, nowPage) {
	var data = {
		"nowPage" : nowPage
	}
	$.ajax({
		url : url,
		type : "POST",
		data : data,
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function() {
			alert("error");
		}
	});
}

// 현재 페이지 번호 가지고 이동
function acyncNowPage2(url, nowPage, searchCondition, searchKeyword) {
	var data = {
		"nowPage" : nowPage,
		"searchCondition" : searchCondition,
		"searchKeyword" : searchKeyword
	}
	$.ajax({
		url : url,
		type : "POST",
		data : data,
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function() {
			alert("error");
		}
	});
}

// 조건 검색
function acyncConditionMovePage(url) {
	var $form = $('#insertConditionForm').serialize();
	// console.log(JSON.stringify($form));
	// alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data : $form,
		// dataType : "json",
		// contentType : "application/json",
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});
}

var movieDeleteSeq = "";
$(document).ready(function() {
	$('#deleteMovie').on('show.bs.modal', function(event) {
		movieDeleteSeq = $(event.relatedTarget).data('delseq');
		// alert(movieDeleteSeq);
		// console.log(movieDeleteSeq);
	});
	$('#detailMovie').on('show.bs.modal', function(event) {
		var title = $(event.relatedTarget).data('title');
		var summary = $(event.relatedTarget).data('summary');
		var actor = $(event.relatedTarget).data('actor');
		var director = $(event.relatedTarget).data('director');
		var genre = $(event.relatedTarget).data('genre');
		var moviepath = $(event.relatedTarget).data('moviepath');
		// var posterpath = $(event.relatedTarget).data('posterpath');
		var releasedate = $(event.relatedTarget).data('releasedate');

		// alert(title);
		// console.log(title);
		var modal = $(this);
		modal.find('.modal-videoMetadata').text(title);
		modal.find('.modal-description').text(summary);
		modal.find('.modal-actor').text(actor);
		modal.find('.modal-director').text(director);
		modal.find('.modal-genre').text(genre);
		modal.find('.modal-video').attr('src', moviepath);
		// modal.find('.modal-video').attr('poster', posterpath);
		// modal.find('.modal-poster').attr('src', posterpath);
		modal.find('.modal-releasedate').text(releasedate);

	});

	// 모달 수평 수직 정렬
	// $("#detailMovie").modal('show').css({
	$("#detailMovie").on('show.bs.modal').css({
		'margin-top' : function() { // vertical centering
			return +($(this).height() / 7);
		},
		'margin-left' : function() { // Horizontal centering
			return -($(this).width() / 3.5);
		}
	});

});

// 영화 삭제
function acyncDeleteMovie(url) {
	var seq = {
		"seq" : movieDeleteSeq
	};
	// console.log(JSON.stringify(seq));
	// alert(JSON.stringify(seq));
	$.ajax({
		url : url,
		type : "POST",
		data : seq,
		dataType : "json",
		success : function(data) {
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
			if (data == 1) {

				alert("해당 영화가 삭제되었습니다.");
				acyncMovePage('manage_movie.mdo');
			} else {
				alert("[Error] 영화 삭제 오류");
			}
		},
		error : function() {
			alert("error");
		}
	});
}

// 영화 추가
function acyncInsertMovie(url) {
	var $form = $('#insertMovieForm').serialize();
	// console.log(JSON.stringify($form));
	// alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data : $form,
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("해당 영화가 추가되었습니다.");
				acyncMovePage('manage_movie.mdo');
			} else {
				alert("[Error] 영화 추가 오류");
			}
		},
		error : function() {
			alert("error");
		}
	});
}

// 영화 수정
function acyncModifyMovie(url) {
	var $form = $('#insertMovieForm').serialize();
	// console.log(JSON.stringify($form));
	// alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data : $form,
		dataType : "json",
		success : function(data) {
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
			if (data == 1) {
				alert("해당 영화가 수정되었습니다.")
				acyncMovePage('manage_movie.mdo');
			} else {
				alert("[Error] 영화 수정 오류");
			}
		},
		error : function() {
			console.log("영화 수정 오류")
			alert("영화 수정 오류")
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
		}
	});
}

// 영화 수정 데이터 불러오기
function acyncModifyMoviePage(url, seq) {
	var seq = {
		"seq" : seq
	}
	$.ajax({
		url : url,
		type : "POST",
		data : seq,
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function() {
			console.log("영화 수정 데이터 불러오기 실패")
			alert("영화 수정 데이터 불러오기 실패")
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
		}
	});
}

// PDF 이름값 저장을 하기 위한..
function acyncpdf(url) {
	$.ajax({
		url : url,
		type : "POST",
		data : {
			'newpdf' : $('#newpdf').val()
		},
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("PDF가 저장 되었습니다");
				acyncMovePage('manage_movie.mdo');
			} else {
				alert("PDF 저장 실패 했습니다.");
			}
		},
		error : function() {
			alert("[Error] PDF 저장 실패");
		}
	});
}
