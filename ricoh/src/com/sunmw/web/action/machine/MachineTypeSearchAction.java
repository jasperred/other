package com.sunmw.web.action.machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunmw.web.bean.machine.MachineServices;
import com.sunmw.web.util.WebUtil;

public class MachineTypeSearchAction {

	private MachineServices machineServices;
	
	private String machineType;
	private String machineCd;
	private String machineCat;
	private String serviceProviderType;
	private List machineTypeList;

	private int currentPage = 1;// 当前页
	private int rowCount;// 总行数
	private int pageRow = 15;// 每页显示数

	private List<Map> resultList;// 查询结果

	private String isNext = "TRUE";// 是否有下一页

	private String isBack = "TRUE";// 是否有上一页
	private int pageCount;// 页数
	
	
	public MachineServices getMachineServices() {
		return machineServices;
	}

	public void setMachineServices(MachineServices machineServices) {
		this.machineServices = machineServices;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getMachineCd() {
		return machineCd;
	}

	public void setMachineCd(String machineCd) {
		this.machineCd = machineCd;
	}

	public String getMachineCat() {
		return machineCat;
	}

	public void setMachineCat(String machineCat) {
		this.machineCat = machineCat;
	}

	public String getServiceProviderType() {
		return serviceProviderType;
	}

	public void setServiceProviderType(String serviceProviderType) {
		this.serviceProviderType = serviceProviderType;
	}

	public List getMachineTypeList() {
		return machineTypeList;
	}

	public void setMachineTypeList(List machineTypeList) {
		this.machineTypeList = machineTypeList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public List<Map> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map> resultList) {
		this.resultList = resultList;
	}

	public String getIsNext() {
		return isNext;
	}

	public void setIsNext(String isNext) {
		this.isNext = isNext;
	}

	public String getIsBack() {
		return isBack;
	}

	public void setIsBack(String isBack) {
		this.isBack = isBack;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String searchMachineType()
	{
		try {
			Map param = new HashMap();
			param.put("MachineType", WebUtil.filterSpecialCharacters(machineType));
			param.put("MachineCd", WebUtil.filterSpecialCharacters(machineCd));
			param.put("MachineCat", WebUtil.filterSpecialCharacters(machineCat));
			param.put("ServiceProviderType", WebUtil.filterSpecialCharacters(serviceProviderType));
			Map r = this.machineServices.searchMachineType(param, currentPage, pageRow);
			this.rowCount = (Integer) r.get("COUNT_ROW");
			this.resultList = (List) r.get("RESULT");
			countPage();
		} catch (Exception e) {
			if(this.resultList!=null)
				this.resultList.clear();
			this.rowCount = 0;
		}
		return "success";
	}
	
	private void countPage() {
		if (rowCount % this.pageRow == 0)
			pageCount = rowCount / this.pageRow;
		else
			pageCount = rowCount / this.pageRow + 1;// 总页数
		if (currentPage < pageCount)
			isNext = "true";
		else
			isNext = "false";
		if (currentPage > 1)
			isBack = "true";
		else
			isBack = "false";
	}
	
	public void machineTypeList()
	{
		try {
			this.machineTypeList = this.machineServices.machineTypeList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
