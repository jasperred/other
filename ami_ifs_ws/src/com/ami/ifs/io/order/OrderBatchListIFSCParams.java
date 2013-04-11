package com.ami.ifs.io.order;

import java.io.Serializable;

import com.ami.ifs.io.IfsWsParams;


@javax.xml.bind.annotation.XmlType(name="OrderBatchListIFSCParams")
public class OrderBatchListIFSCParams extends IfsWsParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ifsEcCd;
	private int pageSize = 1000;

	public String getIfsEcCd() {
		return ifsEcCd;
	}

	public void setIfsEcCd(String ifsEcCd) {
		this.ifsEcCd = ifsEcCd;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
