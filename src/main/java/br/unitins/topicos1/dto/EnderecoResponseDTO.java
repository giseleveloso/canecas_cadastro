package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;

public record EnderecoResponseDTO (Long id,Integer cep,String rua, Integer numero) { 
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
    return new  EnderecoResponseDTO(
        endereco.getId(),
        endereco.getCep(),
        endereco.getRua(),
        endereco.getNumero());
    }
}
