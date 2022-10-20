function mostrar_productos(){
$.get("ServicioWebVideojuegos/obtenerVideojuegos", function(res){
			var videojuegos = JSON.parse(res);
			var resultado = Mustache.render(plantillas.videojuegos, videojuegos);
			$("#contenedor").html(resultado);
			$(".enlace_detalles").click(function(e){
				var id = $(this).attr("id_producto");
				alert("mostrar detalles del libro de id: " + id + "\n" + "pedir servicio Web datos videojuego con ID");
			});
			$(".enlace_comprar").click(comprar_producto);
		});
}

function comprar_producto(){
	if(nombre_login == ""){
		alert("debes identificarte para poder comprar productos");
	}else{
		var id = $(this).attr("id_producto");

		$.post("ServicioWebCarrito/agregarVideojuego",
			{
				idProducto: id
			}
		).done(function(res){
			alert(res);
		});
	}	
}

function identificar_usuario(){
	var email = $("#email").val();
	var pass = $("#pass").val();
	$.ajax("ServicioWebUsuarios/identificarUsuario",{
		type: "post",
		data: "email="+email+"&pass="+pass,
		success: function(res){
			var respuesta = res.split(",")[0];
			var mensaje = res.split(",")[1];
			if(respuesta == "ok"){
				alert("bienvenido " + mensaje + " ya puedes comprar");
				nombre_login = mensaje;
				mostrar_productos();
				$("#inicio_span_nombre_usuario").html("hola "+ nombre_login);
				$("#login").hide();
				$("#registrarme").hide();
				$("#logout").show();
			}else if( respuesta == "error"){
				alert(mensaje);
			}
		}
	});
}

function logout(){
	$.ajax("ServicioWebUsuarios/logout",{
		success: function(res){
			if(res == "ok"){
				alert("hasta pronto");
				nombre_login="";
				$("#login").show();
				$("#registrarme").show();
				$("#logout").hide();
				$("#inicio_span_nombre_usuario").html("(Usuario no identificado)");
			}
		}
	});
}



