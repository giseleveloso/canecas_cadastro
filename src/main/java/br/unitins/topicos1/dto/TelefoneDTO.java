package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record TelefoneDTO (
    @NotBlank(message = "O codigo de área não pode ser nulo ou vazio")
    String codigoArea,
    String numero
) { }
