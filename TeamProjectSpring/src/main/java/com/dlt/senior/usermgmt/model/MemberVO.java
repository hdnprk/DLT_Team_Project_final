package com.dlt.senior.usermgmt.model;

import java.util.Date;

public class MemberVO {
	private String userId;
	private String userPw;
	private String phone;
	private String name;
	private String email;
	private Date date;

	public String getUserId() {
		return userId;
	}
	public String getUserPw() {
		return userPw;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
