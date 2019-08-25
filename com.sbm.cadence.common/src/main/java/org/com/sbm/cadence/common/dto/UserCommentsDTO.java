package org.com.sbm.cadence.common.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_comments")
public class UserCommentsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String commentID;
	
	@Column
	private String title;
	
	@Column
	private Date createDate;
	
	@Column
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "opportunity", nullable = true)
	private OpportunityDTO opportunity;

	public UserCommentsDTO() {}
	
	public UserCommentsDTO(String title, Date createDate, String text, OpportunityDTO opportunity) {
		super();
		this.title = title;
		this.createDate = createDate;
		this.text = text;
		this.opportunity = opportunity;
	}

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public OpportunityDTO getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(OpportunityDTO opportunity) {
		this.opportunity = opportunity;
	}

	@Override
	public String toString() {
		return "UserComments [commentID=" + commentID + ", title=" + title + ", createDate=" + createDate + ", text="
				+ text + ", opportunity=" + opportunity + "]";
	}
}
