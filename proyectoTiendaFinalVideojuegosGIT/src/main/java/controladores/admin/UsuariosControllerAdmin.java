package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Usuario;
import modelo.Videojuego;
import servicios.ServicioUsuarios;

@Controller
@RequestMapping("/admin/")
public class UsuariosControllerAdmin {
	
	//autowired en este caso pide la bean cuya clase implmente servicioUsuarios
	//dicha bean es la que hemos cargado en beans.xml
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@RequestMapping("gestionarUsuarios")
	public String gestionarUsuarios(Model model) {
		model.addAttribute("info",servicioUsuarios.obtenerUsuarios());		
		return "admin/gestionarUsuarios";
	}


	@RequestMapping("borrarUsuario")
	public String borrarUsuario(String idUsuario, Model model) {
		servicioUsuarios.borrarUsuario(Integer.parseInt(idUsuario));	
		return gestionarUsuarios(model);
	}
	
	@RequestMapping("nuevoUsuarioAdmin")
	public String registrarUsuarios(Model model) {
		Usuario u = new Usuario();
		model.addAttribute("usuario", u);
		
		return "admin/formRegistrarUsuario";
	}
	
	@RequestMapping("guardarNuevoUsuarioAdmin")
	public String guardarUsuarios(Usuario usuario, Model model) {
		servicioUsuarios.registrarUsuario(usuario);	
		return gestionarUsuarios(model);
	}
	@RequestMapping("editarUsuario")
	public String editarUsuarioAdmin(@RequestParam String idUsuario, Model model) {
		model.addAttribute("usuario", servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario)));
		return "admin/editarUsuario";
	}
	
	@RequestMapping("guardarEdicionUsuarioAdmin")
	public String guardarEdicionUsuarioAdmin(Usuario usuario, Model model) {
		servicioUsuarios.guardarCambiosUsuario(usuario);
		return gestionarUsuarios(model);
	}
}
