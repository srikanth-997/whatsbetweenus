<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
span {
	color: red;
	font-weight: bold;
}

.appresult {
	color: green;
}
</style>
</head>
<body>
	<h1 align="center">Relation Calculator</h1>
	<hr>
	<div align="center">

		<h2>The Relation Calculator Predicts :</h2>
		<br> <span>${userInfo.userName}</span> and <span>${userInfo.othersName}</span>
		are <br> <span class="appresult"> ${userInfo.appResult} </span><br>
		<a href="/whatsBetweenUs/sendEmail">Send result to your email</a> 
	</div>
</body>
</html>