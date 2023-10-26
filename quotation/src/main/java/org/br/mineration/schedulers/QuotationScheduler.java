package org.br.mineration.schedulers;

import io.quarkus.scheduler.Scheduled;
import org.br.mineration.services.QuotationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class QuotationScheduler {

    @Inject
    private QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35", identity = "task-job")
    private void schedule() {
        quotationService.getCurrencyPrice();
    }
}
