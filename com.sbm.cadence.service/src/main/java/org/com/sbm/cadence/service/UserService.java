package org.com.sbm.cadence.service;

import org.com.sbm.cadence.common.dto.UsersDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService extends CRUDService<UsersDTO> {

}
