package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunitySourceLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunitySourceLookupRepository;
import org.com.sbm.cadence.service.OpportunitySourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunitySourceService")
public class OpportunitySourceServiceImpl extends CRUDServiceImpl<OpportunitySourceLookupRepository, OpportunitySourceLookupDTO> implements OpportunitySourceService {

	@Autowired
	private OpportunitySourceLookupRepository repository;

	@Override
	public OpportunitySourceLookupDTO update(OpportunitySourceLookupDTO newObject) throws ResourceNotFoundException {
		OpportunitySourceLookupDTO originalObject = repository.findById(newObject.getSourceId())
				.orElseThrow(() -> new ResourceNotFoundException("source not found !!! "));
		
		originalObject.setSource(newObject.getSource());

		final  OpportunitySourceLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
