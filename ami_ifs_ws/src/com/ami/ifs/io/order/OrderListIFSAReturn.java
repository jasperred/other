package com.ami.ifs.io.order;

import java.io.Serializable;
import java.util.List;

import com.ami.ifs.dao.IOrderHead;
import com.ami.ifs.io.IfsWsReturn;


@javax.xml.bind.annotation.XmlType(name="OrderListIFSAReturn")
public class OrderListIFSAReturn extends IfsWsReturn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IOrderHead> orderHeadList;
	private int rowCount;

	public List<IOrderHead> getOrderHeadList() {
		return orderHeadList;
	}

	public void setOrderHeadList(List<IOrderHead> orderHeadList) {
		this.orderHeadList = orderHeadList;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
