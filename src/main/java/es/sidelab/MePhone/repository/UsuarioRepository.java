package es.sidelab.MePhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByIdUsuario (long idUsuario);

	Usuario findByNombreAndPass (String nombre, String pass);

	Usuario findByNombre(String nombre);
	
}
