<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar</title>
</head>
<body>
<form action="eliminar" method="post">
<h1>Ingrese la cédula de la persona a eliminar: </h1>
		<table>
			<tr>
				<td>Cédula:</td>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<td><input type="submit"value="Eliminar" /></td>
				<td><a href="menu.jsp">Regresar</a></td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>