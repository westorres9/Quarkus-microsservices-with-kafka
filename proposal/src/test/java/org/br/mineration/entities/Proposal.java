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
    private BigDecimal priceTonne;
    private Integer tonnes;
    private String country;
    private Integer proposalValidityDays;
    private Date created_at;

    public Proposal() {
    }

    public Proposal(Long id, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays, Date created_at) {
        this.id = id;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
        this.created_at = created_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = new Date();
    }
}
