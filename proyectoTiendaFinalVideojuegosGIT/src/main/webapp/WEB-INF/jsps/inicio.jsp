<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	input[type=numer]{
		width: 3rem;
	}
</style>
<body>
<div style="text-align: right; margin: 10px">
	<a href="?lang=es" >Español</a>
	<a href="?lang=en" >Ingles</a>
	<a href="?lang=fr" >Frances</a>
	<a href="?lang=de" >Aleman</a>
	<a href="?lang=it" >Italiano</a>
</div>

<spring:message code="inicio.bienvenida"/> <span style="color: blue" id="inicio_span_nombre_usuario"><spring:message code="inicio.noidentificado"/></span>

<div>
	<a href="#" id="listVideojuegos"><spring:message code="inicio.mvideojuegos"/></a>&nbsp;&nbsp;&nbsp;
	<a href="#" id="carrito"><spring:message code="inicio.carrito"/></a> &nbsp;&nbsp;&nbsp;
	<a href="#" id="registrarme"><spring:message code="inicio.registrarme"/></a>&nbsp;&nbsp;&nbsp;
	<a href="#" id="login"><spring:message code="inicio.identificarme"/></a>&nbsp;&nbsp;&nbsp;
	<a href="#" style="display: none" id="logout"><spring:message code="inicio.salir"/></a> &nbsp;&nbsp;&nbsp;
	
</div>
<div id="contenedor">

</div>

<script type="text/javascript" src="librerias_js/jquery.js"></script>
<script type="text/javascript" src="librerias_js/mustache.js" ></script>
<script type="text/javascript" src="javascript/cargar_plantillas.js"></script>
<script type="text/javascript" src="javascript/cargar_eventos.js"></script>
<script type="text/javascript" src="javascript/funciones.js"></script>
<script type="text/javascript" src="javascript/globales.js"></script>
<script type="text/javascript" src="javascript/funciones_checkout.js"></script>


</body>
</html>