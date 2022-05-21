package com.ssafy.happyhouse.model;

public class QnADto {
	int QnAIndex;
	String userId;
	String QnARegtime;
	String QnATitle;
	String QnAContent;
	int Private1;

	public int getQnAIndex() {
		return QnAIndex;
	}

	public void setQnAIndex(int qnAIndex) {
		QnAIndex = qnAIndex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQnARegtime() {
		return QnARegtime;
	}

	public void setQnARegtime(String qnARegtime) {
		QnARegtime = qnARegtime;
	}

	public String getQnATitle() {
		return QnATitle;
	}

	public void setQnATitle(String qnATitle) {
		QnATitle = qnATitle;
	}

	public String getQnAContent() {
		return QnAContent;
	}

	public void setQnAContent(String qnAContent) {
		QnAContent = qnAContent;
	}

	public int getPrivate1() {
		return Private1;
	}

	public void setPrivate1(int private1) {
		Private1 = private1;
	}

	@Override
	public String toString() {
		return "QnADto [QnAIndex=" + QnAIndex + ", userId=" + userId + ", QnARegtime=" + QnARegtime + ", QnATitle="
				+ QnATitle + ", QnAContent=" + QnAContent + ", Private1=" + Private1 + "]";
	}
	
}
