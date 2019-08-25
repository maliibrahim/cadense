package org.com.sbm.cadence.common.utilities;

import java.util.Locale;

import org.com.sbm.cadence.common.constants.ConfigurationConstants;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;


public class ConfigurationUtil {

	private static MessageSourceAccessor accessor;

	public static String getConfiguration(String config) {
		if (accessor == null) {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames(ConfigurationConstants.CONFIG_FILE_NAME);
			accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
		}
		return accessor.getMessage(config);
	}
}
