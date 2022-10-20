<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br>
Editar usuario:

<springform:form modelAttribute="usuario" action="guardarEdicionUsuarioAdmin">
<springform:input type="hidden" path="id"/> <br>
Nombre usuario: <springform:input path="nombre"/> <br>
Apellido: <springform:input path="apellido"/> <br>
Teléfono: <springform:input path="tel"/> <br>
Ciudad: <springform:input path="ciudad"/> <br>
Código Postal: <springform:input path="cp"/> <br>
<input onclick="return confirm('¿Estás seguro que desa editar el usuario ${usuario.nombre} con id ${usuario.id}?');" type="submit" value="EDITAR"/> <br>

</springform:form>

</body>
</html>