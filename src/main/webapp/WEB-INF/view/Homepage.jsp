<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 20px;
}
</style>
<script>
	function validateForm() {
		if (document.getElementById("yn").value) {
			return true;
		} else {
			alert('Please enter Your name');
			return false;
		}

	}
</script>

</head>
<body>
	<h1 align="center">Relation Calculator</h1>
	<hr>
	<form:form action="process-homepage" method="get"
		modelAttribute="userInfo">
		<div align="center">
			<p>
				<label for="yn">Your Name</label>
				<form:input id="yn" path="userName"></form:input>
				<form:errors path="userName" cssClass="errors" />
			</p>
			<p>
				<label for="cn">Other's Name</label>
				<form:input id="cn" path="othersName"></form:input>
				<form:errors path="othersName" cssClass="errors" />
			</p>
			<form:checkbox path="termsAndConditions" />
			I agree that this is for fun

			<form:errors path="termsAndConditions" cssClass="errors" />

			<br>
			<br> <input type="submit" value="calculate">

		</div>


	</form:form>
</body>
</html>