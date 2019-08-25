package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunityDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface OpportunityService extends CRUDService<OpportunityDTO> {

}
