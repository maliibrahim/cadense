package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

public class ValidationException extends CadenceApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidationException() {
		super();
	}

	public ValidationException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public ValidationException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}

}
