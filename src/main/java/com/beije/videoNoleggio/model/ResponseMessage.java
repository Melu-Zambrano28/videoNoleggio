package com.beije.videoNoleggio.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResponseMessage{
	private String msg;
	private boolean status;
	
	public ResponseMessage() {
		
	}
	
	public ResponseMessage(String message , boolean status) {
		this.msg =  message;
		this.status = status;
		
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
		
	}
	
	public String getMessage() {
		return msg;
	}
	
	public boolean getStatus() {
		return status;
	}

}
