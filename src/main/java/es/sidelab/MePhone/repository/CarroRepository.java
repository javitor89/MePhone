package es.sidelab.MePhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.Carro;
import es.sidelab.MePhone.model.Usuario;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	Usuario findByIdCarro (long idCarro);
	
}