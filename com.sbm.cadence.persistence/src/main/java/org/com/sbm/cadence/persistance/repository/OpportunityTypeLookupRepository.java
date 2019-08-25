package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.OpportunityTypeLookupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityTypeLookupRepository extends JpaRepository<OpportunityTypeLookupDTO, Long>{

}
