package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import jakarta.validation.Valid;

public interface EnderecoService {

    public EnderecoResponseDTO create(@Valid EnderecoDTO dto);

    public void update(Long id, EnderecoDTO dto);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findAll();

}
