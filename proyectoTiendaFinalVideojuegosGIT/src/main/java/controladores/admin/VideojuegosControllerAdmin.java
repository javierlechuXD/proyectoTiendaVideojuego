package controladores.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Usuario;
import modelo.Videojuego;
import servicios.ServicioCategorias;
import servicios.ServicioVideojuegos;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("/admin/")
public class VideojuegosControllerAdmin {
	@Autowired
	private ServicioVideojuegos servicioVideojuegos;
	@Autowired 
	ServicioCategorias servicioCategorias;
	
	@RequestMapping("videojuegos")
	public String videojuegos() {
		System.out.println("ProductosController");
		return "videojuegos";
	}
	
	@RequestMapping("gestionarVideojuegos")
	public String gestionarVideojuegos(Model model, @RequestParam(defaultValue = "") String nombre) {
		model.addAttribute("info",servicioVideojuegos.obtenerVideojuegos(nombre));	
		return "admin/gestionarVideojuegos";
	}
	
	@RequestMapping("borrarVideojuego")
	public String borrarVideojuego(@RequestParam String idVideojuego, Model model) {
		servicioVideojuegos.borrarVideojuego(Integer.parseInt(idVideojuego));	
		return gestionarVideojuegos(model, "");
	}
	
	@RequestMapping("nuevoVideojuegoAdmin")
	public String registrarVideojuegosAdmin(Model model) {
		Videojuego v = new Videojuego();
		v.setPrecio(1);
		v.setEdadmin(13);
		v.setNotaCritica(5);
		model.addAttribute("videojuego", v);
		model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
		
		return "admin/formRegistrarVideojuego";
	}
	
	@RequestMapping("editarVideojuego")
	public String editarVideojuegoAdmin(@RequestParam String idVideojuego, Model model) {
		model.addAttribute("videojuego", servicioVideojuegos.obtenerVideojuegoPorId(Integer.parseInt(idVideojuego)));
		model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/editarVideojuego";
	}
	
	@RequestMapping("guardarNuevoVideojuegoAdmin")
	public String guardarNuevoVideojuegoAdmin(Videojuego videojuego, Model model, HttpServletRequest request) {
		String nombrePortada = videojuego.getPortada().getOriginalFilename();
		String nombrePortada2 = videojuego.getPortada().getOriginalFilename();
		if (nombrePortada.endsWith(".jpg") && nombrePortada2.endsWith(".jpg")) {
			servicioVideojuegos.registrarVideojuego(videojuego);	
			try {
				String rutaRealDelProyecto = request.getServletContext().getRealPath("");
				GestorArchivos.guardarPortadaVideojuego(videojuego, rutaRealDelProyecto);
			} catch (Exception e) {
				System.out.println("Fallo al guardar");
			}

			return gestionarVideojuegos(model, "");
		}else {
			System.out.println("Extensión de archivo no valida");
			return gestionarVideojuegos(model, "");
		}

	}
	
	@RequestMapping("guardarEdicionVideojuegoAdmin")
	public String guardarEdicionVideojuegoAdmin(Videojuego videojuego, Model model) {
		servicioVideojuegos.guardarCambiosVideojuego(videojuego); 
		return gestionarVideojuegos(model, "");
	}

}
