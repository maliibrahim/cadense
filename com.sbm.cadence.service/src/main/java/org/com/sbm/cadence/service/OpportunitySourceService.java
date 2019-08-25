package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunitySourceLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface OpportunitySourceService extends CRUDService<OpportunitySourceLookupDTO>{

}
