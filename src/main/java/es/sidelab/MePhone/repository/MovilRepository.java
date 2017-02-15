package es.sidelab.MePhone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.Movil;

public interface MovilRepository extends JpaRepository<Movil, Long>{
	
	Movil findByIdMovil (long idMovil);

	List<Movil> findAllByModelo (String modelo);
	List<Movil> findAllByMarca (String marca);
	List<Movil> findAllByPulgadas (String pulgadas);
	List<Movil> findAllByBateria (String bateria);
	List<Movil> findAllByAlmacenamiento (String almacenamiento);
	List<Movil> findAllByRam (String ram);
	List<Movil> findAllByResolucion (String resolucion);
	List<Movil> findAllByCamara (String camara);
	List<Movil> findAllByPrecio (int precio);
	List<Movil> findAllByStockGreaterThan (int stock);
	List<Movil> findAllByVendidas (int vendidas);
	List<Movil> findAllByOferta(String oferta);

	Movil findByMarca(String marca);
}
