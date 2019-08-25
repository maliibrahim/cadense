package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

public class RespositoryException extends CadenceApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RespositoryException() {
		super();
	}

	public RespositoryException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public RespositoryException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}
