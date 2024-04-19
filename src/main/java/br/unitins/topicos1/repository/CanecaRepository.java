package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Caneca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CanecaRepository implements PanacheRepository<Caneca> {

    public List<Caneca> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

    public Caneca findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
    
}
