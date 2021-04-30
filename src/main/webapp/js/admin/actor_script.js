var actorId = "";
var actorName="";
var actorBirth="";

$(document).ready(function() {   
   
   $('#modifyActor').on('show.bs.modal', function(event) {
      actorId = $(event.relatedTarget).data('modid');
      actorName = $(event.relatedTarget).data('aname');
      actorBirth = $(event.relatedTarget).data('abirth');
//      alert(actorName, actorBirth);
//      console.log(actorName, actorBirth);
      $('#mod_actor_name').val(actorName);
      $('#mod_actor_birth').val(actorBirth);
   });

   $('#deleteActor').on('show.bs.modal', function(event) {
      actorId = $(event.relatedTarget).data('delid');
//      alert(actorId);
//      console.log(actorId);
   });
   
   
});

//배우 삭제
function acyncDeleteActor(url) {
   var id = {
      "actor_id" : actorId
   };
//   console.log(JSON.stringify(id));
//   alert(JSON.stringify(id));
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 배우가 삭제되었습니다.");
            acyncMovePage('manage_actor.mdo');
         } else {
            alert("[Error] 배우 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

// 배우 추가
function acyncInsertActor(url) {
   //var $form = $('#insertActorForm').serialize();
   //console.log(JSON.stringify($form));
   //alert(JSON.stringify($form));
   $.ajax({
      url : url,
      type : "POST",
      data : { "actor_name" : $('#ins_actor_name').val(),
             "actor_birth" : $('#ins_actor_birth').val()},
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 배우가 추가되었습니다.");
         } else {
            alert("[Error] 배우 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
    	  $('#mod_actor_name').val("");
          $('#mod_actor_birth').val("");
    	  acyncMovePage('manage_actor.mdo');
      }
   });
}

// 배우 수정
function acyncModifyActor(url) {
//   var $form = $('#insertActorForm').serialize();
//   console.log(JSON.stringify($form));
//   alert(JSON.stringify($form));
   var data = {"actor_id" : actorId, 
         "actor_name" : $('#mod_actor_name').val(),
         "actor_birth" : $('#mod_actor_birth').val()}
//   console.log(JSON.stringify(data));
//   alert(JSON.stringify(data));
   $.ajax({
      url : url,
      type : "POST",
      data : data,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 배우가 수정되었습니다.")
            acyncMovePage('manage_actor.mdo');
         } else {
            alert("[Error] 배우 수정 오류");
         }
      },
      error : function() {
         console.log("error")
         alert("error")
         // console.log(JSON.stringify(data));
         // alert(JSON.stringify(data));
      }
   });
}

// 배우 수정 데이터 불러오기
function acyncModifyActorPage(url, seq) {
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

// PDF 이름값 저장을 하기 위한..
function acyncActorPdf(url) {
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
            acyncMovePage('manage_actor.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}