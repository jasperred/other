package com.sunmw.web.bean.serviceOrder;

import java.util.Map;

public interface ServiceOrderServices {
	
	/**
	 * 维修单查询
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchServiceOrder(Map param, int currentPage, int pageRow);
	
	/**
	 * 根据店名和状态查询维修单
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchServiceOrderByStatus(Map param, int currentPage, int pageRow);
	
	/**
	 * 机器受理,保存后状态为INIT
	 * @param param
	 * @return
	 */
	public Map createServiceOrder(Map param);
	
	/**
	 * 维修单受理信息
	 * @param serviceId
	 * @return
	 */
	public Map newServiceOrderInfo(Map param);
	
	/**
	 * 发票日期和发票地址保存
	 * @param param
	 * @return
	 */
	public Map invoiceFileUpload(Map param);
	
	/**
	 * 维修单附件地址保存
	 * @param param
	 * @return
	 */
	public Map serviceOrderFileUpload(Map param);
	
	/**
	 * 保存维修内容
	 * @param param
	 * @return
	 */
	public Map saveServiceOrder(Map param);
	
	/**
	 * 申请不通过后保存
	 * @param param
	 * @return
	 */
	public Map saveServiceOrderItem(Map param);
	
	/**
	 * 取消维修单
	 * @param param
	 * @return
	 */
	public Map cancelServiceOrder(Map param);
	
	/**
	 * 零件或换机申请
	 * @param param
	 * @return
	 */
	public Map partOrMachineApply(Map param);
	
	/**
	 * 维修单完成
	 * @param param
	 * @return
	 */
	public Map finishServiceOrder(Map param);

}
