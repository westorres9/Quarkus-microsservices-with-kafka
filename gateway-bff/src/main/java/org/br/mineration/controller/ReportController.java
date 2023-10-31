package org.br.mineration.controller;

import org.br.mineration.service.ReportService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@ApplicationScoped
@Path("/opportunity")
public class ReportController {

    @Inject
    ReportService reportService;

    @GET
    @Path("/report")
    @RolesAllowed({"user", "manager"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport() {
        try {
             return Response.ok(reportService.generateCSVOpportunityReport(), MediaType.APPLICATION_OCTET_STREAM)
                     .header("content-disposition", "attachment; filename = " + new Date() + "sale-opportunities.csv").build();
        }
        catch (ServerErrorException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/data")
    @RolesAllowed({"user","manager"})
    public Response getOpportunitiesData() {
        try {
            return Response.ok(reportService.getOpportunitiesData(), MediaType.APPLICATION_JSON).build();
        }
        catch (ServerErrorException e) {
            return Response.serverError().build();
        }
    }
}
