package com.sunmw.web.bean.base;

import java.util.List;
import java.util.Map;

import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.UserLogin;

public interface BaseServices {
	
	/**
	 * 状态类型信息
	 * @param unitType
	 * @return
	 */
	public List getUnitList(String unitType);
	
	/**
	 * 故障信息树
	 * @param unitType
	 * @param parentNo
	 * @return
	 */
	public List getTreeUnit(String unitType,String parentNo);
	
	/**
	 * 得到登录用户的未完成任务
	 * @param ul
	 * @param c
	 * @return
	 */
	public Map userLoginMessage(UserLogin ul,Company c);
	
	/**
	 * 机器分类
	 * @return
	 */
	public List getMachineCatList();

}
