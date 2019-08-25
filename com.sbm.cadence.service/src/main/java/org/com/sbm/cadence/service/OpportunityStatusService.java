package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunityStatusLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface OpportunityStatusService extends CRUDService<OpportunityStatusLookupDTO>{

}
