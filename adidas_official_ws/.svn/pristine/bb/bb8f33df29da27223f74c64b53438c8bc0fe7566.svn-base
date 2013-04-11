package com.ami.ec.channel.bean.officialPlugin;

import java.util.Map;

import com.ami.ec.channel.io.impl.ReturnOrder;
import com.ami.ec.channel.io.impl.SalesOrder;

public interface OfficialPluginServices {

	/**
	 * 上传销售订单到official plugin
	 * @param so
	 * @return
	 */
	public Map uploadSalesOrder(SalesOrder so,Long storeId,Long pjId);
	
	/**
	 * 上传退货单到official plugin
	 * @param ro
	 * @return
	 */
	public Map uploadReturnOrder(ReturnOrder ro,Long storeId,Long pjId);
	
	/**
	 * 导出商品文件
	 * @param param
	 * @return
	 */
	public Map exportArticleMasterCsv(Map param);
	
	/**
	 * 得到需要做价格更新的Item列表
	 * @param param
	 * @return
	 */
	public Map priceUpdateItemList(Map param);
	
	/**
	 * 更新价格更新后的Flag状态，更新成功或更新失败
	 * @param param
	 * @return
	 */
	public Map updatePriceUpdateFlag(Map param);

	/**
	 * 得到需要做库存更新的Item列表
	 * @param param
	 * @return
	 */
	public Map inventoryUpdateItemList(Map param);
	
	/**
	 * 更新库存更新后的Flag状态，更新成功或更新失败
	 * @param param
	 * @return
	 */
	public Map updateInventoryUpdateFlag(Map param);
	
	/**
	 * 调用价格更新SP
	 * @param param
	 * @return
	 */
	public Map callPriceUpdateSP(Map param);
	
	
}
