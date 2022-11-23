	function cargarEventos(){
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#listVideojuegos").click(function(){
		mostrar_productos();
	});
	
	
	$("#carrito").click(function(){
		mostrar_productos_carrito();
	});
	
	$("#login").click(function(){
		$("#contenedor").html(plantillas.login);

		if(typeof(Cookies.get("email")) != "undefined"){
			$("#email").val(Cookies.get("email"));
		}

		if(typeof(Cookies.get("pass")) != "undefined"){
		$("#pass").val(Cookies.get("pass"));
		}


		$("#form_login").submit(function(e){
			e.preventDefault();
			identificar_usuario();
		});
	});

	$("#registrarme").click(function(){
		$("#contenedor").html(plantillas.registrarme);
		$("#form_registro_usuario").submit(function(e){
			//este codigo se ejecuta cuando se 
			//pulsa el boton de submit del form 
			e.preventDefault();//se cancela el envio de form de forma tradicional
			
			// Forma para mandar directamente toda l ainformación dle form que tenga o no
			// uno o más input type file
			// No podemos coger el elemento por JQUERY
			let formulario = this;
			let formData = new FormData(formulario);

			// Validar los campos de formulario - cliente
			// Del formData puedo obtener el input que quiera por su name, no su id.
			if(!validarNombre(formData.get("nombre")) || !validarEmail(formData.get("email")) || !validarPass(formData.get("pass")) ){
				return false;
			}

			
			$.ajax("ServicioWebUsuarios/registrarUsuario", {
				type: "POST",
				data: formData,
				cache: false,
				contentType: false,
				processData: false,
				success: function(res){
					if(res == "ok"){
						alert("Ya puedes identificarte con tus datos");
						identificar_usuario();
					}else{
						alert(res);
					}
				}
			});
			
// FORMA POR AJAX			
//			var nombre = $("#nombre").val();
//			var apellido = $("#apellido").val();
//			var email = $("#email").val();
//			var pass = $("#pass").val();
//			var tel = $("#tel").val();
//			var ciudad = $("#ciudad").val();
//			var cp = $("#cp").val();
//			//ahora se deberian validar los campos
//			var usuario = {nombre: nombre, apellido: apellido, email: email, pass: pass, tel: tel, ciudad: ciudad, cp: cp};
//			console.log(usuario);
//			var json = JSON.stringify(usuario);//transformar a string un json del 
//											  //objeto usuario
//			alert("json a enviar: " + json);
//			$.ajax("ServicioWebUsuarios/registrarUsuario",{
//				type: "POST",
//				data: "info="+json,
//				success: function(res){
//					if(res == "ok"){
//						alert("registro ok, ya puedes identificarte - por hacer..");
//						$("#nombre").val("");
//						$("#apellido").val("");
//						$("#tel").val("");
//						$("#ciudad").val("");
//						$("#cp").val("");
//					}
//				}
//			});//end ajax						
		});//end submit
	});//end click
	$("#logout").click(function(e){
		logout();		
	});
}//cargar eventos
