<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevos Datos</title>
</head>
<body>


<h1>Editar persona: </h1>
	<form action="editar" method ="post" >
		<table>
			<tr>
				<td>Cédula:</td>
				<td><%=request.getAttribute("id") %></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"  value=<%=request.getAttribute("nombre") %>></td>
			</tr>
			<tr>
				<td>Dirección:</td>
				<td><input  type="text" name="direccion" value=<%=request.getAttribute("direccion") %>></td>
			</tr>

			<tr>
				<td><input type="submit"value="Editar" /></td>
				<td><a href="editar.jsp">Cancelar</a></td>
			</tr>
			
			
		</table>
		<input type="hidden" name="bandera" value ="1" />
		<input type="hidden" name="id" value =<%=request.getAttribute("id") %>>
	</form>
</body>
</html>