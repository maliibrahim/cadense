package org.com.sbm.cadence.common.exceptions.enums;

import org.com.sbm.cadence.common.utilities.MessagesUtil;

public enum ExceptionEnums {
	
	INVALID_REQUEST("sa.gov.yesser.controller.code.1000"),
	MISSING_PARAMS("sa.gov.yesser.controller.code.1001"),
	INVALID_HTTP_METHOD("sa.gov.yesser.controller.code.1002"),
	INVALID_OPERATION("sa.gov.yesser.controller.code.1003"),
	INTERNAL_SERVER_ERROR("sa.gov.yesser.controller.code.500"),
	
	PUMA_ERROR("sa.gov.yesser.puma.code.2000"),
	PUMA_NO_USER_ERROR("sa.gov.yesser.puma.code.2001"),
	PUMA_NO_GROUP_ERROR("sa.gov.yesser.puma.code.2002"),
	
	BUSINESS_ERROR("sa.gov.yesser.business.code.3000");
	
	private String code;
	private String messageEn;
	private String messageAr;
	
	ExceptionEnums(String code){
		this.code = code;
		this.messageEn = MessagesUtil.getMessageEn(code);
		this.messageAr = MessagesUtil.getMessageAr(code);
	}

	public String getCode() {
		return code;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
