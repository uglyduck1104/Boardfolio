/**
 * 
 * @author UglyDuck
 * getRecBtnStat(): 추천, 비추천 처리에 따른 상태 불러오기
 * refreshRecBtnStat(): Jquery -> javascript로 함수 전달
 * countRecs(): 추천, 비추천 처리
 * resetRecs(): 추천, 비추천 초기화(=삭제)
 * 
 */
$(function(){
	getRecBtnStat();
	
	function getRecBtnStat(){
		var memberId = $("#memberId").val();
		var boardNo = $("#boardNo").text();
		$.ajax({
			url: "rec-btn-stat",
			type: "GET",
			dataType: "json",
			data: "memberId=" + memberId +
				  "&boardNo=" + boardNo,
			success: function(obj){
				if(obj["btnStat"]=="good"){
					$("#goodStat").addClass("goodActive");
					$("#badStat").removeClass("badActive");
				} else if(obj["btnStat"]=="bad"){
					$("#goodStat").removeClass("goodActive");
					$("#badStat").addClass("badActive");
				} else {
					$("#goodStat").removeClass("goodActive");
					$("#badStat").removeClass("badActive");
					
				}
			},
			error: function(){
				alert("Ajax 통신 실패");
			}
			
		});
	}
	refreshRecBtnStat = getRecBtnStat;
	
});
function refreshRecBtnStat(){
	getRecBtnStat();
}

function countRecs(recommend){
	var boardNo = $("#boardNo").text();
	var memberId = $("#memberId").val();
	if( memberId != null ){
		jQuery.ajax({
			url: "count-recs",
			type: "POST",
			dataType: "json",
			data: "boardNo=" + boardNo + 
			"&memberId=" + memberId +
			"&recVote=" + recommend,
			success: function(obj){
				console.log(obj);
				if(obj["isChecked"] == "true"){
					if(confirm("추천을 취소하시겠습니까?")){
						resetRecs(boardNo, memberId);
					}
				} else if(obj["isChecked"] == "false"){
					if(confirm("비추천을 취소하시겠습니까?")){
						resetRecs(boardNo, memberId);
					}
				}
				if(obj["isRecommend"] == "good"){
					alert("추천 했습니다.");
					refreshRecBtnStat();
				} else if(obj["isRecommend"] == "bad"){
					alert("비추천 했습니다.");
					refreshRecBtnStat();
				}
			},
			error: function(){
				alert("Ajax 통신 실패!");
			}
		});
	} else {
		alert("로그인 후 이용해주세요.");
	}
}
function resetRecs(boardNo, memberId){
	jQuery.ajax({
		url: "reset-recs",
		type: "POST",
		dataType: "json",
		data: "boardNo=" + boardNo + 
		"&memberId=" + memberId,
		success: function(obj){
			if(obj["result"] > 0){
				refreshRecBtnStat();
			}
		},
		error: function(){
			alert("Ajax 통신 실패!");
		}
	});
}