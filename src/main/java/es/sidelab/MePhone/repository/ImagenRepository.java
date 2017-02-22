package es.sidelab.MePhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Long>{
	
	Imagen findByIdImagen (long idImagen);
	
}
