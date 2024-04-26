package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Tamanho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TamanhoRepository implements PanacheRepository<Tamanho> {
    
    public Tamanho findByLargura(float largura) {
        return find("largura = ?1", largura).firstResult();
    }
}
