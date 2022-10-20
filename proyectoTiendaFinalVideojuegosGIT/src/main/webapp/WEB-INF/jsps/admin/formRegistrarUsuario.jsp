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

Introduce tus datos:

<springform:form modelAttribute="usuario" action="guardarNuevoUsuarioAdmin">
Nombre usuario: <springform:input path="nombre"/> <br>
Apellido: <springform:input path="apellido"/> <br>
Teléfono: <springform:input path="tel"/> <br>
Ciudad: <springform:input path="ciudad"/> <br>
Código Postal: <springform:input path="cp"/> <br>
<input type="submit" value="REGISTRARME"/> <br>

</springform:form>

</body>
</html>