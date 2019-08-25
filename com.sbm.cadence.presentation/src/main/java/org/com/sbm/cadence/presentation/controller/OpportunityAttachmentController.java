package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.OpportunityAttachmentDTO;
import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.facade.OpportunityAttachmentFacade;
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
@RequestMapping("/api/v1/opportunity/attachment")
public class OpportunityAttachmentController {
	
	@Autowired
	private OpportunityAttachmentFacade attachmentFacade;

	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<OpportunityAttachmentDTO>> retriveAll() {
		System.out.println("inside controller  .............................. ");
		List<OpportunityAttachmentDTO> dtos = attachmentFacade.retrieve(null);

		return ResponseEntity.ok(dtos);	
	}

	@GetMapping("/{id}")
	public List<OpportunityAttachmentDTO> retrive(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return attachmentFacade.retrieve(id);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> create(@Valid @RequestBody OpportunityAttachmentDTO newDto) throws BusinessException {
		return ResponseEntity.ok(attachmentFacade.save(newDto));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> update(@Valid @RequestBody OpportunityAttachmentDTO details) throws ResourceNotFoundException {
		return ResponseEntity.ok(attachmentFacade.update(details));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(attachmentFacade.delete(id));
	}
	
}
