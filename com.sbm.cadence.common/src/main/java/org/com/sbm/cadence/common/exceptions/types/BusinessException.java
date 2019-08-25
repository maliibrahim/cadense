package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class BusinessException extends CadenceApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public BusinessException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}