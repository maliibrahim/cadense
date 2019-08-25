package org.com.sbm.cadence.service;

import java.util.List;

import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CRUDService<T>{

	public List<T> get(Long id);

	public T add(T object);
	
	public T update(T newObject) throws ResourceNotFoundException;

	public Boolean delete(Long id) throws ResourceNotFoundException;

}
