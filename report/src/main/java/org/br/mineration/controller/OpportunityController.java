package org.br.mineration.controller;

import io.quarkus.security.Authenticated;
import org.br.mineration.dto.OpportunityDTO;
import org.br.mineration.services.OpportunityService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Path("/opportunity")
@Authenticated
public class OpportunityController {

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OpportunityDTO> generateReport() {
        List<OpportunityDTO> list = opportunityService.generateOpportunityData();
        return  list;
    }
}
