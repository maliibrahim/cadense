package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.ProductCategoryLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.ProductCategoryLookupRepository;
import org.com.sbm.cadence.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "ProductCategoryService")
public class ProductCategoryServiceImpl extends CRUDServiceImpl<ProductCategoryLookupRepository, ProductCategoryLookupDTO> implements ProductCategoryService {

	@Autowired
	private ProductCategoryLookupRepository repository;

	@Override
	public ProductCategoryLookupDTO update(ProductCategoryLookupDTO newObject) throws ResourceNotFoundException {
		ProductCategoryLookupDTO originalObject = repository.findById(newObject.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not found !!! "));
		
		originalObject.setCategory(newObject.getCategory());

		final  ProductCategoryLookupDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
