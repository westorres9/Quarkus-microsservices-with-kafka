package org.br.mineration.schedulers;

import io.quarkus.scheduler.Scheduled;
import org.br.mineration.services.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class QuotationScheduler {
    private  static  final Logger logger = LoggerFactory.getLogger(QuotationScheduler.class);

    @Inject
    private QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        logger.info("--- Executing schedule ---");
        quotationService.getCurrencyPrice();
    }
}
