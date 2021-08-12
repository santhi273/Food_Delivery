package com.capg.foodonlinedelivery.exceptionhandler;

public class ErrorDetails {
	private String url;
	private String message;
	
	public String getUrl() {
		return url;
	}
	public ErrorDetails(String message, String url) {
		super();
		this.url = url;
		this.message = message;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
