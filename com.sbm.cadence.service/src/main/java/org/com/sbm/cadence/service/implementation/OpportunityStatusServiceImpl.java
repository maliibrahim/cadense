package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityStatusLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityStatusLookupRepository;
import org.com.sbm.cadence.service.OpportunityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunityStatusService")
public class OpportunityStatusServiceImpl extends CRUDServiceImpl<OpportunityStatusLookupRepository, OpportunityStatusLookupDTO> implements OpportunityStatusService {

	@Autowired
	private OpportunityStatusLookupRepository repository;

	@Override
	public OpportunityStatusLookupDTO update(OpportunityStatusLookupDTO newObject) throws ResourceNotFoundException {
		OpportunityStatusLookupDTO originalObject = repository.findById(newObject.getStatusId())
				.orElseThrow(() -> new ResourceNotFoundException("Status not found !!! "));
		
		originalObject.setStatus(newObject.getStatus());

		final  OpportunityStatusLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
