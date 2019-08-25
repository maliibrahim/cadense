package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunitySectorLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunitySectorLookupRepository;
import org.com.sbm.cadence.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "SectorService")
public class SectorServiceImpl extends CRUDServiceImpl<OpportunitySectorLookupRepository, OpportunitySectorLookupDTO> implements SectorService {

	@Autowired
	private OpportunitySectorLookupRepository repository;

	@Override
	public OpportunitySectorLookupDTO update(OpportunitySectorLookupDTO newObject) throws ResourceNotFoundException {
		OpportunitySectorLookupDTO originalObject = repository.findById(newObject.getSectorId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setSector(newObject.getSector());

		final  OpportunitySectorLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
