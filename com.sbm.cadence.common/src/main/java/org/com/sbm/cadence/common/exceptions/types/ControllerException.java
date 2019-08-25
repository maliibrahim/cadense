package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

public class ControllerException extends CadenceApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ControllerException() {
		super();
	}

	public ControllerException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public ControllerException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}

}
