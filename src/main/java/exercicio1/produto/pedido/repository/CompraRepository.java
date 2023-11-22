package exercicio1.produto.pedido.repository;

import exercicio1.produto.pedido.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
