package es.sidelab.MePhone.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCarro;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Movil> productos;
	
	@JsonIgnore
	@OneToOne(mappedBy="carro")
	private Usuario usuario;

	public Carro() {
	}

	public long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(long idCarro) {
		this.idCarro = idCarro;
	}

	public List<Movil> getProductos() {
		return productos;
	}

	public void setProductos(List<Movil> productos) {
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	


	@Override
	public String toString() {
		return "Carro [idCarro=" + idCarro + ", productos=" + productos + ", usuario=" + usuario + "]";
	}


	
}