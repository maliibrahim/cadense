package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.UserRolesLookupDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRolesService extends CRUDService<UserRolesLookupDTO>{

}
