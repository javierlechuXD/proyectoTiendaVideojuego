package servicios;

import java.util.List;

import datos.serviciosWEB.ResumenPedido;
import modelo.Pedido;
import modelo.Usuario;

public interface ServicioPedidos {

	void procesarPaso1(String nombreCompleto, String direccion, String provincia,String pais, String telefono, Usuario usuario);
	
	void procesarPaso2(String titular, String numero, Usuario usuario);
	
	void procesarPaso3(String observacion, Usuario usuario);

	ResumenPedido obtenerResumenDelPedido(Usuario usuario);

	void confirmarPedido(Usuario usuario);
	
	List<Pedido> obtenerPedidos();

	Pedido obtenerPedidoPorId(int idPedido);

	void actualizarEstadoPedido(int idPedido, String estado);
}