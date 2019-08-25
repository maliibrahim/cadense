package org.com.sbm.cadence.common.exceptions.types;

import org.com.sbm.cadence.common.exceptions.enums.ExceptionEnums;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class CadenceApplicationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String messageEn;
	private String messageAr;
	
	public CadenceApplicationException() {
		super();
	}
	
	public CadenceApplicationException(ExceptionEnums exEnums) {
		super(exEnums.getMessageEn());
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}
	
	
	public CadenceApplicationException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums.getMessageEn(), e);
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
