package org.com.sbm.cadence.common.dto;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_attachment")
public class OpportunityAttachmentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long attachmentId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "opportunityAttachmet", nullable = true)
	private OpportunityDTO opportunityAttachmet;
	
	@Column
	private String attachmentName;
	
	@Column(name="content")
	@Lob
	private Blob content;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name="created")
	private Date created;

	public OpportunityAttachmentDTO() {}
	
	public OpportunityAttachmentDTO(OpportunityDTO opportunityAttachmet, String attachmentName, Blob content,
			String contentType, Date created) {
		super();
		this.opportunityAttachmet = opportunityAttachmet;
		this.attachmentName = attachmentName;
		this.content = content;
		this.contentType = contentType;
		this.created = created;
	}

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public OpportunityDTO getOpportunityAttachmet() {
		return opportunityAttachmet;
	}

	public void setOpportunityAttachmet(OpportunityDTO opportunityAttachmet) {
		this.opportunityAttachmet = opportunityAttachmet;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
