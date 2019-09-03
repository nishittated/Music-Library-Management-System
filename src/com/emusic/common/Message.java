/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */ 
package com.emusic.common;
 
public class Message { 
	private String messageType, header, description;
	public static final String ERROR = "ERROR", 
			INFO = "INFO",
			SUCCESS = "SUCCESS";
	
	public Message() 
	{
		super();
	}

	public Message(String messageType, String header, String description) 
	{
		super();
		this.messageType = messageType;
		this.header = header;
		this.description = description;
	}
	
	public String getMessageType() 
	{
		return messageType;	
	}
	public void setMessageType(String messageType) {this.messageType = messageType;}

	public String getHeader() {	return header;}
	public void setHeader(String header) {this.header = header;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
}
