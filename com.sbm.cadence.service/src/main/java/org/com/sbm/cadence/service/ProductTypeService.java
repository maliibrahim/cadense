package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.ProductTypeLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ProductTypeService extends CRUDService<ProductTypeLookupDTO>{

}
