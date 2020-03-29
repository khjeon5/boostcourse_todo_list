<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>

<script>

function move1(id,type) {
	var xhr = new XMLHttpRequest();
	xhr.addEventListener("load",function(evt){
		var parent = document.getElementById("doing");
		console.log(parent);
		var newItem = document.getElementById(id);	
		parent.appendChild(newItem);					
	});
	xhr.open("POST","/ToDo/todotype");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("id="+id+"&type=TODO");
};
function move2(id) {
	var xhr = new XMLHttpRequest();
	xhr.addEventListener("load",function(evt){
		var parent = document.getElementById("done");
		console.log(parent);
		var newItem = document.getElementById(id);	
		parent.appendChild(newItem);			
	});
	xhr.open("POST","/ToDo/todotype");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("id="+id+"&type=DOING");
};
function move(id,type) {
	var xhr = new XMLHttpRequest();
	xhr.addEventListener("load",function(){
		if (type=="TODO") {
			var parent = document.getElementById("doing");
			var newItem = document.getElementById(id);	
			console.log(newItem);
			console.log(newItem.children);
	
			parent.appendChild(newItem);			
		}else{
			var parent = document.getElementById("done");
			console.log(parent);
			var newItem = document.getElementById(id);	
			parent.appendChild(newItem);			
		}
	});
	xhr.open("POST","/ToDo/todotype");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("id="+id+"&type="+type);
};
</script>

<body>
	${ja}

	<div id="nav">
		<div class="title">나의 해야할 일들</div>
		<form method="POST" action="/ToDo/todoform">
			<input type="submit" class="addtodo" value="새로운 TODO 등록"></input>
		</form>

	</div>
	<div id="section">
		<div id="todo" class="main">
			<div  class="main-title">TODO</div>
			<c:forEach var="item" items="${ja}">
				<c:if test="${item.type =='TODO'}">
					<div id="${item.id }" class="main-contents">
						<div class="main-contents-title">${item.title }</div>
						<div class="main-contents-contents">
							등록날짜:${item.regDate }, ${item.name }, 우선순위 ${item.sequence } 
						</div>
						<input type="button" id="remove"
							onclick="move('${item.id }','${item.type }');" value="->" />
					</div>
				</c:if>
			</c:forEach>

		</div>
		<div id="doing" class="main">
			<div  class="main-title">DOING</div>
			<c:forEach var="item" items="${ja}">
				<c:if test="${item.type =='DOING'}">
					<div id="${item.id }" class="main-contents">
						<div class="main-contents-title">${item.title }</div>
						<div class="main-contents-contents">
							등록날짜:${item.regDate }, ${item.name }, 우선순위 ${item.sequence } <input
								type="button" onclick="move('${item.id }','${item.type }');" value="->" />
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<div  id="done" class="main">
			<div class="main-title">DONE</div>
			<c:forEach var="item" items="${ja}">
				<c:if test="${item.type =='DONE'}">
					<div class="main-contents">
						<div class="main-contents-title">${item.title }</div>
						<div class="main-contents-contents">등록날짜:${item.regDate },
							${item.name }, 우선순위 ${item.sequence }</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>


<script>
	/*
	var remove = document.querySelector("#remove");
	console.log(remove);
	var parent = remove.parentElement;
	console.log(parent);
	var pp = parent.parentElement;
	console.log(pp);
	remove.addEventListener("click",function(evt){
		console.log(evt)
		console.log(evt.target);
		console.log(evt.target.nodeName);
	});
	*/
</script>

</html>