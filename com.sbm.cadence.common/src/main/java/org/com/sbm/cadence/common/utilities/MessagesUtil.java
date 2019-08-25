package org.com.sbm.cadence.common.utilities;

import java.util.Locale;

import org.com.sbm.cadence.common.dto.StatusDTO;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class MessagesUtil {

	private static MessageSourceAccessor accessor;
	
	public static String getMessageEn(String code) {
		if (accessor == null){
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames("messages");
			accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
		}
		return accessor.getMessage(code);
	}
	
	public static String getMessageAr(String code) {
		if (accessor == null){
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames("messages");
			accessor = new MessageSourceAccessor(messageSource, new Locale("ar"));
		}
		return accessor.getMessage(code);
	}
	public static StatusDTO getStatusByCode(String code){
		String statusMessageEN = MessagesUtil.getMessageEn(code);
		String statusMessageAR = MessagesUtil.getMessageAr(code);
		return new StatusDTO(code, statusMessageEN, statusMessageAR, null);
		
	}
}
