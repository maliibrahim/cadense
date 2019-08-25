package org.com.sbm.cadence.service;

import java.util.List;

import org.com.sbm.cadence.common.dto.UserRulesDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRulesService extends CRUDService<UserRulesDTO>{

	public List<UserRulesDTO> getRulesByUserId(Long userId);
}
