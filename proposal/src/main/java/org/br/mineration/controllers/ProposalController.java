package org.br.mineration.controllers;

import io.quarkus.security.Authenticated;
import org.br.mineration.dto.ProposalDetailsDTO;
import org.br.mineration.services.ProposalServiceImpl;


import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/proposal")
@Authenticated
public class ProposalController {
    private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    ProposalServiceImpl proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"manager", "user"})
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") long id) {
        ProposalDetailsDTO dto = proposalService.findFullProposal(id);
        return dto;
    }

    @POST
    @RolesAllowed("proposal-customer")
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
