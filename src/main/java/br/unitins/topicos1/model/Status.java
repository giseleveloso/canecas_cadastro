package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
    PAGO(1, "Pago"),
    NAO_PAGO(2, "Não pago");

    private int id;
    private String nome;

    Status(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Status valueOf(Integer id) throws IllegalArgumentException {
        for (Status status : Status.values()) {
            if (status.id == id)
                return status;
        }
        throw new IllegalArgumentException("id status inválido.");
    }

}