package org.com.sbm.cadence.service.facade;

import java.util.List;

import org.com.sbm.cadence.common.dto.UserRulesDTO;
import org.com.sbm.cadence.service.UserRulesService;
import org.com.sbm.cadence.service.implementation.UserRulesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRulesFacade extends CRUDFacade<UserRulesServiceImpl, UserRulesDTO> {

	@Autowired
	private UserRulesService userRulesService;
	
	public List<UserRulesDTO> retrievebyUserId(Long id) { //throws BusinessException {
		
		List<UserRulesDTO> Ks = userRulesService.getRulesByUserId(id);

		return Ks;
	}
	
	
}
