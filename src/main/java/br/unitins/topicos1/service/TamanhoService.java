package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TamanhoDTO;
import br.unitins.topicos1.dto.TamanhoResponseDTO;
import jakarta.validation.Valid;

public interface TamanhoService {

    public TamanhoResponseDTO create(@Valid TamanhoDTO dto);

    public void update(Long id, TamanhoDTO dto);

    public void delete(Long id);

    public TamanhoResponseDTO findById(Long id);

    public List<TamanhoResponseDTO> findAll();

}
