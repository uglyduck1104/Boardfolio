$(function(){
	getReplyList();
	
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
				if( data["dataSize"] > 0){
					$.each(data.data, function(index, item){
						var member_id = this.member_id; 
						var reply_con = this.reply_con; 
						var reply_dt = this.reply_dt;
						var isYourId = this.isYourId;
						reply_dt = reply_dt.slice(0, 4) + "-" + reply_dt.slice(4, 6) + "-" + reply_dt.slice(6);
						htmls += `<tr class='comment-${index}'><td>`;
						htmls += member_id;
						htmls += reply_dt;
						htmls += reply_con;
						if( isYourId ){
							htmls += `<div class='comment-${index}' style="display:none;">`;
							htmls += `<input type='text' name='replyCon' value='${item.reply_con}'/>`;
							htmls += "<button type='button'>수정</button>";
							htmls += `<button type='button' onclick='replyReset(${index})'>취소</button>`;
							htmls += "</div>";
							htmls += `<button type='button' onclick='replyUpdateArea(${index})'>수정하기</button>`;
							htmls += "<button onclick='replyDelete()'>삭제하기</button>"
						}
						htmls += "</td></tr>";
					});
					$("#reply-con").val('');
				} else {
					htmls += "<tr>";
					htmls += "<td colspan='3'>작성된 댓글이 없습니다.</td>";
					htmls += "</tr>";
				}
				$("#reply-view").append(htmls);
			},
			error: function(request,status,error){
				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			}
		});
	}
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
					console.log(obj);
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
		} 
	}); // end click
	
});

//댓글 수정 입력 공간 만들기
function replyUpdateArea(index){
	var replyArea = $(`.comment-${index}`);   // 원래 댓글
	replyArea.children('td').children('div').css("display","block");
} // end replyUpdateArea()

//댓글 수정 취소
function replyReset(index){
	var replyArea = $(`.comment-${index}`);
	replyArea.children('td').children('div').css("display","none");
	
} // end replyReset()



