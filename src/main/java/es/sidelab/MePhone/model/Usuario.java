package es.sidelab.MePhone.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;



@Entity
@Component
@SessionScope

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

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Pedido> pedidos;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public Usuario(){	}
	
	public Usuario(String nombre, String apellidos, String pass, String correo, String telefono, List<String> roles ) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pass = new BCryptPasswordEncoder().encode(pass);
		this.correo = correo;
		this.telefono = telefono;
		this.carro = new Carro();
		this.roles = roles;
		 
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
		this.pass = new BCryptPasswordEncoder().encode(pass);
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", pass=" + pass + ", telefono=" + telefono + ", carro=" + carro + ", pedidos=" + pedidos
				+ ", roles=" + roles + "]";
	}






	


}