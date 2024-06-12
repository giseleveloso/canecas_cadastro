package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CanecaDTO;
import br.unitins.topicos1.dto.CanecaResponseDTO;
import br.unitins.topicos1.model.Caneca;
import br.unitins.topicos1.model.Material;
import br.unitins.topicos1.repository.CanecaRepository;
import br.unitins.topicos1.repository.FornecedorRepository;
import br.unitins.topicos1.repository.TamanhoRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CanecaServiceImpl implements CanecaService {

    @Inject
    public CanecaRepository canecaRepository;
    @Inject
    public TamanhoRepository tamanhoRepository;
    @Inject
    public FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public CanecaResponseDTO create(@Valid CanecaDTO dto) {
        validarNomeCaneca(dto.nome());

        Caneca caneca = new Caneca();
        caneca.setNome(dto.nome());
        caneca.setDescricao(dto.descricao());
        caneca.setPreco(dto.preco());
        caneca.setTamanho(tamanhoRepository.findById(dto.id_tamanho()));
        caneca.setCapacidade(dto.capacidade());
        caneca.setMaterial(Material.valueOf(dto.id_material()));
        caneca.setFornecedor(fornecedorRepository.findById(dto.id_fornecedor()));
        caneca.setEstoque(dto.estoque());

        canecaRepository.persist(caneca);
        return CanecaResponseDTO.valueOf(caneca);
    }

    public void validarNomeCaneca(String nome) {
        Caneca caneca = canecaRepository.findByNomeCompleto(nome);
        if (caneca != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, CanecaDTO dto) {
        Caneca canecaBanco =  canecaRepository.findById(id);
        
        canecaBanco.setNome(dto.nome());
        canecaBanco.setDescricao(dto.descricao());
        canecaBanco.setPreco(dto.preco());
        canecaBanco.setTamanho(tamanhoRepository.findById(dto.id_tamanho()));
        canecaBanco.setCapacidade(dto.capacidade());
        canecaBanco.setMaterial(Material.valueOf(dto.id_material()));
        canecaBanco.setFornecedor(fornecedorRepository.findById(dto.id_fornecedor()));
        canecaBanco.setEstoque(dto.estoque());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        canecaRepository.deleteById(id);
    }

    @Override
    public CanecaResponseDTO findById(Long id) {
        return CanecaResponseDTO.valueOf(canecaRepository.findById(id));
    }

    @Override
    public List<CanecaResponseDTO> findAll() {
        return canecaRepository
        .listAll()
        .stream()
        .map(e -> CanecaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CanecaResponseDTO> findByNome(String nome) {
        return canecaRepository.findByNome(nome).stream()
        .map(e -> CanecaResponseDTO.valueOf(e)).toList();
    }

}
