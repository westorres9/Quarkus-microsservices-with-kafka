package org.br.mineration.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_opportunity")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Column(name = "proposal_id")
    private Long proposalId;
    private String customer;
    @Column(name = "price_tonne")
    private BigDecimal priceTonne;
    @Column(name = "last_dollar_quotation")
    private BigDecimal lastDollarQuotation;

    public Opportunity(){
    }

    public Opportunity(Long id, Date date, Long proposalId, String customer, BigDecimal priceTonne, BigDecimal lastDollarQuotation) {
        this.id = id;
        this.date = date;
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.lastDollarQuotation = lastDollarQuotation;
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

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public void setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
    }

    public BigDecimal getLastDollarQuotation() {
        return lastDollarQuotation;
    }

    public void setLastDollarQuotation(BigDecimal lastDollarQuotation) {
        this.lastDollarQuotation = lastDollarQuotation;
    }
}
