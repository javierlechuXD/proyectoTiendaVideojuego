<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Introduce datos videojuego:

<springform:form modelAttribute="videojuego" action="guardarNuevoVideojuegoAdmin" enctype="multipart/form-data">
Nombre: <springform:input path="nombre"/> <br>
Descripción: <springform:input path="descri"/> <br>
Edad Mínima: <springform:input path="edadmin"/> <br>
Precio: <springform:input path="precio"/> <br>
Desarrollador: <springform:input path="desarrollador"/> <br>
Nota Crítica: <springform:input path="notaCritica"/> <br>
Categoría: <springform:select path="idCategoria">
				<springform:options items="${categorias}"></springform:options>
			</springform:select><br>
Portada: <springform:input path="portada" type="file"/> <br>
Portada2: <springform:input path="portada2" type="file"/> <br>
<input type="submit" value="REGISTRARME"/> <br>

</springform:form>

</body>
</html>