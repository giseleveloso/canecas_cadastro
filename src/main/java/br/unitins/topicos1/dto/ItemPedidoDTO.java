package br.unitins.topicos1.dto;

public record ItemPedidoDTO(
    Integer quantidade,
    Double desconto,
    Long idCaneca
) {

}