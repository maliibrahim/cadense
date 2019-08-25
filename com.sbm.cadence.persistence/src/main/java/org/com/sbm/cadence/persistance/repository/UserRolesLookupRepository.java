package org.com.sbm.cadence.persistance.repository;

import org.com.sbm.cadence.common.dto.UserRolesLookupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesLookupRepository extends JpaRepository<UserRolesLookupDTO, Long>{

}
