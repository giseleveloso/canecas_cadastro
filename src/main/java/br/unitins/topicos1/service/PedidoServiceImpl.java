package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.Caneca;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Status;
import br.unitins.topicos1.repository.CanecaRepository;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.validation.ValidationError;
import br.unitins.topicos1.validation.ValidationException;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    CanecaRepository canecaRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));
        pedido.setTotal(0d);
        pedido.setFormaPagamento(Pagamento.valueOf(dto.idPagamento()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedidoDTO itemDTO : dto.itens()) {

            Caneca caneca = canecaRepository.findById(itemDTO.idCaneca());

            ItemPedido item = new ItemPedido();
           
            item.setDesconto(itemDTO.desconto());
            item.setQuantidade(itemDTO.quantidade());

            Double precoDesconto = Double.valueOf(caneca.getPreco() * item.getQuantidade())-((itemDTO.desconto()/100) * Double.valueOf(caneca.getPreco() * item.getQuantidade()));

            item.setPreco(precoDesconto);
            item.setCaneca(caneca);

            pedido.setTotal(pedido.getTotal() + item.getPreco());

            // trabalhar o estoque de cada produto
            if(itemDTO.quantidade() <= caneca.getEstoque()){
                // adicionando na lista
                itens.add(item);
                
                caneca.setEstoque(caneca.getEstoque() - itemDTO.quantidade());
                canecaRepository.persist(caneca);
            } else {
                throw new ValidationException("Pedido não finalizado", "Estoque insuficiente do produto: "+caneca.getNome());
            }
           
            
        }
        pedido.setItens(itens);
        pedido.setStatusPagamento(Status.NAO_PAGO);

        

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente)
                .stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

/*
    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }
*/

    @Override
    @Transactional
    public void switchStatus(Long id){
        Pedido pedido = pedidoRepository.findById(id);

        if(pedido != null){
            
            if(pedido.getStatusPagamento() == Status.PAGO){
                pedido.setStatusPagamento(Status.NAO_PAGO);
            } else if (pedido.getStatusPagamento() == Status.NAO_PAGO){
                pedido.setStatusPagamento(Status.PAGO);
            }

        } else {
            throw new BadRequestException("Pedido não encontrado");
        }

       
        
    }

}