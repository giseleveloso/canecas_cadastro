package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

    public Telefone findByNumero(String numero) {
        return find("numero = ?1",  numero).firstResult();
    }
    
}
