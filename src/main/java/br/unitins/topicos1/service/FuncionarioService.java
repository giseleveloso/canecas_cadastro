package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.UpdatePasswordDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {

    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);

    public void update(Long id, FuncionarioDTO dto);

    public void updatePassword(Long id, UpdatePasswordDTO dto);

    public void updateUsername(Long id, UpdateUsernameDTO dto);

    public void delete(Long id);

    public FuncionarioResponseDTO findById(Long id);

    public List<FuncionarioResponseDTO> findAll();

    public List<FuncionarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO login(String username, String senha);
}
