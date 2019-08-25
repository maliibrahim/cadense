package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityAttachmentDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityAttachmentRepository;
import org.com.sbm.cadence.service.OpportunityAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunityAttachementService")
public class OpportunityAttachmentServiceImpl extends CRUDServiceImpl<OpportunityAttachmentRepository, OpportunityAttachmentDTO> implements OpportunityAttachmentService {

	@Autowired
	private OpportunityAttachmentRepository repository;

	@Override
	public OpportunityAttachmentDTO update(OpportunityAttachmentDTO newObject) throws ResourceNotFoundException {
		OpportunityAttachmentDTO originalObject = repository.findById(newObject.getAttachmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Attachment not found !!! "));
		
		originalObject.setAttachmentName(newObject.getAttachmentName());
		originalObject.setContent(newObject.getContent());
		originalObject.setContentType(newObject.getContentType());
		originalObject.setCreated(newObject.getCreated());
		originalObject.setOpportunityAttachmet(newObject.getOpportunityAttachmet());

		final  OpportunityAttachmentDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
