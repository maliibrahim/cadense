package org.com.sbm.cadence.persistance.repository;

import java.util.List;

import org.com.sbm.cadence.common.dto.UserRulesDTO;
import org.com.sbm.cadence.common.dto.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRulesRepository extends JpaRepository<UserRulesDTO, Long>{
	
    //@Query("SELECT t FROM public.user_rules t WHERE t.user_user_id = ?1")
	List<UserRulesDTO> findByUserUserId(long userId);

}

