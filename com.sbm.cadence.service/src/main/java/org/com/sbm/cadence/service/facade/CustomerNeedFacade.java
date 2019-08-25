package org.com.sbm.cadence.service.facade;

import org.com.sbm.cadence.common.dto.OpportunityCustomerNeedLookupDTO;
import org.com.sbm.cadence.service.CustomerNeedService;
import org.com.sbm.cadence.service.implementation.CustomerNeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerNeedFacade extends CRUDFacade<CustomerNeedServiceImpl, OpportunityCustomerNeedLookupDTO> {

	@Autowired
	private CustomerNeedService CustomerNeedService;
	
	
	
}
