package com.ami.ec.channel.task;

import java.util.Map;

public interface OfficialTask {
	
	/**
	 * 上传商品主档文件
	 * @param param
	 * @return
	 */
	Map exportArticleMasterCsv(Map param);
	/**
	 * 上传发货实际
	 * @param param
	 * @return
	 */
	Map uploadDeliverResult(Map param);
	/**
	 * 上传库存数据
	 * @param param
	 * @return
	 */
	Map uploadInventory(Map param);
	/**上传价格信息
	 * 
	 * @param param
	 * @return
	 */
	Map uploadPrice(Map param);
	/**
	 * 上传退货实际
	 * @param param
	 * @return
	 */
	Map uploadReturnResult(Map param);

}
