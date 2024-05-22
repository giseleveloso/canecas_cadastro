package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AuthUsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO, UsuarioResponseDTO dto);
}