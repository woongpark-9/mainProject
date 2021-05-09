//PDF 이름값 저장을 하기 위한..
function acyncSalesPdf(url){
   $.ajax({
      url : url,
      type : "POST",
      data:{'newpdf' : $('#newpdf').val()},
      dataType:"json",
      success : function(data) {
         if(data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_sales.mdo');
         } else {
            alert("PDF저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("error");
      }
   });
}


//결제 취소
function acyncCancelPayment(url) {
	var form = {
	   "tid" : document.getElementById("tid").value,
	   "total" : document.getElementById("total").value
	};
	$.ajax({
	   url : url,
	   type : "POST",
	   data : form,
	   dataType : "json",
	   success : function(data) {
	      if (data == 1) {
	         alert("해당 답변이 수정되었습니다.");
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