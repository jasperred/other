package com.ami.ifs.io.order;

import java.io.Serializable;
import java.util.List;

import com.ami.ifs.dao.OOrderHead;
import com.ami.ifs.io.IfsWsReturn;

@javax.xml.bind.annotation.XmlType(name="OrderListIFSCReturn")
public class OrderListIFSCReturn extends IfsWsReturn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OOrderHead> orderHeadList;
	private int rowCount;

	public List<OOrderHead> getOrderHeadList() {
		return orderHeadList;
	}

	public void setOrderHeadList(List<OOrderHead> orderHeadList) {
		this.orderHeadList = orderHeadList;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
