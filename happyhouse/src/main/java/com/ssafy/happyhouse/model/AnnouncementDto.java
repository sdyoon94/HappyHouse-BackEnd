package com.ssafy.happyhouse.model;

public class AnnouncementDto {
	int announcementNo;
	String userid;
	String subject;
	String content;
	String regtime;
	public int getAnnouncementNo() {
		return announcementNo;
	}
	public void setAnnouncementNo(int announcementNo) {
		this.announcementNo = announcementNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	@Override
	public String toString() {
		return "AnnouncementDto [announcementNo=" + announcementNo + ", userid=" + userid + ", subject=" + subject
				+ ", content=" + content + ", regtime=" + regtime + "]";
	}
}
