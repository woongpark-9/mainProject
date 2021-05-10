var managerDeleteId = "";
var managerModifyId = "";
$(document).ready(function() {
   $('#deleteManager').on('show.bs.modal', function(event) {
      managerDeleteId = $(event.relatedTarget).data('delid');
   });
   $('#modifyManager').on('show.bs.modal', function(event) {
      managerModifyId = $(event.relatedTarget).data('modifyid');
      var managerModifyEmail = $(event.relatedTarget).data('modifyemail');
      var managerModifyPass = $(event.relatedTarget).data('modifypass');
      var managerModifyType = $(event.relatedTarget).data('modifytype');
      alert(managerModifyType);
      $('.modifyManagerEmailInput').val(managerModifyEmail);
      $('.modifyManagerPassInput').val(managerModifyPass);
      $(event.currentTarget).find('select[name="manager_type"]').val(managerModifyType);
   });
});

//관리자 삭제
function acyncDeleteManager(url) {
   var id = {"manager_id" : managerDeleteId};
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 관리자가 삭제되었습니다.");  
            acyncMovePage('manage_manager.mdo');
         } else {
            alert("[Error] 관리자 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//관리자 수정
function acyncModifyManager(url) {
   var form = {"manager_id" : managerModifyId,
            "manager_email" : document.getElementById('modifyManagerEmailInput').value,
            "manager_pass" : document.getElementById('modifyManagerPassInput').value,
            "manager_type" : document.getElementById('modifyManagerTypeInput').value
            }; 
   $.ajax({
      url : url,
      type : "POST",
      data : form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 관리자 정보가 수정되었습니다.");  
            acyncMovePage('manage_manager.mdo');
         } else {
            alert("[Error] 관리자 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


// 관리자 추가
function acyncInsertManager(url) {
   var $form = $('#insertManagerForm').serialize();
   $.ajax({
      url : url,
      type : "POST",
      data : $form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 관리자가 추가되었습니다.");
         } else {
            alert("[Error] 관리자 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
         acyncMovePage('manage_manager.mdo');
      }
   });
}



//PDF 이름값 저장을 하기 위한..
function acyncManagerPdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_manager.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}
