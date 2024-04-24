package br.unitins.topicos1.dto;

public record FuncionarioDTO (
    String nome,
    String cargo, 
    Long id_endereco, 
    Long id_telefone, 
    String email) { }
