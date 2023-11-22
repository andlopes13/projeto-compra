package exercicio1.produto.pedido.controller;

import exercicio1.produto.pedido.domain.Produto;
import exercicio1.produto.pedido.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto novoProduto) {
        return this.produtoService.cadastrarProduto(novoProduto);
    }

    @PutMapping("{produtoId}")
    public Produto editarProduto(@PathVariable("produtoId") Integer produtoId, @RequestBody Produto novoProduto) {
        return this.produtoService.editarProduto(produtoId, novoProduto);
    }

    @GetMapping("tudo")
    public List<Produto> listarProdutos() {
        return this.produtoService.listarProdutos();
    }

    @GetMapping("{id}")
    public List<Produto> listarProdutoPorId(@PathVariable("id") Integer id) {
        return this.produtoService.listarProdutoPorId(id);
    }

    @GetMapping("por-inicio-nome")
    public List<Produto> listarProdutoPorInicioNome(@RequestParam("inicioNome") String inicioNome) {
        return this.produtoService.listarProdutosPorInicioNome(inicioNome);
    }

    @DeleteMapping("{id}")
    public void excluirPorId(@PathVariable Integer id) {
        this.produtoService.excluirPorId(id);
    }
}
