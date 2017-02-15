package es.sidelab.MePhone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.MePhone.model.Usuario;
import es.sidelab.MePhone.repository.UsuarioRepository;

@Controller
public class RegistroController {

	@Autowired
	private UsuarioRepository repositorioUsuarios;
	
	@RequestMapping("/registro")
	public String registro(Model model, @RequestParam String alta, String nombre, String apellidos, String correo,String pass, String telefono) {{
	
		model.addAttribute("a", true);
		
		if (Integer.parseInt(alta)==1){
			Usuario  usuario = new Usuario(nombre, apellidos, correo, pass, telefono);
			repositorioUsuarios.save(usuario);
			model.addAttribute("mensaje", true);
		} else {
			model.addAttribute("mensaje", false);
		}
	}
		
		return "registro";
	}
}
