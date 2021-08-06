<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Astral by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/main.css" />
<noscript><link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/noscript.css" /></noscript>
<link href='${pageContext.request.contextPath }/calendar-assets/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/calendar-assets/main.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var no = document.getElementById("no");
		var mdate = document.getElementById("mdate");
		var title = document.getElementById("title");
		var memo = document.getElementById("memo-area");
		var cancelBtn = document.getElementById("cancel-btn");
		var saveBtn = document.getElementById("save-btn");
		var updateBtn = document.getElementById("update-btn");
		var deleteBtn = document.getElementById("delete-btn");
		
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView: 'dayGridMonth',
			dateClick: function(info){
				
				no.value="";
				mdate.value = info.dateStr
				title.value="";
				memo.value="";
				saveBtn.setAttribute("type","button");
				updateBtn.setAttribute("type","hidden");
				deleteBtn.setAttribute("type","hidden");
				
				location.href="${pageContext.request.contextPath }/index#memo";
			},
			eventClick: function(arg){
				
				no.value = arg.event.id;
				mdate.value = arg.event.startStr;
				title.value = arg.event.title;
				memo.value = arg.event.extendedProps.description;
				
				saveBtn.setAttribute("type","hidden");
				updateBtn.setAttribute("type","button");
				deleteBtn.setAttribute("type","button");
				
				location.href="${pageContext.request.contextPath }/index#memo";
				
			},
			events: ${mjson}
        
        });
        
        calendar.render();
     
		
		cancelBtn.onclick = function(){
			
			no.value="";
			mdate.value="";
			title.value="";
			memo.value="";
			saveBtn.setAttribute("type","button");
			updateBtn.setAttribute("type","hidden");
			deleteBtn.setAttribute("type","hidden");
			
			location.href="${pageContext.request.contextPath }/index#home";
			
		}
		saveBtn.onclick = function(){
			//ajax 통신 요청
			var xhr = new XMLHttpRequest();
			xhr.open("POST","${pageContext.request.contextPath}/memo-regist",true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("mdate="+mdate.value+"&title="+title.value+"&memo="+memo.value);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == XMLHttpRequest.DONE && xhr.status ==200){
					
					var code = xhr.responseText;
					
					if(code){
						calendar.addEvent({
							title: title.value,
							start: mdate.value,
							description: memo.value
						});
						alert("메모 등록 성공");
					} else {
						alert("메모 등록 실패");
					}
					
				}
			}
// 			document.form.submit();
		}
		updateBtn.onclick = function(){
			document.form.action = "${pageContext.request.contextPath }/memo-update";
			alert("수정되었습니다.");
			document.form.submit();
		}
		deleteBtn.onclick = function(){
			document.form.action = "${pageContext.request.contextPath }/memo-delete";
			alert("삭제되었습니다.");
			document.form.submit();
		}
		
	});

</script>
</head>
<body class="is-preload">
	<!-- Wrapper-->
	<div id="wrapper">
		<!-- Nav -->
		<nav id="nav">
			<a href="#home" class="icon solid fa-home"><span>Calendar</span></a>
			<a href="#memo" class="icon solid fa-envelope"><span>Memo</span></a>
<!-- 		<a href="https://twitter.com/ajlkn" class="icon brands fa-twitter"><span>Twitter</span></a> -->
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Me -->
			<article id="home" class="panel intro">
				<div id='calendar'></div>
			</article>

			<!-- Memo -->
			<article id="memo" class="panel">
				<header>
					<h2>Memo</h2>
				</header>
				<form name="form" action="${pageContext.request.contextPath }/memo-regist" method="post">
					<input type ="hidden" name="no" id="no">
					<div>
						<div class="row">
							<div>
								<input type="date" name="mdate" id="mdate">
							</div>
							<div class="col-12">
								<input type="text" name="title" id="title" placeholder="Title" />
							</div>
							<div class="col-12">
								<textarea name="memo" id="memo-area" placeholder="Memo" rows="6"></textarea>
							</div>
							<div class="col-12">
								<input type="button" value="Save" id="save-btn"/>
								<input type="hidden" value="Update" id="update-btn"/>
								<input type="hidden" value="Delete" id="delete-btn"/>
								<input type="button" value="Cancel" id="cancel-btn"/>
							</div>
						</div>
					</div>
				</form>
			</article>

		</div>

		<!-- Footer -->
		<div id="footer">
			<ul class="copyright">
				<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>

		</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/main.js"></script>

</body>
</html>