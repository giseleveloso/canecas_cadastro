package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Tamanho extends DefaultEntity {
    private Float largura;
    private Float comprimento;
    private Float profundidade;

    public Float getLargura() {
        return largura;
    }
    public void setLargura(Float largura) {
        this.largura = largura;
    }
    public Float getComprimento() {
        return comprimento;
    }
    public void setComprimento(Float comprimento) {
        this.comprimento = comprimento;
    }
    public Float getProfundidade() {
        return profundidade;
    }
    public void setProfundidade(Float profundidade) {
        this.profundidade = profundidade;
    }

    
}
