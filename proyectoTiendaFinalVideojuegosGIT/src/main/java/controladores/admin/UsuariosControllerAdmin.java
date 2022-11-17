package controladores.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modelo.Usuario;
import modelo.Videojuego;
import servicios.ServicioUsuarios;
import utilidadesArchivos.GestorArchivos;

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
	public String guardarUsuarios(Usuario usuario, Model model, HttpServletRequest request) {
		if (usuario.getFotoPerfil().getSize() != 0) {
			usuario.setFechaImagenPerfil(new Date());
		}
		
		String nombreFotoPerfil = usuario.getFotoPerfil().getOriginalFilename();
		if (nombreFotoPerfil.endsWith(".jpg")) {
			servicioUsuarios.registrarUsuario(usuario);
			try {
				String rutaRealDelProyecto = request.getServletContext().getRealPath("");
				GestorArchivos.guardarFotoUsuario(usuario, (CommonsMultipartFile)usuario.getFotoPerfil(), rutaRealDelProyecto);
			} catch (Exception e) {
				System.out.println("Fallo al guardar");
			}

			return gestionarUsuarios(model);
		}
		
		return gestionarUsuarios(model);
	}
	@RequestMapping("editarUsuario")
	public String editarUsuarioAdmin(@RequestParam String idUsuario, Model model) {
		model.addAttribute("usuario", servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario)));
		return "admin/editarUsuario";
	}
	
	@RequestMapping("guardarEdicionUsuarioAdmin")
	public String guardarEdicionUsuarioAdmin(Usuario usuario, Model model, HttpServletRequest request) {
		if (usuario.getFotoPerfil().getSize() != 0) {
			usuario.setFechaImagenPerfil(new Date());
		}
		
		String nombreFotoPerfil = usuario.getFotoPerfil().getOriginalFilename();
		if (nombreFotoPerfil.endsWith(".jpg")) {
			servicioUsuarios.guardarCambiosUsuario(usuario);
			try {
				String rutaRealDelProyecto = request.getServletContext().getRealPath("");
				GestorArchivos.guardarFotoUsuario(usuario, (CommonsMultipartFile)usuario.getFotoPerfil(), rutaRealDelProyecto);
			} catch (Exception e) {
				System.out.println("Fallo al guardar");
			}

			return gestionarUsuarios(model);
		}
		
		return gestionarUsuarios(model);
	}
}
