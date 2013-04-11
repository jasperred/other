package com.ami.ec.channel.io.impl;

import java.util.Date;
import java.util.List;

import com.ami.ec.channel.io.WsReturn;

@javax.xml.bind.annotation.XmlType(name="UploadSalesOrderReturn")
public class UploadSalesOrderReturn extends WsReturn {
	
	private int success;
	private int failed;
	private int requestTotal;
	private Date startDate;
	private Date endDate;
	private List<FailedOrders> failedOrders;
	private List<String> successOrders;
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFailed() {
		return failed;
	}
	public void setFailed(int failed) {
		this.failed = failed;
	}
	public int getRequestTotal() {
		return requestTotal;
	}
	public void setRequestTotal(int requestTotal) {
		this.requestTotal = requestTotal;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<FailedOrders> getFailedOrders() {
		return failedOrders;
	}
	public void setFailedOrders(List<FailedOrders> failedOrders) {
		this.failedOrders = failedOrders;
	}
	public List<String> getSuccessOrders() {
		return successOrders;
	}
	public void setSuccessOrders(List<String> successOrders) {
		this.successOrders = successOrders;
	}

}
