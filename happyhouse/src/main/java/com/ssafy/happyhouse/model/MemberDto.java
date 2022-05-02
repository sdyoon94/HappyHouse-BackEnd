package com.ssafy.happyhouse.model;

public class MemberDto {

	private String userName;
	private String userId;
	private String userPwd;
	private String email;
	private String joinDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberDto [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", email=" + email
				+ ", joinDate=" + joinDate + "]";
	}

}
