package controladores.admin;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constantes.Paginacion;
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
	public String gestionarVideojuegos(Model model, @RequestParam(defaultValue = "") String nombre, @RequestParam(defaultValue = "0")String comienzo) {
		int comienzo_int = Integer.parseInt(comienzo);
		System.out.println("Mostrar resultados desde: " + comienzo_int);
		
		model.addAttribute("info",servicioVideojuegos.obtenerVideojuegos(nombre, comienzo_int));	
		model.addAttribute("siguiente", comienzo_int + Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("nombre", nombre);
		model.addAttribute("anterior", comienzo_int - Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("total", servicioVideojuegos.obtenerTotalDeVideojuegos(nombre));
		return "admin/gestionarVideojuegos";
	}
	
	@RequestMapping("borrarVideojuego")
	public String borrarVideojuego(@RequestParam String idVideojuego, Model model) {
		servicioVideojuegos.borrarVideojuego(Integer.parseInt(idVideojuego));	
		return gestionarVideojuegos(model, "", "0");
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
		System.out.println("Libro a editar parámetro ID: " + idVideojuego);
		model.addAttribute("videojuego", servicioVideojuegos.obtenerVideojuegoPorId(Integer.parseInt(idVideojuego)));
		model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/editarVideojuego";
	}
	
	@RequestMapping("guardarNuevoVideojuegoAdmin")
	public String guardarNuevoVideojuegoAdmin(@ModelAttribute("videojuego") @Valid Videojuego videojuego, BindingResult br, Model model, HttpServletRequest request) {
		System.out.println(videojuego.getNombre());
		if(! br.hasErrors()) {
			if (videojuego.getPortada().getSize() != 0) {
				videojuego.setFechaImagenPortada1(new Date());
			}
			if (videojuego.getPortada2().getSize() != 0) {
				videojuego.setFechaImagenPortada2(new Date());
			}
			String nombrePortada = videojuego.getPortada().getOriginalFilename();
			String nombrePortada2 = videojuego.getPortada().getOriginalFilename();
			if (nombrePortada.endsWith(".jpg") && nombrePortada2.endsWith(".jpg")) {
				videojuego.setAlta(true);
				servicioVideojuegos.registrarVideojuego(videojuego);
				System.out.println("Videojuego registrado correctamente;");
				try {
					String rutaRealDelProyecto = request.getServletContext().getRealPath("");
					GestorArchivos.guardarPortadaVideojuego(videojuego, rutaRealDelProyecto);
				} catch (Exception e) {
					System.out.println("Fallo al guardar");
				}

				return gestionarVideojuegos(model, "", "0");
			}else {
				System.out.println("Extensión de archivo no valida");
				return gestionarVideojuegos(model, "", "0");
			}
		}else {
			model.addAttribute("videojuego", videojuego);
			model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
			return "admin/formRegistrarVideojuego";
		}
	}
	
	@RequestMapping("guardarEdicionVideojuegoAdmin")
	public String guardarEdicionVideojuegoAdmin(Videojuego videojuego, Model model, HttpServletRequest request) {
		if (videojuego.getPortada().getSize() != 0) {
			videojuego.setFechaImagenPortada1(new Date());
		}
		if (videojuego.getPortada2().getSize() != 0) {
			videojuego.setFechaImagenPortada2(new Date());
		}
		String nombrePortada = videojuego.getPortada().getOriginalFilename();
		String nombrePortada2 = videojuego.getPortada().getOriginalFilename();
		if (nombrePortada.endsWith(".jpg") && nombrePortada2.endsWith(".jpg")) {
			servicioVideojuegos.guardarCambiosVideojuego(videojuego); 
			try {
				String rutaRealDelProyecto = request.getServletContext().getRealPath("");
				GestorArchivos.guardarPortadaVideojuego(videojuego, rutaRealDelProyecto);
			} catch (Exception e) {
				System.out.println("Fallo al guardar");
			}
		}else {
			System.out.println("Extensión de archivo no valida");
			return gestionarVideojuegos(model, "", "0");
		}
		
		return gestionarVideojuegos(model, "", "0");
	}

}
