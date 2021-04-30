var policyDeleteId = "";
var policyModifyId = "";
$(document).ready(function() {
   $('#deletePolicy').on('show.bs.modal', function(event) {
      policyDeleteId = $(event.relatedTarget).data('delid');
   });
   $('#modifyPolicy').on('show.bs.modal', function(event) {
      policyModifyId = $(event.relatedTarget).data('modifyid');
      var policyModifyTitle = $(event.relatedTarget).data('modifytitle');
      var policyModifyContent = $(event.relatedTarget).data('modifycontent');
      $('.modifyPolicyTitleInput').val(policyModifyTitle);
      $('.modifyPolicyContentInput').val(policyModifyContent);
   });
   $('#detailPolicy').on('show.bs.modal', function(event) {
         policyDetailId = $(event.relatedTarget).data('detailid');
         var policyDetailTitle = $(event.relatedTarget).data('detailtitle');
         var policyDetailContent = $(event.relatedTarget).data('detailcontent');
         $('.detailPolicyTitleInput').val(policyDetailTitle);
         $('.detailPolicyContentInput').val(policyDetailContent);
      });
});

//이용약관 삭제
function acyncDeletePolicy(url) {
   var id = {"policy_id" : policyDeleteId};
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 이용약관이 삭제되었습니다.");  
            acyncMovePage('manage_policy.mdo');
         } else {
            alert("[Error] 이용약관 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//이용약관 수정
function acyncModifyPolicy(url) {
   var form = {"policy_id" : policyModifyId,
            "policy_title" : document.getElementById('modifyPolicyTitleInput').value,
            "policy_content" : document.getElementById('modifyPolicyContentInput').value,
            }; 
   $.ajax({
      url : url,
      type : "POST",
      data : form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 이용약관 정보가 수정되었습니다.");  
            acyncMovePage('manage_policy.mdo');
         } else {
            alert("[Error] 이용약관 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


// 이용약관 추가
function acyncInsertPolicy(url) {
   var $form = $('#insertPolicyForm').serialize();
   $.ajax({
      url : url,
      type : "POST",
      data : $form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 이용약관이 추가되었습니다.");
         } else {
            alert("[Error] 이용약관 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
         acyncMovePage('manage_policy.mdo');
      }
   });
}



//PDF 이름값 저장을 하기 위한..
function acyncPolicyPdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_policy.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}
