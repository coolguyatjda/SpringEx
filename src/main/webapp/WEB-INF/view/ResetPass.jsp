<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
</head>
<body>
	<form method="post" action="updatePass" modelAttribute="User">
		<h3>Reset Password :</h3>
		<label for="password">Enter Password:</label> <input type="password" name="password" placeholder="Enter Password"> <br> 
		<label for="reEnterPassword">Confirm Password:</label> <input type="password" name="reEnterPassword" placeholder="Enter Password Again">
		<br> <input type="submit" value="submit">
	</form>
</body>
</html>