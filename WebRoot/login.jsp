<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#aj").click(function(){
				alert("jq ok!");
				location.href="a.html";
			});
			$("#loginBut").click(function(){
				var user = {
					"username":$("#username").val(),
					"password":$("#password").val()
				};
				$.ajax({
					type:"post",
					url:"login",
					dataType:"json",
					data:user,
					success:function(data){
						if(data.code===1){
							location.href="index.jsp";
						}else{
							alert(data.message);
						}
					},
					error:function(jqXHR){
						alert(error);
					}
				});
			});
		});
	</script>
</head>
<body>
	<input id="aj" type="button" value="ajax test" />
	<div>
		username:<input type="text" name="username" id="username">
		<br>
		password:<input type="text" name="password" id="password">
		<br>
		<input type="button" id="loginBut" value="login">
	</div>
	<a href="register.jsp">register.jsp</a>
</body>
</html>