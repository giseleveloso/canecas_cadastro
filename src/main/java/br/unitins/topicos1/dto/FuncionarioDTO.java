package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String nome,
    @NotBlank(message = "O cargo não pode ser nulo ou vazio")
    String cargo, 
    Long id_endereco, 
    Long id_telefone, 
    String email,
    String username,
    String senha) { }
