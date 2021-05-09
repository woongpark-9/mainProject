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

var cancleTid = "";
$(document).ready(function() {
	$('#cancle').on('show.bs.modal', function(event) {
		cancleTid = $(event.relatedTarget).data('tid');
		// alert(movieDeleteSeq);
		// console.log(movieDeleteSeq);
	});
});

//결제 취소
function acyncCancelPayment(url) {

	var form = {
	   "tid" : cancleTid,
	   "total" : document.getElementById("total").value
	};
	$.ajax({
	   url : url,
	   type : "POST",
	   data : form,
	   dataType : "json",
	   success : function(data) {
	      if (data == 1) {
	    	  alert('결제취소완료');
	    	  acynUpdateSalesStatus('updateSalesStatus.mdo', tid);
	      } else {
	         alert("[Error] 결제 취소 오류");
	      }
	   },
	   error : function() {
	      alert("error");
	   }
	});
}

//결제 취소 시 결제 상태값 변경
function acynUpdateSalesStatus(url, get_tid) {
	$.ajax({
	   url : url,
	   type : "POST",
	   data : get_tid,
	   dataType : "json",
	   success : function(data) {
	      if (data == 1) {
	    	  alert("해당 결제건이 취소되었습니다.");
	    	  acyncMovePage('manage_sales.mdo');
	      } else {
	         alert("[Error] 결제 상태값 변경 오류");
	      }
	   },
	   error : function() {
	      alert("error");
	   }
	});
}
