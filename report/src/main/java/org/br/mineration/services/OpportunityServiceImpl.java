package org.br.mineration.services;

import org.br.mineration.dto.OpportunityDTO;
import org.br.mineration.dto.ProposalDTO;
import org.br.mineration.dto.QuotationDTO;
import org.br.mineration.entities.Opportunity;
import org.br.mineration.entities.Quotation;
import org.br.mineration.repositories.OpportunityRepository;
import org.br.mineration.repositories.QuotationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService {

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    OpportunityRepository opportunityRepository;


    @Override
    @Transactional
    public void buildOpportunity(ProposalDTO proposal) {
        List<Quotation> quotations = quotationRepository.findAll().list();
        Collections.reverse(quotations);

        Opportunity opportunity = new Opportunity();
        opportunity.setDate(new Date());
        opportunity.setProposalId(proposal.getProposalId());
        opportunity.setCustomer(proposal.getCustomer());
        opportunity.setPriceTonne(proposal.getPriceTonne());
        opportunity.setLastDollarQuotation(quotations.get(0).getCurrencyPrice());

        opportunityRepository.persist(opportunity);
    }

    @Override
    @Transactional
    public void saveQuotation(QuotationDTO quotation) {
        Quotation createQuotation = new Quotation();
        createQuotation.setDate(new Date());
        createQuotation.setCurrencyPrice(quotation.getCurrencyPrice());

        quotationRepository.persist(createQuotation);
    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {

        List<OpportunityDTO> opportunities = new ArrayList<>();

        opportunityRepository
                .findAll()
                .stream()
                .forEach(item -> {
                    opportunities.add(new OpportunityDTO(item));
                });

        return opportunities;
    }

}
