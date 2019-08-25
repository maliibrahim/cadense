package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunityRegionLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface RegionService extends CRUDService<OpportunityRegionLookupDTO>{

}
