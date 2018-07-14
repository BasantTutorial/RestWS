<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/forward.mvc" method="post">
		<div align="center">
			<h1>Sample Form Page To Test Rest Client Api</h1>
			Account No:-<input type="text" name="accountNo"><br>
			Branch Code:-<input type="text" name="branchCode"><br>
			Year:-<input type="text" name="year"><br> Name:-<input
				type="text" name="name"><br> <br> <input
				type="submit" value="SUBMIT">
		</div>
	</form>
</body>
</html>