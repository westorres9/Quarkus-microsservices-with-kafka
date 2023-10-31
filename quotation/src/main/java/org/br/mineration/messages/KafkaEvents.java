package org.br.mineration.messages;

import org.br.mineration.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {
    private static final Logger logger = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("quotation")
    Emitter<QuotationDTO> quotationRequestEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotation) {
        logger.info("--- Send quotation to Kafka Topic ---");
        quotationRequestEmitter.send(quotation).toCompletableFuture().join();
    }

}
