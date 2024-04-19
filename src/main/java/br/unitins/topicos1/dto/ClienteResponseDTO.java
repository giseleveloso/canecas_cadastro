package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Telefone;

public record ClienteResponseDTO
    (Long id, String nome, Endereco endereco, Telefone telefone, String email) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO( 
            cliente.getId(),
            cliente.getNome(),
            cliente.getEndereco(),
            cliente.getTelefone(),
            cliente.getEmail());
            //EstadoResponseDTO.valueOf(cidade.getEstado()));
    }
    
}
