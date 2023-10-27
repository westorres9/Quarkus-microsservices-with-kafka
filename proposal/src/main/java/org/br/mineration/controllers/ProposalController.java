package org.br.mineration.controllers;

import org.br.mineration.dto.ProposalDetailsDTO;
import org.br.mineration.services.ProposalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/proposal")
public class ProposalController {
    private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    ProposalServiceImpl proposalService;

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") long id) {
        ProposalDetailsDTO dto = proposalService.findFullProposal(id);
        return dto;
    }

    @POST
    public Response createProposal(ProposalDetailsDTO proposalDetailsDTO) {
        logger.info("receiving a new proposal");
        try {
            proposalService.createNewProposal(proposalDetailsDTO);
            return Response.ok().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") long id) {
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
