package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    String nome,
    String cargo, 
    EnderecoResponseDTO endereco, 
    TelefoneResponseDTO telefone, 
    String email,
    String username,
    String senha) { 
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
    return new FuncionarioResponseDTO(
        funcionario.getId(),
        funcionario.getNome(),
        funcionario.getCargo(),
        EnderecoResponseDTO.valueOf(funcionario.getEndereco()),
        TelefoneResponseDTO.valueOf(funcionario.getTelefone()),
        funcionario.getEmail(),
        funcionario.getUsuario().getUsername(),
        funcionario.getUsuario().getSenha());
    }
}
