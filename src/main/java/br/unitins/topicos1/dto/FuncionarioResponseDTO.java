package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Telefone;

public record FuncionarioResponseDTO (Long id,String nome,String cargo, Endereco endereco, Telefone telefone, String email) { 
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
    return new  FuncionarioResponseDTO(
        funcionario.getId(),
        funcionario.getNome(),
        funcionario.getCargo(),
        funcionario.getEndereco(),
        funcionario.getTelefone(),
        funcionario.getEmail());
    }
}
