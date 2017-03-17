package es.sidelab.MePhone.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.MePhone.repository.MovilRepository;
import es.sidelab.MePhone.repository.UsuarioRepository;
import es.sidelab.MePhone.model.Movil;
import es.sidelab.MePhone.model.Usuario;

@Controller
public class WebController {

	@Autowired
	private MovilRepository repositorioMoviles;
	@Autowired
	private UsuarioRepository repositorioUsuarios;
	//@Autowired
	private Usuario usuario = null;
	
	@RequestMapping("/")
	public String webInicial(Model model) {
		return "inicio";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/loginAnswer")
	public String loginAnswer(Model model, @RequestParam String name, String pass) {
		Usuario user = repositorioUsuarios.findByNombreAndPass(name, pass);
		if (user != null){
			usuario = user;
			model.addAttribute("success", true);
			model.addAttribute("unsuccess", false);
		} else {
			model.addAttribute("success", false);
			model.addAttribute("unsuccess", true);
		}
		return "loginAnswer";
	}
	
	@RequestMapping("/registro")
	public String registro(Model model, @RequestParam String alta, String nombre, String apellidos, String correo,String pass, String telefono) {
	
		model.addAttribute("a", true);
		
		if (Integer.parseInt(alta)==1){
			Usuario  usuario = new Usuario(nombre, apellidos, correo, pass, telefono);
			repositorioUsuarios.save(usuario);
			model.addAttribute("mensaje", true);
		} else {
			model.addAttribute("mensaje", false);
		}
		
		return "registro";
	}
	 
	@RequestMapping("/carrito")
	public String carrito(Model model) {
		model.addAttribute("carrito", usuario.getCarro().getProductos());
		return "carrito";
	}
	
	@RequestMapping("/busqueda")
	public String busqueda(Model model, @RequestParam String tipoConsulta, String arg1, String arg2) {
		
		model.addAttribute("text", "0");
		model.addAttribute("c", false);
		if (usuario != null) {
			model.addAttribute("nombreUsuario", usuario.getNombre());
			model.addAttribute("b", true);
			model.addAttribute("a", false);
		} else {
			model.addAttribute("nombreUsuario", "0");
			model.addAttribute("b", false);
			model.addAttribute("a", true);
		}
		
		switch (tipoConsulta) {
		case "marca":
			model.addAttribute("moviles", repositorioMoviles.findAllByMarca(arg1));
			break;
		case "pulgadas":
			model.addAttribute("moviles", repositorioMoviles.findAllByPulgadas(arg1));
			break;
		case "bateria":
			model.addAttribute("moviles", repositorioMoviles.findAllByBateria(arg1));
			break;
		case "almacenamiento":
			model.addAttribute("moviles", repositorioMoviles.findAllByAlmacenamiento(arg1));
			break;
		case "ram":
			model.addAttribute("moviles", repositorioMoviles.findAllByRam(arg1));
			break;
		case "resolucion":
			model.addAttribute("moviles", repositorioMoviles.findAllByResolucion(arg1));
			break;
		case "camara":
			model.addAttribute("moviles", repositorioMoviles.findAllByCamara(arg1));
			break;
		case "precio":
			model.addAttribute("moviles", repositorioMoviles.findAllByPrecio(Integer.parseInt(arg1)));
			break;
		case "modelo":
			model.addAttribute("moviles", repositorioMoviles.findAllByModelo(arg1));
			break;
		case "inicio":
			model.addAttribute("moviles", repositorioMoviles.findAllByStockGreaterThan(Integer.parseInt("1")));
			model.addAttribute("text", "stock");
			break;
		case "oferta":
			model.addAttribute("moviles", repositorioMoviles.findAllByOferta("true"));
			model.addAttribute("text", "oferta");
			break;
		case "añadir":
			Movil movil = new Movil(arg1);
			repositorioMoviles.save(movil);
			break;
		case "contacto":
			model.addAttribute("text", "contacto");
			break;
		case "logout":
			usuario = null;
			model.addAttribute("a", true);
			model.addAttribute("b", false);
			model.addAttribute("text", "logout");
			break;
		case "vista":
			model.addAttribute("movil", repositorioMoviles.findByIdMovil(Integer.parseInt(arg1)));
			model.addAttribute("text", "vista");
			model.addAttribute("vista", true);
			break;
		case "agregarAlCarrito":
			Movil m = repositorioMoviles.findByIdMovil(Integer.parseInt(arg1));
			usuario.getCarro().getProductos().add(m);
			break;
		case "agregarDeseo":
		    Movil m1 = repositorioMoviles.findByIdMovil(Integer.parseInt(arg1));
		    List<Movil> p1 = usuario.getListaDeseos().getListaProductos();
		    p1.add(m1);
		    usuario.getListaDeseos().setListaProductos(p1);
		    model.addAttribute("moviles", usuario.getListaDeseos().getListaProductos());
		    repositorioUsuarios.save(usuario);
		    break;
		default:
			model.addAttribute("moviles", null);
		}

		return "busqueda_template";
	}
}
