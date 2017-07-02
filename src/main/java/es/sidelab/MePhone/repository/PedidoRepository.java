package es.sidelab.MePhone.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import es.sidelab.MePhone.model.Pedido;
import es.sidelab.MePhone.model.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	Usuario findByIdPedido(long idPedido);
	
}