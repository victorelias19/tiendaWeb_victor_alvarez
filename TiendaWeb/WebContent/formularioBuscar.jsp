<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="controlador">
		<label>Introduce Id del producto a buscar:</label>
		<input type="text" name="codigo" />
		<input type="hidden"  name="opcion" value="2"/>
		<input type="submit"  value="BUSCAR"/>
	</form>

</body>
</html>