package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {
    private Double preco;
    private Integer quantidade;
    private Double desconto;

    @ManyToOne
    @JoinColumn(name="id_caneca")
    private Caneca caneca;

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Caneca getCaneca() {
        return caneca;
    }

    public void setCaneca(Caneca caneca) {
        this.caneca = caneca;
    }

    

    
}
