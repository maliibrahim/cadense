package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.OpportunityTypeLookupDTO;
import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.facade.OpportunityTypeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/opportunity/type/")
public class OpportunityTypeController {
	
	@Autowired
	private OpportunityTypeFacade opportunityTypeFacade;


	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<OpportunityTypeLookupDTO>> retriveAll() {
		System.out.println("inside controller  .............................. ");
		List<OpportunityTypeLookupDTO> dtos = opportunityTypeFacade.retrieve(null);

		return ResponseEntity.ok(dtos);	
	}

	@GetMapping("/{id}")
	public List<OpportunityTypeLookupDTO> retrive(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return opportunityTypeFacade.retrieve(id);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> create(@Valid @RequestBody OpportunityTypeLookupDTO newDto) throws BusinessException {
		return ResponseEntity.ok(opportunityTypeFacade.save(newDto));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> update(@Valid @RequestBody OpportunityTypeLookupDTO details) throws ResourceNotFoundException {
		return ResponseEntity.ok(opportunityTypeFacade.update(details));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(opportunityTypeFacade.delete(id));
	}
	
}
