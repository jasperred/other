package com.sunmw.web.bean.machine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sunmw.web.entity.UserLogin;

public interface MachineServices {
	
	/**
	 * 机器查询
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchMachine(Map param, int currentPage, int pageRow);
	
	/**
	 * 检查机号
	 * @param machineNo
	 * @return
	 */
	public String checkMachineNo(String machineNo);
	
	/**
	 * 保存机器信息
	 * @param param
	 * @return
	 */
	public Integer saveMachine(Map param);
	
	/**
	 * 机器信息
	 * @param machineId
	 * @return
	 */
	public Map getMachineInfo(String machineId);
	
	/**
	 * 查询机器类型
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchMachineType(Map param, int currentPage, int pageRow);
	
	/**
	 * 机器类型列表
	 * @return
	 */
	public List machineTypeList();
	
	/**
	 * 检查商品编号
	 * @param machineCd
	 * @return
	 */
	public String checkMachineCd(String machineCd);
	
	/**
	 * 保存机器类型
	 * @param param
	 * @return
	 */
	public Integer saveMachineType(Map param);
	/**
	 * 机器类型信息
	 * @param machineTypeId
	 * @return
	 */
	public Map getMachineTypeInfo(String machineTypeId);
	
	/**
	 * 删除机器类型
	 * @param machineTypeId
	 * @return
	 */
	public boolean deleteMachineType(String machineTypeId);
	
	/**
	 * 维修受理,查询机器信息
	 * @param machineNo
	 * @param ul
	 * @return
	 */
	public Map checkMachine(String machineNo,UserLogin ul);
	
	/**
	 * 得到相应机器分类的保修期
	 * @param machineNo
	 * @return
	 */
	public BigDecimal getServiceDate(String machineCat);

}
