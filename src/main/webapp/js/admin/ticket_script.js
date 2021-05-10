var ticketDeleteSeq = "";
var ticketModifyId = "";
var ticketModifyName = "";
var ticketModifyperiod = "";
var ticketModifyprice = "";
var ticketModifystatus = "";
var ticketModifySeq = "";


$(document).ready(function() {
   $('#deleteTicket').on('show.bs.modal', function(event) {
      ticketDeleteSeq = $(event.relatedTarget).data('delseq');

   });
   
    $('#modifyTicket').on('show.bs.modal', function(event) { 
         ticketModifyId = $(event.relatedTarget).data('modify_ticket_id');
         ticketModifyName = $(event.relatedTarget).data('modify_ticket_name');
         ticketModifyperiod = $(event.relatedTarget).data('modify_ticket_period');
         ticketModifyprice = $(event.relatedTarget).data('modify_ticket_price');
         ticketModifystatus = $(event.relatedTarget).data('modify_ticket_status');
         ticketModifySeq = $(event.relatedTarget).data('modify_ticket_seq');
         
         $('#mod_ticket_id').val(ticketModifyId);
         $('#mod_ticket_name').val(ticketModifyName);
         $('#mod_ticket_period').val(ticketModifyperiod);
         $('#mod_ticket_price').val(ticketModifyprice);
         $('#mod_ticket_status').val(ticketModifystatus);
      });
});


//티켓 추가 
function acyncInsertTicket(url) { //data : { "genre_name" : $('#ins_genre_name').val()},
   $.ajax({
      url : url,
      type : "POST",
      data : { "ticket_id" : $('#ticket_id').val(),
    	  		"ticket_name" : $('#ticket_name').val(),
    	  		"ticket_price" : $('#ticket_price').val(),
    	  		"ticket_period" : $('#ticket_period').val(),
    	  		"ticket_status" : $('#ticket_status').val(),
      },
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("해당 티켓이 추가되었습니다.");
            acyncMovePage('manage_ticket.mdo');
         } else {
            alert("[Error] 티켓 추가 오류");
         }
      },
      error : function() {
         alert("티켓 추가 오류");
      },
      complete : function() {
    	  acyncMovePage('manage_ticket.mdo');
      }
   });
}

//티켓 수정
function acyncModifyTicket(url) {
   //var $form = $('#modifyDirectorForm').serialize();
   var form = {"seq" : ticketModifySeq,
		   	"ticket_id" : $('#mod_ticket_id').val(),
            "ticket_name" : $('#mod_ticket_name').val(),
            "ticket_period" : $('#mod_ticket_period').val(),
            "ticket_price" : $('#mod_ticket_price').val(),
            "ticket_status" : $('#mod_ticket_status').val()
            }; 
//   console.log(JSON.stringify(form));
//   alert(JSON.stringify(form));
   $.ajax({
      url : url,
      type : "POST",
      data : form,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {
            alert("해당 티켓 정보가 수정되었습니다.");  
            acyncMovePage('manage_ticket.mdo');
         } else {
            alert("[Error] 티켓 수정 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//티켓 삭제
function acyncDeleteTicket(url) {
   var seq = {
      "seq" : ticketDeleteSeq
   };
//   console.log(JSON.stringify(seq));
//   alert(JSON.stringify(seq));
   $.ajax({
      url : url,
      type : "POST",
      data : seq,
      dataType : "json",
      success : function(data) {
//         console.log(JSON.stringify(data));
//         alert(JSON.stringify(data));
         if (data == 1) {

            alert("해당 티켓이 삭제되었습니다.");
            acyncMovePage('manage_ticket.mdo');
         } else {
            alert("[Error] 티켓 삭제 오류");
         }
      },
      error : function() {
         alert("error");
      }
   });
}

//Ticket PDF 이름값 저장을 하기 위한..
function acync_ticket_pdf(url) {
   $.ajax({
      url : url,
      type : "POST",
      data : {
         'newticketpdf' : $('#newticketpdf').val()
      },
      dataType : "json",
      success : function(data) {
         if (data == 1) {
            alert("PDF가 저장 되었습니다");
            acyncMovePage('manage_ticket.mdo');
         } else {
            alert("PDF 저장 실패 했습니다.");
         }
      },
      error : function() {
         alert("PDF 저장 실패 했습니다.");
      }
   });
}