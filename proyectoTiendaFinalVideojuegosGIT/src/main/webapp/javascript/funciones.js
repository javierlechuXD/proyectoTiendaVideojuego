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


function mostrar_productos_carrito(){

	if(nombre_login == ""){
		alert("debes identificarte para acceder a tu carrito");
		return;
	}

	$.getJSON("ServicioWebCarrito/obtenerProdcutosCarrito",function(res){
		$("#contenedor").html( Mustache.render(plantillas.carrito,res) );
		$(".input_cantidad").change(function(){
			alert("mandar al servidor la nueva cantidad, por hacer...");
		});
		$(".enlace_borrar_producto").click(function(){
			alert("borrar producto del carrito, por hacer...");
		});
		$("#realizar_pedido").click(function(){
			checkout_paso_1();
		});
	});

}

function comprar_producto(){
	if(nombre_login == ""){
		alert("debes identificarte para poder comprar productos");
	}else{
		var id = $(this).attr("id_producto");
		var cantidadS = $("#input-cantidad-"+id).val();

		$.post("ServicioWebCarrito/agregarVideojuego",
			{
				idProducto: id,
				cantidad: cantidadS
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



