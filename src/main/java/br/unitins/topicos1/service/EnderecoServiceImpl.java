package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    public EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public EnderecoResponseDTO create(@Valid EnderecoDTO dto) {
        validarCEPEndereco(dto.cep());

        Endereco endereco = new Endereco();
        endereco.setCep(dto.cep());
        endereco.setNumero(dto.numero());
        endereco.setRua(dto.rua());


        enderecoRepository.persist(endereco);
        return EnderecoResponseDTO.valueOf(endereco);
    }

    public void validarCEPEndereco(Integer cep) {
        Endereco endereco = enderecoRepository.findByCEP(cep);
        if (endereco != null)
            throw  new ValidationException("cep", "O CEP '"+cep+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EnderecoDTO dto) {
        Endereco enderecoBanco =  enderecoRepository.findById(id);
        
        enderecoBanco.setCep(dto.cep());
        enderecoBanco.setNumero(dto.numero());
        enderecoBanco.setRua(dto.rua());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(enderecoRepository.findById(id));
    }

    @Override
    public List<EnderecoResponseDTO> findAll() {
        return enderecoRepository
        .listAll()
        .stream()
        .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

}
