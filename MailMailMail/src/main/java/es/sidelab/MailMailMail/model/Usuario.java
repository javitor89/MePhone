package es.sidelab.MailMailMail.model;


import java.util.List;




public class Usuario {
	private long idUsuario;

	private String nombre;
	private String apellidos;
	private String correo;
	private String pass;
	private String telefono;
	
	private Carro carro;

	private List<Pedido> pedidos;
	
	private List<String> roles;
	
	public Usuario(){	}
	
	public Usuario(String nombre, String apellidos, String pass, String correo, String telefono, List<String> roles ) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pass = pass;
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