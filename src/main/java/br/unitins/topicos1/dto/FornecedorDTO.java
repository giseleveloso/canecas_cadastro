package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String nome, 
Long id_endereco, 
Long id_telefone, 
String email) { }
