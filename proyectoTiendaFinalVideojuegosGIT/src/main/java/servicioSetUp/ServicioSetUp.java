package servicioSetUp;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import modelo.SetUp;
import modelo.Usuario;
import modelo.Videojuego;

// utilidad para preparar registros

@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp {

	@Autowired
	SessionFactory sessionFactory;

	public void setUp() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(SetUp.class);

		if (c.list().size() == 0) {
			//preparamos unos registros

			sessionFactory.getCurrentSession().save(new Usuario("Pepa", "marinez", "pepa@gmail.com", "123", "4131233", "Madrid", 123));

			sessionFactory.getCurrentSession().save(new Usuario("Javi", "Lechu", "javi@gmail.com", "123", "4131233", "Barcelona", 123));
			
			sessionFactory.getCurrentSession().save(new Usuario("Samuel", "Perez", "samuel@gmail.com", "123", "4131233", "Madrid", 123));

			Categoria accion = new Categoria("accion", "categoría accion clásica");
			sessionFactory.getCurrentSession().save(accion);

			Categoria aventura = new Categoria("aventura", "categoría aventura clásica");
			sessionFactory.getCurrentSession().save(aventura);

			Categoria terror = new Categoria("terror", "categoría terror clásica");
			sessionFactory.getCurrentSession().save(terror);


			
			String titulo = "Call of Duty ";
			String descripcion = "Descripción por defecto";
			
			sessionFactory.getCurrentSession().save(new Videojuego("El quijote", "Un juego de historio pura", 13, 19.33, "QuijoteCorp", 3, accion));
			sessionFactory.getCurrentSession().save(new Videojuego("Call Of Duty", "Un juego de enfrenteaminetos puros", 18, 49.45, "Activision", 3, aventura));
			sessionFactory.getCurrentSession().save(new Videojuego("SCP", "Sobrevive para poder escapar", 18, 11.34, "NortWord", 3, terror));
			
			for (int i = 0; i < 100; i++) {
				String tituloGuardar = titulo + i;
				sessionFactory.getCurrentSession().save(new Videojuego(tituloGuardar, "Un juego de historio pura", 13, 49.33, "Activision", 3, accion));
			}
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
		}
	}
}