package exercicio1.produto.pedido.service;

import exercicio1.produto.pedido.domain.Produto;
import exercicio1.produto.pedido.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public List<Produto> listar;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto(Produto novoProduto) {
        this.validarDadosProduto(novoProduto);
        return this.produtoRepository.save(novoProduto);
    }

    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }

    public List<Produto> listarProdutoPorId(Integer Id) {
        return this.produtoRepository.findAllById(Id);
    }

    public void excluirPorId(Integer id) {
        this.produtoRepository.deleteById(id);
    }

    public Produto editarProduto(Integer produtoId, Produto novoProduto) {
        this.validarDadosProduto(novoProduto);

        Produto produtoAntigo = this.produtoRepository.findById(produtoId).orElseThrow(() -> new EntityNotFoundException(("Produto não encontrado!")));
        produtoAntigo.setCategoria(novoProduto.getCategoria());
        produtoAntigo.setNome(novoProduto.getNome());
        produtoAntigo.setDataCriacao(novoProduto.getDataCriacao());
        produtoAntigo.setPeso(novoProduto.getPeso());
        produtoAntigo.setMarca(novoProduto.getMarca());
        produtoAntigo.setUnidade(novoProduto.getUnidade());
        return this.produtoRepository.save(produtoAntigo);
    }

    private void validarDadosProduto(Produto novoProduto) {
        if (novoProduto.getNome() == null || novoProduto.getNome().trim().equals("")) {
            throw new IllegalArgumentException("Nome inválido!");
        }
    }

    public List<Produto> listarProdutosPorInicioNome(String inicioNome) {
        return this.produtoRepository.findByNomeStartingWith(inicioNome);
    }
}
