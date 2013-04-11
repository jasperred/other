package com.ami.ec.channel.bean.asp;

import java.util.Map;

import com.ami.ec.channel.io.impl.ReturnOrder;
import com.ami.ec.channel.io.impl.SalesOrder;

public interface ForAspServices {
	
	/**
	 * 上传销售订单到official plugin
	 * @param so
	 * @return
	 */
	public Map uploadSalesOrder(SalesOrder so,Long storeId);
	
	/**
	 * 上传退货单到official plugin
	 * @param ro
	 * @return
	 */
	public Map uploadReturnOrder(ReturnOrder ro,Long storeId);
	
	/**
	 * 增量获取订单
	 * @param param
	 * @return
	 */
	public Map incrementOrder(Map param);
	
	/**
	 * 查询订单
	 * @param param
	 * @return
	 */
	public Map searchOrder(Map param);
	
	/**
	 * 获得待发货列表
	 * @param param
	 * @return
	 */
	public Map deliverResultList(Map param);
	
	/**
	 * 更新发货成功和未成功的订单状态
	 * @param param
	 * @return
	 */
	public Map updateDeliverStatus(Map param);

	/**
	 * 获得退货实际列表
	 * @param param
	 * @return
	 */
	public Map returnResultList(Map param);
	
	/**
	 * 更新退货上传成功和未成功的退货单状态
	 * @param param
	 * @return
	 */
	public Map updateReturnStatus(Map param);
}
