<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ServletTienda" method="post">

		<ul>
			<li><label>Descripción:</label><input type="text"
				name="descripcion" id="descripcion" >
			<li><label>Precio:</label><input type="number" 
				name="precio" id="precio" >
			<li><input type="submit" 
				value="Guardar" >
		</ul>
	</form>


</body>
</html>