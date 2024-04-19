package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Tamanho;


public record TamanhoResponseDTO (Long id,Float largura,
                                Float comprimento,
                                Float profundidade) { 
    public static TamanhoResponseDTO valueOf(Tamanho tamanho) {
    return new  TamanhoResponseDTO(
        tamanho.getId(),
        tamanho.getLargura(),
        tamanho.getComprimento(),
        tamanho.getProfundidade());
    }
}
