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

<div style="margin: 15px">
	<form action="gestionarVideojuegos">
		Nombre: <input type="text" name="nombre" value="${nombre}"/>
		<input type="submit" value="BUSCAR"/>
	</form>
</div>

<div style="text-align: center;">
	Paginación: <br>
	Total Videojuegos: ${total} <br>
	<c:if test ="${anterior >= 0}">
		<a href="gestionarVideojuegos?comienzo=${anterior}&nombre=${nombre}">Anterior</a>
	</c:if>
	<c:if test ="${siguiente < total}">
		<a href="gestionarVideojuegos?comienzo=${siguiente}&nombre=${nombre}">Siguiente</a>
	</c:if>
</div>

<div style="text-align: center;">
	Número de registros: ${numRegistros}
</div>

<c:forEach var="videojuego" items="${info}">
	<div>
		<%// con el $ en realidad sacamos del request la información que queramos %>
		Portadas: <br>
		<img style="height: 160px" src="../subidas/${videojuego.id}.jpg?token=${videojuego.fechaImagenPortada1}"/>
		<img style="height: 160px" src="../subidas/${videojuego.id}-2.jpg?token=${videojuego.fechaImagenPortada2}"/>
		<br>
		Videojuego: ${videojuego.nombre} | Descripción: ${videojuego.descri} | Edad Mínima: +${videojuego.edadmin} años | Categoría: ${videojuego.categoria.nombre} | Precio: ${videojuego.precio}€ | Desarrollador: ${videojuego.desarrollador} | Nota Crítica: ${videojuego.notaCritica}
		<a onclick="return confirm('¿Estás seguro que desa borrar el videojuego ${videojuego.nombre} con id ${videojuego.id}?');" href="borrarVideojuego?idVideojuego=${videojuego.id}"> Borrar</a>
		 | 
		<a href=editarVideojuego?idVideojuego=${videojuego.id}> Editar</a>
		
		<a href="agregarIdioma?idVideojuego=${videojuego.id}" onclick="alert('mostrar formulario para registrar para el videojuego textos en otro idioma'); return false;">Agregar idioma</a>	
	</div>
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
</c:forEach>
</body>
</html>