//멤버추가
function acyncInsertMember(url) {
	var $form = $('#insertMemberForm').serialize();
//	console.log(JSON.stringify($form));
//	alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data : $form,
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("해당 멤버가 추가되었습니다.");
				acyncMovePage('manage_member.mdo');
			} else {
				alert("[Error] 영화 추가 오류");
			}
		},
		error : function() {
			alert("영화 추가 오류");
		}
	});
}

//멤버수정
function acyncModifyMember(url) {
	var $form = $('#insertMemberForm').serialize();
//	console.log(JSON.stringify($form));
//	alert(JSON.stringify($form));
	$.ajax({
		url : url,
		type : "POST",
		data : $form,
		dataType : "json",
		success : function(data) {
//			console.log(JSON.stringify(data));
//			alert(JSON.stringify(data));
			if (data == 1) {
				alert("해당 멤버가 수정되었습니다.")
				acyncMovePage('manage_member.mdo');
			} else {
				alert("[Error] 영화 수정 오류");
			}
		},
		error : function() {
			console.log("영화 수정 오류")
			alert("영화 수정 오류")
//			console.log(JSON.stringify(data));
//			alert(JSON.stringify(data));
		}
	});
}
//멤버 수정 데이터 불러오기
function acyncModifyMemberPage(url, seq) {
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
			console.log("error")
			alert("error")
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
		}
	});
}
//MEMBER PDF 이름값 저장을 하기 위한..
function acync_member_pdf(url) {
	$.ajax({
		url : url,
		type : "POST",
		data : {
			'newmemberpdf' : $('#newmemberpdf').val()
		},
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("PDF가 저장 되었습니다");
				acyncMovePage('manage_member.mdo');
			} else {
				alert("PDF 저장 실패 했습니다.");
			}
		},
		error : function() {
			alert("PDF 저장 실패 했습니다.");
		}
	});
}
