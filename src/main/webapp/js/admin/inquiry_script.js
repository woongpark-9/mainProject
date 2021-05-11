var inquiryDeleteId = "";
var inquiryModifyId = "";
$(document).ready(
		function() {
			$('#deleteInquiry').on('show.bs.modal', function(event) {
				inquiryDeleteId = $(event.relatedTarget).data('delid');
			});

			$('#modifyInquiry').on(
					'show.bs.modal',
					function(event) {

						inquiryModifyId = $(event.relatedTarget).data(
								'modifyid');
						var inquiryModifyType = $(event.relatedTarget).data(
								'modifytype');
						var inquiryModifyTitle = $(event.relatedTarget).data(
								'modifytitle');
						var inquiryModifyContent = $(event.relatedTarget).data(
								'modifycontent');
						var replyModifyTitle = $(event.relatedTarget).data(
								'modifyreplytitle');
						var replyModifyContent = $(event.relatedTarget).data(
								'modifyreplycontent');

						$('.modifyInquiryTypeInput').val(inquiryModifyType);
						$('.modifyInquiryTitleInput').val(inquiryModifyTitle);
						$('.modifyInquiryContentInput').val(
								inquiryModifyContent);
						$('.modifyReplyTitleInput').val(replyModifyTitle);
						$('.modifyReplyContentInput').val(replyModifyContent);
					});

			$('#detailInquiry').on(
					'show.bs.modal',
					function(event) {
						inquiryDetailId = $(event.relatedTarget).data(
								'detailid');
						var inquiryDetailType = $(event.relatedTarget).data(
								'detailtype');
						var inquiryDetailTitle = $(event.relatedTarget).data(
								'detailtitle');
						var inquiryDetailContent = $(event.relatedTarget).data(
								'detailcontent');
						var replyDetailTitle = $(event.relatedTarget).data(
								'detailreplytitle');
						var replyDetailContent = $(event.relatedTarget).data(
								'detailreplycontent');

						$('.detailInquiryTypeInput').val(inquiryDetailType);
						$('.detailInquiryTitleInput').val(inquiryDetailTitle);
						$('.detailInquiryContentInput').val(
								inquiryDetailContent);
						$('.detailReplyTitleInput').val(replyDetailTitle);
						$('.detailReplyContentInput').val(replyDetailContent);
					});
		});

// 문의 삭제
function acyncDeleteInquiry(url) {
	var id = {
		"inquiry_id" : inquiryDeleteId
	};
	$.ajax({
		url : url,
		type : "POST",
		data : id,
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("해당 문의가 삭제되었습니다.");
				acyncMovePage('manage_inquiry.mdo');
			} else {
				alert("[Error] 문의 삭제 오류");
			}
		},
		error : function() {
			alert("error");
		}
	});
}


function acyncRefreshPage() {
	$.ajax({
		url : 'manage_template.mdo',
		type : "POST",
		contentType : "application/json",
		success : function(data) {
			$('#navbar1').children().remove();
			$('#navbar1').html(data);
		},
		error : function() {
			alert("error");
		}
	});
}

// 답변 수정
function acyncModifyInquiry(url) {
	var form = {
		"inquiry_id" : inquiryModifyId,
		"inquiry_type" : document.getElementById('modifyInquiryTypeInput').value,
		"inquiry_title" : document.getElementById('modifyInquiryTitleInput').value,
		"inquiry_content" : document.getElementById('modifyInquiryContentInput').value,
		"reply_title" : document.getElementById('modifyReplyTitleInput').value,
		"reply_content" : document.getElementById('modifyReplyContentInput').value,
		"check_flag" : '1'
	};
	$.ajax({
		url : url,
		type : "POST",
		data : form,
		dataType : "json",
		success : function(data) {
			if (data == 1) {
				alert("해당 답변이 등록되었습니다.");
				// acyncRefreshPage();
				 acyncMovePage('manage_inquiry.mdo');
			} else {
				alert("[Error] 답변 수정 오류");
			}
		},
		error : function() {
			alert("error");
		}
	})
}


// acyncModifyInquiry()
// .then(acyncRefreshPage())
// .then(acyncMovePage('manage_inquiry.mdo'));

//
// // FAQ 추가
// function acyncInsertInquiry(url) {
// var $form = $('#insertInquiryForm').serialize();
// $.ajax({
// url : url,
// type : "POST",
// data : $form,
// dataType : "json",
// success : function(data) {
// if (data == 1) {
// alert("해당 FAQ가 추가되었습니다.");
// } else {
// alert("[Error] FAQ 추가 오류");
// }
// },
// error : function() {
// alert("error");
// },
// complete : function() {
// acyncMovePage('manage_inquiry.mdo');
// }
// });
// }

// PDF 이름값 저장을 하기 위한..
function acyncInquiryPdf(url) {
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
				acyncMovePage('manage_inquiry.mdo');
			} else {
				alert("PDF 저장 실패 했습니다.");
			}
		},
		error : function() {
			alert("error");
		}
	});
}