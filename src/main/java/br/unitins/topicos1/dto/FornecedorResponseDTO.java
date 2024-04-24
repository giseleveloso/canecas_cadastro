package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;

public record FornecedorResponseDTO (
    Long id,
    String nome, 
    EnderecoResponseDTO endereco, 
    TelefoneResponseDTO telefone, 
    String email) { 
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
    return new  FornecedorResponseDTO(
    fornecedor.getId(),    
    fornecedor.getNome(),
    EnderecoResponseDTO.valueOf(fornecedor.getEndereco()),
    TelefoneResponseDTO.valueOf(fornecedor.getTelefone()),
        fornecedor.getEmail());
    }
}
