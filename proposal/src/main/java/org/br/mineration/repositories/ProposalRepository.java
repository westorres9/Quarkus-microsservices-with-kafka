package org.br.mineration.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineration.entities.Proposal;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
@ApplicationScoped
public class ProposalRepository implements PanacheRepository<Proposal> {

    public Optional<Proposal> findByCustomer(String customer) {
        return Optional.of(find("customer", customer).firstResult());
    }

}
