package org.br.mineration.service;

import org.br.mineration.client.ProposalRestClient;
import org.br.mineration.dto.ProposalDetailsDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    @RestClient
    ProposalRestClient proposalRestClient;

    @Override
    public ProposalDetailsDTO getProposalDetailsById(long id) {
       return proposalRestClient.getProposalDetailsById(id);
    }

    @Override
    public Response createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {
        return proposalRestClient.createProposal(proposalDetailsDTO);
    }

    @Override
    public Response removeProposal(long id) {
        return proposalRestClient.removeProposal(id);
    }
}
