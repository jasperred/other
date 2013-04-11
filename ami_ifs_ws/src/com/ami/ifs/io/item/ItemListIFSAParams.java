package com.ami.ifs.io.item;

import java.io.Serializable;

import com.ami.ifs.io.IfsWsParams;

@javax.xml.bind.annotation.XmlType(name = "ItemListIFSAParams")
public class ItemListIFSAParams extends IfsWsParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String storeCd;
	private String ifsAspCd;	
	private int pageSize = 1000;

	public String getIfsAspCd() {
		return ifsAspCd;
	}

	public void setIfsAspCd(String ifsAspCd) {
		this.ifsAspCd = ifsAspCd;
	}

	public String getStoreCd() {
		return storeCd;
	}

	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
