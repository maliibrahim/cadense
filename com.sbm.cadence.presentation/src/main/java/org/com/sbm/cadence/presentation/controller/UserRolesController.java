package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.dto.UserRolesLookupDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.facade.UserRolesFacade;
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
@RequestMapping("/api/v1/role/")
public class UserRolesController {
	
	@Autowired
	private UserRolesFacade userRolesFacade;


	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<UserRolesLookupDTO>> retriveRoles() {
		System.out.println("inside controller  .............................. ");
		List<UserRolesLookupDTO> dtos = userRolesFacade.retrieve(null);

		return ResponseEntity.ok(dtos);	
	}

	@GetMapping("/{id}")
	public List<UserRolesLookupDTO> retriveRule(@PathVariable(value = "id") Long ruleId)
			throws ResourceNotFoundException {
		return userRolesFacade.retrieve(ruleId);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createRule(@Valid @RequestBody UserRolesLookupDTO user) throws BusinessException {
		return ResponseEntity.ok(userRolesFacade.save(user));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> updateRule(@Valid @RequestBody UserRolesLookupDTO userDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(userRolesFacade.update(userDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteRule(@PathVariable(value = "id") Long RuleId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userRolesFacade.delete(RuleId));
	}
	
}
