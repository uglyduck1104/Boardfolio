$(function(){
	
	getMyBoardList();
	
	function getMyBoardList(){
		var id = $("#id").val();
		$.ajax({
			url: "board-ajax-list",
			type: "GET",
			dataType: "json",
			data: {"id" : id},
			success: function(data){
				var htmls = "";
				if( data["dataSize"] > 0){
					$.each(data.data, function(index, item){
						var board_no = this.board_no; 
						var title = this.title;
						var member_id = this.member_id;
						var board_dt = this.board_dt;
						htmls += `<tr class='board-list-${index} my-board'>`;
						htmls += "<td>";
						htmls += "<span class='bNum'>" + board_no + "</span>";
						htmls += "<p><a href=board-view?board_no=" + board_no + ">" + title + "</a></p>";
						htmls += "</td>";
						htmls += "<td>";
						htmls += "<span>" + member_id + "</span>";
						htmls += "<p class='date-format'>" + board_dt + "</p>";
						htmls += "</td>";
						htmls += "</tr>";
					});
				} else {
					htmls += "<tr><td colspan='2'>등록된 게시물이 없습니다.</td></tr>";
				}
				if(data["dataSize"] >= 8)
					htmls += "<tr id='more-btn'><td colspan='2'><button type='button' id='more-btn' onclick='getMoreBoardList(this.value);' value='1'>+ 더 보기</button></td><tr>";
				$("#board-write-list").append(htmls);
			},
			error: function(error){
				alert("에러 발생 : " + error);
			}
		});
	}
});
function getMoreBoardList(btnValue){
	var id = document.getElementById("id").value;
	var currentPage = Number(btnValue) + 1;
	jQuery.ajax({
		url: "board-ajax-list",
		type: "GET",
		dataType: "json",
		data: {"id" : id, "currentPage" : currentPage},
		success: function(data){
			var htmls = "";
			if( data["dataSize"] > 0){
				$.each(data.data, function(index, item){
					var board_no = this.board_no; 
					var title = this.title; 
					var member_id = this.member_id;
					var board_dt = this.board_dt;
					htmls += `<tr class='board-list-${index} my-board'>`;
					htmls += "<td>";
					htmls += "<span class='bNum'>" + board_no + "</span>";
					htmls += "<p><a href=board-view?board_no=" + board_no + ">" + title + "</a></p>";
					htmls += "</td>";
					htmls += "<td>";
					htmls += "<span>" + member_id + "</span>";
					htmls += "<p class='date-format'>" + board_dt + "</p>";
					htmls += "</td>";
					htmls += "</tr>";
				});
			} 
			if( data["dataSize"] >= 8 ) {
				htmls += "<tr id='more-btn'><td colspan='2'><button type='button' onclick='getMoreBoardList(this.value);' " + "value=" + currentPage + ">+ 더 보기</button></td><tr>";
			}
			$("#more-btn").remove();
			$("#board-write-list").append(htmls);
			var height = document.getElementById('board-write-list').getBoundingClientRect().height;
			document.getElementById("content").style.minHeight = height + "px";
		},
		error: function(error){
			alert("에러 발생 : " + error);
		}
	});
}