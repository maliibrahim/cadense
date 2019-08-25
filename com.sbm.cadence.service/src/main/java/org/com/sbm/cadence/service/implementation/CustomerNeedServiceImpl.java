package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityCustomerNeedLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityCustomerNeedLookupRepository;
import org.com.sbm.cadence.service.CustomerNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "CustomerNeedService")
public class CustomerNeedServiceImpl extends CRUDServiceImpl<OpportunityCustomerNeedLookupRepository, OpportunityCustomerNeedLookupDTO> implements CustomerNeedService {

	@Autowired
	private OpportunityCustomerNeedLookupRepository repository;

	@Override
	public OpportunityCustomerNeedLookupDTO update(OpportunityCustomerNeedLookupDTO newObject) throws ResourceNotFoundException {
		OpportunityCustomerNeedLookupDTO originalObject = repository.findById(newObject.getId())
				.orElseThrow(() -> new ResourceNotFoundException("customer need item not found in OpportunityCustomerNeedLookup table!!! "));
		
		originalObject.setCustomerNeed(newObject.getCustomerNeed());

		final  OpportunityCustomerNeedLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
