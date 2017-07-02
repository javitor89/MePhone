package es.sidelab.MePhone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.sidelab.MePhone.repository.MovilRepository;
import es.sidelab.MePhone.repository.UsuarioRepository;
import es.sidelab.MePhone.model.Movil;
import es.sidelab.MePhone.model.Pedido;
import es.sidelab.MePhone.model.Usuario;

@Controller
public class WebController {

	@Autowired
	private MovilRepository repositorioMoviles;
	@Autowired
	private UsuarioRepository repositorioUsuarios;
	
	@Autowired
	private Usuario usuario = null;
	
	
	@RequestMapping("/")
	public String webInicial(Model model) {
		return "inicio";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/loginError")
	public String loginAnswer(Model model) {
		return "loginError";
	}
		
	@RequestMapping("/logout")
	public String logout(Model model) {
		usuario = null;
		return "logout";
	}
	
	@RequestMapping("/registro")
	public String registro(Model model, @RequestParam String alta, String nombre, String apellidos, String correo,String pass, String telefono) {
	
		model.addAttribute("a", true);
		
		if (Integer.parseInt(alta)==1){
			List<String> roles = new ArrayList<>();
			roles.add("ROLE_USER");
			Usuario  usuario = new Usuario(nombre, apellidos, pass, correo, telefono, roles);
			repositorioUsuarios.save(usuario);
			model.addAttribute("mensaje", true);
		} else {
			model.addAttribute("mensaje", false);
		}
		
		return "registro";
	} 
	
	@RequestMapping("/miCuenta")
	public String miCuenta(Model model, HttpServletRequest request) {
		usuario = repositorioUsuarios.findByNombre(request.getUserPrincipal().getName());
		model.addAttribute("usuario", usuario);
		return "miCuenta";
	}
	
	
	@RequestMapping("/pedidos")
	public String pedidos(Model model, HttpServletRequest request) {
		usuario = repositorioUsuarios.findByNombre(request.getUserPrincipal().getName());
		model.addAttribute("pedidos", usuario.getPedidos());
		return "pedidos";
	}
	
	@RequestMapping("/pedidoAnswer")
	public String hacerPedido(Model model, HttpServletRequest request) {
		Usuario user = repositorioUsuarios.findByNombre(request.getUserPrincipal().getName());
		
		String idMoviles = " -> ";
		for (Movil movil : user.getCarro().getProductos()) {
			idMoviles = idMoviles + movil.getIdMovil() + ", ";
		}
		idMoviles = idMoviles.substring(0, idMoviles.length() - 2) + ".";
		
		Pedido p = new Pedido();
		p.setRecibo(idMoviles);
		usuario.getPedidos().add(p);
		usuario.getCarro().getProductos().clear();
		repositorioUsuarios.save(usuario);
		
		
		RestTemplate restTemplate = new RestTemplate();

		String url="http://dadjunio.cloudapp.net:90/pedido";   // <--------- LINK <-----------
		try {
			URL u = new URL(url);
			HttpURLConnection huc =  (HttpURLConnection)  u.openConnection();
			huc.setRequestMethod("POST");
			huc.getResponseCode();
			restTemplate.postForObject(url, user, Usuario.class);
		} catch (IOException e) {
			url="http://dadjunio.cloudapp.net:91/pedido";
			restTemplate.postForObject(url, user, Usuario.class);
		} 

		return "pedidoAnswer";
	}
	
	@RequestMapping("/carrito")
	public String carrito(Model model, HttpServletRequest request, @RequestParam String tipoConsulta, String arg1) {
		usuario = repositorioUsuarios.findByNombre(request.getUserPrincipal().getName());
		if (tipoConsulta.equals("agregar") ){
			int idBuscado = Integer.parseInt(arg1);
			for (int i = 0; i < usuario.getCarro().getProductos().size(); i++) {
				if (usuario.getCarro().getProductos().get(i).getIdMovil() == idBuscado) {
					model.addAttribute("carrito", usuario.getCarro().getProductos());
					return "carrito";
				}
				
			}
			
			Movil m = repositorioMoviles.findByIdMovil(Integer.parseInt(arg1));
			usuario.getCarro().getProductos().add(m);
			repositorioUsuarios.save(usuario);
		}

		if (tipoConsulta.equals("borrar")) {
			int idBuscado = Integer.parseInt(arg1);
			for (int i = 0; i < usuario.getCarro().getProductos().size(); i++) {
				if (usuario.getCarro().getProductos().get(i).getIdMovil() == idBuscado) {
					usuario.getCarro().getProductos().remove(i);
					repositorioUsuarios.save(usuario);
					break;
				}
			}
		}
		
		model.addAttribute("carrito", usuario.getCarro().getProductos());
		return "carrito";
		
	} 
	
	@RequestMapping("/busqueda")
	public String busqueda(Model model, @RequestParam String tipoConsulta, String arg1, String arg2, HttpServletRequest request) {
		
		model.addAttribute("text", "0");
		model.addAttribute("c", false);
		if (request.isUserInRole("USER")) {
			model.addAttribute("nombreUsuario",  request.getUserPrincipal().getName());
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
		case "vista":
			model.addAttribute("movil", repositorioMoviles.findByIdMovil(Integer.parseInt(arg1)));
			model.addAttribute("text", "vista");
			model.addAttribute("vista", true);
			break;
		default:
			model.addAttribute("moviles", null);
		}

		return "busqueda_template";
	}
}
