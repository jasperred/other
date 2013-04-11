package com.sunmw.web.action.serviceDelivery;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceDeliveryServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class ServiceDeliveryInfoAction {

	private ServiceDeliveryServices serviceDeliveryServices;

	private String serviceDeliveryId;
	private String allTime;
	private String auditedTime;
	private String companyId;
	private String companyName;
	private String ctime;
	private String cuser;
	private String deliveryTime;
	private String department;
	private String serviceApplyId;
	private String serviceId;
	private String serviceNo;
	private String shippingNo;
	private String status;
	private String statusName;
	private String serviceDeliveryNo;
	private String serviceApplyNo;
	private String deliveryStock;
	private String deliveryDate;
	private String serviceApplyAuditedUser;

	private List serviceDeliveryItemList;
	private List serviceDeliveryFileList;
	private List serviceApplyFileList;

	private String message;

	private String fileUploadUrl;

	public String getFileUploadUrl() {
		return fileUploadUrl;
	}

	public void setFileUploadUrl(String fileUploadUrl) {
		this.fileUploadUrl = fileUploadUrl;
	}

	public ServiceDeliveryServices getServiceDeliveryServices() {
		return serviceDeliveryServices;
	}

	public void setServiceDeliveryServices(
			ServiceDeliveryServices serviceDeliveryServices) {
		this.serviceDeliveryServices = serviceDeliveryServices;
	}

	public String getServiceDeliveryId() {
		return serviceDeliveryId;
	}

	public void setServiceDeliveryId(String serviceDeliveryId) {
		this.serviceDeliveryId = serviceDeliveryId;
	}

	public String getAllTime() {
		return allTime;
	}

	public void setAllTime(String allTime) {
		this.allTime = allTime;
	}

	public String getAuditedTime() {
		return auditedTime;
	}

	public void setAuditedTime(String auditedTime) {
		this.auditedTime = auditedTime;
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

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getServiceDeliveryNo() {
		return serviceDeliveryNo;
	}

	public void setServiceDeliveryNo(String serviceDeliveryNo) {
		this.serviceDeliveryNo = serviceDeliveryNo;
	}

	public String getServiceApplyNo() {
		return serviceApplyNo;
	}

	public void setServiceApplyNo(String serviceApplyNo) {
		this.serviceApplyNo = serviceApplyNo;
	}

	public String getDeliveryStock() {
		return deliveryStock;
	}

	public void setDeliveryStock(String deliveryStock) {
		this.deliveryStock = deliveryStock;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getServiceApplyAuditedUser() {
		return serviceApplyAuditedUser;
	}

	public void setServiceApplyAuditedUser(String serviceApplyAuditedUser) {
		this.serviceApplyAuditedUser = serviceApplyAuditedUser;
	}

	public List getServiceDeliveryItemList() {
		return serviceDeliveryItemList;
	}

	public void setServiceDeliveryItemList(List serviceDeliveryItemList) {
		this.serviceDeliveryItemList = serviceDeliveryItemList;
	}

	public List getServiceDeliveryFileList() {
		return serviceDeliveryFileList;
	}

	public void setServiceDeliveryFileList(List serviceDeliveryFileList) {
		this.serviceDeliveryFileList = serviceDeliveryFileList;
	}


	public List getServiceApplyFileList() {
		return serviceApplyFileList;
	}

	public void setServiceApplyFileList(List serviceApplyFileList) {
		this.serviceApplyFileList = serviceApplyFileList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String serviceDeliveryInfoByScm() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "SCM");
			Map r = serviceDeliveryServices.serviceDeliveryInfo(param);
			String flag = (String) r.get("Flag");
			if (flag.equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				fileUploadUrl = WebConfigProperties.getProperties("file.upload.url");
				if(WebUtil.isNotNull(r.get("ServiceDeliveryId")))
					serviceDeliveryId =  WebUtil.replaceSpecialCharacters(r.get("ServiceDeliveryId").toString());
				else
					serviceDeliveryId = "";
				allTime = WebUtil.replaceSpecialCharacters((String) r.get("AllTime"));
				auditedTime = (WebUtil.replaceSpecialCharacters((String) r.get("AuditedTime")));
				if (WebUtil.isNotNull(r.get("CompanyId")))
					companyId = WebUtil.replaceSpecialCharacters(r.get("CompanyId").toString());
				else
					companyId = "";
				companyName = (WebUtil.replaceSpecialCharacters((String) r.get("CompanyName")));
				if (WebUtil.isNotNull(r.get("Ctime")))
					ctime = WebUtil.formatDateString((Date) r.get("Ctime"),
							"yyyy-MM-dd HH:mm");
				else
					ctime = "";
				cuser = WebUtil.replaceSpecialCharacters((String) r.get("Cuser"));
				deliveryTime = WebUtil.replaceSpecialCharacters((String) r.get("DeliveryTime"));
				department = WebUtil.replaceSpecialCharacters((String) r.get("Department"));
				if (WebUtil.isNotNull(r.get("ServiceApplyId")))
					serviceApplyId = WebUtil.replaceSpecialCharacters(r.get("ServiceApplyId").toString());
				else
					serviceApplyId = "";
				if (WebUtil.isNotNull(r.get("ServiceId")))
					serviceId = WebUtil.replaceSpecialCharacters(r.get("ServiceId").toString());
				else
					serviceId = "";
				serviceNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceNo"));
				shippingNo = WebUtil.replaceSpecialCharacters((String) r.get("ShippingNo"));
				status = WebUtil.replaceSpecialCharacters((String) r.get("Status"));
				serviceApplyAuditedUser = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyAuditedUser"));
				statusName = WebUtil.replaceSpecialCharacters((String) r.get("StatusName"));
				serviceDeliveryNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceDeliveryNo"));
				serviceApplyNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyNo"));
				deliveryStock = WebUtil.replaceSpecialCharacters((String)r.get("DeliveryStock"));
				if(WebUtil.isNotNull(r.get("DeliveryDate")))
					deliveryDate = WebUtil.formatDateString((Date)r.get("DeliveryDate"), "yyyy-MM-dd");
				else
					deliveryDate = null;
				serviceDeliveryItemList = (List) r.get("ServiceDeliveryItemList");
				serviceDeliveryFileList = (List) r.get("ServiceDeliveryFileList");
				serviceApplyFileList = (List) r.get("ServiceApplyFileList");
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	
	public String serviceDeliveryInfoByCspc() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "CSPC");
			Map r = serviceDeliveryServices.serviceDeliveryInfo(param);
			String flag = (String) r.get("Flag");
			if (flag.equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				fileUploadUrl = WebConfigProperties.getProperties("file.upload.url");
				if(WebUtil.isNotNull(r.get("ServiceDeliveryId")))
					serviceDeliveryId =  WebUtil.replaceSpecialCharacters(r.get("ServiceDeliveryId").toString());
				else
					serviceDeliveryId = "";
				allTime = WebUtil.replaceSpecialCharacters((String) r.get("AllTime"));
				auditedTime = WebUtil.replaceSpecialCharacters((String) r.get("AuditedTime"));
				if (WebUtil.isNotNull(r.get("CompanyId")))
					companyId = WebUtil.replaceSpecialCharacters(r.get("CompanyId").toString());
				else
					companyId = "";
				companyName = WebUtil.replaceSpecialCharacters((String) r.get("CompanyName"));
				if (WebUtil.isNotNull(r.get("Ctime")))
					ctime = WebUtil.formatDateString((Date) r.get("Ctime"),
							"yyyy-MM-dd HH:mm");
				else
					ctime = "";
				cuser = WebUtil.replaceSpecialCharacters((String) r.get("Cuser"));
				deliveryTime = WebUtil.replaceSpecialCharacters((String) r.get("DeliveryTime"));
				department = WebUtil.replaceSpecialCharacters((String) r.get("Department"));
				if (WebUtil.isNotNull(r.get("ServiceApplyId")))
					serviceApplyId = WebUtil.replaceSpecialCharacters(r.get("ServiceApplyId").toString());
				else
					serviceApplyId = "";
				if (WebUtil.isNotNull(r.get("ServiceId")))
					serviceId = WebUtil.replaceSpecialCharacters(r.get("ServiceId").toString());
				else
					serviceId = "";
				serviceNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceNo"));
				shippingNo = WebUtil.replaceSpecialCharacters((String) r.get("ShippingNo"));
				deliveryStock = WebUtil.replaceSpecialCharacters((String)r.get("DeliveryStock"));
				if(WebUtil.isNotNull(r.get("DeliveryDate")))
					deliveryDate = WebUtil.formatDateString((Date)r.get("DeliveryDate"), "yyyy-MM-dd");
				else
					deliveryDate = null;
				status = WebUtil.replaceSpecialCharacters((String) r.get("Status"));
				statusName = WebUtil.replaceSpecialCharacters((String) r.get("StatusName"));
				serviceApplyAuditedUser = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyAuditedUser"));
				serviceDeliveryNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceDeliveryNo"));
				serviceApplyNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyNo"));
				deliveryStock = WebUtil.replaceSpecialCharacters((String)r.get("DeliveryStock"));
				if(WebUtil.isNotNull(r.get("DeliveryDate")))
					deliveryDate = WebUtil.formatDateString((Date)r.get("DeliveryDate"), "yyyy-MM-dd");
				else
					deliveryDate = null;
				serviceDeliveryItemList = (List) r.get("ServiceDeliveryItemList");
				serviceDeliveryFileList = (List) r.get("ServiceDeliveryFileList");
				serviceApplyFileList = (List) r.get("ServiceApplyFileList");
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
}
