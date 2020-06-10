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
						var member_id = this.member_id;
						var reply_dt = this.reply_dt;
						htmls += `<tr class='reply-list-${index} my-board'>`;
						htmls += "<td>";
						htmls += "<span class='bNum'>" + board_no + "</span>";
						htmls += "<p><a href=board-view?board_no=" + board_no + ">" + reply_con + "</a></p>";
						htmls += "</td>";
						htmls += "<td>";
						htmls += "<span>" + member_id + "</span>";
						htmls += "<p class='date-format'>" + reply_dt + "</p>";
						htmls += "</td>";
						htmls += "</tr>";
					});
				} else {
					htmls += "<tr><td colspan='2'>등록된 댓글이 없습니다.</td></tr>";
				}
				if(data["dataSize"] >= 8)
					htmls += "<tr id='more-btn'><td colspan='2'><button type='button' id='more-btn' onclick='getMoreReplyList(this.value);' value='1'>+ 더 보기</button></td><tr>";
				$("#reply-write-list").append(htmls);
			},
			error: function(error){
				alert("에러 발생 : " + error);
			}
		});
	}
});
function getMoreReplyList(btnValue){
	var id = document.getElementById("id").value;
	var currentPage = Number(btnValue) + 1;
	jQuery.ajax({
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
					var member_id = this.member_id;
					var reply_dt = this.reply_dt;
					htmls += `<tr class='reply-list-${index} my-board'>`;
					htmls += "<td>";
					htmls += "<span class='bNum'>" + board_no + "</span>";
					htmls += "<p><a href=board-view?board_no=" + board_no + ">" + reply_con + "</a></p>";
					htmls += "</td>";
					htmls += "<td>";
					htmls += "<span>" + member_id + "</span>";
					htmls += "<p class='date-format'>" + reply_dt + "</p>";
					htmls += "</td>";
					htmls += "</tr>";
				});
			} else {
				htmls += "<tr><td colspan='2'>더 불러올 댓글이 없습니다.</td></tr>";
			}
			if(data["dataSize"] >= 8)
				htmls += "<tr id='more-btn'><td colspan='2'><button type='button' onclick='getMoreReplyList(this.value);' " + "value=" + currentPage + ">+ 더 보기</button></td><tr>";
			$("#more-btn").remove();
			$("#reply-write-list").append(htmls);
			var height = document.getElementById('board-write-list').getBoundingClientRect().height;
			document.getElementById("content").style.minHeight = height + "px";
		},
		error: function(error){
			alert("에러 발생 : " + error);
		}
	});
}