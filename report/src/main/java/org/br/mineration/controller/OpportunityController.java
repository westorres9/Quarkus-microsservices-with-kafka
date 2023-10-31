package org.br.mineration.controller;

import org.br.mineration.dto.OpportunityDTO;
import org.br.mineration.services.OpportunityService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/opportunity")
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/data")
    public List<OpportunityDTO> generateReport(){
        return opportunityService.generateOpportunityData();
    }
}
