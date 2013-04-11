package com.sunmw.web.action.serviceInvoice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.invoice.ServiceInvoiceServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class InvoiceInfoAction {

	private ServiceInvoiceServices invoiceServices;

	private String invoiceId;
	private String invoiceCd;
	private String invoiceDate;
	private String invoiceNoticeDate;
	private String invoiceNoticePerson;
	private String invoiceReceiveDate;
	private String invoiceStatus;
	private String invoiceUrl;
	private String companyId;
	private String companyName;
	private String fromDate;
	private String endDate;
	private String homeAmt;
	private String otherAmt;
	private String serviceAmt;
	private String paymentDate;
	private String totalAmt;
	private String memo;
	private List invoiceItemList;

	private String message;
	private String crumb;

	public ServiceInvoiceServices getInvoiceServices() {
		return invoiceServices;
	}

	public void setInvoiceServices(ServiceInvoiceServices invoiceServices) {
		this.invoiceServices = invoiceServices;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceCd() {
		return invoiceCd;
	}

	public void setInvoiceCd(String invoiceCd) {
		this.invoiceCd = invoiceCd;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNoticeDate() {
		return invoiceNoticeDate;
	}

	public void setInvoiceNoticeDate(String invoiceNoticeDate) {
		this.invoiceNoticeDate = invoiceNoticeDate;
	}

	public String getInvoiceNoticePerson() {
		return invoiceNoticePerson;
	}

	public void setInvoiceNoticePerson(String invoiceNoticePerson) {
		this.invoiceNoticePerson = invoiceNoticePerson;
	}

	public String getInvoiceReceiveDate() {
		return invoiceReceiveDate;
	}

	public void setInvoiceReceiveDate(String invoiceReceiveDate) {
		this.invoiceReceiveDate = invoiceReceiveDate;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getHomeAmt() {
		return homeAmt;
	}

	public void setHomeAmt(String homeAmt) {
		this.homeAmt = homeAmt;
	}

	public String getOtherAmt() {
		return otherAmt;
	}

	public void setOtherAmt(String otherAmt) {
		this.otherAmt = otherAmt;
	}

	public String getServiceAmt() {
		return serviceAmt;
	}

	public void setServiceAmt(String serviceAmt) {
		this.serviceAmt = serviceAmt;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List getInvoiceItemList() {
		return invoiceItemList;
	}

	public void setInvoiceItemList(List invoiceItemList) {
		this.invoiceItemList = invoiceItemList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCrumb() {
		return crumb;
	}

	public void setCrumb(String crumb) {
		this.crumb = crumb;
	}

	public String invoiceInfo() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("InvoiceId", WebUtil.filterSpecialCharacters(invoiceId));
			Map r = this.invoiceServices.invoiceInfo(param);
			if (r.get("Flag").equals("ERROR")) {
				invoiceId = null;
				invoiceCd = null;
				invoiceDate = null;
				invoiceNoticeDate = null;
				invoiceNoticePerson = null;
				invoiceReceiveDate = null;
				invoiceStatus = null;
				invoiceUrl = null;
				companyId = null;
				companyName = null;
				fromDate = null;
				endDate = null;
				homeAmt = null;
				otherAmt = null;
				serviceAmt = null;
				paymentDate = null;
				totalAmt = null;
				invoiceItemList = null;
				message = (String) r.get("Message");
			} else {
				invoiceId = WebUtil.replaceSpecialCharacters(r.get("InvoiceId").toString());
				invoiceCd = WebUtil.replaceSpecialCharacters((String) r.get("InvoiceCd"));
				if (WebUtil.isNotNull(r.get("InvoiceDate")))
					invoiceDate = WebUtil.formatDateString((Date) r
							.get("InvoiceDate"), "yyyy-MM-dd");
				else
					invoiceDate = "";
				if (WebUtil.isNotNull(r.get("InvoiceNoticeDate")))
					invoiceNoticeDate = WebUtil.formatDateString((Date) r
							.get("InvoiceNoticeDate"), "yyyy-MM-dd");
				else
					invoiceNoticeDate = "";
				invoiceNoticePerson = WebUtil.replaceSpecialCharacters((String) r.get("InvoiceNoticePerson"));
				if (WebUtil.isNotNull(r.get("InvoiceReceiveDate")))
					invoiceReceiveDate = WebUtil.formatDateString((Date) r
							.get("InvoiceReceiveDate"), "yyyy-MM-dd");
				else
					invoiceReceiveDate = "";
				invoiceStatus = WebUtil.replaceSpecialCharacters((String) r.get("InvoiceStatus"));
				if (WebUtil.isNotNull(r.get("InvoiceUrl")))
					invoiceUrl = WebConfigProperties.getProperties("file.upload.url")+ r.get("InvoiceUrl");
				else
					invoiceUrl = "";
				if (WebUtil.isNotNull(r.get("CompanyId")))
					companyId = WebUtil.replaceSpecialCharacters(r.get("CompanyId").toString());
				else
					companyId = "";
				companyName = WebUtil.replaceSpecialCharacters((String) r.get("CompanyName"));
				if (WebUtil.isNotNull(r.get("FromDate")))
					fromDate = WebUtil.formatDateString((Date) r.get("FromDate"),
							"yyyy-MM-dd");
				else
					fromDate = "";
				if (WebUtil.isNotNull(r.get("EndDate")))
					endDate = WebUtil.formatDateString((Date) r.get("EndDate"),
							"yyyy-MM-dd");
				else
					endDate = "";
				if (WebUtil.isNotNull(r.get("HomeAmt")))
					homeAmt = WebUtil.replaceSpecialCharacters(r.get("HomeAmt").toString());
				else
					homeAmt = "";
				if (WebUtil.isNotNull(r.get("OtherAmt")))
					otherAmt = WebUtil.replaceSpecialCharacters(r.get("OtherAmt").toString());
				else
					otherAmt = "";
				if (WebUtil.isNotNull(r.get("ServiceAmt")))
					serviceAmt = WebUtil.replaceSpecialCharacters(r.get("ServiceAmt").toString());
				else
					serviceAmt = "";
				if (WebUtil.isNotNull(r.get("PaymentDate")))
					paymentDate = WebUtil.formatDateString((Date) r
							.get("PaymentDate"), "yyyy-MM-dd");
				else
					paymentDate = "";
				if (WebUtil.isNotNull(r.get("TotalAmt")))
					totalAmt = WebUtil.replaceSpecialCharacters(r.get("TotalAmt").toString());
				else
					totalAmt = "";
				if (WebUtil.isNotNull(r.get("Memo")))
					memo = WebUtil.replaceSpecialCharacters(r.get("Memo").toString());
				else
					memo = "";
				invoiceItemList = (List) r.get("InvoiceItemList");
				message = null;
			}
		} catch (Exception e) {

			message = MessageInfo.OperationType;
		}
		return "success";
	}

	public String previewInvoiceInfo() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("CompanyId", WebUtil.filterSpecialCharacters(companyId));
			param.put("FromDate", WebUtil.filterSpecialCharacters(fromDate));
			param.put("EndDate", WebUtil.filterSpecialCharacters(endDate));
			Map r = this.invoiceServices.previewInvoiceServiceOrder(param);
			if (r.get("Flag").equals("ERROR")) {
				invoiceId = null;
				invoiceCd = null;
				invoiceDate = null;
				invoiceNoticeDate = null;
				invoiceNoticePerson = null;
				invoiceReceiveDate = null;
				invoiceStatus = null;
				invoiceUrl = null;
				companyId = null;
				companyName = null;
				fromDate = null;
				endDate = null;
				homeAmt = null;
				otherAmt = null;
				serviceAmt = null;
				paymentDate = null;
				totalAmt = null;
				memo = null;
				invoiceItemList = null;
				message = (String) r.get("Message");
				return "error";
			} else {
				if (WebUtil.isNotNull(r.get("InvoiceId")))
					invoiceId = WebUtil.replaceSpecialCharacters(r.get("InvoiceId").toString());
				else
					invoiceId = "";
				invoiceCd = WebUtil.replaceSpecialCharacters((String) r.get("InvoiceCd"));
				if (WebUtil.isNotNull(r.get("InvoiceDate")))
					invoiceDate = WebUtil.formatDateString((Date) r
							.get("InvoiceDate"), "yyyy-MM-dd");
				else
					invoiceDate = "";
				if (WebUtil.isNotNull(r.get("InvoiceNoticeDate")))
					invoiceNoticeDate = WebUtil.formatDateString((Date) r
							.get("InvoiceNoticeDate"), "yyyy-MM-dd");
				else
					invoiceNoticeDate = "";
				invoiceNoticePerson = (String) r.get("InvoiceNoticePerson");
				if (WebUtil.isNotNull(r.get("InvoiceReceiveDate")))
					invoiceReceiveDate = WebUtil.formatDateString((Date) r
							.get("InvoiceReceiveDate"), "yyyy-MM-dd");
				else
					invoiceReceiveDate = "";
				invoiceStatus = WebUtil.replaceSpecialCharacters((String) r.get("InvoiceStatus"));
				if (WebUtil.isNotNull(r.get("InvoiceUrl")))
					invoiceUrl = WebUtil.replaceSpecialCharacters(WebConfigProperties
							.getProperties("file.upload.url")
							+ r.get("InvoiceUrl"));
				else
					invoiceUrl = "";
				if (WebUtil.isNotNull(r.get("CompanyId")))
					companyId = WebUtil.replaceSpecialCharacters(r.get("CompanyId").toString());
				else
					companyId = "";
				companyName = WebUtil.replaceSpecialCharacters((String) r.get("CompanyName"));
				if (WebUtil.isNotNull(r.get("FromDate")))
					fromDate = WebUtil.formatDateString((Date) r.get("FromDate"),
							"yyyy-MM-dd");
				else
					fromDate = "";
				if (WebUtil.isNotNull(r.get("EndDate")))
					endDate = WebUtil.formatDateString((Date) r.get("EndDate"),
							"yyyy-MM-dd");
				else
					endDate = "";
				if (WebUtil.isNotNull(r.get("HomeAmt")))
					homeAmt = WebUtil.replaceSpecialCharacters(r.get("HomeAmt").toString());
				else
					homeAmt = "";
				if (WebUtil.isNotNull(r.get("OtherAmt")))
					otherAmt = WebUtil.replaceSpecialCharacters(r.get("OtherAmt").toString());
				else
					otherAmt = "";
				if (WebUtil.isNotNull(r.get("ServiceAmt")))
					serviceAmt = WebUtil.replaceSpecialCharacters(r.get("ServiceAmt").toString());
				else
					serviceAmt = "";
				paymentDate = WebUtil.replaceSpecialCharacters((String) r.get("PaymentDate"));
				if (WebUtil.isNotNull(r.get("TotalAmt")))
					totalAmt = WebUtil.replaceSpecialCharacters(r.get("TotalAmt").toString());
				else
					totalAmt = "";
				if (WebUtil.isNotNull(r.get("TotalAmt")))
					totalAmt = WebUtil.replaceSpecialCharacters(r.get("TotalAmt").toString());
				else
					totalAmt = "";
				memo = "";
				invoiceItemList = (List) r.get("InvoiceItemList");
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}

	public String generateInvoice() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("CompanyId", WebUtil.filterSpecialCharacters(companyId));
			param.put("FromDate", WebUtil.filterSpecialCharacters(fromDate));
			param.put("EndDate", WebUtil.filterSpecialCharacters(endDate));
			//param.put("InvoiceDate", invoiceDate);
			param.put("InvoiceCd", invoiceCd);
			param.put("Memo", WebUtil.filterSpecialCharacters(memo));
			Map r = this.invoiceServices.generateInvoiceServiceOrder(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				invoiceId = r.get("InvoiceId").toString();
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}

	public String saveInvoice() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("InvoiceId", WebUtil.filterSpecialCharacters(invoiceId));
			param.put("InvoiceReceiveDate", WebUtil.filterSpecialCharacters(invoiceReceiveDate));
			param.put("PaymentDate", WebUtil.filterSpecialCharacters(paymentDate));
			param.put("Memo", WebUtil.filterSpecialCharacters(memo));
			Map r = this.invoiceServices.saveInvoiceInfo(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
			} else {
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}

	public String completeInvoice() {

		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("InvoiceId", WebUtil.filterSpecialCharacters(invoiceId));
			param.put("InvoiceDate", WebUtil.filterSpecialCharacters(invoiceDate));
			param.put("InvoiceReceiveDate", WebUtil.filterSpecialCharacters(invoiceReceiveDate));
			param.put("PaymentDate", WebUtil.filterSpecialCharacters(paymentDate));
			param.put("Memo", WebUtil.filterSpecialCharacters(memo));
			Map r = this.invoiceServices.completeInvoice(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
			} else {
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";

	}

}
