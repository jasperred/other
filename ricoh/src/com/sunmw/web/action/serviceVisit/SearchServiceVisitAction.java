package com.sunmw.web.action.serviceVisit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceCsServices;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class SearchServiceVisitAction {
	
	private ServiceCsServices serviceVisitServices;
	
	private String companyName;
	private String visitPeople;
	private String serviceNo;
	private String visitFromDate;
	private String visitEndDate;
	
	private int currentPage = 1;// 当前页
	private int rowCount;// 总行数
	private int pageRow = 15;// 每页显示数

	private List<Map> resultList;// 查询结果

	private String isNext = "TRUE";// 是否有下一页

	private String isBack = "TRUE";// 是否有上一页
	private int pageCount;// 页数
	
	public ServiceCsServices getServiceVisitServices() {
		return serviceVisitServices;
	}

	public void setServiceVisitServices(ServiceCsServices serviceVisitServices) {
		this.serviceVisitServices = serviceVisitServices;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getVisitPeople() {
		return visitPeople;
	}

	public void setVisitPeople(String visitPeople) {
		this.visitPeople = visitPeople;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getVisitFromDate() {
		return visitFromDate;
	}

	public void setVisitFromDate(String visitFromDate) {
		this.visitFromDate = visitFromDate;
	}

	public String getVisitEndDate() {
		return visitEndDate;
	}

	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
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

	public String searchVisit()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("CompanyName", WebUtil.filterSpecialCharacters(companyName));
			param.put("VisitPeople",WebUtil.filterSpecialCharacters(visitPeople));
			param.put("ServiceNo",WebUtil.filterSpecialCharacters(serviceNo));
			param.put("VisitFromDate",WebUtil.filterSpecialCharacters(visitFromDate));
			param.put("VisitEndDate",WebUtil.filterSpecialCharacters(visitEndDate));
			
			Map r = this.serviceVisitServices.searchServiceVisit(param, currentPage, pageRow);
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
