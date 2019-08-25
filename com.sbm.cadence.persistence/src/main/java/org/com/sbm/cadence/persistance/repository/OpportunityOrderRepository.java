package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.OpportunityOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityOrderRepository extends JpaRepository<OpportunityOrderDTO, Long>{

}
