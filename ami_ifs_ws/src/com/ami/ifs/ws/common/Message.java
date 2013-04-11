package com.ami.ifs.ws.common;

import java.io.Serializable;

@javax.xml.bind.annotation.XmlType(name="Message")
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageCode;
	private String messageContent;
	private long storeId = 0;
	
	public Message()
	{
		
	}
	
	public Message(String messageCode,String messageContent)
	{
		this.messageCode = messageCode;
		this.messageContent = messageContent;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	

}
