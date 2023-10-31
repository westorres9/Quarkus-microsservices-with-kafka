package org.br.mineration.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineration.entities.Opportunity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpportunityRepository implements PanacheRepository<Opportunity> {
}
