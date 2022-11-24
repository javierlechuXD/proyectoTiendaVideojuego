package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.Paginacion;
import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.Videojuego;
import servicios.ServicioVideojuegos;

@Service // Marca que es un servicio
@Transactional //Con esta anotación en el caso de que exista un error en algún punto se haría un roll back, es decir
// se volvería hacia atras y se quedaría como si no se hubiera hecho nada
public class ServicioVideojuegosImpl implements ServicioVideojuegos {
	
	// Todas las operaciones con hibernate se harán a traves del sigueinte elemento
	
	// El siguiente elemento es la bean sessionFactory en datasource.xml
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarVideojuego(Videojuego videojuegoRegistrar) {
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class, videojuegoRegistrar.getIdCategoria());
		videojuegoRegistrar.setCategoria(c);
		sessionFactory.getCurrentSession().save(videojuegoRegistrar);
		
	}

	@Override
	public List<Videojuego> obtenerVideojuegos(String nombre, int comienzo) {
		System.out.println("nombre videojuego buscar: " + nombre);
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Videojuego.class);
		c.add(Restrictions.eq("alta", true));
		c.add(Restrictions.like("nombre", "%"+nombre+"%"));
		c.addOrder(Order.desc("id"));
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADOS_POR_PAGINA);
		return c.list();
	}

	@Override
	public Videojuego obtenerVideojuegoPorId(int idVideojuegoEditar) {
		return (Videojuego)sessionFactory.getCurrentSession().get(Videojuego.class, idVideojuegoEditar);
	}

	@Override
	public void guardarCambiosVideojuego(Videojuego videojuego) {
		System.out.println("Editando libro con id:" + videojuego.getId());
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class, videojuego.getIdCategoria());
		videojuego.setCategoria(c);
		//Merge crea si no lo encuentra, mienstras que update solo actualiza 
		sessionFactory.getCurrentSession().merge(videojuego);
		
	}

	@Override
	public void borrarVideojuego(int id) {
		Videojuego v = (Videojuego)sessionFactory.getCurrentSession().get(Videojuego.class, id);
		v.setAlta(false);
		sessionFactory.getCurrentSession().update(v);
		//sessionFactory.getCurrentSession().delete(l);
		
	}

	@Override
	public int obtenerTotalDeVideojuegos(String nombre) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.OBTENER_TOTAL_VIDEOJUEGOS);
		query.setParameter("nombre", "%"+ nombre + "%");
		return Integer.parseInt(query.list().get(0).toString());
	}

}
