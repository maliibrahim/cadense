package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.UsersDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.UsersRepository;
import org.com.sbm.cadence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "UserService")
public class UserServiceImpl extends CRUDServiceImpl<UsersRepository, UsersDTO> implements UserService {

	@Autowired
	private UsersRepository repository;

	@Override
	public UsersDTO update(UsersDTO newObject) throws ResourceNotFoundException {
		UsersDTO originalObject = repository.findById(newObject.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setEmail(newObject.getEmail());
		originalObject.setFirstName(newObject.getFirstName());
		originalObject.setLastName(newObject.getLastName());
		originalObject.setManagerId(newObject.getManagerId());
		originalObject.setPassword(newObject.getPassword());
		
		final  UsersDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
