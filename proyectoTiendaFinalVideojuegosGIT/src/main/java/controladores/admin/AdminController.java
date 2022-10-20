package controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("admin/")
	public String inicio() {
		return "admin/index";
	}
	
	@RequestMapping("admin/atras")
	public String atras() {
		return "admin/index";
	}
	
}
