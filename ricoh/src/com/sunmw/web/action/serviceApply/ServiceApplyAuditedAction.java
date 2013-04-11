package com.sunmw.web.action.serviceApply;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceApplyServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceApplyAuditedAction {
	
	private ServiceApplyServices serviceApplyServices;
	
	private String serviceApplyId;
	private String auditedResult;
	private String resultMemo;
	private String partType;
	private String shopMemo;
	private String homeRate;
	private String otherRate;
	private String otherRateMemo;
	
	private String message;
	
	public ServiceApplyServices getServiceApplyServices() {
		return serviceApplyServices;
	}

	public void setServiceApplyServices(ServiceApplyServices serviceApplyServices) {
		this.serviceApplyServices = serviceApplyServices;
	}

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public String getAuditedResult() {
		return auditedResult;
	}

	public void setAuditedResult(String auditedResult) {
		this.auditedResult = auditedResult;
	}

	public String getResultMemo() {
		return resultMemo;
	}

	public void setResultMemo(String resultMemo) {
		this.resultMemo = resultMemo;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getShopMemo() {
		return shopMemo;
	}

	public void setShopMemo(String shopMemo) {
		this.shopMemo = shopMemo;
	}

	public String getHomeRate() {
		return homeRate;
	}

	public void setHomeRate(String homeRate) {
		this.homeRate = homeRate;
	}

	public String getOtherRate() {
		return otherRate;
	}

	public void setOtherRate(String otherRate) {
		this.otherRate = otherRate;
	}

	public String getOtherRateMemo() {
		return otherRateMemo;
	}

	public void setOtherRateMemo(String otherRateMemo) {
		this.otherRateMemo = otherRateMemo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String auditedServiceApply()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", WebUtil.filterSpecialCharacters(serviceApplyId));
			param.put("AuditedResult", WebUtil.filterSpecialCharacters(auditedResult));
			param.put("ResultMemo", WebUtil.filterSpecialCharacters(resultMemo));
			param.put("PartType", WebUtil.filterSpecialCharacters(partType));
			Map r = this.serviceApplyServices.auditedServiceApply(param);
			String flag = (String)r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = (String)r.get("Message");
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
	
	public String reApplyService()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", WebUtil.filterSpecialCharacters(serviceApplyId));
			param.put("ShopMemo", WebUtil.filterSpecialCharacters(shopMemo));
			param.put("HomeRate", WebUtil.filterSpecialCharacters(homeRate));
			param.put("OtherRate", WebUtil.filterSpecialCharacters(otherRate));
			param.put("OtherRateMemo", WebUtil.filterSpecialCharacters(otherRateMemo));
			Map r = this.serviceApplyServices.reApplyService(param);
			String flag = (String)r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = (String)r.get("Message");
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
