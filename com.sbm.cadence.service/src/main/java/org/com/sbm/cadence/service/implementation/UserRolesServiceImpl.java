package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.UserRolesLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.UserRolesLookupRepository;
import org.com.sbm.cadence.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "UserRolesService")
public class UserRolesServiceImpl extends CRUDServiceImpl<UserRolesLookupRepository, UserRolesLookupDTO> implements UserRolesService {

	@Autowired
	private UserRolesLookupRepository repository;

	@Override
	public UserRolesLookupDTO update(UserRolesLookupDTO newObject) throws ResourceNotFoundException {
		UserRolesLookupDTO originalObject = repository.findById(newObject.getRoleId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setUserRole(newObject.getUserRole());

		final  UserRolesLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
