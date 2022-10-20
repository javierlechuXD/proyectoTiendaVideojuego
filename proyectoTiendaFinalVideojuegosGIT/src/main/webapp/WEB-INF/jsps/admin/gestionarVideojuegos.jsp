<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br>
<div style="margin: 10px">
	<a href="nuevoVideojuegoAdmin">Registrar un Videojuego</a>
</div>

<c:forEach var="videojuego" items="${info}">
	<div>
		<%// con el $ en realidad sacamos del request la información que queramos %>
		Portadas: <br>
		<img style="height: 160px" src="../subidas/${videojuego.id}.jpg"/>
		<img style="height: 160px" src="../subidas/${videojuego.id}-2.jpg"/>
		<br>
		Videojuego: ${videojuego.nombre} | Descripción: ${videojuego.descri} | Edad Mínima: +${videojuego.edadmin} años | Precio: ${videojuego.precio}€ | Desarrollador: ${videojuego.desarrollador} | Nota Crítica: ${videojuego.notaCritica}
		<a onclick="return confirm('¿Estás seguro que desa borrar el videojuego ${videojuego.nombre} con id ${videojuego.id}?');" href="borrarVideojuego?idVideojuego=${videojuego.id}"> Borrar</a>
		 | 
		<a href=editarVideojuego?idVideojuego=${videojuego.id}> Editar</a>
	</div>
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
</c:forEach>
</body>
</html>