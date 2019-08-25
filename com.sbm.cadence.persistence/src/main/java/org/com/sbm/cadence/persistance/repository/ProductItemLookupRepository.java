package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.ProductItemLookupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemLookupRepository extends JpaRepository<ProductItemLookupDTO, Long>{

}
