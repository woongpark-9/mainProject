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
        $('#bodyContents').children().remove();
        // Contents 영역 교체
        $('#bodyContents').html(data);
    });
}

function acyncMovePage2(url){
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
        $('#body').children().remove();
        // Contents 영역 교체
        $('#body').html(data);
    });
}

function acyncMovePage3(url, id, name, img, kid) {
    // ajax option
    var ajaxOption = {
            url : url,
            data : {"profile_id" : id, "profile_name" : name, "profile_img" : img, "kids" : kid},
            type : "POST",
    };
    
    $.ajax(ajaxOption).done(function(data){
        // Contents 영역 삭제
        $('#body').children().remove();
        // Contents 영역 교체
        $('#body').html(data);
    });
}