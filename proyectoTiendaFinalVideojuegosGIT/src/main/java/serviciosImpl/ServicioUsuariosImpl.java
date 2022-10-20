package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Service
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuarios {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario usuarioRegistrar) {
		sessionFactory.getCurrentSession().save(usuarioRegistrar);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return c.list();
	}

	@Override
	public void borrarUsuario(int id) {
		Usuario u = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, id);
		sessionFactory.getCurrentSession().delete(u);
		
	}

	@Override
	public Usuario obtenerUsuarioPorId(int idUsuarioEditar) {
		return (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, idUsuarioEditar);
	}

	@Override
	public void guardarCambiosUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().merge(usuario);
		
	}
	
	@Override
	public Usuario obtenerUsuarioPorEmailYPass(String email, String pass) {
		Criteria c = 
				sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		c.add(Restrictions.eq("email", email));
		c.add(Restrictions.eq("pass", pass));
		Usuario u = null;
		if(c.uniqueResult()!=null) {
			u = (Usuario)c.uniqueResult();
		}
		return u;
	}
	
}
