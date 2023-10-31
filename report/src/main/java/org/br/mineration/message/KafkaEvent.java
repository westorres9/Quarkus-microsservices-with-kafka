package org.br.mineration.message;

import io.smallrye.reactive.messaging.annotations.Blocking;
import org.br.mineration.dto.ProposalDTO;
import org.br.mineration.dto.QuotationDTO;
import org.br.mineration.services.OpportunityService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

public class KafkaEvent {
    private static final Logger logger = LoggerFactory.getLogger(KafkaEvent.class);

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    @Transactional
    public void receiveProposal(ProposalDTO proposal) {
        logger.info("--- Receiving a new proposal of Kafka Topic ---");
        opportunityService.buildOpportunity(proposal);
    }

    @Incoming("quotation")
    @Blocking
    public void receiveQuotation(QuotationDTO quotation) {
        logger.info("--- Receiving a new Currency Quotation of Kafka Topic ---");
        opportunityService.saveQuotation(quotation);
    }
}
