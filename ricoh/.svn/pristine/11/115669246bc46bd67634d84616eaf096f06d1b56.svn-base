package com.sunmw.web.bean.serviceOrder;

import java.util.Map;

public interface ServiceApplyServices {

	/**
	 * 维修单申请查询
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchServiceApply(Map param, int currentPage, int pageRow);
	/**
	 * 维修单申请
	 * @param param
	 * @return
	 */
	public Map createServiceApplyByPartAndMachine(Map param);
	
	
	/**
	 * 维修单费用申请
	 * @param param
	 * @return
	 */
	public Map createServiceApplyByRate(Map param);

	/**
	 * 检查维修单费用是否可申请
	 * @param serviceId
	 * @return
	 */
	public Map checkServiceApplyByRate(String serviceId);
	/**
	 * 维修单申请信息
	 * @param param
	 * @return
	 */
	public Map serviceApplyInfo(Map param);
	
	/**
	 * 维修单申请审核
	 * @param param
	 * @return
	 */
	public Map auditedServiceApply(Map param);
	
	/**
	 * 维修单申述
	 * @param param
	 * @return
	 */
	public Map reApplyService(Map param);
	
	/**
	 * 维修单申请文件上传
	 * @param param
	 * @return
	 */
	public Map serviceApplyFileUpload(Map param);
	
	/**
	 * 保存维修单零件返回信息
	 * @param param
	 * @return
	 */
	public Map saveServiceApplyReturn(Map param);
}
