package serviciosWEB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
public class ServicioWebPlantillas {
	@RequestMapping("ServicioWebPlantillas")
	public ResponseEntity<String> plantillas(HttpServletRequest request){
		
		String idiomaActucal = LocaleContextHolder.getLocale().toString();
		String carpetaPlantillas = "plantillas";
		
		if(idiomaActucal.startsWith("en")) {
			carpetaPlantillas = "plantillas_en";
		}
		if(idiomaActucal.startsWith("de")) {
			carpetaPlantillas = "plantillas_de";
		}
		if(idiomaActucal.startsWith("fr")) {
			carpetaPlantillas = "plantillas_fr";
		}
		if(idiomaActucal.startsWith("it")) {
			carpetaPlantillas = "plantillas_it";
		}
		
		
		File plantillas = 
				new File(request.getServletContext().getRealPath("/"+carpetaPlantillas));
		File[] archivos = plantillas.listFiles();
		List<String> rutas = new ArrayList<>();
		for(File f : archivos) {
			rutas.add(f.getName());
		}
		String respuesta = new Gson().toJson(rutas);
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
}
