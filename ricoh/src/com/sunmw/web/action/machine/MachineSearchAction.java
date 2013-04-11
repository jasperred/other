package com.sunmw.web.action.machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.machine.MachineServices;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class MachineSearchAction {
	
	private MachineServices machineServices;
	
	private String machineNo;
	private String ppsNo;
	private String machineTypeId;
	private String machineCd;
	private String fromOutDate;
	private String endOutDate;
	private String customerName;

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

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getPpsNo() {
		return ppsNo;
	}

	public void setPpsNo(String ppsNo) {
		this.ppsNo = ppsNo;
	}

	public String getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(String machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getMachineCd() {
		return machineCd;
	}

	public void setMachineCd(String machineCd) {
		this.machineCd = machineCd;
	}

	public String getFromOutDate() {
		return fromOutDate;
	}

	public void setFromOutDate(String fromOutDate) {
		this.fromOutDate = fromOutDate;
	}

	public String getEndOutDate() {
		return endOutDate;
	}

	public void setEndOutDate(String endOutDate) {
		this.endOutDate = endOutDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String searchMachine()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("MachineNo", WebUtil.filterSpecialCharacters(machineNo));
			param.put("PpsNo", WebUtil.filterSpecialCharacters(ppsNo));
			param.put("MachineTypeId", WebUtil.filterSpecialCharacters(machineTypeId));
			param.put("MachineCd", WebUtil.filterSpecialCharacters(machineCd));
			param.put("FromOutDate", WebUtil.filterSpecialCharacters(fromOutDate));
			param.put("EndOutDate", WebUtil.filterSpecialCharacters(endOutDate));
			param.put("CustomerName",WebUtil.filterSpecialCharacters( customerName));
			param.put("UserLogin", ul);
			Map r = this.machineServices.searchMachine(param, currentPage, pageRow);
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
}
