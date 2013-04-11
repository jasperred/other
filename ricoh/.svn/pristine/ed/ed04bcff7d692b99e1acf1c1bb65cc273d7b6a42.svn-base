package com.sunmw.web.bean.machine;

import java.util.List;
import java.util.Map;

public interface MachineImportServices {

	/**
	 * EXCEED从文件导入临时表
	 * @param exceedList
	 * @return
	 */
	public List<String> importTempExceed(Map param);
	
	/**
	 * EXCEED从临时表导入,这个方法会单独使用
	 * @return
	 */
	public List<String> importExceed();
	
	/**
	 * 服务费从文件导入临时表,导入前删除之前成功导入临时表内容
	 * @param serviceRateList
	 * @return
	 */
	public List<String> importTempServiceRate(Map param);
	
	/**
	 * 从临时表导入服务费
	 * @return
	 */
	public List<String> importServiceRate();
	
	/**
	 * 维修能力从文件导入临时表,导入前删除临时表内容
	 * @param cmtrList
	 * @return
	 */
	public List<String> importTempCompanyMachineTypeRef(Map param);
	
	/**
	 * 从临时表导入维修能力,以公司ID为KEY,先删除再插入
	 * @return
	 */
	public List<String> importCompanyMachineTypeRef();
}
