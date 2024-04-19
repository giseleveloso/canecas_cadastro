package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CanecaDTO;
import br.unitins.topicos1.dto.CanecaResponseDTO;
import jakarta.validation.Valid;

public interface CanecaService {

    public CanecaResponseDTO create(@Valid CanecaDTO dto);

    public void update(Long id, CanecaDTO dto);

    public void delete(Long id);

    public CanecaResponseDTO findById(Long id);

    public List<CanecaResponseDTO> findAll();

    public List<CanecaResponseDTO> findByNome(String nome);
}
