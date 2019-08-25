package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ProductService extends CRUDService<ProductDTO>{

}
