package org.br.mineration.services;

import org.br.mineration.dto.OpportunityDTO;
import org.br.mineration.dto.ProposalDTO;
import org.br.mineration.dto.QuotationDTO;

import javax.enterprise.context.ApplicationScoped;
import java.io.ByteArrayInputStream;
import java.util.List;

@ApplicationScoped
public interface OpportunityService {

    void buildOpportunity(ProposalDTO proposal);

    void saveQuotation(QuotationDTO quotation);

    List<OpportunityDTO> generateOpportunityData();

}
