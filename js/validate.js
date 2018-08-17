function validate() {
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("reEnterPassword").value;
	if (password === confirmPassword) {
		// document.getElementById("PasswordError").innerHTML = "Password
		// MisMatch";
		alert("Password match");
		return true;
	}else{
		console.log(document.getElementById("password").value);
		alert("Password Mismatch");
		return false;
	}
	alert(document.getElementById("password").value);
}