package com.ami.ec.channel.ws;

import javax.jws.WebService;

import com.ami.ec.channel.io.impl.ConditionOrderParams;
import com.ami.ec.channel.io.impl.ConditionOrderReturn;
import com.ami.ec.channel.io.impl.IncrementOrderParams;
import com.ami.ec.channel.io.impl.IncrementOrderReturn;
import com.ami.ec.channel.io.impl.UploadReturnOrderParams;
import com.ami.ec.channel.io.impl.UploadReturnOrderReturn;
import com.ami.ec.channel.io.impl.UploadSalesOrderParams;
import com.ami.ec.channel.io.impl.UploadSalesOrderReturn;
@WebService
public interface OfficialWebservice {
	
	/**
	 * 上传订单
	 * 
	 * @return
	 */
	public String uploadSaleOrder(String userNo,String wsKey,String content);
	
	/**
	 * 上传退货单
	 * 
	 * @return
	 */
	public String uploadReturnOrder(String userNo,String wsKey,String content);
	
	/**
	 * 增量查询订单
	 * @param param
	 * @return
	 */
	public IncrementOrderReturn incrementOrder(IncrementOrderParams param);
	
	/**
	 * 按条件查询订单
	 * @param param
	 * @return
	 */
	public ConditionOrderReturn conditionOrder(ConditionOrderParams param);

}
