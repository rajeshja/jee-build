<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Logon Page</title>
</head>
<body>
<h1>Logon page</h1>

<form action="j_security_check">
	<fieldset>
		<legend>Please Login</legend>
		<label>
			Username:
			<input type="text" name="j_username"/>
		</label>
		<label>
			Password:
			<input type="password" name="j_password"/>
		</label>
		<input type="submit" value="Submit"/>
	</fieldset>
</form>
</body>
</html>
