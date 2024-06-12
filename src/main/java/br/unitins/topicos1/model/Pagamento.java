package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Pagamento {
    PIX(1, "Pix"),
    BOLETO(2, "Boleto");

    private int id;
    private String descricao;

    Pagamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Pagamento valueOf(Integer id) throws IllegalArgumentException {
        for (Pagamento pagamento : Pagamento.values()) {
            if (pagamento.id == id)
                return pagamento;
        }
        throw new IllegalArgumentException("id pagamento inválido.");
    }

}