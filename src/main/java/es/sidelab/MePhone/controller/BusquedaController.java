package es.sidelab.MePhone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.MePhone.repository.ImagenRepository;
import es.sidelab.MePhone.repository.MovilRepository;
import es.sidelab.MePhone.repository.UsuarioRepository;
import es.sidelab.MePhone.model.Carro;
import es.sidelab.MePhone.model.Imagen;
import es.sidelab.MePhone.model.Movil;
import es.sidelab.MePhone.model.Usuario;

@Controller
public class BusquedaController {

	@Autowired
	private MovilRepository repositorioMoviles;
	@Autowired
	private UsuarioRepository repositorioUsuarios;
	
	private long id = -1;

	@RequestMapping("/busqueda")
	public String busqueda(Model model, @RequestParam String tipoConsulta, String arg1, String arg2) {
		
		model.addAttribute("text", "0");
		model.addAttribute("c", false);
		if (id != -1) {
			model.addAttribute("nombreUsuario", repositorioUsuarios.findByIdUsuario(id).getNombre());
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
		case "logear":
			Usuario usuario = repositorioUsuarios.findByNombreAndPass(arg1,arg2);
			if (usuario != null){
				id = usuario.getIdUsuario();
				model.addAttribute("nombreUsuario", repositorioUsuarios.findByIdUsuario(id).getNombre());
				model.addAttribute("b", true);
				model.addAttribute("a", false);
				model.addAttribute("text", "logear");
			} else {
				model.addAttribute("c", true);
				model.addAttribute("text", "incorrecta");
			}
			break;
		case "logout":
			id = -1;
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
			List<Movil> p = repositorioUsuarios.findByIdUsuario(id).getCarro().getProductos();
			p.add(m);
			repositorioUsuarios.findByIdUsuario(id).getCarro().setProductos(p);
			repositorioUsuarios.save(repositorioUsuarios.findByIdUsuario(id));
			break;
		case "agregarDeseo":
		    Movil m1 = repositorioMoviles.findByIdMovil(Integer.parseInt(arg1));
		    List<Movil> p1 = repositorioUsuarios.findByIdUsuario(id).getListaDeseos().getListaProductos();
		    p1.add(m1);
		    repositorioUsuarios.findByIdUsuario(id).getListaDeseos().setListaProductos(p1);
		    model.addAttribute("moviles", repositorioUsuarios.findByIdUsuario(id).getListaDeseos().getListaProductos());
		    repositorioUsuarios.save(repositorioUsuarios.findByIdUsuario(id));
		    break;
		case "carro":
			model.addAttribute("moviles", repositorioUsuarios.findByIdUsuario(id).getCarro().getProductos());
			model.addAttribute("text", "carro");
			model.addAttribute("carro", true);
			break;
		case "listaDeseos":
			model.addAttribute("moviles", repositorioUsuarios.findByIdUsuario(id).getListaDeseos().getListaProductos());
			model.addAttribute("text", "deseos");
			model.addAttribute("deseos", true);
			break;
		default:
			model.addAttribute("moviles", null);
		}

		return "busqueda_template";
	}
}
