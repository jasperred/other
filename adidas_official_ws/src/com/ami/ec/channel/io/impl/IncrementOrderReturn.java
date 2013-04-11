package com.ami.ec.channel.io.impl;

import java.util.List;

import com.ami.ec.channel.domain.asp.OrderHeadForWs;
import com.ami.ec.channel.io.WsReturn;

@javax.xml.bind.annotation.XmlType(name="IncrementOrderReturn")
public class IncrementOrderReturn extends WsReturn {
	private int total;
	private List<OrderHeadForWs> orderHeadList;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<OrderHeadForWs> getOrderHeadList() {
		return orderHeadList;
	}
	public void setOrderHeadList(List<OrderHeadForWs> orderHeadList) {
		this.orderHeadList = orderHeadList;
	}
	
}
