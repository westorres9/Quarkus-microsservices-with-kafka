package org.br.mineration.dto;

import org.br.mineration.entities.Quotation;

import java.math.BigDecimal;
import java.util.Date;

public class QuotationDTO {

    private Date date;
    private BigDecimal currencyPrice;

    public QuotationDTO() {
    }

    public QuotationDTO(Date date, BigDecimal currencyPrice) {
        this.date = date;
        this.currencyPrice = currencyPrice;
    }

    public QuotationDTO(Quotation quotation) {
        this.date = quotation.getDate();
        this.currencyPrice = quotation.getCurrencyPrice();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(BigDecimal currencyPrice) {
        this.currencyPrice = currencyPrice;
    }
}
