<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso de Personas</title>
</head>

<body>
<h1>Ingrese los datos de la persona: </h1>
	<form action="ingresar" method="post">
		<table>
			<tr>
				<td>C�dula:</td>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input name="nombre" /></td>
			</tr>
			<tr>
				<td>Direcci�n:</td>
				<td><input name="direccion" /></td>
			</tr>

			<tr>
				<td><input type="submit"value="Crear" /></td>
				<td><a href="menu.jsp">Regresar</a></td>
			</tr>
			
			
		</table>
	</form>




</body>
</html>