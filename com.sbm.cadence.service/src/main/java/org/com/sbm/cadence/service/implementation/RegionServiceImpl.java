package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityRegionLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityRegionLookupRepository;
import org.com.sbm.cadence.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "RegionService")
public class RegionServiceImpl extends CRUDServiceImpl<OpportunityRegionLookupRepository, OpportunityRegionLookupDTO> implements RegionService {

	@Autowired
	private OpportunityRegionLookupRepository repository;

	@Override
	public OpportunityRegionLookupDTO update(OpportunityRegionLookupDTO newObject) throws ResourceNotFoundException {
		OpportunityRegionLookupDTO originalObject = repository.findById(newObject.getRegionId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setRegion(newObject.getRegion());

		final  OpportunityRegionLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
