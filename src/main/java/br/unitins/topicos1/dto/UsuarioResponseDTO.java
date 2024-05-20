package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Funcionario;

public record UsuarioResponseDTO(
    String username,
    String nome
) {
    public static UsuarioResponseDTO valueOf(Funcionario func) {
        return new UsuarioResponseDTO(
                func.getUsuario().getUsername(),
                func.getNome()
            );
    }
    public static UsuarioResponseDTO valueOf(Cliente cli) {
        return new UsuarioResponseDTO(
                cli.getUsuario().getUsername(),
                cli.getNome()
            );
    }

}