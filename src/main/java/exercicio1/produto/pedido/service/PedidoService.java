package exercicio1.produto.pedido.service;

import exercicio1.produto.pedido.domain.Pedido;
import exercicio1.produto.pedido.repository.PedidoRepsoitory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepsoitory pedidoRepsoitory;

    public PedidoService(PedidoRepsoitory pedidoRepsoitory) {
        this.pedidoRepsoitory = pedidoRepsoitory;
    }

    public Pedido cadastrarPedido(Pedido novoPedido) {
        this.validarDadosPedido(novoPedido);
        return this.pedidoRepsoitory.save(novoPedido);
    }

    private void validarDadosPedido(Pedido novoPedido) {
    }

    public List<Pedido> listarPedidos() {
        return this.pedidoRepsoitory.findAll();
    }

    public List<Pedido> listarPedidoPorData(LocalDate porData) {
        return this.pedidoRepsoitory.findByDataCompraGreaterThanEqual(porData);
    }

    public Pedido editarPedido(Integer pedidoId, Pedido novoPedido) {
        this.validarDadosPedido(novoPedido);

        Pedido pedidoAntigo = this.pedidoRepsoitory.findById(pedidoId).orElseThrow(() -> new EntityNotFoundException(("Pedido não encontrado!")));
        pedidoAntigo.setId(novoPedido.getId());
        pedidoAntigo.setDataCompra(novoPedido.getDataCompra());
        return this.pedidoRepsoitory.save(pedidoAntigo);
    }

    public void excluiPedidoPorId(Integer id) {
        this.pedidoRepsoitory.deleteById(id);
    }
}
