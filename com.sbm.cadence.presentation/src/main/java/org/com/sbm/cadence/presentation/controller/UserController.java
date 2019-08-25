package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.dto.UsersDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.service.facade.UserFacade;
import org.com.sbm.cadence.service.facade.UserRulesFacade;
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
@RequestMapping("/api/v1/user/")
public class UserController {
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private UserRulesFacade userRulesFacade;


	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<UsersDTO>> retriveUsers() {
		System.out.println("inside controller  .............................. ");
		List<UsersDTO> usersDTOs = userFacade.retrieve(null);

		return ResponseEntity.ok(usersDTOs);	
	}

	@GetMapping("/{id}")
	public List<UsersDTO> retriveUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		return userFacade.retrieve(userId);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody UsersDTO user) throws BusinessException {
		return ResponseEntity.ok(userFacade.save(user));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> updateUser(@Valid @RequestBody UsersDTO userDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(userFacade.update(userDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userFacade.delete(id));
	}
	
	
}
