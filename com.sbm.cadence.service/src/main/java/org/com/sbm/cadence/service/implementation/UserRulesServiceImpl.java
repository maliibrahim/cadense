package org.com.sbm.cadence.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.com.sbm.cadence.common.dto.UserRulesDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.UserRulesRepository;
import org.com.sbm.cadence.service.UserRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "UserRulesService")
public class UserRulesServiceImpl extends CRUDServiceImpl<UserRulesRepository, UserRulesDTO> implements UserRulesService {

	@Autowired
	private UserRulesRepository repository;

	@Override
	public UserRulesDTO update(UserRulesDTO newObject) throws ResourceNotFoundException {
		UserRulesDTO originalObject = repository.findById(newObject.getRuleId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setCanCreate(newObject.getCanCreate());
		originalObject.setCanDelete(newObject.getCanDelete());
		originalObject.setCanEdit(newObject.getCanEdit());
		originalObject.setCanView(newObject.getCanView());
		originalObject.setCustomerManagement(newObject.isCustomerManagement());
		originalObject.setLob(newObject.getLob());
		originalObject.setLookupManagement(newObject.isLookupManagement());
		originalObject.setRegion(newObject.getRegion());
		originalObject.setRole(newObject.getRole());
		originalObject.setSector(newObject.getSector());
		originalObject.setUser(newObject.getUser());
		originalObject.setUserManagement(newObject.isUserManagement());
		
		final  UserRulesDTO updated = repository.save(originalObject);
		
		return updated;
	}

	@Override
	public List<UserRulesDTO> getRulesByUserId(Long userId) {
		List<UserRulesDTO> dtos = null;
	
		dtos = repository.findByUserUserId(userId);	
		
		return dtos;
	}

}
