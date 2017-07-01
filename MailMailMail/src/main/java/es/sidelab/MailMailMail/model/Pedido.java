package es.sidelab.MailMailMail.model;


public class Pedido {
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