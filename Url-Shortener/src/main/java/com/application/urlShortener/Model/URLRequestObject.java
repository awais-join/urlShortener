package com.application.urlShortener.Model;

public class URLRequestObject {
	
	private String originalURL;
	private String shortenedURLID;
	
	public URLRequestObject() {
		
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getShortenedURLID() {
		return shortenedURLID;
	}

	public void setShortenedURLID(String shortenedURLID) {
		this.shortenedURLID = shortenedURLID;
	}
	
}
