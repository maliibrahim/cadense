package org.com.sbm.cadence.service.facade;

import java.util.List;

import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.dto.StatusDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.implementation.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CRUDFacade<T extends CRUDServiceImpl,K>{

	@Autowired
	private T service;
	
public List<K> retrieve(Long id) { //throws BusinessException {
		
		List<K> Ks = service.get(id);
		
//		boolean flag = true;
//		if(flag)
//			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		
		return Ks;
	}

	
	public ResponseDTO save(K k) throws BusinessException{ //throws ResourceNotFoundException {
		K savedOpportunity = (K) service.add(k);

		if(savedOpportunity == null)
//			throw new ResourceNotFoundException("Cannot Add Opportunity!!! ");
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		
		StatusDTO status = new StatusDTO("200", 
				savedOpportunity.getClass().getSimpleName() + " has been added successfully", 
				savedOpportunity.getClass().getSimpleName() + " has been added successfully", null);
		
		return new ResponseDTO(status, savedOpportunity);
	}
	
	public ResponseDTO update(K k) throws ResourceNotFoundException {// throws BusinessException{
		K updatedOpportunity = (K) service.update(k);

		if(updatedOpportunity == null)
			throw new ResourceNotFoundException("Cannot Update Opportunity ");
			//throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		
		StatusDTO status = new StatusDTO("200", 
				updatedOpportunity.getClass().getSimpleName() + " has been updated successfully", 
				updatedOpportunity.getClass().getSimpleName() + " has been updated successfully", null);
		
		return new ResponseDTO(status, updatedOpportunity);
	}
	
	public ResponseDTO delete(Long id) throws ResourceNotFoundException {// throws BusinessException{
		service.delete(id);

//		if(isDeleted == null)
//			throw new ResourceNotFoundException("Cannot Update Opportunity With ID :: " + id);
//			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		
		StatusDTO status = new StatusDTO("200", 
				"Object has been deleted successfully", 
				"Object has been deleted successfully", null);
		
		return new ResponseDTO(status, true);
	}
}
