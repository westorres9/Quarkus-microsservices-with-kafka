package org.br.mineration.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private BigDecimal currencyPrice;
    private String pctChange;
    private String Pair;

    public Quotation() {
    }

    public Quotation(Long id, Date date, BigDecimal currencyPrice, String pctChange, String pair) {
        this.id = id;
        this.date = date;
        this.currencyPrice = currencyPrice;
        this.pctChange = pctChange;
        Pair = pair;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public String getPair() {
        return Pair;
    }

    public void setPair(String pair) {
        Pair = pair;
    }
}
