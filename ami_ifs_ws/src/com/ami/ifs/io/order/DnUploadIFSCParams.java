package com.ami.ifs.io.order;

import java.io.Serializable;
import java.util.List;

import com.ami.ifs.dao.IOrderHead;
import com.ami.ifs.dao.IDnIfHead;
import com.ami.ifs.io.IfsWsParams;

@javax.xml.bind.annotation.XmlType(name="DnUploadIFSCParams")
public class DnUploadIFSCParams extends IfsWsParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IDnIfHead> dnIfHeadList;
	private String ifsEcCd; 

	public String getIfsEcCd() {
		return ifsEcCd;
	}

	public void setIfsEcCd(String ifsEcCd) {
		this.ifsEcCd = ifsEcCd;
	}

	public List<IDnIfHead> getDnIfHeadList() {
		return dnIfHeadList;
	}

	public void setDnIfHeadList(List<IDnIfHead> dnIfHeadList) {
		this.dnIfHeadList = dnIfHeadList;
	}
	
}
