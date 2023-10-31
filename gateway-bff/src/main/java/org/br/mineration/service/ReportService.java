package org.br.mineration.service;

import org.br.mineration.dto.OpportunityDTO;

import javax.enterprise.context.ApplicationScoped;
import java.io.ByteArrayInputStream;
import java.util.List;

@ApplicationScoped
public interface ReportService {

    ByteArrayInputStream generateCSVOpportunityReport();

    List<OpportunityDTO> getOpportunitiesData();
}
