package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.Material;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MaterialConverter implements AttributeConverter<Material, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Material material) {
       return material.getId();
    }

    @Override
    public Material convertToEntityAttribute(Integer id) {
        return Material.valueOf(id);
    }

    
}