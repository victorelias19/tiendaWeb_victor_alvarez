<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="controlador" method="post">
		Usuario: <input type="text" name="user" /><br>
		Password: <input type="password" name="pw"> <br>
		<input type="hidden"  name="opcion" value="5"/>
		
		<input type="submit" value="LOGIN" /> 
	</form>

</body>
</html>