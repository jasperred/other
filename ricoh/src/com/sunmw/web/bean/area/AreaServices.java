package com.sunmw.web.bean.area;

import java.util.List;
import java.util.Map;

import com.sunmw.web.entity.Area;
import com.sunmw.web.entity.Province;

public interface AreaServices {
	

	/**
	 * 区域列表
	 * @return
	 */
	public List<Area> areaList();
	
	/**
	 * 查询区域
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchArea(Map param, int currentPage, int pageRow);
	
	/**
	 * 省份列表
	 */
	public List<Province> provinceList();
	
	/**
	 * 省份列表
	 * @param areaCd
	 * @return
	 */
	public List<Province> provinceList(String areaCd);
	
	/**
	 * 区域所包含的省份
	 * @param areaCd
	 * @return
	 */
	public List<Map> areaProvinceList(String areaCd);
	
	/**
	 * 保存区域
	 * @param areaCd
	 * @param areaName
	 * @return
	 */
	public String saveArea(String areaCd,String areaName);
	
	/**
	 * 保存区域省份
	 * @param areaCd
	 * @param provinceIds
	 * @return
	 */
	public String saveAreaProvince(String areaCd,String provinceIds);
	
	/**
	 * 删除区域
	 * @param areaCd
	 * @return
	 */
	public String deleteArea(String areaCd);

}
