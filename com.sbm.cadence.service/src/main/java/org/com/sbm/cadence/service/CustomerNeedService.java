package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunityCustomerNeedLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CustomerNeedService extends CRUDService<OpportunityCustomerNeedLookupDTO>{

}
