<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <marquee> <%= application.getAttribute("msgOferta") %>  </marquee>		

	<a href="controlador?opcion=1">Mostrar todos los productos</a>  <br>

	<a href=formularioBuscar.jsp>Buscar un producto</a>  <br>

</body>
</html>