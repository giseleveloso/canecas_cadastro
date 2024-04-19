package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.repository.FuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setCargo(dto.cargo());
        funcionario.setEndereco(dto.endereco());
        funcionario.setTelefone(dto.telefone());
        funcionario.setEmail(dto.email());


        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco =  funcionarioRepository.findById(id);
        
        funcionarioBanco.setNome(dto.nome());
        funcionarioBanco.setCargo(dto.cargo());
        funcionarioBanco.setEndereco(dto.endereco());
        funcionarioBanco.setTelefone(dto.telefone());
        funcionarioBanco.setEmail(dto.email());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository
        .listAll()
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome).stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();
    }

}