package br.unitins.topicos1.dto;


import br.unitins.topicos1.model.Caneca;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Material;
public record CanecaResponseDTO
    (Long id,String nome, String descricao, float preco, TamanhoResponseDTO tamanho, Integer capacidade, Material material, Fornecedor fornecedor){
    public static CanecaResponseDTO valueOf(Caneca caneca) {
        return new  CanecaResponseDTO(
            caneca.getId(),
            caneca.getNome(),
            caneca.getDescricao(),
            caneca.getPreco(),
            TamanhoResponseDTO.valueOf(caneca.getTamanho()),
            caneca.getCapacidade(),
            caneca.getMaterial(),
            caneca.getFornecedor());
        }
    
}
