package serviciosWEB;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import servicios.ServicioVideojuegos;

@Controller
public class ServicioWebVideojuegos {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;
	
	@RequestMapping("ServicioWebVideojuegos/obtenerVideojuegos")
	public ResponseEntity<String> obtenerVideojuegos(){
		String respuesta = new Gson().toJson(servicioVideojuegos.obtenerVideojuegos(""));
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
}
