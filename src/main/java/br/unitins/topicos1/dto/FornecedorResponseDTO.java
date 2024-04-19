package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Telefone;

public record FornecedorResponseDTO (Long id,String nome, Endereco endereco, Telefone telefone, String email) { 
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
    return new  FornecedorResponseDTO(
    fornecedor.getId(),    
    fornecedor.getNome(),
        fornecedor.getEndereco(),
        fornecedor.getTelefone(),
        fornecedor.getEmail());
    }
}
