/**
 * 
 */

var checkFirst = false;
var lastKeyword = '';
var loopSendKeyword = false;

function startSuggest() {
   if (checkFirst == false) {
      setTimeout("searchajax();", 500);
      loopSendKeyword = true;
   }
   checkFirst = true;
}

function searchajax() {
   if (loopSendKeyword == false) return;
   var words = $("#search-txt").val();
   if (words == '') {
      lastKeyword = '';
      acyncMovePage('http://localhost:8080/nowflix/index.do');
   }
   else if (words != lastKeyword) {
      lastKeyword = words;
      if (words != '') {
         $.ajax({
         type: 'POST',
         url: 'search.do',
         data: {title : words},
         dataType: 'json',
         success: function(data){
            if ( data.length > 0){
               var str = '';
               str += '<div class="searchResult">다음과 관련된 콘텐츠: <span class="searchRes">' + words + '</span><br><br></div><div class="col-md-12">'
//               for (var i=0; i<data.length; i++){
//                  str += '<div class="col-md-2 poster"><img src="'
//                      + data[i].poster_path
//                      + '" alt=""></div>';
               for (var i=0; i<30; i++){
                  str += '<div class="col-md-2 poster"><img src="'
                      + 'http://yonom.duckdns.org/test.jpg'
                      + '" alt="" style="width:17vw; height:auto;"></div>';
               }
               str += "</div>"
               $('.banner').children().remove();
               $('.video').remove();
               $(".banner").html(str);
            } 
            else {
            }
         },
          error: function(e) {console.log('error:' + e.status);}
         });
      } 
   }
   loopSendKeyword = false;
   checkFirst = false;
   lastKeyword = '';
}

function acyncMovePage(url){
    // ajax option
    var ajaxOption = {
            url : url,
            async : true,
            type : "POST",
            dataType : "html",
            cache : false
    };
    
    $.ajax(ajaxOption).done(function(data){
        // Contents 영역 삭제
        $('.home').children().remove();
        // Contents 영역 교체
        $('.home').html(data);
    });
}