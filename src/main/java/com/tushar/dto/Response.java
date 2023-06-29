package com.tushar.dto;

public class Response<I> {

	private String status;
	private String message;
	private I data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public I getData() {
		return data;
	}
	public void setData(I data) {
		this.data = data;
	}
	
	
	
	
	
}
