package es.sidelab.MailMailMail.model;


public class Imagen {
	private long idImagen;
	
	private String nombre;
	
	public Imagen(){
		this.nombre = "nexus5.png";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Imagen [idImagen=" + idImagen + ", nombre=" + nombre + "]";
	}
	
	
}