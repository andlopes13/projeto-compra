package exercicio1.produto.pedido.repository;

import exercicio1.produto.pedido.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllById(Integer produtoId);

    List<Produto> findByNomeStartingWith(String inicioNome);
}
