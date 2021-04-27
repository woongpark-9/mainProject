//페이지 이동
function acyncMovePage(url) {

	$.ajax({
		url : url,
		type : "POST",
		//data : JSON.stringify(json),
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

//영화 삭제
//function acyncDeleteMovie(url) {
//
//	$('#deleteMovie').on('show.bs.modal', function (event) {
//		var button = $(event.relatedTarget);
//		var deleteUrl = button.data('title');
//		var modal = $(this);
//
//		})
//	
//	var seqData = {"seq" : seq};
//	
//	console.log(JSON.stringify(seqData));
//	alert(JSON.stringify(seqData));
//	$.ajax({
//		url : url,
//		type : "POST",
//		data: seqData,
//		dataType:"json",
//		success : function(data) {
//			console.log(JSON.stringify(data));
//	alert(JSON.stringify(data));
//			if(data == 1) {
//			
//				alert("해당 영화가 삭제되었습니다.");
//				acyncMovePage('manage_movie.mdo');
//			} else {
//				alert("[Error] 영화 삭제 오류");
//			}
//		},
//		error : function() {
//			alert("error");
//		}
//	});
//}





//영화 추가
function acyncInsertMovie(url) {
	var $form = $('#insertMovieForm').serialize();
	$.ajax({
		url : url,
		type : "POST",
		data: $form,
		dataType:"json",
		success : function(data) {
			if(data == 1) {
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

//영화 수정
function acyncModifyMovie(url) {
	var $form = $('#insertMovieForm').serialize();
	console.log(JSON.stringify($form));
	alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data: $form,
		dataType:"json",
		success : function(data) {
			console.log(JSON.stringify(data));
			alert(JSON.stringify(data));
			if(data == 1) { 
				alert("해당 영화가 수정되었습니다.")
				acyncMovePage('manage_movie.mdo');
			} else {
				alert("[Error] 영화 수정 오류");
			}
		},
		error : function() {
			console.log("error")
			alert("error")
			//console.log(JSON.stringify(data));
			//alert(JSON.stringify(data));
		}
	});
}

//영화 수정 데이터 불러오기
function acyncModifyMoviePage(url, seq) {
	var seq = {"seq" : seq}
	$.ajax({
		url : url,
		type : "POST",
		data: seq,
		success : function(data) {
			$('#bodyContents').children().remove();
			$('#bodyContents').html(data);
		},
		error : function() {
			console.log("error")
			alert("error")
			//console.log(JSON.stringify(data));
			//alert(JSON.stringify(data));
		}
	});
}


