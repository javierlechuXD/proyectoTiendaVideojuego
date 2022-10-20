package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		sessionFactory.getCurrentSession().save(videojuegoRegistrar);
		
	}

	@Override
	public List<Videojuego> obtenerVideojuegos() {
		
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Videojuego.class);
		// c.add(Restrictions.like("nombre", "a%"));
		return c.list();
	}

	@Override
	public Videojuego obtenerVideojuegoPorId(int idVideojuegoEditar) {
		return (Videojuego)sessionFactory.getCurrentSession().get(Videojuego.class, idVideojuegoEditar);
	}

	@Override
	public void guardarCambiosVideojuego(Videojuego videojuego) {
		sessionFactory.getCurrentSession().merge(videojuego);
		
	}

	@Override
	public void borrarVideojuego(int id) {
		Videojuego v = (Videojuego)sessionFactory.getCurrentSession().get(Videojuego.class, id);
		sessionFactory.getCurrentSession().delete(v);
		
	}

}
