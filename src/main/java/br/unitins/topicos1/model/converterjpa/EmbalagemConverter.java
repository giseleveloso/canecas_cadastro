package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.Embalagem;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmbalagemConverter implements AttributeConverter<Embalagem, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Embalagem embalagem) {
       return embalagem.getId();
    }

    @Override
    public Embalagem convertToEntityAttribute(Integer id) {
        return Embalagem.valueOf(id);
    }

    
}