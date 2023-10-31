package org.br.mineration.message;

import org.br.mineration.dto.ProposalDTO;
import org.br.mineration.entities.Proposal;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvent {
    private static final Logger logger = LoggerFactory.getLogger(KafkaEvent.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalRequestEmitter;

    public void sendKafkaEvent(ProposalDTO proposalDTO) {
        logger.info("--- sending new proposal to kafka topic ---");
        proposalRequestEmitter.send(proposalDTO).toCompletableFuture().join();
    }
}
