package com.ami.ifs.io;

@javax.xml.bind.annotation.XmlType(name="SuccessMapping")
public class SuccessMapping {
	private String successKey;
	private long storeId;
	
	public SuccessMapping()
	{
	}
	
	public SuccessMapping(String successKey,long storeId)
	{
		this.successKey = successKey;
		this.storeId = storeId;
	}
	public String getSuccessKey() {
		return successKey;
	}
	public void setSuccessKey(String successKey) {
		this.successKey = successKey;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	
	

}
