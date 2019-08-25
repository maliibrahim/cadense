package org.com.sbm.cadence.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.dto.UserRulesDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
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
@RequestMapping("/api/v1/rule/")
public class UserRulesController {
	
	@Autowired
	private UserRulesFacade userRulesFacade;


	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<UserRulesDTO>> retriveRules() {
		System.out.println("inside controller  .............................. ");
		List<UserRulesDTO> dtos = userRulesFacade.retrieve(null);

		return ResponseEntity.ok(dtos);	
	}

	@GetMapping("/{id}")
	public List<UserRulesDTO> retriveRule(@PathVariable(value = "id") Long ruleId)
			throws ResourceNotFoundException {
		return userRulesFacade.retrieve(ruleId);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createRule(@Valid @RequestBody UserRulesDTO user) throws BusinessException {
		return ResponseEntity.ok(userRulesFacade.save(user));
		
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO> updateRule(@Valid @RequestBody UserRulesDTO userDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(userRulesFacade.update(userDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteRule(@PathVariable(value = "id") Long RuleId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userRulesFacade.delete(RuleId));
	}
	
	@GetMapping("/user/{id}")
	public List<UserRulesDTO> retriveUserRules(@PathVariable(value = "id") Long userId) {
		try {
			return userRulesFacade.retrievebyUserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRulesFacade.retrievebyUserId(userId);
	}
}
