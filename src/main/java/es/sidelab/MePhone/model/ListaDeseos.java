package es.sidelab.MePhone.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.sidelab.MePhone.model.Movil;

@Entity
public class ListaDeseos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idListaDeseos;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Movil> listaProductos;
	
	@OneToOne(mappedBy="listaDeseos")
	private Usuario usuario;
	
	
	
	public ListaDeseos(){}

	public List<Movil> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Movil> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "ListaDeseos [listaProductos=" + listaProductos + "]";
	}
}
