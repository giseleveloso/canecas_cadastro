package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Telefone;

public record FornecedorDTO (String nome, Endereco endereco, Telefone telefone, String email) { }
