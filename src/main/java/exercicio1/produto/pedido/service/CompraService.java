package exercicio1.produto.pedido.service;

import exercicio1.produto.pedido.domain.Compra;
import exercicio1.produto.pedido.domain.Pedido;
import exercicio1.produto.pedido.domain.Produto;
import exercicio1.produto.pedido.repository.CompraRepository;
import exercicio1.produto.pedido.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra cadastrarCompra(Compra novaCompra) {
        this.validarDadosCompra(novaCompra);
        return this.compraRepository.save(novaCompra);
    }

    private void validarDadosCompra(Compra novaCompra) {
    }

    public List<Compra> listarCompra() {
        return compraRepository.findAll();
    }

    public Compra editarCompra(Integer compraId, Compra novaCompra) {
        this.validarDadosCompra(novaCompra);

        Compra compraAntiga = this.compraRepository.findById(compraId).orElseThrow(() -> new EntityNotFoundException(("Compra não encontrada!")));
        compraAntiga.setQuantidade(novaCompra.getQuantidade());
        compraAntiga.setValor(novaCompra.getValor());
        compraAntiga.setProdutos(novaCompra.getProdutos());
        compraAntiga.setPedido(novaCompra.getPedido());
        return this.compraRepository.save(compraAntiga);
    }

    public void excluirCompraPorId(Integer id) {
        this.compraRepository.deleteById(id);
    }
}
