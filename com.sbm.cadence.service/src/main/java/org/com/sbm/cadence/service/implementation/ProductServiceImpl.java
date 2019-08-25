package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.ProductDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.ProductRepository;
import org.com.sbm.cadence.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "ProductService")
public class ProductServiceImpl extends CRUDServiceImpl<ProductRepository, ProductDTO> implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public ProductDTO update(ProductDTO newObject) throws ResourceNotFoundException {
		ProductDTO originalObject = repository.findById(newObject.getProductId())
				.orElseThrow(() -> new ResourceNotFoundException("Item not found !!! "));
		
		originalObject.setProductCategory(newObject.getProductCategory());
		originalObject.setProductItem(newObject.getProductItem());
		originalObject.setProductKind(newObject.getProductKind());
		originalObject.setProductType(newObject.getProductType());

		final  ProductDTO updated = repository.save(originalObject);
		
		return updated;
	}

}
