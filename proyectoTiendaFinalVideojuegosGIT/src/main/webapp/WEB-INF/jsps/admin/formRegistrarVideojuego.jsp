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
Nombre: <springform:input path="nombre"/> 
	<span style="color: red"><springform:errors path="nombre"/></span><br>
	
Descripci�n: <springform:input path="descri"/>  
	<span style="color: red"><springform:errors path="descri"/></span><br>
	
Edad M�nima: <springform:input path="edadmin"/>  
	<span style="color: red"><springform:errors path="edadmin"/></span><br>
	
Precio: <springform:input path="precio"/>  
	<span style="color: red"><springform:errors path="precio"/></span><br>
	
Desarrollador: <springform:input path="desarrollador"/>  
	<span style="color: red"><springform:errors path="desarrollador"/></span><br>
	
Nota Cr�tica: <springform:input path="notaCritica"/>  
	<span style="color: red"><springform:errors path="notaCritica"/></span><br>
	
Categor�a: <springform:select path="idCategoria">
				<springform:options items="${categorias}"></springform:options>
			</springform:select><br>
			
Portada: <springform:input path="portada" type="file"/> <br>

Portada2: <springform:input path="portada2" type="file"/> <br>
<input type="submit" value="REGISTRARME"/> <br>

</springform:form>

</body>
</html>