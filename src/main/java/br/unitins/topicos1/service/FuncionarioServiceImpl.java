package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.repository.FuncionarioRepository;
import br.unitins.topicos1.repository.TelefoneRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;
    @Inject
    public EnderecoRepository enderecoRepository;
    @Inject
    public TelefoneRepository telefoneRepository;
    @Inject
    public UsuarioRepository usuarioRepository;
    @Inject
    public HashService hashService;


    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));

        // salvando o usuario
        usuarioRepository.persist(usuario);

        validarNomeFuncionario(dto.nome());
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setCargo(dto.cargo());
        funcionario.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        funcionario.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        funcionario.setEmail(dto.email());
        funcionario.setUsuario(usuario);


        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarNomeFuncionario(String nome) {
        Funcionario funcionario = funcionarioRepository.findByNomeCompleto(nome);
        if (funcionario != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }


    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        // Funcionario funcionarioBanco =  funcionarioRepository.findById(id);
        
        // funcionarioBanco.setNome(dto.nome());
        // funcionarioBanco.setCargo(dto.cargo());
        // funcionarioBanco.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        // funcionarioBanco.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        // funcionarioBanco.setEmail(dto.email());

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


    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(funcionario);
    }


}
