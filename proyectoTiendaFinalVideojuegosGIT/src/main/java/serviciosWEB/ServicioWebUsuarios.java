package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Controller
@RequestMapping("ServicioWebUsuarios/")
public class ServicioWebUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@RequestMapping("registrarUsuario")
	public ResponseEntity<String> registrarUsuario(@RequestParam("info") String json){
		Usuario u = new Gson().fromJson(json, Usuario.class);
		System.out.println("registrar: " + u.toString());
		String respuesta = "ok";
		servicioUsuarios.registrarUsuario(u);
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}

}






