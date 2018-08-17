<!-- %@page import="com.jda.model.UserModel"% -->
<html>
<head>
</head>
<body>
	<form method="post" action="login" modelAttribute="User">
		<h3>Login your account :</h3>
		<label for="email">User name:</label> <input type="text" name="email"
			placeholder="email"> <br> <label for="password">Password:</label>
		<input type="password" name="password" placeholder="password">
		<br> <input type="submit" value="submit">
	</form>
	<a href="registration">Create Account!</a><br>
	<a href="forgot">Forgot Password!</a>
</body>
</html>