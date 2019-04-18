package com.application.urlShortener.Model;

public class URLObject {
	
	private String originalURL;
	private String convertedURL;
	
	public URLObject() {
		
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getConvertedURL() {
		return convertedURL;
	}

	public void setConvertedURL(String convertedURL) {
		this.convertedURL = convertedURL;
	}
	
}
