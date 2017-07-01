package es.sidelab.MailMailMail.model;

import java.util.List;

public class Carro {
	private long idCarro;

	private List<Movil> productos;
	
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