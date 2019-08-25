package org.com.sbm.cadence.common.utilities;

import org.com.sbm.cadence.common.dto.EmailDTO;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class MailUtil {
	
	private static MailUtil mailInstance;
	
	private MailUtil(){}
	
	public static MailUtil getInstance() {
		if (mailInstance == null) {
			mailInstance = new MailUtil();
		}
		return mailInstance;
	} 
	
	public boolean sendMail(EmailDTO emailDTO){
		// To be implemented
		return true;
	}
}
