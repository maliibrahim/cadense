package org.com.sbm.cadence.service.facade;

import org.com.sbm.cadence.common.dto.CustomerDTO;
import org.com.sbm.cadence.service.CustomerService;
import org.com.sbm.cadence.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerFacade extends CRUDFacade<CustomerServiceImpl, CustomerDTO> {

	@Autowired
	private CustomerService customerService;
	
	
	
}
