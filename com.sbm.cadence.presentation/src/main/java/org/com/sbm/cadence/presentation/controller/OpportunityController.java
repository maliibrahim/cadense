package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.OpportunityDTO;
import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.facade.OpportunityFacade;
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
@RequestMapping("/api/v1/opportunity/")
public class OpportunityController {
	
	@Autowired
	private OpportunityFacade opportunityFacade;

	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<OpportunityDTO>> retriveOpportunites() {
		System.out.println("inside controller  .............................. ");
		List<OpportunityDTO> opportunityDTOs = opportunityFacade.retrieve(null);

		return ResponseEntity.ok(opportunityDTOs);	
	}

	@GetMapping("/{id}")
	public List<OpportunityDTO> retriveOpportunity(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return opportunityFacade.retrieve(id);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createOpportunity(@Valid @RequestBody OpportunityDTO opportunity) throws BusinessException {
		return ResponseEntity.ok(opportunityFacade.save(opportunity));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody OpportunityDTO opportunityDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(opportunityFacade.update(opportunityDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(opportunityFacade.delete(id));
	}
}
