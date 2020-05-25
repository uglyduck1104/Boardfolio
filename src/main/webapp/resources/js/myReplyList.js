$(function(){
	
	getMyReplyList();
	
	function getMyReplyList(){
		var id = $("#id").val();
		$.ajax({
			url: "reply-ajax-list",
			type: "GET",
			dataType: "json",
			data: {"id" : id},
			success: function(data){
				var htmls = "";
				if( data["dataSize"] > 0){
					$.each(data.data, function(index, item){
						var board_no = this.board_no; 
						var reply_con = this.reply_con; 
						var reply_dt = this.reply_dt;
						htmls += `<tr class='reply-list-${index}'>`;
						htmls += "<td><a href=board-view?board_no=" + board_no + ">" + board_no + "</a></td>";
						htmls += "<td>" + reply_con + "</td>";
						htmls += "<td>" + reply_dt + "</td>";
						htmls += "</tr>";
					});
				} else {
					htmls += "<tr><td colspan='3'>등록된 댓글이 없습니다.</td></tr>";
				}
				if(data["dataSize"] >= 8)
					htmls += "<tr id='more-btn'><td colspan='3'><button type='button' id='more-btn' onclick='getMoreReplyList(this.value);' value='1'>더보기</button></td><tr>";
				$("#reply-write-list").append(htmls);
			},
			error: function(error){
				alert("에러 발생 : " + error);
			}
		});
	}
});
function getMoreReplyList(btnValue){
	var id = $("#id").val();
	var currentPage = Number(btnValue) + 1;
	$.ajax({
		url: "reply-ajax-list",
		type: "GET",
		dataType: "json",
		data: {"id" : id, "currentPage" : currentPage},
		success: function(data){
			var htmls = "";
			if( data["dataSize"] > 0){
				$.each(data.data, function(index, item){
					var board_no = this.board_no; 
					var reply_con = this.reply_con; 
					var reply_dt = this.reply_dt;
					htmls += `<tr class='reply-list-${index}'>`;
					htmls += "<td><a href=board-view?board_no=" + board_no + ">" + board_no + "</a></td>";
					htmls += "<td>" + reply_con + "</td>";
					htmls += "<td>" + reply_dt + "</td>";
					htmls += "</tr>";
				});
			} else {
				htmls += "<tr><td colspan='3'>더 불러올 댓글이 없습니다.</td></tr>";
			}
			if(data["dataSize"] >= 8)
				htmls += "<tr id='more-btn'><td colspan='3'><button type='button' onclick='getMoreReplyList(this.value);' " + "value=" + currentPage + ">더보기</button></td><tr>";
			$("#more-btn").remove();
			$("#reply-write-list").append(htmls);
		},
		error: function(error){
			alert("에러 발생 : " + error);
		}
	});
}