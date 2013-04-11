package com.sunmw.web.action.serviceVisit;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceCsServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderVisitInfoAction {

	private ServiceCsServices serviceVisitServices;
	
	private String serviceVisitId;	
	private String serviceId;
	private String serviceNo;
	private String status;
	private String visitFlag;
	private String visitResult;
	private String visitMemo;
	private String ctime;
	private String cuser;
	private String serviceVisitNo;
	
	private String message;
	private String crumb;
	
	public ServiceCsServices getServiceVisitServices() {
		return serviceVisitServices;
	}

	public void setServiceVisitServices(ServiceCsServices serviceVisitServices) {
		this.serviceVisitServices = serviceVisitServices;
	}

	public String getServiceVisitId() {
		return serviceVisitId;
	}

	public void setServiceVisitId(String serviceVisitId) {
		this.serviceVisitId = serviceVisitId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVisitFlag() {
		return visitFlag;
	}

	public void setVisitFlag(String visitFlag) {
		this.visitFlag = visitFlag;
	}

	public String getVisitResult() {
		return visitResult;
	}

	public void setVisitResult(String visitResult) {
		this.visitResult = visitResult;
	}

	public String getVisitMemo() {
		return visitMemo;
	}

	public void setVisitMemo(String visitMemo) {
		this.visitMemo = visitMemo;
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

	public String getServiceVisitNo() {
		return serviceVisitNo;
	}

	public void setServiceVisitNo(String serviceVisitNo) {
		this.serviceVisitNo = serviceVisitNo;
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

	public String serviceVisitInfo()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceVisitId",WebUtil.filterSpecialCharacters(serviceVisitId));
			Map r = this.serviceVisitServices.serviceVisitInfo(param);
			if(r.get("Flag").equals("ERROR"))
			{
				this.serviceId = null;
				this.serviceNo = null;
				this.status = null;
				this.visitFlag = null;
				this.visitResult = null;
				this.visitMemo = null;
				this.ctime = null;
				this.cuser = null;
				this.serviceVisitNo = null;
				message = (String) r.get("Message");
				return "error";
			}
			if(WebUtil.isNotNull(r.get("ServiceId")))
				this.serviceId = r.get("ServiceId").toString();
			else
				this.serviceId = "";
			this.serviceNo = WebUtil.replaceSpecialCharacters((String)r.get("ServiceNo"));
			this.status = WebUtil.replaceSpecialCharacters((String)r.get("Status"));
			this.visitFlag = WebUtil.replaceSpecialCharacters((String)r.get("VisitFlag"));
			this.visitResult = WebUtil.replaceSpecialCharacters((String)r.get("VisitResult"));
			this.visitMemo = WebUtil.replaceSpecialCharacters((String)r.get("VisitMemo"));
			this.ctime = WebUtil.replaceSpecialCharacters((String)r.get("Ctime"));
			this.cuser = WebUtil.replaceSpecialCharacters((String)r.get("Cuser"));
			this.serviceVisitNo = WebUtil.replaceSpecialCharacters((String)r.get("ServiceVisitNo"));
			message = null;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	
	public String visitServiceOrder()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "error";
			}
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceId", WebUtil.filterSpecialCharacters(this.serviceId));
			param.put("VisitFlag", WebUtil.filterSpecialCharacters(this.visitFlag));
			param.put("VisitMemo", WebUtil.filterSpecialCharacters(this.visitMemo));
			param.put("VisitResult", WebUtil.filterSpecialCharacters(this.visitResult));
			Map r = this.serviceVisitServices.visitServiceOrder(param);
			if(r.get("Flag").equals("ERROR"))
			{
				message = (String) r.get("Message");
				return "error";
			}
			else
			{
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
}
