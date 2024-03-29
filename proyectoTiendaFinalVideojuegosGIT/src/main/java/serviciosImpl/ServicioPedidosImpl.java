package serviciosImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.EstadosPedido;
import constantesSQL.ConstantesSQL;
import datos.serviciosWEB.ResumenPedido;
import modelo.Carrito;
import modelo.Pedido;
import modelo.ProductoCarrito;
import modelo.ProductoPedido;
import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioPedidos;

@Service
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ServicioCarrito servicioCarrito;

	@Override
	public void procesarPaso1(String nombreCompleto, String direccion, String provincia,String pais,String telefono,Usuario usuario) {

		Pedido p = new Pedido();
		p.setUsuario(usuario);
		p.setEstado("en proceso"); // Mas adelante solo podrá haber un pedido en proceso para un mismo usuario
		p.setNombreCompleto(nombreCompleto);
		p.setDireccion(direccion);
		p.setProvincia(provincia);
		p.setPais(pais);
		p.setTelefono(telefono);

		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public void procesarPaso2(String titular, String numero, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setTitularTarjeta(titular);
		p.setNumeroTarjeta(numero);
		sessionFactory.getCurrentSession().update(p);
	}
	
	@Override
	public void procesarPaso3(String observacion, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setObservaciones(observacion);
		sessionFactory.getCurrentSession().save(p);
	}
	
	@Override
	public ResumenPedido obtenerResumenDelPedido(Usuario usuario) {
		ResumenPedido resumen = new ResumenPedido();
		Pedido p = obtenerPedidoActual(usuario);
		resumen.setNombreCompleto(p.getNombreCompleto());
		resumen.setDireccion(p.getDireccion());
		resumen.setProvincia(p.getProvincia());
		resumen.setTitularTarjeta(p.getTitularTarjeta());
		resumen.setNumeroTarjeta(p.getNumeroTarjeta());
		resumen.setPais(p.getPais());
		resumen.setTelefono(p.getTelefono());
		resumen.setObservaciones(p.getObservaciones());

		resumen.setVideojuegos(servicioCarrito.obtenerProductosCarrito(usuario));

		return resumen;
	}
	
	@Override
	public void confirmarPedido(Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		// Pasar los productos del carrito a producto pedido
		Carrito c = uBaseDatos.getCarrito();
		if(c != null) {
			for (ProductoCarrito pc : c.getProductosCarrito()) {
				ProductoPedido pp = new ProductoPedido();
				pp.setCantidad(pc.getCantidad());
				pp.setVideojuego(pc.getVideojuego());
				//p.getProductosPedido().add(pp);
				pp.setPedido(p);
				sessionFactory.getCurrentSession().save(pp);
			}
		}
		// Borrar los productos del carrito
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.BORRAR_PRODUCTOS_CARRITO);

		query.setParameter("carrito_id", c.getId());
		query.executeUpdate();
		//Finalizamos pedido
		p.setEstado(EstadosPedido.COMPLETADO);
		sessionFactory.getCurrentSession().update(p);
	}
	
	@Override
	public List<Pedido> obtenerPedidos() {
		// Usando Hibernate tenemos 3 formas de hacer consultas:

			//HQL -> Hibernate Query Language (pseudo SQL)
			//	  -> devuelve objetos de entidades
			//SQL -> Devuelve diferentes tipos de colección, 
			//	  -> la más común: List<Map<String,Object>>
			//Criteria -> Evita en gran parte el uso de Strings 
			//		   -> devuelve objetos de entidades

			//HQL
			List<Pedido> pedidos = sessionFactory.getCurrentSession().createQuery("from Pedido").list();

		return pedidos;
	}

	@Override
	public Pedido obtenerPedidoPorId(int idPedido) {
		// TODO Auto-generated method stub
		return (Pedido)sessionFactory.getCurrentSession().get(Pedido.class, idPedido);
	}

	@Override
	public void actualizarEstadoPedido(int idPedido, String estado) {
		Pedido p = obtenerPedidoPorId(idPedido);
		p.setEstado(estado);
		sessionFactory.getCurrentSession().update(p);

	}
	
	
	// Obtiene el pedido en estado "en proceso" del usuario actual, en el caso de no existir lo crea
	private Pedido obtenerPedidoActual(Usuario usuario) {
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		Object pedidoEnProceso = sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("estado", EstadosPedido.EN_PROCESO))
				.add(Restrictions.eq("usuario.id", usuario.getId())).uniqueResult();

		Pedido p = null;
		if (pedidoEnProceso == null) {
			p = new Pedido();
			p.setEstado(EstadosPedido.EN_PROCESO);
			p.setUsuario(uBaseDatos);
		}else {
			p = (Pedido)pedidoEnProceso;
		}
		return p;
	}


}