package com.ami.ifs.ws.item;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ami.ifs.io.item.ItemBatchListIFSAParams;
import com.ami.ifs.io.item.ItemBatchListIFSAReturn;
import com.ami.ifs.io.item.ItemListIFSAParams;
import com.ami.ifs.io.item.ItemListIFSAReturn;

@WebService(name="ItemServiceForAsp")
public interface ItemServiceForAsp {
	/**
	 * IFS A 批量得到ITEM信息
	 * @return
	 */
	@WebMethod(operationName="itemBatchListIFSA")
	public ItemBatchListIFSAReturn itemBatchListIFSA(ItemBatchListIFSAParams r);
	
	/**
	 * IFS A 按店铺得到ITEM信息
	 * @return
	 */
	@WebMethod(operationName="itemListIFSA")
	public ItemListIFSAReturn itemListIFSA(ItemListIFSAParams r);
}
