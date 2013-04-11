package com.sunmw.web.action.serviceInvoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.invoice.ServiceInvoiceServices;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class SearchInvoiceAction {
	
	private ServiceInvoiceServices invoiceServices;
	
	private String invoiceCd;
	private String companyName;
	private String invoiceFromDate;
	private String invoiceEndDate;
	private String invoiceNoticeFromDate;
	private String invoiceNoticeEndDate;
	
	private int currentPage = 1;// 当前页
	private int rowCount;// 总行数
	private int pageRow = 15;// 每页显示数

	private List<Map> resultList;// 查询结果

	private String isNext = "TRUE";// 是否有下一页

	private String isBack = "TRUE";// 是否有上一页
	private int pageCount;// 页数
	
	public ServiceInvoiceServices getInvoiceServices() {
		return invoiceServices;
	}

	public void setInvoiceServices(ServiceInvoiceServices invoiceServices) {
		this.invoiceServices = invoiceServices;
	}

	public String getInvoiceCd() {
		return invoiceCd;
	}

	public void setInvoiceCd(String invoiceCd) {
		this.invoiceCd = invoiceCd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInvoiceFromDate() {
		return invoiceFromDate;
	}

	public void setInvoiceFromDate(String invoiceFromDate) {
		this.invoiceFromDate = invoiceFromDate;
	}

	public String getInvoiceEndDate() {
		return invoiceEndDate;
	}

	public void setInvoiceEndDate(String invoiceEndDate) {
		this.invoiceEndDate = invoiceEndDate;
	}

	public String getInvoiceNoticeFromDate() {
		return invoiceNoticeFromDate;
	}

	public void setInvoiceNoticeFromDate(String invoiceNoticeFromDate) {
		this.invoiceNoticeFromDate = invoiceNoticeFromDate;
	}

	public String getInvoiceNoticeEndDate() {
		return invoiceNoticeEndDate;
	}

	public void setInvoiceNoticeEndDate(String invoiceNoticeEndDate) {
		this.invoiceNoticeEndDate = invoiceNoticeEndDate;
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

	public String searchInvoice()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("CompanyName", WebUtil.filterSpecialCharacters(companyName));
			param.put("InvoiceCd",WebUtil.filterSpecialCharacters(invoiceCd));
			param.put("InvoiceFromDate",WebUtil.filterSpecialCharacters(invoiceFromDate));
			param.put("InvoiceEndDate",WebUtil.filterSpecialCharacters(invoiceEndDate));
			param.put("InvoiceNoticeFromDate",WebUtil.filterSpecialCharacters(invoiceNoticeFromDate));
			param.put("InvoiceNoticeEndDate",WebUtil.filterSpecialCharacters(invoiceNoticeEndDate));
			
			Map r = this.invoiceServices.searchServiceInvoice(param, currentPage, pageRow);
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
