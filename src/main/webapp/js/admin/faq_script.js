var faqDeleteId = "";
var faqModifyId = "";
$(document).ready(function() {
   $('#deleteFaq').on('show.bs.modal', function(event) {
      faqDeleteId = $(event.relatedTarget).data('delid');
   });
   
   $('#modifyFaq').on('show.bs.modal', function(event) {

      faqModifyId = $(event.relatedTarget).data('modifyid');
      var faqModifyCategory = $(event.relatedTarget).data('modifycategory');
      var faqModifyTitle = $(event.relatedTarget).data('modifytitle');
      var faqModifyContent = $(event.relatedTarget).data('modifycontent');
     
      $('.modifyFaqTitleInput').val(faqModifyTitle);
      $('.modifyFaqContentInput').val(faqModifyContent);
      $(event.currentTarget).find('select[name="faq_category"]').val(faqModifyCategory);
   });
   
   $('#detailFaq').on('show.bs.modal', function(event) {
         faqDetailId = $(event.relatedTarget).data('detailid');
         var faqDetailCategory = $(event.relatedTarget).data('detailcategory');
         var faqDetailTitle = $(event.relatedTarget).data('detailtitle');
         var faqDetailContent = $(event.relatedTarget).data('detailcontent');
         
         $('.detailFaqCategoryInput').val(faqDetailCategory);
         $('.detailFaqTitleInput').val(faqDetailTitle);
         $('.detailFaqContentInput').val(faqDetailContent);
      });
});

//FAQ 삭제
function acyncDeleteFaq(url) {
   var id = {"faq_id" : faqDeleteId};
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 FAQ가 삭제되었습니다.");  
            acyncMovePage('manage_faq.mdo');
         } else {
            alert("[Error] FAQ 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//FAQ 수정
function acyncModifyFaq(url) {
   var form = {"faq_id" : faqModifyId,
          "faq_category" : document.getElementById('modifyFaqCategoryInput').value,
            "faq_title" : document.getElementById('modifyFaqTitleInput').value,
            "faq_content" : document.getElementById('modifyFaqContentInput').value,
            }; 
   $.ajax({
      url : url,
      type : "POST",
      data : form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 FAQ 정보가 수정되었습니다.");  
            acyncMovePage('manage_faq.mdo');
         } else {
            alert("[Error] FAQ 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


// FAQ 추가
function acyncInsertFaq(url) {
   var $form = $('#insertFaqForm').serialize();
   $.ajax({
      url : url,
      type : "POST",
      data : $form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 FAQ가 추가되었습니다.");
         } else {
            alert("[Error] FAQ 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
         acyncMovePage('manage_faq.mdo');
      }
   });
}



//PDF 이름값 저장을 하기 위한..
function acyncFaqPdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_faq.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}