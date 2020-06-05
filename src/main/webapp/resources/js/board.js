$(function(){
	var searchValue = $("#searchInput");
	var btnIco = $(".ico");
	btnIco.css("display","none");
	// 검색 영역 X버튼 표시/비표시
	searchValue.keyup(function(){
		if( searchValue.val() != ""  ){
			btnIco.css("display","block");
		} else {
			btnIco.css("display","none");
		}
	});
	searchValue.focusin(function(){
		if( searchValue.val() != ""  ){
			btnIco.css("display","block");
		} else {
			btnIco.css("display","none");
		}
	});
	// 클릭 이벤트 처리 후 사라지는 이벤트
	searchValue.blur(function(){
		var timer = setTimeout(function(){
			btnIco.css("display","none");
		}, 150);
	});
	// x버튼 input 값 지우기
	btnIco.click(function(){
		searchValue.val("");
	});
});

