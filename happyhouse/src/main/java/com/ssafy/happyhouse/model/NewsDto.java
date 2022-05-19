package com.ssafy.happyhouse.model;

public class NewsDto {
	public String imgUrl;
	public String articleTitle;
	public String articleContent;
	public String articleUrl;
	
	public NewsDto(String imgUrl, String articleTitle, String articleContent, String articleUrl) {
		super();
		this.imgUrl = imgUrl;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleUrl = articleUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleUrl() {
		return articleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	@Override
	public String toString() {
		return "NewsDto [imgUrl=" + imgUrl + ", articleTitle=" + articleTitle + ", articleContent=" + articleContent
				+ ", articleUrl=" + articleUrl + "]";
	}
}
