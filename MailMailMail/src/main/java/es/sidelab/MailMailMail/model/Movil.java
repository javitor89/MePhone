package es.sidelab.MailMailMail.model;




public class Movil {
	private long idMovil;

	private String modelo;
	private String marca;
	private String pulgadas;
	private String bateria;
	private String almacenamiento;
	private String ram;
	private String resolucion;
	private String camara;
	private int precio;
	private int stock;
	private int vendidas;
	private String oferta;

	private Imagen imagen;
	
	public Movil(){}
	
	public Movil(String marca){
		this.modelo = "modelo";
		this.marca = marca;
		this.pulgadas = "pulgadas";
		this.bateria = "bateria";
		this.almacenamiento = "almacenamiento";
		this.ram = "ram";
		this.resolucion = "resolucion";
		this.camara = "camara";
		this.precio = 1;
		this.stock = 2;
		this.vendidas = 3;
		this.imagen = new Imagen();
		this.oferta = "true";
	}
	
	public long getIdMovil() {
		return idMovil;
	}

	public void setIdMovil(long idMovil) {
		this.idMovil = idMovil;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(String pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getCamara() {
		return camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getVendidas() {
		return vendidas;
	}

	public void setVendidas(int vendidas) {
		this.vendidas = vendidas;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}


	public String getOferta() {
		return oferta;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	


	@Override
	public String toString() {
		return "Movil [idMovil=" + idMovil + ", modelo=" + modelo + ", marca=" + marca + ", pulgadas=" + pulgadas
				+ ", bateria=" + bateria + ", almacenamiento=" + almacenamiento + ", ram=" + ram + ", resolucion="
				+ resolucion + ", camara=" + camara + ", precio=" + precio + ", stock=" + stock + ", vendidas="
				+ vendidas + ", oferta=" + oferta + ", imagen=" + imagen + "]";
	}






}
