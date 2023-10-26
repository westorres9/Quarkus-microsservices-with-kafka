package org.br.mineration.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineration.entities.Quotation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository implements PanacheRepository<Quotation> {

}
