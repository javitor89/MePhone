package es.sidelab.MePhone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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