package es.sidelab.MePhone.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.Movil;

@CacheConfig(cacheNames="moviles")
public interface MovilRepository extends JpaRepository<Movil, Long>{
	
	@SuppressWarnings("unchecked") // auto generado por spring . . . 
	@CacheEvict(allEntries=true)
	Movil save (Movil movil);
	
	@Cacheable
	Movil findByIdMovil (long idMovil);
	
	@Cacheable
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
