package es.sidelab.MePhone.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;

	private String nombre;
	private String apellidos;
	private String correo;
	private String pass;
	private String telefono;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Carro carro;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ListaDeseos listaDeseos;
	
	public Usuario(){
		
	}
	
	public Usuario(String nombre, String apellidos, String correo,String pass, String telefono ) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.pass = pass;
		this.telefono = telefono;
		this.carro = new Carro();
		this.listaDeseos = new ListaDeseos();
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public ListaDeseos getListaDeseos() {
		return listaDeseos;
	}

	public void setListaDeseos(ListaDeseos listaDeseos) {
		this.listaDeseos = listaDeseos;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", pass=" + pass + ", telefono=" + telefono + ", carro=" + carro + ", listaDeseos="
				+ listaDeseos + "]";
	}



	


}