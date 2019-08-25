package org.com.sbm.cadence.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CRUDServiceImpl<T extends JpaRepository,K> implements CRUDService<K> {

	@Autowired
	private T repository;

	@Override
	public List<K> get(Long id) {
		List<K> dtos = null;
		Optional<K> dto = null;
		
		if (id == null) {
			dtos = (List<K>) repository.findAll();
		} else {
			dto = repository.findById(id);
			
			if (dto.isPresent()){
				dtos = new ArrayList<K>();
				dtos.add(dto.get());
			}
		}
		
//		if(customers.isEmpty())
//			throw new ResourceNotFoundException(0L, "There are no customers");
		
		return dtos;
	}

	@Override
	public K add(K object) {
		System.out.println("inside add in service impl .........");
		return (K) repository.save(object);
	}

	@Override
	public Boolean delete(Long id) throws ResourceNotFoundException{
		try {
			Optional<K> dto = repository.findById(id);
			repository.delete(dto.get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Object not found for this id :: " + id);
		}
	}
}
