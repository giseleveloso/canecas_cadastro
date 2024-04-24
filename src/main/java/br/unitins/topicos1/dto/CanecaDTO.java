package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CanecaDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome, 
    String descricao, 
    float preco, 
    Long id_tamanho, 
    Integer capacidade, 
    Integer id_material, 
    Long id_fornecedor) { }
