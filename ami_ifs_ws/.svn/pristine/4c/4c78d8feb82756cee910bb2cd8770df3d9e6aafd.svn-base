package com.ami.ifs.ws.item;

import javax.jws.WebService;

import com.ami.ifs.io.item.InventoryAndPriceBatchListIFSCParams;
import com.ami.ifs.io.item.InventoryAndPriceBatchListIFSCReturn;
import com.ami.ifs.io.item.InventoryAndPriceListIFSCParams;
import com.ami.ifs.io.item.InventoryAndPriceListIFSCReturn;

@WebService(name="InventoryAndPriceServiceForEc")
public interface InventoryAndPriceServiceForEc {

	
	/**
	 * IFS C 批量得到库存和价格更新列表
	 * @return
	 */
	public InventoryAndPriceBatchListIFSCReturn inventoryAndPriceBatchListIFSC(InventoryAndPriceBatchListIFSCParams r);
	
	/**
	 * IFS C 按店铺得到库存和价格更新列表
	 * @return
	 */
	public InventoryAndPriceListIFSCReturn inventoryAndPriceListIFSC(InventoryAndPriceListIFSCParams r);
}
