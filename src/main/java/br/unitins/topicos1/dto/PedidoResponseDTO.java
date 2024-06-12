package br.unitins.topicos1.dto;

import java.util.List;
import java.util.UUID;

import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Status;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    Double total,
    List<ItemPedidoResponseDTO> itens,
    Pagamento pagamento,
    String chavePagamento,
    Status statusPagamento
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                            .stream()
                                            .map(ItemPedidoResponseDTO::valueOf)
                                            .toList();
        return new PedidoResponseDTO(
            pedido.getId(), 
            ClienteResponseDTO.valueOf(pedido.getCliente()),
            pedido.getTotal(),
            lista,
            pedido.getFormaPagamento(),

            // implementar logica de geracao de chave de pagamento
            String.valueOf(UUID.randomUUID()),
            
            pedido.getStatusPagamento());
    }

}