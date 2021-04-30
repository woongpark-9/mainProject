var noticeDeleteId = "";
var noticeModifyId = "";
$(document).ready(function() {
   $('#deleteNotice').on('show.bs.modal', function(event) {
      noticeDeleteId = $(event.relatedTarget).data('delid');
   });
   $('#modifyNotice').on('show.bs.modal', function(event) {
      noticeModifyId = $(event.relatedTarget).data('modifyid');
      var noticeModifyTitle = $(event.relatedTarget).data('modifytitle');
      var noticeModifyContent = $(event.relatedTarget).data('modifycontent');
      $('.modifyNoticeTitleInput').val(noticeModifyTitle);
      $('.modifyNoticeContentInput').val(noticeModifyContent);
   });
   $('#detailNotice').on('show.bs.modal', function(event) {
         noticeDetailId = $(event.relatedTarget).data('detailid');
         var noticeDetailTitle = $(event.relatedTarget).data('detailtitle');
         var noticeDetailContent = $(event.relatedTarget).data('detailcontent');
         $('.detailNoticeTitleInput').val(noticeDetailTitle);
         $('.detailNoticeContentInput').val(noticeDetailContent);
      });
});

//공지사항 삭제
function acyncDeleteNotice(url) {
   var id = {"notice_id" : noticeDeleteId};
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 공지사항이 삭제되었습니다.");  
            acyncMovePage('manage_notice.mdo');
         } else {
            alert("[Error] 공지사항 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//공지사항 수정
function acyncModifyNotice(url) {
   var form = {"notice_id" : noticeModifyId,
            "notice_title" : document.getElementById('modifyNoticeTitleInput').value,
            "notice_content" : document.getElementById('modifyNoticeContentInput').value,
            }; 
   $.ajax({
      url : url,
      type : "POST",
      data : form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 공지사항 정보가 수정되었습니다.");  
            acyncMovePage('manage_notice.mdo');
         } else {
            alert("[Error] 공지사항 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


// 공지사항 추가
function acyncInsertNotice(url) {
   var $form = $('#insertNoticeForm').serialize();
   $.ajax({
      url : url,
      type : "POST",
      data : $form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 공지사항이 추가되었습니다.");
         } else {
            alert("[Error] 공지사항 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
         acyncMovePage('manage_notice.mdo');
      }
   });
}



//PDF 이름값 저장을 하기 위한..
function acyncNoticePdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_notice.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}