package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.ProductItemLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ProductItemService extends CRUDService<ProductItemLookupDTO>{

}
