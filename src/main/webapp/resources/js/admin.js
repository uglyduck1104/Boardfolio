$(function(){

	$('#date-search1').datepicker({
		 format: "yyyy-mm-dd",
		 language: "kr",
		 daysOfWeekHighlighted: "0",
		 autoclose : true,
		 todayHighlight: true
	});
	$('#date-search2').datepicker({
		format: "yyyy-mm-dd",
		language: "kr",
		daysOfWeekHighlighted: "0",
		autoclose : true,
		todayHighlight: true
	});
});

function dateChk(f){
	var num1 = Number(f.beginDate.value.replace(/-/gi,""));
	var num2 = Number(f.endDate.value.replace(/-/gi,""));
	if(num1 > num2){
		alert("작성일 검색 시작 날짜가 종료 날짜보다 큽니다.");
		return false;
	}
	return true;
}

