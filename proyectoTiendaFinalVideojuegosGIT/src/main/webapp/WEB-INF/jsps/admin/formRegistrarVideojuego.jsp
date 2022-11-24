<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

Introduce datos videojuego:

<springform:form modelAttribute="videojuego" action="guardarNuevoVideojuegoAdmin" enctype="multipart/form-data">
Nombre: <springform:input path="nombre"/> 
	<span style="color: red"><springform:errors path="nombre"/></span><br>
	
Descripción: <springform:input path="descri"/>  
	<span style="color: red"><springform:errors path="descri"/></span><br>
	
Edad Mínima: <springform:input path="edadmin"/>  
	<span style="color: red"><springform:errors path="edadmin"/></span><br>
	
Precio: <springform:input path="precio"/>  
	<span style="color: red"><springform:errors path="precio"/></span><br>
	
Desarrollador: <springform:input path="desarrollador"/>  
	<span style="color: red"><springform:errors path="desarrollador"/></span><br>
	
Nota Crítica: <springform:input path="notaCritica"/>  
	<span style="color: red"><springform:errors path="notaCritica"/></span><br>
	
Categoría: <springform:select path="idCategoria">
				<springform:options items="${categorias}"></springform:options>
			</springform:select><br>
			
Portada: <springform:input path="portada" type="file"/> <br>

Portada2: <springform:input path="portada2" type="file"/> <br>
<input type="submit" value="REGISTRARME"/> <br>

</springform:form>

</body>
</html>