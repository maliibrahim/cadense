package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityOrderDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityOrderRepository;
import org.com.sbm.cadence.service.OpportunityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunityOrderService")
public class OpportunityOrderServiceImpl extends CRUDServiceImpl<OpportunityOrderRepository, OpportunityOrderDTO> implements OpportunityOrderService {

	@Autowired
	private OpportunityOrderRepository repository;

	@Override
	public OpportunityOrderDTO update(OpportunityOrderDTO newObject) throws ResourceNotFoundException {
		OpportunityOrderDTO originalObject = repository.findById(newObject.getOrderId())
				.orElseThrow(() -> new ResourceNotFoundException("order not found !!! "));
		
		originalObject.setOpportunity(newObject.getOpportunity());
		originalObject.setOpportunityProduct(newObject.getOpportunityProduct());
		originalObject.setOrderPrice(newObject.getOrderPrice());
		originalObject.setStgServiceName(newObject.getStgServiceName());
		originalObject.setStgServiceValue(newObject.getStgServiceValue());
		originalObject.setSwgServiceAssetId(newObject.getSwgServiceAssetId());
		originalObject.setSwgServiceAssetIncluded(newObject.isSwgServiceAssetIncluded());
		originalObject.setSwgServiceAssetName(newObject.getSwgServiceAssetName());
		originalObject.setSwgServiceAssetVersion(newObject.getSwgServiceAssetVersion());
		
		final  OpportunityOrderDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
