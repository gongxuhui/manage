<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录界面</title>
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<div class="page-container">
		<h1>用户登录</h1>
		<form action="loginAction" method="post">
			<input type="text" name="userName" class="username"
				placeholder="请输入用户名"> <input type="password" name="passWord"
				class="password" placeholder="请输入密码">
			<button type="submit">登录</button>
			<button type="reset">重置</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
	</div>
	<!-- <form action="loginAction" method="get">
		用户名：<input type="text" name="userName"><br> 密码：<input
			type="text" name="passWord"><br> <input type="submit"
			value="登录">
	</form> -->
</body>
</html>