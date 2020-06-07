/**
 * 
 * @author UglyDuck
 * getReplyList(): 댓글 목록 불러오기
 * getRecBtnStat(): 추천, 비추천 처리에 따른 상태 불러오기
 * refreshReplyList(): Jquery -> javascript로 함수 전달
 * refreshRecBtnStat(): Jquery -> javascript로 함수 전달
 * replyUpdateArea(): 댓글 입력 공간 만들기
 * replyReset(): 댓글 수정 취소
 * replyUpdate(): 댓글 수정
 * replyDrop(): 댓글 삭제
 * countRecs(): 추천, 비추천 처리
 * resetRecs(): 추천, 비추천 초기화(=삭제)
 * 
 */
$(function(){
	getReplyList();
	getRecBtnStat();
	
	function getReplyList(){
		var boardNo = $("#board_no").val();
		var memberId = $("#member_id").val();
		$.ajax({
			url: "reply-list",
			type: "GET",
			dataType: "json",
			data: "boardNo=" + boardNo, 
			success: function(data){
				$("#reply-view").empty();
				var htmls = "";
				var dataSize = data["dataSize"];
				htmls += "<tr class='reply-size'><td>댓글 " + dataSize + "개</td></tr>"; 
				if( data["dataSize"] > 0){
					$.each(data.data, function(index, item){
						var member_id = this.member_id; 
						var reply_con = this.reply_con; 
						var reply_dt = this.reply_dt;
						var isYourId = this.isYourId;
						var reply_no = this.reply_no
						reply_dt = reply_dt.replace(/-/gi,"");
						htmls += `<tr class='comment-${index}'><td>`;
						htmls += "<div>"
						htmls += "<span>" + member_id + "</span>";
						htmls += "<p class='date-format'>" + reply_dt + "</p>";
						if( isYourId ){
							htmls += `<button type='button' class='out-side-btn' onclick='replyUpdateArea(${index})'>수정하기</button>`;
							htmls += `<button type='button' class='out-side-btn' onclick='replyDrop(${index}, "${item.reply_no}")'>삭제하기</button>`;
							htmls += `<div class='comment-${index}' style="display:none;">`;
							htmls += `<textarea name='replyCon'>${item.reply_con}</textarea>`;
							htmls += `<button type='button' onclick='replyUpdate(${index}, "${item.reply_con}", "${item.reply_no}")'>수정</button>`;
							htmls += `<button type='button' onclick='replyReset(${index})'>취소</button>`;
							htmls += "</div>";
						}
						htmls += "<p class='reply-con'>" + reply_con + "</p>";
						htmls += "</div>"
						htmls += "</td></tr>";
					});
					$("#reply-con").val('');
				} else {
					htmls += "<tr><td colspan='3'>작성된 댓글이 없습니다.</td></tr>";
				}
				$("#reply-view").append(htmls);
			},
			error: function(){
				alert("Ajax 통신 실패!");
			}
		});
	}
	
	refreshReplyList = getReplyList;
	
	// 댓글 등록
	$("#reply-btn").click(function(){
		var replyCon = $("#reply-con").val();
		if( replyCon ){
			$.ajax({
				url: "reply-write",
				type: "POST",
				dataType: "json",
				data: $("#reply-form").serialize(),
				success: function(obj){
					if( obj["isReplyWrite"] == "YES"){
						getReplyList();
					} else {
						alert("댓글 등록이 실패했습니다. 관리자에게 문의해주세요.");
					}
				},
				error: function(){
					alert("Ajax 통신 실패");
				}
			}); // end ajax
		} else {
			alert("댓글 내용을 입력해주세요!");
		} // end if
	}); // end click
	
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
function refreshReplyList(){
	getReplyList();
}
function refreshRecBtnStat(){
	getRecBtnStat();
}

function replyUpdateArea(index){
	var replyArea = $(`.comment-${index}`);
	replyArea.children('td').children('div').children('div').css("display","block");
	replyArea.children('td').children('div').children('p.reply-con').css("display","none");
} // end replyUpdateArea()

function replyReset(index){
	var replyArea = $(`.comment-${index}`);
	replyArea.children('td').children('div').children('div').css("display","none");
	replyArea.children('td').children('div').children('p.reply-con').css("display","block");
	
} // end replyReset()

function replyUpdate(index, content, no){
	var replyArea = $(`.comment-${index}`);
	var replyCon = replyArea.children('td').children('div').children('div').children('textarea').val();
	if( content != replyCon && replyCon != ""){
		jQuery.ajax({
			url: "reply-update",
			type: "POST",
			data: "replyNo=" + no + "&replyCon=" + replyCon,
			dataType: "json",
			success: function(obj){
				if( obj["isReplyUpdate"] == "YES"){
					refreshReplyList();
				} else {
					alert("댓글 수정이 실패했습니다. 관리자에게 문의해주세요.");
				}
			},
			error: function(){
				alert("Ajax 통신 실패!");
			}
		}); // end ajax
	} else if(replyCon == ""){
		alert("수정할 댓글 내용을 입력해주세요.");
	} else {
		replyReset(index);
	} // end if
} // end replyUpdate()

function replyDrop(index,  no){
	if( confirm("삭제하시겠습니까?") ){
		jQuery.ajax({
			url: "reply-drop",
			type: "POST",
			data: "replyNo=" + no,
			dataType: "json",
			success: function(obj){
				if( obj["isReplyDelete"] == "YES"){
					refreshReplyList();
				} else {
					alert("댓글 삭제가 실패했습니다. 관리자에게 문의해주세요.");
				}
			},
			error: function(){
				alert("Ajax 통신 실패!");
			}
		}); // end ajax
	} else {
		replyReset(index);
	} // end if
} // end replyDelete()

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