package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO (
    Long id,
    Double preco,
    Integer quantidade,
    Double desconto,
    CanecaResponseDTO caneca
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getId(), 
            item.getPreco(), 
            item.getQuantidade(),
            item.getDesconto(),
            CanecaResponseDTO.valueOf(item.getCaneca()));
    }
}