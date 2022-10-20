package utilidadesSpring;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContenedorSpring {
	
	// método que devuelve el contenedor de spring
	public static WebApplicationContext otenerContenedor(ServletContext sc) {
			
		return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	}
}
