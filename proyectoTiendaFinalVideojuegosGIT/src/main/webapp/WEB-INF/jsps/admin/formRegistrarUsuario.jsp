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

Introduce sus datos:

<springform:form modelAttribute="usuario" action="guardarNuevoUsuarioAdmin" enctype="multipart/form-data">
Nombre usuario: <springform:input path="nombre"/> <br>
Apellido: <springform:input path="apellido"/> <br>
Teléfono: <springform:input path="tel"/> <br>
Ciudad: <springform:input path="ciudad"/> <br>
Código Postal: <springform:input path="cp"/> <br>
Foto Usuario: <springform:input path="fotoPerfil" type="file"/> <br>
<input type="submit" value="REGISTRAR"/> <br>

</springform:form>

</body>
</html>