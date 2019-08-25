package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunityTypeLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface OpportunityTypeService extends CRUDService<OpportunityTypeLookupDTO>{

}
