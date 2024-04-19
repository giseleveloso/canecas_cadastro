package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Tamanho;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CanecaDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome, 
    String descricao, 
    float preco, 
    Tamanho tamanho, 
    Integer capacidade, 
    Integer id_material, 
    Fornecedor fornecedor) { }
