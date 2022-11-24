package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {
	
	public void registrarUsuario(Usuario usuarioRegistrar);
	
	public List<Usuario> obtenerUsuarios();
	
	public void borrarUsuario (int id);

	public Usuario obtenerUsuarioPorId(int idUsuarioEditar);

	public void guardarCambiosUsuario(Usuario usuario);
	
	Usuario obtenerUsuarioPorEmail(String email);
	
	Usuario obtenerUsuarioPorEmailYPass(String email, String pass);
}
