var directorDeleteId = "";
var directorModifyId = "";
$(document).ready(function() {
   $('#deleteDirector').on('show.bs.modal', function(event) {
      directorDeleteId = $(event.relatedTarget).data('delid');
//      alert(directorDeleteId);
//      console.log(directorDeleteId);
   });
   $('#modifyDirector').on('show.bs.modal', function(event) {
      directorModifyId = $(event.relatedTarget).data('modifyid');
      var directorModifyName = $(event.relatedTarget).data('modifyname');
      var directorModifyBirthDate = $(event.relatedTarget).data('modifybirthdate');
//      alert(directorModifyBirthDate);
//      alert(directorModifyName);
//      alert(directorModifyId);
//      console.log(directorModifyId);
      $('.modifyDirectorNameInput').val(directorModifyName);
      $('.modifyDirectorBirthDateInput').val(directorModifyBirthDate);
   });
});

//감독 삭제
function acyncDeleteDirector(url) {
   var id = {"director_id" : directorDeleteId};
//   console.log(JSON.stringify(id));
//   alert(JSON.stringify(id));
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
         console.log(JSON.stringify(data));
         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 감독이 삭제되었습니다.");  
            acyncMovePage('manage_director.mdo');
         } else {
            alert("[Error] 감독 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//감독 수정
function acyncModifyDirector(url) {
   //var $form = $('#modifyDirectorForm').serialize();
   var form = {"director_id" : directorModifyId,
            "director_name" : document.getElementById('modifyDirectorNameInput').value,
            "director_birthdate" : document.getElementById('modifyDirectorBirthDateInput').value
            }; 
//   console.log(JSON.stringify(form));
//   alert(JSON.stringify(form));
   $.ajax({
      url : url,
      type : "POST",
      //data : $form,
      data : form,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 감독 정보가 수정되었습니다.");  
            acyncMovePage('manage_director.mdo');
         } else {
            alert("[Error] 감독 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


// 감독 추가
function acyncInsertDirector(url) {
   var $form = $('#insertDirectorForm').serialize();
//   console.log(JSON.stringify($form));
//   alert(JSON.stringify($form));
   $.ajax({
      url : url,
      type : "POST",
      data : $form,
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 감독이 추가되었습니다.");
         } else {
            alert("[Error] 감독 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
    	  acyncMovePage('manage_director.mdo');
      }
   });
}



//PDF 이름값 저장을 하기 위한..
function acyncDirectorPdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_director.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}