<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>할일 등록</h1>

	<form action="/ToDo/ToDoAddServlet" method="POST">
		어떤일인가요?<br> 
		<input type="text" id="title" name="title" placeholder="swift공부하기(24자까지)" /><br>
		누가 할일인가요?<br> 
		<input type="text" id="name" name="name" placeholder="홍길동" /><br>
		우선순위를 선택하세요<br> 
		<label><input type="radio" name="sequence" value=1> 1순위</label> 
		<label><input type="radio" name="sequence" value=2> 2순위</label> 
		<label><input type="radio" name="sequence" value=3> 3순위</label><br>
			
		<input type="button" id="back" value="<이전"/>
		<input type="submit" value="제출"/>
		<input type="reset" value="내용지우기"/>
	</form>
</body>

<script>
 var back = document.querySelector("#back");
 back.addEventListener("click",function(){
	location.href="main";
 });
 

</script>
</html>