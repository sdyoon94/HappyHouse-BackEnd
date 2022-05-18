package com.ssafy.happyhouse.model;

public class CommentDto {
	int commentIndex;
	int QnAIndex;
	String commentContent;
	String commentRegtime;

	public int getCommentIndex() {
		return commentIndex;
	}

	public void setCommentIndex(int commentIndex) {
		this.commentIndex = commentIndex;
	}

	public int getQnAIndex() {
		return QnAIndex;
	}

	public void setQnAIndex(int qnAIndex) {
		QnAIndex = qnAIndex;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentRegtime() {
		return commentRegtime;
	}

	public void setCommentRegtime(String commentRegtime) {
		this.commentRegtime = commentRegtime;
	}

	@Override
	public String toString() {
		return "CommentDto [commentIndex=" + commentIndex + ", QnAIndex=" + QnAIndex + ", commentContent="
				+ commentContent + ", commentRegtime=" + commentRegtime + "]";
	}
}
