package com.ami.ec.channel.dao.asp;

import java.util.List;
import java.util.Map;

import com.ami.ec.channel.domain.asp.OrderHeadForWs;

public interface WsOrderSearchMapper {
	/**
	 * 增加查询订单
	 * @param param
	 * @return
	 */
	List<OrderHeadForWs> selectByIncrement(Map param);
	
	/**
	 * 查询符合条件的订单ID
	 * @param param
	 * @return
	 */
	List<Integer> selectByIncrementCount(Map param);
	
	/**
	 * 按条件查询订单
	 * @param param
	 * @return
	 */
	List<OrderHeadForWs> selectByCondition(Map param);
	

	/**
	 * 发货列表
	 * @param param
	 * @return
	 */
	List<Map> selectByDeliverResult(Map param);
	
	/**
	 * 退货列表
	 * @param param
	 * @return
	 */
	List<Map> selectByReturnResult(Map param);
}
