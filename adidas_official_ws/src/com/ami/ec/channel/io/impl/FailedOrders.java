package com.ami.ec.channel.io.impl;

@javax.xml.bind.annotation.XmlType(name="FailedOrders")
public class FailedOrders {
	private String orderNo;
	private String errors;
	private String comment;
	private String reserve;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	
	

}
