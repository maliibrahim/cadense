package org.com.sbm.cadence.service.facade;

import org.com.sbm.cadence.common.dto.OpportunityOrderDTO;
import org.com.sbm.cadence.service.OpportunityOrderService;
import org.com.sbm.cadence.service.implementation.OpportunityOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityOrderFacade extends CRUDFacade<OpportunityOrderServiceImpl, OpportunityOrderDTO> {

	@Autowired
	private OpportunityOrderService OpportunityOrderService;
	
	
	
}
