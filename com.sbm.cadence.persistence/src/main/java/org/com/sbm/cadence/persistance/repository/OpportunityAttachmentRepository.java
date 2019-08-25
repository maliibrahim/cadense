package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.OpportunityAttachmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityAttachmentRepository extends JpaRepository<OpportunityAttachmentDTO, Long>{

}
