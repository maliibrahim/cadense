package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.ProductItemLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.ProductItemLookupRepository;
import org.com.sbm.cadence.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "ProductItemService")
public class ProductItemServiceImpl extends CRUDServiceImpl<ProductItemLookupRepository, ProductItemLookupDTO> implements ProductItemService {

	@Autowired
	private ProductItemLookupRepository repository;

	@Override
	public ProductItemLookupDTO update(ProductItemLookupDTO newObject) throws ResourceNotFoundException {
		ProductItemLookupDTO originalObject = repository.findById(newObject.getItemId())
				.orElseThrow(() -> new ResourceNotFoundException("Item not found !!! "));
		
		originalObject.setItem(newObject.getItem());

		final  ProductItemLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
