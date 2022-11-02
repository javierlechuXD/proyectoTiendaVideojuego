function checkout_paso_1(){
	//datos de envio del pedido
	$("#contenedor").html(plantillas.checkout_1);
	$("#aceptar_paso_1").click(function(){
		let nombre = $("#campo_nombre").val();
		let direccion = $("#campo_direccion").val();
		let provincia = $("#campo_provincia").val();

		$.post("ServicioWebPedidos/paso1",
			{
				nombre: nombre,
				direccion: direccion,
				provincia: provincia	
			}
		).done(function(res){
			alert("respuesta del servidor: " + res);
		});
	});
}