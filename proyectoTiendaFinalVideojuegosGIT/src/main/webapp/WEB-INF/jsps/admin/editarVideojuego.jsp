<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Videojuego</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br>
Editar usuario:

<springform:form modelAttribute="videojuego" action="guardarEdicionVideojuegoAdmin">
<springform:input type="hidden" path="id"/> <br>
Nombre: <springform:input path="nombre"/> <br>
Descripción: <springform:input path="descri"/> <br>
Edad Mínima: <springform:input path="edadmin"/> <br>
Precio: <springform:input path="precio"/> <br>
Desarrollador: <springform:input path="desarrollador"/> <br>
Nota Crítica: <springform:input path="notaCritica"/> <br>
Categoría: <springform:select path="idCategoria">
				<springform:options items="${categorias}"></springform:options>
			</springform:select><br>
<input onclick="return confirm('¿Estás seguro que desa editar el videojuego ${videojuego.nombre} con id ${videojuego.id}?');" type="submit" value="EDITAR"/> <br>

</springform:form>

</form>

</body>
</html>