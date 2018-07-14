<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OlaCabManagementSystem</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/rest/cab-management/book"
		method="post">
		<div align="center" style="color: blue;">
			<h1>
				<b>Welcome To Ola Cab Management</b>
			</h1>
		</div>
		<table align="center">
			<tr bgcolor="green">
				<td>SOURCE:</td>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<td>DESTINATION:</td>
				<td><input type="text" name="dest"></td>
			</tr>
			<tr bgcolor="orange">
				<td>CAB-TYPE:</td>
				<td><select name="cabType">
						<option value="Max">Max</option>
						<option value="Min">Mini</option>
						<option value="Midium">Medium</option>
				</select></td>
			</tr>
		</table>
		<center>
			<input type="submit" value="BOOKNOW">
		</center>
	</form>
</body>
</html>