function cargarEventos(){
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#listVideojuegos").click(function(){
		$.get("ServicioWebVideojuegos/obtenerVideojuegos", function(res){
			var videojuegos = JSON.parse(res);
			var resultado = Mustache.render(plantillas.videojuegos, videojuegos);
			$("#contenedor").html(resultado);
			$(".enlace_detalles").click(function(e){
				//this -> es el elemento sobre el que se hizo click en este caso
				//$(this) es obtener el mismo elemento en forma de jquery
				var id = $(this).attr("id_producto");
				alert("mostrar detalles del libro de id: " + id);
				//ahora lo suyo es llamar a obter libro por id y mostrar
				//en una plantilal el resultado obtenido
			});
		});
	});
	
	$("#registrarme").click(function(){
		$("#contenedor").html(plantillas.registrarme);
		$("#form_registro_usuario").submit(function(e){
			//este codigo se ejecuta cuando se 
			//pulsa el boton de submit del form 
			e.preventDefault();//se cancela el envio de form de forma tradicional
			var nombre = $("#nombre").val();
			var apellido = $("#apellido").val();
			var tel = $("#tel").val();
			var ciudad = $("#ciudad").val();
			var cp = $("#cp").val();
			//ahora se deberian validar los campos
			var usuario = {nombre: nombre, apellido: apellido, tel: tel, ciudad: ciudad, cp: cp};
			console.log(usuario);
			var json = JSON.stringify(usuario);//transformar a string un json del 
											  //objeto usuario
			alert("json a enviar: " + json);
			$.ajax("ServicioWebUsuarios/registrarUsuario",{
				type: "POST",
				data: "info="+json,
				success: function(res){
					if(res == "ok"){
						alert("registro ok, ya puedes identificarte - por hacer..");
						$("#nombre").val("");
						$("#apellido").val("");
						$("#tel").val("");
						$("#ciudad").val("");
						$("#cp").val("");
					}
				}
			});//end ajax						
		});//end submit
	});//end click

}//cargar eventos
