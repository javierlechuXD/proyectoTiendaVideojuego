package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import servicioSetUp.InterfazSetUp;

@Controller
public class ControladorInicio {

	@Autowired
	private InterfazSetUp servicioSetUp;

	@RequestMapping("/inicio")
	public String inicio() {
		System.out.println("Código de idioma actual: " + LocaleContextHolder.getLocale());
		servicioSetUp.setUp();
		return "inicio";
	}
}
