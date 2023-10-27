package org.br.mineration.dto;

import org.br.mineration.entities.Proposal;

import java.math.BigDecimal;

public class ProposalDTO {

    private Long proposalId;
    private String customer;
    private BigDecimal priceTonne;

    public ProposalDTO() {
    }

    public ProposalDTO(Long proposalId, String customer, BigDecimal priceTonne) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
    }

    public ProposalDTO(Proposal proposal) {
        this.proposalId = proposal.getId();
        this.customer = proposal.getCustomer();
        this.priceTonne = proposal.getPriceTonne();
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
}
