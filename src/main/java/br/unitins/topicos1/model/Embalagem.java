package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;



@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum Embalagem {
    KRAFT(1, "Kraft"),
    BRANCA(2, "Branca");

    private int id;
    private String nome;

    Embalagem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Embalagem valueOf(Integer id) throws IllegalArgumentException {
        for (Embalagem embalagem : Embalagem.values()) {
            if (embalagem.id == id)
                return embalagem;
        }
        throw new IllegalArgumentException("id embalagem inválido.");
    }

}
