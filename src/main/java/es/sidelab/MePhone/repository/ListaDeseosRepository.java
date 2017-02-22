package es.sidelab.MePhone.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.MePhone.model.ListaDeseos;
import es.sidelab.MePhone.model.Usuario;

public interface ListaDeseosRepository extends JpaRepository<ListaDeseos, Long>{
	
	Usuario findByIdListaDeseos (long idListaDeseos);
	
}
