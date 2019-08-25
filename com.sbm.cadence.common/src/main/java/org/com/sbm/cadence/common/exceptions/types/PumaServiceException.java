package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class PumaServiceException extends CadenceApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PumaServiceException() {
		super();
	}

	public PumaServiceException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public PumaServiceException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}
