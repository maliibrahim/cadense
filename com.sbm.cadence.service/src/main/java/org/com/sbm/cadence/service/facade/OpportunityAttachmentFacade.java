package org.com.sbm.cadence.service.facade;

import org.com.sbm.cadence.common.dto.OpportunityAttachmentDTO;
import org.com.sbm.cadence.service.OpportunityAttachmentService;
import org.com.sbm.cadence.service.implementation.OpportunityAttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityAttachmentFacade extends CRUDFacade<OpportunityAttachmentServiceImpl, OpportunityAttachmentDTO> {

	@Autowired
	private OpportunityAttachmentService OpportunityAttachmentService;
	
	
	
}
