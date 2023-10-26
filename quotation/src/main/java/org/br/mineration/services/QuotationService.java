package org.br.mineration.services;

import org.br.mineration.clients.CurrencyPriceClient;
import org.br.mineration.dto.CurrencyPriceDTO;
import org.br.mineration.dto.QuotationDTO;
import org.br.mineration.entities.Quotation;
import org.br.mineration.messages.KafkaEvents;
import org.br.mineration.repositories.QuotationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@ApplicationScoped
public class QuotationService {

    @Inject
    @RestClient
    private CurrencyPriceClient currencyPriceClient;

    @Inject
    private QuotationRepository quotationRepository;

    @Inject
    private KafkaEvents kafkaEvents;

    public void getCurrencyPrice() {
        CurrencyPriceDTO currencyPriceInfo = currencyPriceClient.getPricePair("USD-BRL");

        if(updateCurrencyInfoPrice(currencyPriceInfo)){
            QuotationDTO quotationDTO = new QuotationDTO();
            quotationDTO.setCurrencyPrice(new BigDecimal(currencyPriceInfo.getUSDBRL().getBid()));
            quotationDTO.setDate(new Date());
            kafkaEvents.sendNewKafkaEvent(quotationDTO);
        }
    }

    private boolean updateCurrencyInfoPrice(CurrencyPriceDTO currencyPriceInfo) {

        BigDecimal currentPrice = new BigDecimal(currencyPriceInfo.getUSDBRL().getBid());
        boolean updatePrice = false;

        List<Quotation> list = quotationRepository.findAll().list();

        if(list.isEmpty()) {
            saveQuotation(currencyPriceInfo);
            updatePrice = true;
        }
        else {
            Quotation lastDollarPrice = list.get(list.size()-1);

            if(currentPrice.floatValue() > lastDollarPrice.getCurrencyPrice().floatValue()) {
                updatePrice = true;
                saveQuotation(currencyPriceInfo);
            }
        }
        return updatePrice;
    }

    private void saveQuotation(CurrencyPriceDTO currencyPriceInfo) {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setCurrencyPrice(new BigDecimal(currencyPriceInfo.getUSDBRL().getBid()));
        quotation.setPctChange(currencyPriceInfo.getUSDBRL().getPctChange());
        quotation.setPair("USD-BRL");

        quotationRepository.persist(quotation);
    }
}
