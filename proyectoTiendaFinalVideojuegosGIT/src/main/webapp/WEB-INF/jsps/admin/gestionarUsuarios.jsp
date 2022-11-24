<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div style="margin: 10px">
	<a href="nuevoUsuarioAdmin">Registrar un Usuario</a>
</div>

<c:forEach var="usuario" items="${info}">
	<div>
		Foto: <img style="height: 80px" src="../subidas/u${usuario.id}.jpg"/> <br>
		<%// con el $ en realidad sacamos del request la información que queramos %>
		ID: ${usuario.id} | Nombre: ${usuario.nombre} | Apellido: ${usuario.apellido} | Teléfono: ${usuario.tel} | Ciudad: ${usuario.ciudad} | CP: ${usuario.cp}
		<a onclick="return confirm('¿Estás seguro que desa borrar el usuario ${usuario.nombre} con id ${usuario.id}?, Todos los pedidos del usuario serán eliminados');" href="borrarUsuario?idUsuario=${usuario.id}"> Borrar</a>
		 | 
		<a href="editarUsuario?idUsuario=${usuario.id}"> Editar</a>
		
	</div>
	<br>
	<hr></hr>
	<br>

</c:forEach>

</body>
</html>