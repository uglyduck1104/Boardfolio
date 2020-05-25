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
						var board_dt = this.board_dt;
						htmls += `<tr class='board-list-${index}'>`;
						htmls += "<td>" + board_no + "</td>";
						htmls += "<td><a href=board-view?board_no=" + board_no + ">" + title + "</a></td>";
						htmls += "<td>" + board_dt + "</td>";
						htmls += "</tr>";
					});
				} else {
					htmls += "<tr><td colspan='3'>등록된 게시물이 없습니다.</td></tr>";
				}
				if(data["dataSize"] >= 8)
					htmls += "<tr id='more-btn'><td colspan='3'><button type='button' id='more-btn' onclick='getMoreBoardList(this.value);' value='1'>더보기</button></td><tr>";
				$("#board-write-list").append(htmls);
			},
			error: function(error){
				alert("에러 발생 : " + error);
			}
		});
	}
});
function getMoreBoardList(btnValue){
	var id = $("#id").val();
	var currentPage = Number(btnValue) + 1;
	$.ajax({
		url: "board-ajax-list",
		type: "GET",
		dataType: "json",
		data: {"id" : id, "currentPage" : currentPage},
		success: function(data){
			console.log(data);
			var htmls = "";
			if( data["dataSize"] > 0){
				$.each(data.data, function(index, item){
					var board_no = this.board_no; 
					var title = this.title; 
					var board_dt = this.board_dt;
					htmls += `<tr class='board-list-${index}'>`;
					htmls += "<td>" + board_no + "</td>";
					htmls += "<td><a href=board-view?board_no=" + board_no + ">" + title + "</a></td>";
					htmls += "<td>" + board_dt + "</td>";
					htmls += "</tr>";
				});
			} 
			if( data["dataSize"] >= 8 ) 
				htmls += "<tr id='more-btn'><td colspan='3'><button type='button' onclick='getMoreBoardList(this.value);' " + "value=" + currentPage + ">더보기</button></td><tr>";
			$("#more-btn").remove();
			$("#board-write-list").append(htmls);
		},
		error: function(error){
			alert("에러 발생 : " + error);
		}
	});
}