package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TamanhoDTO;
import br.unitins.topicos1.dto.TamanhoResponseDTO;
import br.unitins.topicos1.model.Tamanho;
import br.unitins.topicos1.repository.TamanhoRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class TamanhoServiceImpl implements TamanhoService {

    @Inject
    public TamanhoRepository tamanhoRepository;

    @Override
    @Transactional
    public TamanhoResponseDTO create(@Valid TamanhoDTO dto) {
        validarLarguraTamanho(dto.largura());

        Tamanho tamanho = new Tamanho();
        tamanho.setLargura(dto.largura());
        tamanho.setComprimento(dto.comprimento());
        tamanho.setProfundidade(dto.profundidade());


        tamanhoRepository.persist(tamanho);
        return TamanhoResponseDTO.valueOf(tamanho);
    }

    public void validarLarguraTamanho(float largura) {
        Tamanho tamanho = tamanhoRepository.findByLargura(largura);
        if (tamanho != null)
            throw  new ValidationException("largura", "A largura '"+largura+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, TamanhoDTO dto) {
        Tamanho tamanhoBanco =  tamanhoRepository.findById(id);
        
        tamanhoBanco.setLargura(dto.largura());
        tamanhoBanco.setComprimento(dto.comprimento());
        tamanhoBanco.setProfundidade(dto.profundidade());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        tamanhoRepository.deleteById(id);
    }

    @Override
    public TamanhoResponseDTO findById(Long id) {
        return TamanhoResponseDTO.valueOf(tamanhoRepository.findById(id));
    }

    @Override
    public List<TamanhoResponseDTO> findAll() {
        return tamanhoRepository
        .listAll()
        .stream()
        .map(e -> TamanhoResponseDTO.valueOf(e)).toList();
    }


}
