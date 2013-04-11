package com.ami.ifs.ws.item;

import javax.jws.WebService;

import com.ami.ifs.io.item.InventoryUploadIFSAParams;
import com.ami.ifs.io.item.InventoryUploadIFSAReturn;
import com.ami.ifs.io.item.PriceUploadIFSAParams;
import com.ami.ifs.io.item.PriceUploadIFSAReturn;

@WebService(name="InventoryAndPriceServiceForAsp")
public interface InventoryAndPriceServiceForAsp {
	
	/**
	 * IFS A 上传库存信息
	 * @return
	 */
	public InventoryUploadIFSAReturn inventoryUploadIFSA(InventoryUploadIFSAParams r);
	
	/**
	 * IFS A 上传价格信息
	 * @return
	 */
	public PriceUploadIFSAReturn priceUploadIFSA(PriceUploadIFSAParams r);

}
