<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<!-- script src = "js/validate.js"></script-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<form method="post" action="data" onSubmit="return validate()"  modelAttribute="NewUser">
		<h3>Sign up here!</h3>
		<label for="name">Name</label> <input type="text" name="name" placeholder="name"> <br>
		<label for="email">Email</label> <input type="text" name="email" placeholder="email"><br>
		<label for="password">Password</label> <input type="password" name="password" id="password" placeholder="password"> <br>
		<label for="reEnterPassword">Enter password again</label> <input type="password" id="reEnterPassword"  placeholder="Enter password again"> <br> 
		<!-- p><id="PasswordError"></p-->
		<label for="phoneNumber">Phone Number</label> <input type="text" name="phoneNumber" placeholder="phone number"> <br> 
		<input type="submit">Submit
	</form>
</body>
</html>