package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.OpportunitySectorLookupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunitySectorLookupRepository extends JpaRepository<OpportunitySectorLookupDTO, Long>{

}
