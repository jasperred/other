package com.ami.ec.channel.io.impl;

import java.util.List;

import com.ami.ec.channel.io.WsParams;

@javax.xml.bind.annotation.XmlType(name="UploadReturnOrderParams")
public class UploadReturnOrderParams extends WsParams {
	
	private List<ReturnOrder> returnOrderList;

	public List<ReturnOrder> getReturnOrderList() {
		return returnOrderList;
	}

	public void setReturnOrderList(List<ReturnOrder> returnOrderList) {
		this.returnOrderList = returnOrderList;
	}

}
