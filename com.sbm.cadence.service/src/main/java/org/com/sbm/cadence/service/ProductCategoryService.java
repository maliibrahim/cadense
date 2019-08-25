package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.ProductCategoryLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ProductCategoryService extends CRUDService<ProductCategoryLookupDTO> {

}
