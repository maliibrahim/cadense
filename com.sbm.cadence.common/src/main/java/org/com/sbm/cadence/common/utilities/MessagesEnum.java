package org.com.sbm.cadence.common.utilities;

public enum MessagesEnum {
	 RESOURCE_NOT_FOUND_404("sa.gov.yesser.code.404"), 
	 UNAUTHORIZED_401("sa.gov.yesser.code.401"), 
	 UNSUPPORTED_TYPE_415("sa.gov.yesser.code.415"), 
	 SERVER_ERROR_500("sa.gov.yesser.code.500"), 
	 OK_200("sa.gov.yesser.code.200");
	MessagesEnum(String key) {
		this.key = key;
	}
	private String key;
	public String getKey() {
		return key;
	} 
}
