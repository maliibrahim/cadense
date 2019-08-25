package org.com.sbm.cadence.service.facade;

import org.com.sbm.cadence.common.dto.OpportunityDTO;
import org.com.sbm.cadence.service.OpportunityService;
import org.com.sbm.cadence.service.implementation.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityFacade extends CRUDFacade<OpportunityServiceImpl, OpportunityDTO> {

	@Autowired
	private OpportunityService opportunitySerivce;
	
	
	
}
