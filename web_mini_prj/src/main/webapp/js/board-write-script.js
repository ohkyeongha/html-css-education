window.onload=function(){
	var saveBtn = document.getElementById("board-save-btn");
	saveBtn.onclick=function(){
		var bTitle = document.getElementById("bTitle");
		var bContent = document.getElementById("bContent");
		
		if(bTitle.value==""){
			alert("제목을 입력하세요.");
			bTitle.focus();
			return;
		}
		if(bContent.value==""){
			alert("내용을 입력하세요.");
			bContent.focus();
			return;
		}
		
		document.boardWriteFrom.submit();
		
	}
	
}