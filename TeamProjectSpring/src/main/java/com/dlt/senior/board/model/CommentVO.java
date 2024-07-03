package com.dlt.senior.board.model;

import java.sql.Date;

public class CommentVO {
	
	private int cId;
	private int bId;
	private String userId;
	private String cName;
	private Date cDate;
	private String bComment;
	private int bGroup;
	private int cStep;
	

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getcStep() {
		return cStep;
	}
	public void setcStep(int cStep) {
		this.cStep = cStep;
	}


	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getbComment() {
		return bComment;
	}
	public void setbComment(String bComment) {
		this.bComment = bComment;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
}
