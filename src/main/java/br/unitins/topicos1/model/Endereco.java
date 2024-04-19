package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Endereco extends DefaultEntity {
    private Integer cep;
    private String rua;
    private Integer numero;

    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
}
