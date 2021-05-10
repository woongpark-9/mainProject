var genreId = "";
var genreName = "";

$(document).ready(function() {
   
   $('#modifyGenre').on('show.bs.modal', function(event) {
      genreId = $(event.relatedTarget).data('modid');
      genreName = $(event.relatedTarget).data('gname');
      //alert(genreDeleteSeq);
      //console.log(genreDeleteSeq);
      $('#mod_genre_name').val(genreName);
   });

   $('#deleteGenre').on('show.bs.modal', function(event) {
      genreId = $(event.relatedTarget).data('delid');
      //alert(genreDeleteSeq);
      //console.log(genreDeleteSeq);
   });
});

// 장르 삭제
function acyncDeleteGenre(url) {
   var id = {
      "genre_id" : genreId
   };
//   console.log(JSON.stringify(seq));
//   alert(JSON.stringify(seq));
   $.ajax({
      url : url,
      type : "POST",
      data : id,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 장르가 삭제되었습니다.");
            acyncMovePage('manage_genre.mdo');
         } else {
            alert("[Error] 장르 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

// 장르 추가
function acyncInsertGenre(url) {
   //console.log(JSON.stringify($form));
   //alert(JSON.stringify($form));
   $.ajax({
      url : url,
      type : "POST",
      data : { "genre_name" : $('#ins_genre_name').val()},
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 장르가 추가되었습니다.");
         } else {
            alert("[Error] 장르 추가 오류");
         }
      },
      error : function() {
         alert("error");
      },
      complete : function() {
    	  acyncMovePage('manage_genre.mdo');
      }
   });
}

// 장르 수정
function acyncModifyGenre(url) {
//   console.log(JSON.stringify($form));
//   alert(JSON.stringify($form));
   var data = {"genre_id":genreId, 
         "genre_name" : $('#mod_genre_name').val()}
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
            alert("해당 장르가 수정되었습니다.")
            acyncMovePage('manage_genre.mdo');
         } else {
            alert("[Error] 장르 수정 오류");
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

// PDF 이름값 저장을 하기 위한..
function acyncGenrePdf(url) {
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
            acyncMovePage('manage_genre.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}