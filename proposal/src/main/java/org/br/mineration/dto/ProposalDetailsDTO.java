package org.br.mineration.dto;

import org.br.mineration.entities.Proposal;

import java.math.BigDecimal;

public class ProposalDetailsDTO {

    private Long proposalId;
    private String customer;
    private BigDecimal priceTonne;
    private Integer tonnes;
    private String country;
    private Integer proposalValidityDays;

    public ProposalDetailsDTO() {
    }

    public ProposalDetailsDTO(Long proposalId, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes= tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
    }

    public ProposalDetailsDTO(Proposal proposal) {
        this.proposalId = proposal.getId();
        this.customer = proposal.getCustomer();
        this.priceTonne = proposal.getPriceTonne();
        this.tonnes = proposal.getTonnes();
        this.country = proposal.getCountry();
        this.proposalValidityDays = proposal.getProposalValidityDays();
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
}
