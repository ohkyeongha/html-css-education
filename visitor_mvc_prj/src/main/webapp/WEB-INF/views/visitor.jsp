<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 톰캣에서 바이너리 리드미에서 위의 태그라이브러리 가져오면 된다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script>
	window.onload = function(){
		//readOnly를 false로 바꿔주기위한 자바스크립트문
		const searchVisitors = document.getElementById("search-visitors");
		searchVisitors.onclick = function(event){
// 			console.log(event.target);
			//달러도 변수명으로 지정가능
			$target = event.target;
					//아래의 $target은 textarea이다.  previous는 vvo.nickname =>var nickname은 vvo.nickname
			var nickname = $target.previousElementSibling.value;
			console.log((nickname == "${nickname}"));
					//nodeName =태그네임이다          readonly가 아니면 false반환 readonly면 true로 반환
			if($target.nodeName == "TEXTAREA" 
					&& $target.readOnly 
					&& (nickname == "${nickname}")){
				
				var result = confirm("수정하시겠습니까?");
				if(result){
					$target.readOnly = false;
					
				}
				
			}
		}
		
		
	}
							//그저 변수 : 자기자신객체를 가져오는 매개변수
	function updateVisitor($this){
		console.log($this);
		var form = $this.parentElement;
		form.action ="update";
		form.method="post";
		form.submit();
	}
	
	function deleteVisitor($this){
		var form = $this.parentElement;
		form.action ="delete";
		form.method="post";
		form.submit();
	
		
	}

</script>
</head>
<body>
	<h1>방명록 입니다.</h1>
	<form action="regist" method="post">		<!--EL를 썻기에 따로 세션 scope쓰지않아도 됨  --> 
		<input type="hidden" name="nickname" value="${nickname}"><br>
		<textarea rows="10" cols="40" name="content" ></textarea>
		<input type="submit" value="등록">
	</form>
	
	<div id="search-visitors">
			<!--select항목들을 가져오기 위한 for문 -->								
	  <c:forEach items="${vlist}" var="vvo"> <!-- 변수명 -->
		<form action="" method="">

			<br><input type="hidden" name="vno" value="${vvo.vno} ">
			<span>${vvo.nickname } - ${vvo.regdate}</span><!-- textarea바로 위에 닉네임이 잇어야함 --><br>
			<input type= "hidden" name="nickname" value="${vvo.nickname}">
			<textarea rows="10" cols="40" name="content" readonly>${vvo.content }</textarea><br>
			
			<c:if test="${nickname eq vvo.nickname}">
				<a href="#" onclick="updateVisitor(this)">수정</a>
				<a href="#" onclick="deleteVisitor(this)">삭제</a>
			</c:if>
			
		</form>
	  </c:forEach>
	</div>
</body>
</html>