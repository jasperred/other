package com.sunmw.web.action.serviceOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class SearchServiceOrderAction {
	
	private ServiceOrderServices serviceOrderServices;
	
	private String shopName;
	private String fixPeople;
	private String serviceNo;
	private String machineNo;
	private String machineTypeId;
	private String serviceDateStatus;
	private String serviceMethod;
	private String serviceContract;
	private String serviceOperation;
	private String customerName;
	private String thruTime;
	private String actionNo;
	private String symptomNo;
	private String causeNo;
	private String locationNo;
	private String serviceStatus;
	private String itemNo;
	private String fromServiceDate;
	private String endServiceDate;
	private String fromServiceFinishDate;
	private String endServiceFinishDate;
	private String fromCustomerRetrieveDate;
	private String endCustomerRetrieveDate;
	
	private int currentPage = 1;// 当前页
	private int rowCount;// 总行数
	private int pageRow = 15;// 每页显示数

	private List<Map> resultList;// 查询结果

	private String isNext = "TRUE";// 是否有下一页

	private String isBack = "TRUE";// 是否有上一页
	private int pageCount;// 页数
	
	public ServiceOrderServices getServiceOrderServices() {
		return serviceOrderServices;
	}

	public void setServiceOrderServices(ServiceOrderServices serviceOrderServices) {
		this.serviceOrderServices = serviceOrderServices;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getFixPeople() {
		return fixPeople;
	}

	public void setFixPeople(String fixPeople) {
		this.fixPeople = fixPeople;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(String machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getServiceDateStatus() {
		return serviceDateStatus;
	}

	public void setServiceDateStatus(String serviceDateStatus) {
		this.serviceDateStatus = serviceDateStatus;
	}

	public String getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public String getServiceContract() {
		return serviceContract;
	}

	public void setServiceContract(String serviceContract) {
		this.serviceContract = serviceContract;
	}

	public String getServiceOperation() {
		return serviceOperation;
	}

	public void setServiceOperation(String serviceOperation) {
		this.serviceOperation = serviceOperation;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getThruTime() {
		return thruTime;
	}

	public void setThruTime(String thruTime) {
		this.thruTime = thruTime;
	}

	public String getActionNo() {
		return actionNo;
	}

	public void setActionNo(String actionNo) {
		this.actionNo = actionNo;
	}

	public String getSymptomNo() {
		return symptomNo;
	}

	public void setSymptomNo(String symptomNo) {
		this.symptomNo = symptomNo;
	}

	public String getCauseNo() {
		return causeNo;
	}

	public void setCauseNo(String causeNo) {
		this.causeNo = causeNo;
	}

	public String getLocationNo() {
		return locationNo;
	}

	public void setLocationNo(String locationNo) {
		this.locationNo = locationNo;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getFromServiceDate() {
		return fromServiceDate;
	}

	public void setFromServiceDate(String fromServiceDate) {
		this.fromServiceDate = fromServiceDate;
	}

	public String getEndServiceDate() {
		return endServiceDate;
	}

	public void setEndServiceDate(String endServiceDate) {
		this.endServiceDate = endServiceDate;
	}

	public String getFromServiceFinishDate() {
		return fromServiceFinishDate;
	}

	public void setFromServiceFinishDate(String fromServiceFinishDate) {
		this.fromServiceFinishDate = fromServiceFinishDate;
	}

	public String getEndServiceFinishDate() {
		return endServiceFinishDate;
	}

	public void setEndServiceFinishDate(String endServiceFinishDate) {
		this.endServiceFinishDate = endServiceFinishDate;
	}

	public String getFromCustomerRetrieveDate() {
		return fromCustomerRetrieveDate;
	}

	public void setFromCustomerRetrieveDate(String fromCustomerRetrieveDate) {
		this.fromCustomerRetrieveDate = fromCustomerRetrieveDate;
	}

	public String getEndCustomerRetrieveDate() {
		return endCustomerRetrieveDate;
	}

	public void setEndCustomerRetrieveDate(String endCustomerRetrieveDate) {
		this.endCustomerRetrieveDate = endCustomerRetrieveDate;
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

	public String searchServiceOrder()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ShopName",WebUtil.filterSpecialCharacters(shopName));
			param.put("FixPeople",WebUtil.filterSpecialCharacters(fixPeople));
			param.put("ServiceNo",WebUtil.filterSpecialCharacters(serviceNo));
			param.put("MachineNo",WebUtil.filterSpecialCharacters(machineNo));
			param.put("MachineTypeId",WebUtil.filterSpecialCharacters(machineTypeId));
			param.put("ServiceDateStatus",WebUtil.filterSpecialCharacters(serviceDateStatus));
			param.put("ServiceMethod",WebUtil.filterSpecialCharacters(serviceMethod));
			param.put("ServiceContract",WebUtil.filterSpecialCharacters(serviceContract));
			param.put("ServiceOperation",WebUtil.filterSpecialCharacters(serviceOperation));
			param.put("CustomerName",WebUtil.filterSpecialCharacters(customerName));
			param.put("ThruTime",WebUtil.filterSpecialCharacters(thruTime));
			param.put("ActionNo",WebUtil.filterSpecialCharacters(actionNo));
			param.put("SymptomNo",WebUtil.filterSpecialCharacters(symptomNo));
			param.put("CauseNo",WebUtil.filterSpecialCharacters(causeNo));
			param.put("LocationNo",WebUtil.filterSpecialCharacters(locationNo));
			param.put("ServiceStatus",WebUtil.filterSpecialCharacters(serviceStatus));
			param.put("ItemNo",WebUtil.filterSpecialCharacters(itemNo));
			param.put("FromServiceDate",WebUtil.filterSpecialCharacters(fromServiceDate));
			param.put("EndServiceDate",WebUtil.filterSpecialCharacters(endServiceDate));
			param.put("FromServiceFinishDate",WebUtil.filterSpecialCharacters(fromServiceFinishDate));
			param.put("EndServiceFinishDate",WebUtil.filterSpecialCharacters(endServiceFinishDate));
			param.put("FromCustomerRetrieveDate",WebUtil.filterSpecialCharacters(fromCustomerRetrieveDate));
			param.put("EndCustomerRetrieveDate",WebUtil.filterSpecialCharacters(endCustomerRetrieveDate));
			Map r = this.serviceOrderServices.searchServiceOrder(param, currentPage, pageRow);
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
	
	public String searchServiceOrderByStatus()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ShopName",WebUtil.filterSpecialCharacters(shopName));
			param.put("ServiceStatus",WebUtil.filterSpecialCharacters(serviceStatus));
			
			Map r = this.serviceOrderServices.searchServiceOrderByStatus(param, currentPage, pageRow);
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
