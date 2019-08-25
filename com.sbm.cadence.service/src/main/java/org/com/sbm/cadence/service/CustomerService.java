package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.CustomerDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CustomerService extends CRUDService<CustomerDTO>{

}
