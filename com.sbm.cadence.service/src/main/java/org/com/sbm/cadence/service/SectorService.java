package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.OpportunitySectorLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface SectorService extends CRUDService<OpportunitySectorLookupDTO>{

}
