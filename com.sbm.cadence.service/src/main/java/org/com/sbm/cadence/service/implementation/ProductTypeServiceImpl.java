package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.ProductItemLookupDTO;
import org.com.sbm.cadence.common.dto.ProductTypeLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.ProductItemLookupRepository;
import org.com.sbm.cadence.persistance.repository.ProductTypeLookupRepository;
import org.com.sbm.cadence.service.ProductItemService;
import org.com.sbm.cadence.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "ProductTypeService")
public class ProductTypeServiceImpl extends CRUDServiceImpl<ProductTypeLookupRepository, ProductTypeLookupDTO> implements ProductTypeService {

	@Autowired
	private ProductTypeLookupRepository repository;

	@Override
	public ProductTypeLookupDTO update(ProductTypeLookupDTO newObject) throws ResourceNotFoundException {
		ProductTypeLookupDTO originalObject = repository.findById(newObject.getTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Item not found !!! "));
		
		originalObject.setProductType(newObject.getProductType());

		final  ProductTypeLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
