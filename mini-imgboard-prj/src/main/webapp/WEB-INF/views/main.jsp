<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>

<style type="text/css">
h1 {
	text-align: center;
}

#imgBoardList {
	margin: 0 auto;
	width: 70%;
	border: 1px solid gray;
	display: flex;
	flex-wrap: wrap;
}

.imgBoardBox {
	width: 200px;
	height: 200px;
	margin: 4px;
	border: 1px solid black;
}

#moreList {
	text-align: center;
	font-size: 20px;
	clear: both;
	margin: 0 auto;
	width: 70%;
	height: 30px;
	border: 1px solid gray;
	cursor: pointer;
}

#modal-btn {
	display: inline-block;
	padding: 20px;
	background-color: #222;
	color: white;
	border-radius: 10px;
	cursor: pointer;
}

#modal-wrapper {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 10;
}

#modal-box {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 500px;
	height: 300px;
	width: 500px;
	background-color: white;
	border-radius: 20px;
	z-index: 2;
}

#modal-cancle-btn {
	position: absolute;
	top: 0;
	right: 0;
	padding: 10px;
	margin: 5px;
	color: white;
	border-radius: 10px;
	z-index: 2;
	background-color: #6E6E6E;
	cursor: pointer;
}

#modal-cancle-area {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.9);
	z-index: 1;
}

#modal-cancle-btn:hover {
	background-color: #222;
}
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$("#moreList").on("click",function(){
			let start = $(".imgBoardBox").length +1;
			let end = start+8;
// 			console.log("start: " + start+", end: " +end);
			
			$.ajax({
				url:"${path}/main/morelist",
				type:"post",
				data:{"start":start,"end":end},
				dataType:"json",
				success:function(data){
					
					if(data.length < 9){
						$("#moreList").remove();
					}
					if(data.length > 0){
						let imgBoardList="";
						for(let i = 0; i < data.length; i++){
							imgBoardList += "<div class='imgBoardBox'>"
								+ "<input type='hidden' name='no' value='"+ data[i].no +"'>"
								+ "<input type='hidden' name=userid value='"+ data[i].userid +"'>"
								+ "<input type='hidden' name='content' value='"+ data[i].content +"'>"
								+ "<input type='hidden' name='regdate' value='"+ data[i].regdate +"'>"
								+ "<img alt='이미지'src='${path}/" + data[i].img +"' width='200px' height='200px'>"
								+ "</div>";
						}
						$("#imgBoardList").append(imgBoardList);
					}
				},
				error:function(request, status, error){
					
				}
			});
		});
	});
</script>

</head>
<body>
	<h1>이미지 게시판</h1>
	<c:if test="${id ne null}">
		<a class="nav" href="${path }/main/imgboard-regist-page">등록</a>
	</c:if>

	<c:choose>
		<c:when test="${id ne null}">
			<a class="nav" href="${path }/user/logout">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a class="nav" href="${path }/user/login">로그인</a>
		</c:otherwise>
	</c:choose>
	<div id="imgBoardList">
		<c:forEach items="${ibList }" var="ibvo">
			<div class="imgBoardBox">
				<input type="hidden" name="no" value="${ibvo.no }"> <input
					type="hidden" name=userid value="${ibvo.userid }"> <input
					type="hidden" name="content" value="${ibvo.content }"> <input
					type="hidden" name="regdate" value="${ibvo.regdate }">
				<%-- 			<img alt="이미지" src="${ibvo.img }" width="200px" height="200px"> --%>
				<img alt="이미지" src="${path }/${ibvo.img }" width="200px"
					height="200px">
				<!-- 								/uploadfolder	/upload/a.jpg -->
			</div>
		</c:forEach>
	</div>

	<div id="moreList">더보기</div>
	<div id="modal-wrapper">
		<div id="modal-box">
			<div id="modal-cancle-btn">X</div>
		</div>
		<div id="modal-cancle-area"></div>
	</div>

	<script type="text/javascript">
		$("#imgBoardList").on("click",function(event){
			if(event.target.className=="imgBoardBox" || event.target.nodeName=="IMG"){
				
				$("modal-box").append(event.target.parent);
				$("#modal-wrapper").show();
				
			}
		});
		
		var modalBtn = document.getElementById("modal-btn");
		var modalWrap = document.getElementById("modal-wrapper");
		var cancleArea = document.getElementById("modal-cancle-area");
		cancleArea.onclick = function() {
			modalWrap.style.display = "none";
		}
		var cancleBtn = document.getElementById("modal-cancle-btn");
		cancleBtn.onclick = function() {
			modalWrap.style.display = "none";
		}
	</script>
</body>
</html>