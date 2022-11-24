package serviciosWEB;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import servicios.ServicioVideojuegos;

@Controller
public class ServicioWebVideojuegos {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;
	
	@RequestMapping("ServicioWebVideojuegos/obtenerVideojuegos")
	public ResponseEntity<String> obtenerVideojuegos(@RequestParam(defaultValue = "") String nombre,  @RequestParam(defaultValue = "0" ) String comienzo){
		RespuestaVideojuegos rv = new RespuestaVideojuegos();
		rv.setVideojuegos(servicioVideojuegos.obtenerVideojuegos(nombre,Integer.parseInt(comienzo)));
		rv.setTotal(servicioVideojuegos.obtenerTotalDeVideojuegos(nombre));
		String respuesta = new Gson().toJson(rv);
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
}
