package exercicio1.produto.pedido.controller;

import exercicio1.produto.pedido.domain.Compra;
import exercicio1.produto.pedido.service.CompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra cadastrarCompra(@RequestBody Compra novaCompra) {
        return this.compraService.cadastrarCompra(novaCompra);
    }

    @GetMapping
    public List<Compra> lsitarCompras() {
        return this.compraService.listarCompra();
    }

    @PutMapping("{compraId}")
    public Compra editarPedido(@PathVariable("compraId") Integer compraId, @RequestBody Compra novaCompra) {
        return this.compraService.editarCompra(compraId, novaCompra);
    }

    @DeleteMapping("{Id}")
    public void excluirCompraPorId(@PathVariable Integer Id) {
        this.compraService.excluirCompraPorId(Id);
    }
}
