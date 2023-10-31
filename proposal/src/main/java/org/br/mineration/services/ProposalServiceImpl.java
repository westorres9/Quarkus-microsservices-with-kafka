package org.br.mineration.services;

import org.br.mineration.dto.ProposalDTO;
import org.br.mineration.dto.ProposalDetailsDTO;
import org.br.mineration.entities.Proposal;
import org.br.mineration.message.KafkaEvent;
import org.br.mineration.repositories.ProposalRepository;
import org.br.mineration.services.exceptions.ResourceNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaEvent;

    @Override
    public ProposalDetailsDTO findFullProposal(long id) {
        try {
            Proposal proposal = proposalRepository.findById(id);
            return  new ProposalDetailsDTO(proposal);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("proposal not found");
        }
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO dto) {
        try {
            Proposal proposal = new Proposal();
            proposal.setId(dto.getProposalId());
            proposal.setCustomer(dto.getCustomer());
            proposal.setPriceTonne(new BigDecimal(dto.getPriceTonne().toString()));
            proposal.setTonnes(dto.getTonnes());
            proposal.setProposalValidityDays(dto.getProposalValidityDays());
            proposal.setCountry(dto.getCountry());
            proposal.setCreatedAt(new Date());
            proposalRepository.persist(proposal);
            kafkaEvent.sendKafkaEvent(new ProposalDTO(proposal));
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    @Transactional
    public void removeProposal(long id) {
        try {
            proposalRepository.deleteById(id);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Proposal not found: " + id);
        }
    }

    private void copyDtoToEntity(Proposal proposal, ProposalDetailsDTO dto) {
        proposal.setId(dto.getProposalId());
        proposal.setCustomer(dto.getCustomer());
        proposal.setPriceTonne(new BigDecimal(dto.getPriceTonne().toString()));
        proposal.setTonnes(dto.getTonnes());
        proposal.setProposalValidityDays(dto.getProposalValidityDays());
        proposal.setCountry(dto.getCountry());
        proposal.setCreatedAt(new Date());
    }
}
