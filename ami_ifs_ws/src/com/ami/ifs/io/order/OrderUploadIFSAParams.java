package com.ami.ifs.io.order;

import java.io.Serializable;
import java.util.List;

import com.ami.ifs.dao.OOrderHead;
import com.ami.ifs.io.IfsWsParams;

@javax.xml.bind.annotation.XmlType(name="OrderUploadIFSAParams")
public class OrderUploadIFSAParams extends IfsWsParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OOrderHead> orderHeadList;
	private String ifsAspCd;

	public String getIfsAspCd() {
		return ifsAspCd;
	}

	public void setIfsAspCd(String ifsAspCd) {
		this.ifsAspCd = ifsAspCd;
	}

	public List<OOrderHead> getOrderHeadList() {
		return orderHeadList;
	}

	public void setOrderHeadList(List<OOrderHead> orderHeadList) {
		this.orderHeadList = orderHeadList;
	}
	
}
