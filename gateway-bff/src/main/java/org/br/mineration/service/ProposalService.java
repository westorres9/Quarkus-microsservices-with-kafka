package org.br.mineration.service;

import org.br.mineration.dto.ProposalDetailsDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO getProposalDetailsById(@PathParam("id") long id);

    Response createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    Response removeProposal(long id);
}
