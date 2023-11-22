package exercicio1.produto.pedido.repository;

import exercicio1.produto.pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepsoitory extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByDataCompraGreaterThanEqual(LocalDate porData);
}
