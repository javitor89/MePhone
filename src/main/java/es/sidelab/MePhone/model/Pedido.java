package es.sidelab.MePhone.model;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPedido; 
	
	private String recibo;

	public Pedido() {

	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", recibo=" + recibo + "]";
	}
	
	


	





	
}