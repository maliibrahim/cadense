package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.CustomerDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.CustomersRepository;
import org.com.sbm.cadence.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "CustomerService")
public class CustomerServiceImpl extends CRUDServiceImpl<CustomersRepository, CustomerDTO> implements CustomerService {

	@Autowired
	private CustomersRepository repository;

	@Override
	public CustomerDTO update(CustomerDTO newObject) throws ResourceNotFoundException {
		CustomerDTO originalObject = repository.findById(newObject.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found !!! "));
		
		originalObject.setCustomerName(newObject.getCustomerName());
		originalObject.setCustomerNumber(newObject.getCustomerNumber());
		originalObject.setEmail(newObject.getEmail());
		originalObject.setRegion(newObject.getRegion());
		originalObject.setSector(newObject.getSector());

		final  CustomerDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
