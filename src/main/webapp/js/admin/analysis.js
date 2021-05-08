
function acyncDateParmeter(url){
	  var form = {"date1" : document.getElementById('t1').value,
			  	  "date2" : document.getElementById('t2').value
	             }; 
	 $.ajax({
	      url : url,
	      type : "POST",
	      data : form,
//	      dataType : "json",
	      success : function(data) {
	    	  $('#bodyContents').children().remove();
	    	  $('#bodyContents').html(data);
	      },
	      error : function() {
	         alert("error");
	      }
	   });
}