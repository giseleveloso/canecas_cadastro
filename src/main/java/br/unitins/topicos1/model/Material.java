package br.unitins.topicos1.model;


import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum Material {
    PORCELANA(1, "Porcelana"),
    POLIMERO(2, "Polímero"),
    VIDRO_COMUM(3, "Vidro comum"),
    VIDRO_JATEADO(4, "Vidro jateado");

    private Integer id;
    private String nome;

    Material(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Material valueOf(Integer id) throws IllegalArgumentException {
        for (Material material : Material.values()) {
            if (material.id == id)
                return material;
        }
        throw new IllegalArgumentException("id material inválido.");
    }

}
