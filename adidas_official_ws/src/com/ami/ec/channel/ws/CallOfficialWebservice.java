package com.ami.ec.channel.ws;

import java.util.Map;

public interface CallOfficialWebservice {

	/**
	 * 上传发货信息
	 * @param param
	 * @return
	 */
	public Map callOfficialDeliverResult(Map param);
	
	/**
	 * 上传退货信息
	 * @param param
	 * @return
	 */
	public Map callOfficialReturnResult(Map param);
	
	/**
	 * 上传库存信息
	 * @param param
	 * @return
	 */
	public Map callOfficialStockSynchronization(Map param);
	
	/**
	 * 上传价格信息
	 * @param param
	 * @return
	 */
	public Map callOfficialPriceSynchronization(Map param);
}
