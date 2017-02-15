package es.sidelab.MePhone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.sidelab.MePhone.repository.MovilRepository;

@Controller
public class vistaProductoController {

	@Autowired
	private MovilRepository repositorioMoviles;
	
	@RequestMapping("/vistaProducto")
	public String vistaProducto(Model model, @RequestParam String id){
		model.addAttribute("movil",repositorioMoviles.findByIdMovil(Integer.parseInt(id)) );
		
		
		return "vistaProducto";
	}
}
