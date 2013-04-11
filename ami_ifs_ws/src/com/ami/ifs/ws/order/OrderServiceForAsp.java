package com.ami.ifs.ws.order;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ami.ifs.io.order.DnBatchListIFSAParams;
import com.ami.ifs.io.order.DnBatchListIFSAReturn;
import com.ami.ifs.io.order.OrderBatchListIFSAParams;
import com.ami.ifs.io.order.OrderBatchListIFSAReturn;
import com.ami.ifs.io.order.OrderListIFSAParams;
import com.ami.ifs.io.order.OrderListIFSAReturn;
import com.ami.ifs.io.order.OrderUploadIFSAParams;
import com.ami.ifs.io.order.OrderUploadIFSAReturn;
@WebService(name="OrderServiceForAsp")
public interface OrderServiceForAsp {
	/**
	 * IFS A 批量得到订单信息
	 * @return
	 */
	@WebMethod(operationName="orderBatchListIFSA")
	public OrderBatchListIFSAReturn orderBatchListIFSA(OrderBatchListIFSAParams r);
	
	/**
	 * IFS A 按店铺得到订单信息
	 * @return
	 */
	@WebMethod(operationName="orderListIFSA")
	public OrderListIFSAReturn orderListIFSA(OrderListIFSAParams r);
	
	/**
	 * IFS A 上传订单信息（物流发货信息）
	 * @return
	 */
	@WebMethod(operationName="orderUploadIFSA")
	public OrderUploadIFSAReturn orderUploadIFSA(OrderUploadIFSAParams r);

	/**
	 * IFS A 批量得到订单补充信息
	 * @return
	 */
	@WebMethod(operationName="dnBatchListIFSA")
	public DnBatchListIFSAReturn dnBatchListIFSA(DnBatchListIFSAParams r);
	
}
