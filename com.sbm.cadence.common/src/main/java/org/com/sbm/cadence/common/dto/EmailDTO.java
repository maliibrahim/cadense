package org.com.sbm.cadence.common.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String receiverEmail;
	private String senderEmail;
	private String senderName;
	private String emailContent;
	private String emailSubject;
	private String ccEmail;
	/** The set of email addresses to be bcced. */
	private String[] bccReceivers;

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}

	public String[] getBccReceivers() {
		return bccReceivers;
	}

	public void setBccReceivers(String[] bccReceivers) {
		this.bccReceivers = bccReceivers;
	}
}