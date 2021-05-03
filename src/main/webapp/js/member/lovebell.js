/**
 * 
 */
//var autoplayVideoInterval = setInterval("autoplayVideo()",200);
//
//
//function autoplayVideo()
//{
//var promise = document.querySelector('video').play();
//if (promise !== undefined)
//{
//promise.then(function (_)
//{
//// Autoplay started!
//clearInterval(autoplayVideoInterval);
//
//}).catch(function (error) {// Autoplay was prevented.
//// Show a "Play" button so that user can start playback.
//});
//}
//}
$(document).ready(function () {


	
	if($('.favorite-items').length > 6){

	$('.favorite-list').slick({

		autoplay : false,
		speed : 300 /* 이미지가 슬라이딩시 걸리는 시간 */,

		infinite: true,
		dots : true,
		autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,

		arrows: true,

		slidesToShow: 6,

		slidesToScroll: 6,
		draggable : false,
//		centermode:true,
//		fade: false


	
	
	});

	
	}
	
	if($('.watch-items').length > 6){

		$('.watch-list').slick({

			autoplay : false,
			speed : 300 /* 이미지가 슬라이딩시 걸리는 시간 */,

			infinite: true,
			dots : true,
			autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,

			arrows: true,

			slidesToShow: 6,

			slidesToScroll: 6,
			draggable : false,
//			centermode:true,
//			fade: false


		
		
		});

		
		}

	
	

});

function replay() {
	document.querySelector('video').load();
}