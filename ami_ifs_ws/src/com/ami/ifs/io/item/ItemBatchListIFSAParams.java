package com.ami.ifs.io.item;

import java.io.Serializable;

import com.ami.ifs.io.IfsWsParams;

@javax.xml.bind.annotation.XmlType(name = "ItemBatchListIFSAParams")
public class ItemBatchListIFSAParams extends IfsWsParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ifsAspCd;
	private int pageSize = 1000;

	public String getIfsAspCd() {
		return ifsAspCd;
	}

	public void setIfsAspCd(String ifsAspCd) {
		this.ifsAspCd = ifsAspCd;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
