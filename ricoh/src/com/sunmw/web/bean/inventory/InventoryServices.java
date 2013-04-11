package com.sunmw.web.bean.inventory;

import java.util.Map;

public interface InventoryServices {

	/**
	 * 查询库存
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchInventory(Map param, int currentPage, int pageRow);
}
