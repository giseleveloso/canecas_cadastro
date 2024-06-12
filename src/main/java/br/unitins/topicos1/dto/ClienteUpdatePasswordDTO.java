package br.unitins.topicos1.dto;

public record ClienteUpdatePasswordDTO(
    String oldPassword,
    String newPassword
) {
    
}
