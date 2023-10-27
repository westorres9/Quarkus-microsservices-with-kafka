package org.br.mineration.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customer;
    @Column(name = "price_tonne")
    private BigDecimal priceTonne;
    private Integer tonnes;
    private String country;
    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;
    @Column(name = "created_at")
    private Date createdAt;

    public Proposal() {
    }

    public Proposal(Long id, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays, Date createdAt) {
        this.id = id;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTonnes() {
        return tonnes;
    }

    public void setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public void setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
