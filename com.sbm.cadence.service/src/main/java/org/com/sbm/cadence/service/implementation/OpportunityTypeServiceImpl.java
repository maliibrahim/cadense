package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityTypeLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityTypeLookupRepository;
import org.com.sbm.cadence.service.OpportunityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunityTypeService")
public class OpportunityTypeServiceImpl extends CRUDServiceImpl<OpportunityTypeLookupRepository, OpportunityTypeLookupDTO> implements OpportunityTypeService {

	@Autowired
	private OpportunityTypeLookupRepository repository;

	@Override
	public OpportunityTypeLookupDTO update(OpportunityTypeLookupDTO newObject) throws ResourceNotFoundException {
		OpportunityTypeLookupDTO originalObject = repository.findById(newObject.getTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("type not found !!! "));
		
		originalObject.setType(newObject.getType());

		final  OpportunityTypeLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
