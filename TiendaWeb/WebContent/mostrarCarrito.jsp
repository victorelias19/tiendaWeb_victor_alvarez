<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="app.modelo.Producto" %>   
<%@ page import="app.negocio.Carrito" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Carrito miCarro = (Carrito)session.getAttribute("miCarrito"); %>
<%
Cookie[] todas = request.getCookies();

for (Cookie c : todas) {
	if ("nombreUsuario".equals(c.getName())) { 
		out.print("<h2>Usuario: " +  c.getValue()  +"</h2>");
		break;
	}
}
%>

    <% List<Carrito> lista = (List)request.getAttribute("lista");%>
	
	<table border="1" align="center">
		<tr>
			<th>Información carrito</th>
			<th>Lista de productos en el carrito</th>
			<th>Boton de elimnar un producto</th>
		</tr>
		
		<% for(Carrito c : lista){ %>
			<tr>
				<td> <%= c.getImporte() %>  </td>
				<td> <%= c.getContenido() %> </td>
				<td> <%= c.sacarProducto(0) %> </td>
			</tr>
		<% } %>
	</table>
    
    
    
	

</body>
</html>