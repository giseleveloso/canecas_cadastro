package br.unitins.topicos1.dto;

public record ItemPedidoDTO(
    Double preco,
    Integer quantidade,
    Double desconto,
    Long idCaneca
) {

}