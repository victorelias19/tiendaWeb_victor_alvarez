<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="app.modelo.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="encontrado" class="app.modelo.Producto" scope="request"></jsp:useBean>
	<ul>
		<li>ID: <jsp:getProperty property="id" name="encontrado"/> </li>
	</ul>

</body>
</html>