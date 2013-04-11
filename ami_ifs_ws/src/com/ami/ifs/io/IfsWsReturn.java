package com.ami.ifs.io;

import java.util.ArrayList;
import java.util.List;

import com.ami.ifs.ws.common.Message;

@javax.xml.bind.annotation.XmlType(name="IfsWsReturn")
public class IfsWsReturn {
	private String flag;
	private List<Message> messageList;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public void addMessage(Message message)
	{
		if(messageList==null)
			messageList = new ArrayList();
		messageList.add(message);
	}
	
}
