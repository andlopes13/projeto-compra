package exercicio1.produto.pedido.controller;

import exercicio1.produto.pedido.domain.Pedido;
import exercicio1.produto.pedido.domain.Produto;
import exercicio1.produto.pedido.service.PedidoService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido cadastrarPedido(@RequestBody Pedido novoPedido) {
        return this.pedidoService.cadastrarPedido(novoPedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return this.pedidoService.listarPedidos();
    }

    @PutMapping("{pedidoId}")
    public Pedido editarPedido(@PathVariable("pedidoId") Integer pedidoId, @RequestBody Pedido novoPedido ) {
        return this.pedidoService.editarPedido(pedidoId, novoPedido);
    }

    @DeleteMapping("{Id}")
    public void excluirPedidoPorId(@PathVariable Integer Id) {
        this.pedidoService.excluiPedidoPorId(Id);
    }

    @GetMapping("por-data")
    public List<Pedido> listarPedidoPorData(@RequestParam("porData") LocalDate porData) {
        return this.pedidoService.listarPedidoPorData(porData);
    }
}
